package evaluator;

import ast.Node;
import ast.evaluators.Evaluator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.testng.annotations.Test;
import parser.GraphicalLexer;
import parser.GraphicalParser;
import parser.ParseTreeToAST;

import static org.testng.AssertJUnit.assertEquals;

public class EvaluatorTest {

  String prefix = """
      import math
      import tkinter as tk
      canvas = None
      current_frame = None

      class AnimationApp:
        def __init__(self, master, functions, durations):
          self.master = master
          self.functions = functions
          self.durations = durations

        # add new frames to the animation with their own duration
        def add_frames(self, frames, duration):
          for frame in frames:
            self.functions.extend([frame.toScript()])
          self.durations.extend([duration] * len(frames))

        def run_animation(self):
          print("running animation")
          if self.functions:
            func = self.functions.pop(0)
            duration = self.durations.pop(0)
            func()
            if (duration != -1):
              self.master.after(duration, self.run_animation)

      def create_new_canvas(w, h, bg_colour):
        global canvas
        if isinstance(canvas, tk.Canvas):
          canvas.destroy()  # Destroy previous canvas if it exists
        canvas = tk.Canvas(window, width=w, height=h, bg=bg_colour)
        canvas.pack()

      def shift_hex_opacity(foreground_colour, background_colour, opacity):
        # foreground_colour and background_colour are strings in the format "#RRGGBB", opacity is a float between 0 and 1
        # returns a hex string shifted by the opacity towards the background_colour
        # if opacity is 1, the function returns the foreground_colour
        # if opacity is 0, the function returns the background_colour
        fg_r = int(foreground_colour[1:3], 16)
        fg_g = int(foreground_colour[3:5], 16)
        fg_b = int(foreground_colour[5:7], 16)
        bg_r = int(background_colour[1:3], 16)
        bg_g = int(background_colour[3:5], 16)
        bg_b = int(background_colour[5:7], 16)
        new_r = int(fg_r * opacity + bg_r * (1 - opacity))
        new_g = int(fg_g * opacity + bg_g * (1 - opacity))
        new_b = int(fg_b * opacity + bg_b * (1 - opacity))
        return "#{:02x}{:02x}{:02x}".format(new_r, new_g, new_b)

      def check_has_pos(ownerid, childid, x, y, z):
        for i in range(len(ownerid.owns)):
          if ownerid.owns[i][0] == childid:
            if ownerid.owns[i][1] == (x, y, z):
              return True
        return False

      class Object:
        def __init__(self, colour, shape, size, opacity, rotation, shear, scale, owns):
          self.colour = colour
          self.shape = shape
          self.size = size
          self.opacity = opacity
          self.rotation = rotation
          self.shear = shear
          self.scale = scale
          self.owns = owns
            
        def toScript(self, x, y, bg_colour):
          subCalls = []
            
          sortedOwns = sorted(self.owns, key=lambda x: x[1][2])
          for obj, pos in sortedOwns:
            newCall = obj.toScript(x+pos[0], y-pos[1], bg_colour)
            subCalls.append(newCall)
            
          def object():
            computed_colour = shift_hex_opacity(self.colour, bg_colour, self.opacity)
            temp_x = (self.size[0] + self.shear[0]) * self.scale[0]
            temp_y = (self.size[1] + self.shear[1]) * self.scale[1]
            rotation_radians = math.radians(self.rotation)
            final_x = (temp_x * math.cos(rotation_radians)) - (temp_y * math.sin(rotation_radians))
            final_y = (temp_x * math.sin(rotation_radians)) + (temp_y * math.cos(rotation_radians))
            if self.shape == "circle":
              canvas.create_oval(x, y, x + final_x, y - final_y, fill=computed_colour, outline=computed_colour, width=0)
            elif self.shape == "rectangle" or self.shape == "square":
              canvas.create_rectangle(x, y, x + final_x, y - final_y, fill=computed_colour, outline=computed_colour, width=0)
            elif self.shape == "triangle":
              canvas.create_polygon(x, y, x + final_x, y, x + (final_x / 2), y - final_y, fill=computed_colour, outline=computed_colour, width=0)
            elif self.shape == "line":
              canvas.create_line(x, y, x + final_x, y - final_y, fill=computed_colour, width=2)
            
            for call in subCalls:
              call()
            
          return object

      class Frame:
        def __init__(self, backgroundId, owns):
          self.backgroundId = backgroundId
          self.owns = owns

        def toScript(self):
          subCalls = []

          # sort owns based on z value of position
          sortedOwns = sorted(self.owns, key=lambda x: x[1][2])
          for obj, pos in sortedOwns:
            newCall = obj.toScript(pos[0], self.backgroundId.size[1]-pos[1], self.backgroundId.colour)
            subCalls.append(newCall)

          def frame():
            create_new_canvas(self.backgroundId.size[0], self.backgroundId.size[1], self.backgroundId.colour)
            canvas.delete("all")
            for call in subCalls:
              call()

          return frame

      window = tk.Tk()
      app = AnimationApp(window, [], [])
      window.title('Graphical Language')
        """;

  String suffix = "\napp.run_animation()\nwindow.mainloop()\n";

  private Node getASTNode(String graphicalProgram) {
    GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString(graphicalProgram));
    lexer.reset();
    TokenStream tokens = new CommonTokenStream(lexer);
    GraphicalParser parser = new GraphicalParser(tokens);
    ParseTreeToAST visitor = new ParseTreeToAST();
    return parser.program().accept(visitor);
  }

  @Test
  public void testBasicDraw() {
    Node p = getASTNode(
        """
            Let orange be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
            Let canvas be an object with shape = rectangle, colour = white, size = (600,400)
            Let frame be an image on canvas placing orange at (100,100,1)
            DRAW frame
            """);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        orange = Object("#FFA500", "circle", (30, 30), 1.0, 30, (0, 0), (1, 1), [])
        canvas = Object("#FFFFFF", "rectangle", (600, 400), 1.0, 0, (0, 0), (1, 1), [])
        frame = Frame(canvas, [(orange, (100, 100, 1)),])
        app.add_frames([frame], -1)
        current_frame = "frame"
        """ + suffix;

    assertEquals(expected, actual);
  }

  @Test
  public void testRedeclaredObject() {
    String redeclaredOrange = """
                Let orange be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
                Let orange be an object with shape = circle, size = 10, colour = blue, rotation = 30 degrees
                Let canvas be an object with shape = rectangle, colour = white, size = (600,400)
                Let frame be an image on canvas placing orange at (100,100,1)
                DRAW frame
                """;
    Node p = getASTNode(redeclaredOrange);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        orange = Object("#FFA500", "circle", (30, 30), 1.0, 30, (0, 0), (1, 1), [])
        orange = Object("#0000FF", orange.shape, (10, 10), orange.opacity, orange.rotation, orange.shear, orange.scale, [])
        canvas = Object("#FFFFFF", "rectangle", (600, 400), 1.0, 0, (0, 0), (1, 1), [])
        frame = Frame(canvas, [(orange, (100, 100, 1)),])
        app.add_frames([frame], -1)
        current_frame = "frame"
        """ + suffix;

    assertEquals(expected, actual);
  }

  @Test
  public void testRedeclaredFieldInObject() {
    String redeclaredField = """
            Let orange be an object with shape = circle, size = 30, colour = orange, shape = rectangle, size = 50, colour = red, rotation = 30 degrees
            Let canvas be an object with shape = rectangle, colour = white, size = (200,200)
            Let frame be an image on canvas placing orange at (100,100,0)
            DRAW frame""";
    Node p = getASTNode(redeclaredField);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        orange = Object("#FF0000", "rectangle", (50, 50), 1.0, 30, (0, 0), (1, 1), [])
        canvas = Object("#FFFFFF", "rectangle", (200, 200), 1.0, 0, (0, 0), (1, 1), [])
        frame = Frame(canvas, [(orange, (100, 100, 0)),])
        app.add_frames([frame], -1)
        current_frame = "frame"
        """ + suffix;

    assertEquals(expected, actual);

  }

  @Test
  public void testRedeclaredImage() {
    String redeclaredFrame = """
                Let blue be an object with shape = rectangle, size = (20, 48), colour = blue
                Let orange be an object with shape = circle, size=40, colour = orange
                Let canvas be an object with shape = rectangle, colour = (173, 216, 230), size = (400, 400)
                Let orange own blue at (-20, -4, 0)
                Let fish1 be an orange
                Let fish2 be an orange
                Let frame be an image on canvas placing fish1 at (75, 100, 0)
                Let frame be an image on canvas placing fish2 at (50, 50, 0)
                DRAW frame
                """;
    Node p = getASTNode(redeclaredFrame);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        blue = Object("#0000FF", "rectangle", (20, 48), 1.0, 0, (0, 0), (1, 1), [])
        orange = Object("#FFA500", "circle", (40, 40), 1.0, 0, (0, 0), (1, 1), [])
        canvas = Object("#ADD8E6", "rectangle", (400, 400), 1.0, 0, (0, 0), (1, 1), [])
        orange = Object(orange.colour, orange.shape, orange.size, orange.opacity, orange.rotation, orange.shear, orange.scale, [(blue, (-20, -4, 0)),])
        fish1 = orange
        fish2 = orange
        frame = Frame(canvas, [(fish1, (75, 100, 0)),])
        frame = Frame(canvas, [(fish2, (50, 50, 0)),])
        app.add_frames([frame], -1)
        current_frame = "frame"
        """ + suffix;

    assertEquals(expected, actual);
  }

  @Test
  public void testImageOnSelf() {
    String redeclaredOrange = """
                Let canvas be an object with shape=rectangle, size=(400,400), colour=(173, 216, 230)
                Let default be an object with shape=triangle, size = (50, 50), colour=blue
                Let image1 be an image on canvas placing default at (50, 50, 0)
                Let image1 be an image on image1 placing default at (100, 100,0)
                """;
    Node p = getASTNode(redeclaredOrange);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        a
        """ + suffix;

    // Intended null response since we can't place an image on itself.
    assertEquals(null, actual);
  }

  @Test
  public void testDrawDefaultObj() {
    String redeclaredOrange = """
                Let canvas be an object with shape=rectangle, size=(400,400), colour=(173, 216, 230)
                Let default be an object
                Let image1 be an image on canvas placing default at (50, 50, 0)
                DRAW image1
                """;
    Node p = getASTNode(redeclaredOrange);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);

    /**
     * Default Values:
     *  Shape -> rectangle
     *  Colour -> white
     *  Size -> (1, 1)
     *  Opacity -> 0.0
     *  Rotation -> 0
     *  Shear -> (0, 0)
     *  Scale -> (1, 1)
     */
    String expected = prefix + """
        canvas = Object("#ADD8E6", "rectangle", (400, 400), 1.0, 0, (0, 0), (1, 1), [])
        default = Object("#FFFFFF", "rectangle", (1, 1), 0.0, 0, (0, 0), (1, 1), [])
        image1 = Frame(canvas, [(default, (50, 50, 0)),])
        app.add_frames([image1], -1)
        current_frame = "image1"
        """ + suffix;

    assertEquals(expected, actual);
  }

  @Test
  public void testOwnershipProgram() {
    Node p = getASTNode(
        """
            Let orange be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
            Let tree be an object with shape = rectangle, colour = brown, size = (100,600)
            Let tree own orange at (50,20,2), own orange at (60,60,3)
            Let canvas be an object with shape = rectangle, colour = white, size = (1200,1000)
            Let frame be an image on canvas placing tree at (100,100,1)
            DRAW frame
            """);

    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();

    String actual = p.accept(sb, evaluator);
    String expected = prefix
        + """
            orange = Object("#FFA500", "circle", (30, 30), 1.0, 30, (0, 0), (1, 1), [])
            tree = Object("#6F4E37", "rectangle", (100, 600), 1.0, 0, (0, 0), (1, 1), [])
            tree = Object(tree.colour, tree.shape, tree.size, tree.opacity, tree.rotation, tree.shear, tree.scale, [(orange, (50, 20, 2)),(orange, (60, 60, 3)),])
            canvas = Object("#FFFFFF", "rectangle", (1200, 1000), 1.0, 0, (0, 0), (1, 1), [])
            frame = Frame(canvas, [(tree, (100, 100, 1)),])
            app.add_frames([frame], -1)
            current_frame = "frame"
            """
        + suffix;

    assertEquals(expected, actual);
  }

  @Test
  public void testAnimateCall() {
    String animateCall = """
        Let orange be an object with shape = circle, size = 30, colour = orange
        Let tree be an object with shape = rectangle, colour = brown, size = (100,600)
        Let tree own orange at (0,550,2), own orange at (60,60,3)
        Let canvas be an object with shape = rectangle, colour = white, size = (1200,1000)
        Let frame1 be an image on canvas placing tree at (100,0,1), placing orange at (100,650,3)
        Let frame2 be an image on canvas placing tree at (110,0,1), placing orange at (100,600,3)
        Let frame3 be an image on canvas placing tree at (100,0,1), placing orange at (100,300,3)
        Let frame4 be an image on canvas placing tree at (100,0,1), placing orange at (100,0,3)
        ANIMATE frame1 -> frame2 -> frame3 -> frame4 FOR 2 seconds
        """;

    Node p = getASTNode(animateCall);
    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();
    String actual = p.accept(sb, evaluator);

    String expected = prefix
        + """
            orange = Object("#FFA500", "circle", (30, 30), 1.0, 0, (0, 0), (1, 1), [])
            tree = Object("#6F4E37", "rectangle", (100, 600), 1.0, 0, (0, 0), (1, 1), [])
            tree = Object(tree.colour, tree.shape, tree.size, tree.opacity, tree.rotation, tree.shear, tree.scale, [(orange, (0, 550, 2)),(orange, (60, 60, 3)),])
            canvas = Object("#FFFFFF", "rectangle", (1200, 1000), 1.0, 0, (0, 0), (1, 1), [])
            frame1 = Frame(canvas, [(tree, (100, 0, 1)),(orange, (100, 650, 3)),])
            frame2 = Frame(canvas, [(tree, (110, 0, 1)),(orange, (100, 600, 3)),])
            frame3 = Frame(canvas, [(tree, (100, 0, 1)),(orange, (100, 300, 3)),])
            frame4 = Frame(canvas, [(tree, (100, 0, 1)),(orange, (100, 0, 3)),])
            app.add_frames([frame1,frame2,frame3,frame4,], 2000)
            current_frame = "frame4"
            """
        + suffix;
    assertEquals(expected, actual);
  }

  @Test
  public void testComplexDraw() {
    String complexDrawCall = """
        Let head be an object with shape = circle, size = 20, colour = yellow
        Let eyeball1 be an object with shape = circle, size = 4, colour = black
        Let eyeball2 be an eyeball1
        Let mouth be an object with shape = rectangle, size = (12,2), colour = red

        Let torso be an object with shape = triangle, size = (40,50), colour = purple
        Let leg1 be an object with shape = line, size = (4,10), colour = black
        Let leg2 be an object with shape = line, size = (4,-10), colour = black

        Let canvas be an object with shape = rectangle, size = (160,100), colour = white

        Let head own eyeball1 at (4,10,0), own eyeball2 at (12,10,0), and own mouth at (4,4,0)

        Let frame be an image on canvas placing head at (70,66,0), placing torso at (60,24,0), placing leg1 at (66,14,0), and placing leg2 at (90,14,0)

        DRAW frame
        """;
    Node p = getASTNode(complexDrawCall);
    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();
    String actual = p.accept(sb, evaluator);

    String expected = prefix
        + """
            head = Object("#FFFF00", "circle", (20, 20), 1.0, 0, (0, 0), (1, 1), [])
            eyeball1 = Object("#000000", "circle", (4, 4), 1.0, 0, (0, 0), (1, 1), [])
            eyeball2 = eyeball1
            mouth = Object("#FF0000", "rectangle", (12, 2), 1.0, 0, (0, 0), (1, 1), [])
            torso = Object("#800080", "triangle", (40, 50), 1.0, 0, (0, 0), (1, 1), [])
            leg1 = Object("#000000", "line", (4, 10), 1.0, 0, (0, 0), (1, 1), [])
            leg2 = Object("#000000", "line", (4, -10), 1.0, 0, (0, 0), (1, 1), [])
            canvas = Object("#FFFFFF", "rectangle", (160, 100), 1.0, 0, (0, 0), (1, 1), [])
            head = Object(head.colour, head.shape, head.size, head.opacity, head.rotation, head.shear, head.scale, [(eyeball1, (4, 10, 0)),(eyeball2, (12, 10, 0)),(mouth, (4, 4, 0)),])
            frame = Frame(canvas, [(head, (70, 66, 0)),(torso, (60, 24, 0)),(leg1, (66, 14, 0)),(leg2, (90, 14, 0)),])
            app.add_frames([frame], -1)
            current_frame = "frame"
            """
        + suffix;
    assertEquals(expected, actual);
  }

  @Test
  public void testSimpleIfThenElse() {
    String ifThenElse = """
        Let success be an object with shape = circle, size = 500, colour = green
        Let failure be an object with shape = rectangle, size = (200,400), colour = red
        Let canvas be an object with shape = rectangle, size = (1000,1000), colour = black

        Let then_frame be an image on canvas placing success at (500,500,0)
        Let else_frame be an image on canvas placing failure at (500,500,0)

        IF Assert that success has shape = rectangle
            THEN { DRAW then_frame }
            ELSE { DRAW else_frame }
        """;
    Node p = getASTNode(ifThenElse);
    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();
    String actual = p.accept(sb, evaluator);

    String expected = prefix + """
        success = Object("#008000", "circle", (500, 500), 1.0, 0, (0, 0), (1, 1), [])
        failure = Object("#FF0000", "rectangle", (200, 400), 1.0, 0, (0, 0), (1, 1), [])
        canvas = Object("#000000", "rectangle", (1000, 1000), 1.0, 0, (0, 0), (1, 1), [])
        then_frame = Frame(canvas, [(success, (500, 500, 0)),])
        else_frame = Frame(canvas, [(failure, (500, 500, 0)),])
        if (success.shape == "rectangle"):
          app.add_frames([then_frame], -1)
          current_frame = "then_frame"
          pass
        else:
          app.add_frames([else_frame], -1)
          current_frame = "else_frame"
          pass
        """ + suffix;

    assertEquals(expected, actual);
  }

  @Test
  public void testCallAll() {
    String repeatProgram = """
        Let switchingObject be an object with shape = square, colour = yellow, size = (100,200)

        Let canvas be an object with shape = rectangle, colour = white, size = (500,500)


        REPEAT
          IF $current_frame = frame1
            THEN { Let switchingObject be an object with colour = red }
            ELSE { Let switchingObject be an object with colour = green }
          Let frame1 be an image on canvas placing switchingObject at (250,250,1)
          Let frame2 be an image on canvas placing switchingObject at (200,250,2)
          Let frame3 be an image on canvas placing switchingObject at (200,300,1)
          ANIMATE frame1 -> frame2 -> frame3 FOR 3 seconds
          ANIMATE frame3 -> frame2 -> frame1 FOR 3 seconds
        FOR 2
        """;
    Node p = getASTNode(repeatProgram);
    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();
    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        switchingObject = Object("#FFFF00", "square", (100, 200), 1.0, 0, (0, 0), (1, 1), [])
        canvas = Object("#FFFFFF", "rectangle", (500, 500), 1.0, 0, (0, 0), (1, 1), [])
        for _ in range(2):
          if (current_frame == "frame1"):
            switchingObject = Object("#FF0000", switchingObject.shape, switchingObject.size, switchingObject.opacity, switchingObject.rotation, switchingObject.shear, switchingObject.scale, [])
            pass
          else:
            switchingObject = Object("#008000", switchingObject.shape, switchingObject.size, switchingObject.opacity, switchingObject.rotation, switchingObject.shear, switchingObject.scale, [])
            pass
          frame1 = Frame(canvas, [(switchingObject, (250, 250, 1)),])
          frame2 = Frame(canvas, [(switchingObject, (200, 250, 2)),])
          frame3 = Frame(canvas, [(switchingObject, (200, 300, 1)),])
          app.add_frames([frame1,frame2,frame3,], 3000)
          current_frame = "frame3"
          app.add_frames([frame3,frame2,frame1,], 3000)
          current_frame = "frame1"
          """ + suffix;
    assertEquals(expected, actual);
  }

  @Test
  public void testCombinedCall() {
    String repeatProgram = """
        Let switchingObject be an object with shape = square, colour = green, size = (100,200)

        Let canvas be an object with shape = rectangle, colour = white, size = (500,500)

        Let frame1 be an image on canvas placing switchingObject at (250,250,1)

        REPEAT
          IF $current_frame = frame1
            THEN { Let switchingObject be an object with colour = red }
            ELSE { Let switchingObject be an object with colour = green }
          DRAW frame1
        FOR 2
        """;
    Node p = getASTNode(repeatProgram);
    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();
    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        switchingObject = Object("#008000", "square", (100, 200), 1.0, 0, (0, 0), (1, 1), [])
        canvas = Object("#FFFFFF", "rectangle", (500, 500), 1.0, 0, (0, 0), (1, 1), [])
        frame1 = Frame(canvas, [(switchingObject, (250, 250, 1)),])
        for _ in range(2):
          if (current_frame == "frame1"):
            switchingObject = Object("#FF0000", switchingObject.shape, switchingObject.size, switchingObject.opacity, switchingObject.rotation, switchingObject.shear, switchingObject.scale, [])
            pass
          else:
            switchingObject = Object("#008000", switchingObject.shape, switchingObject.size, switchingObject.opacity, switchingObject.rotation, switchingObject.shear, switchingObject.scale, [])
            pass
          app.add_frames([frame1], -1)
          current_frame = "frame1"
          """ + suffix;
    assertEquals(expected, actual);
  }

  @Test
  public void testDeepPredicate() {
    String manyThenClauses = """
        Let success be an object with shape = circle, size = 500, colour = green
        Let failure be an object with shape = rectangle, size = (200,400), colour = red
        Let canvas be an object with shape = rectangle, size = (1000,1000), colour = black

        Let then_frame be an image on canvas placing success at (500,500,0)
        Let else_frame be an image on canvas placing failure at (500,500,0)

        IF Assert that success has shape = rectangle
            THEN {
              ANIMATE then_frame -> else_frame FOR 2 seconds
              ANIMATE else_frame -> then_frame FOR 4 seconds
            }
            ELSE { DRAW else_frame }
        """;
    Node p = getASTNode(manyThenClauses);
    Evaluator evaluator = new Evaluator();
    StringBuilder sb = new StringBuilder();
    String actual = p.accept(sb, evaluator);
    String expected = prefix + """
        success = Object("#008000", "circle", (500, 500), 1.0, 0, (0, 0), (1, 1), [])
        failure = Object("#FF0000", "rectangle", (200, 400), 1.0, 0, (0, 0), (1, 1), [])
        canvas = Object("#000000", "rectangle", (1000, 1000), 1.0, 0, (0, 0), (1, 1), [])
        then_frame = Frame(canvas, [(success, (500, 500, 0)),])
        else_frame = Frame(canvas, [(failure, (500, 500, 0)),])
        if (success.shape == "rectangle"):
          app.add_frames([then_frame,else_frame,], 2000)
          current_frame = "else_frame"
          app.add_frames([else_frame,then_frame,], 4000)
          current_frame = "then_frame"
          pass
        else:
          app.add_frames([else_frame], -1)
          current_frame = "else_frame"
          pass
        """ + suffix;
    assertEquals(expected,actual);
  }
}
