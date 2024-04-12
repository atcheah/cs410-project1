import ast.Node;
import ast.evaluators.Evaluator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import parser.GraphicalLexer;
import parser.GraphicalParser;
import parser.ParseTreeToAST;

import java.io.*;

public class GraphicalExecutor {

    static String drawCall = """
                    Let orange be an object with shape = circle, size = 30, colour = orange
                    Let tree be an object with shape = rectangle, colour = brown, size = (100,600)
                    Let tree own orange at (0,550,2), own orange at (60,60,3)
                    Let canvas be an object with shape = rectangle, colour = white, size = (1200,1000)
                    Let frame be an image on canvas placing tree at (100,100,1)
                    DRAW frame
                    """;
    static String animateCall = """
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

    static String complexDrawCall = """
            Let head be an object with shape = circle, size = 40, colour = yellow
            Let eyeball1 be an object with shape = circle, size = 8, colour = black
            Let eyeball2 be an eyeball1
            Let mouth be an object with shape = rectangle, size = (24, 4), colour = red
            Let torso be an object with shape = triangle, size = (80, 100), colour = purple
            Let leg1 be an object with shape = line, size = (8, 20), colour = black
            Let leg2 be an object with shape = line, size = (8, -20), colour = black
            Let canvas be an object with shape = rectangle, size = (320, 200), colour = white
            Let head own eyeball1 at (8, 20, 0), own eyeball2 at (24, 20, 0), and own mouth at (8, 8, 0)
            Let frame be an image on canvas placing head at (140, 132, 1), placing torso at (120, 48, 0), placing leg1 at (132, 28, 0), and placing leg2 at (180, 48, 0)
                    
            DRAW frame
                    """;

    static String ifThenElse = """
            Let success be an object with shape = circle, size = 500, colour = green, rotation = 90 degrees
            Let failure be an object with shape = rectangle, size = (200,400), colour = red
            Let canvas be an object with shape = rectangle, size = (1000,1000), colour = black
            
            Let then_frame be an image on canvas placing success at (500,500,0)
            Let else_frame be an image on canvas placing failure at (500,500,0)
            
            IF Assert that success has shape = circle
                THEN { DRAW then_frame }
                ELSE { DRAW else_frame }
            """;

    static String combinedCall = """
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

    static String repeatProgram = """
Let switchingObject be an object with shape = square, colour = yellow, size = (100,200)

Let canvas be an object with shape = rectangle, colour = white, size = (500,500)

Let frame1 be an image on canvas placing switchingObject at (250,250,1)
Let frame2 be an image on canvas placing switchingObject at (200,250,2)
Let frame3 be an image on canvas placing switchingObject at (200,300,1)

REPEAT
  IF $current_frame = frame1
    THEN { Let switchingObject be an object with colour = red }
    ELSE { Let switchingObject be an object with colour = green }
  ANIMATE frame1 -> frame2 -> frame3 FOR 3 seconds
  ANIMATE frame3 -> frame2 -> frame1 FOR 3 seconds
FOR 2
            """;

    static String manyThenClauses = """
            Let success be an object with shape = circle, size = 500, colour = green
            Let failure be an object with shape = rectangle, size = (200,400), colour = red
            Let canvas be an object with shape = rectangle, size = (1000,1000), colour = black
            
            Let then_frame be an image on canvas placing success at (500,500,0)
            Let else_frame be an image on canvas placing failure at (500,500,0)
            
            IF Assert that success has shape = circle
                THEN {
                  ANIMATE then_frame -> else_frame FOR 2 seconds
                  ANIMATE else_frame -> then_frame FOR 4 seconds
                }
                ELSE { DRAW else_frame }
            """;

    static String poorlyWrittenProgram = """
            Let badObjectDecl be an object
            Let canvas be an object
            Let frame be an image on canvas placing badObjectDecl at (0,0,0)
            DRAW frame
            """;

    static String interestingExample = """
            Let shiftingObject be an object with shape = line, colour = yellow, size = (50,50)
            Let shiftingObjectCopy be a shiftingObject
            Let canvas be an object with shape = rectangle, colour = white, size = (200,200)
            REPEAT
                IF Assert that shiftingObject has shape = rectangle
                    THEN { Let shiftingObject be an object with shape = circle }
                    ELSE { Let shiftingObject be an object with shape = rectangle }
                IF Assert that shiftingObject has colour = red
                    THEN { Let shiftingObject be an object with colour = green }
                    ELSE { IF Assert that shiftingObject has colour = yellow
                                THEN { Let shiftingObject be an object with colour = blue }
                                ELSE { IF Assert that shiftingObject has colour = blue
                                        THEN { Let shiftingObject be an object with colour = red }
                                        ELSE { Let shiftingObject be an object with shape = triangle } } }
                Let frame be an image on canvas placing shiftingObject at (100,100,0), placing shiftingObjectCopy at (0,0,0)
                ANIMATE frame FOR 1 seconds
            FOR 4
            """; // should get a capture the 4 changing states of the entity

    static String moreExample = """
            Let orange be an object with shape = circle, size = 30, colour = orange
            Let orange be an object with shape = rectangle
            Let canvas be an object with shape = rectangle, colour = (255,255,255), size = (100,100)
            Let frame1 be an image on canvas placing orange at (20, 20, 0)
                        
            DRAW frame1
            """;
    static String tutorialExample = """
             Let head be an object with shape = circle, size = 40, colour = yellow
                        Let eyeball be an object with shape = circle, size = 8, colour = black
                        Let mouth be an object with shape = rectangle, size = (14, 4), colour = red
                        Let head own eyeball at (26, 20, 0), and own mouth at (24, 8, 0)
            \s
                        Let frame1_torso be an object with shape = triangle, size = (60, 100), colour = purple
                        Let frame1_arm1 be an object with shape = line,  size = (28, 18), colour = black
                        Let frame1_arm2 be an object with shape = line,  size = (28, -18), colour = black
                        Let frame1_leg1 be an object with shape = line, size = (12, 30), colour = black
                        Let frame1_leg2 be an object with shape = line, size = (12, -30), colour = black
                        Let frame1_torso own frame1_arm1 at (-9, 44, -1), own frame1_arm2 at (42,62,-1), own frame1_leg1 at (5,-30, 0), own frame1_leg2 at (43, 0, 0)
            \s
                        Let frame2_torso be an object with shape = triangle, size = (60, 100), colour = purple
                        Let frame2_arm1_seg1 be an object with shape = line,  size = (12, 13), colour = black
                        Let frame2_arm1_seg2 be an object with shape = line,  size = (14, 4), colour = black
                        Let frame2_arm2_seg1 be an object with shape = line,  size = (9, -12), colour = black
                        Let frame2_arm2_seg2 be an object with shape = line,  size = (17, -2), colour = black
                        Let frame2_arm1_seg1 own frame2_arm1_seg2 at (12, 13, 0)
                        Let frame2_arm2_seg1 own frame2_arm2_seg2 at (9, -12, 0)
                        Let frame2_leg1_seg1 be an object with shape = line, size = (15, 18), colour = black
                        Let frame2_leg1_seg2 be an object with shape = line, size = (0, 12), colour = black
                        Let frame2_leg2_seg1 be an object with shape = line, size = (10, -9), colour = black
                        Let frame2_leg2_seg2 be an object with shape = line, size = (2, 21), colour = black
                        Let frame2_leg1_seg1 own frame2_leg1_seg2 at (15, 18, 0)
                        Let frame2_leg2_seg1 own frame2_leg2_seg2 at (8, -30, 0)
                        Let frame2_torso own frame2_arm1_seg1 at (-7, 45, -1), own frame2_arm2_seg1 at (42,62,-1), own frame2_leg1_seg1 at (0,-30, 0), own frame2_leg2_seg1 at (50, 0, 0)
            \s
            \s
                        Let frame3_torso be an object with shape = triangle, size = (60, 100), colour = purple
                        Let frame3_arm1_seg1 be an object with shape = line,  size = (13, 12), colour = black
                        Let frame3_arm1_seg2 be an object with shape = line,  size = (14, -2), colour = black
                        Let frame3_arm2_seg1 be an object with shape = line,  size = (13, -12), colour = black
                        Let frame3_arm2_seg2 be an object with shape = line,  size = (14, 0), colour = black
                        Let frame3_arm1_seg1 own frame3_arm1_seg2 at (13, 12, 0)
                        Let frame3_arm2_seg1 own frame3_arm2_seg2 at (13, -12, 0)
                        Let frame3_leg1_seg1 be an object with shape = line, size = (19, 9), colour = black
                        Let frame3_leg1_seg2 be an object with shape = line, size = (2, 12), colour = black
                        Let frame3_leg2_seg1 be an object with shape = line, size = (8, -9), colour = black
                        Let frame3_leg2_seg2 be an object with shape = line, size = (4, -28), colour = black
                        Let frame3_leg1_seg1 own frame3_leg1_seg2 at (19, 9, 0)
                        Let frame3_leg2_seg1 own frame3_leg2_seg2 at (8, -9, 0)
                        Let frame3_torso own frame3_arm1_seg1 at (-7, 52, -1), own frame3_arm2_seg1 at (42,62,-1), own frame3_leg1_seg1 at (-3,-21, 0), own frame3_leg2_seg1 at (50, 0, 0)
            \s
                        Let frame4_torso be an object with shape = triangle, size = (60, 100), colour = purple
                        Let frame4_arm1_seg1 be an object with shape = line,  size = (13, 12), colour = black
                        Let frame4_arm1_seg2 be an object with shape = line,  size = (15, -6), colour = black
                        Let frame4_arm2_seg1 be an object with shape = line,  size = (11, -9), colour = black
                        Let frame4_arm2_seg2 be an object with shape = line,  size = (16, 7), colour = black
                        Let frame4_arm1_seg1 own frame4_arm1_seg2 at (13, 12, 0)
                        Let frame4_arm2_seg1 own frame4_arm2_seg2 at (11, -9, 0)
                        Let frame4_leg1_seg1 be an object with shape = line, size = (25, -5), colour = black
                        Let frame4_leg1_seg2 be an object with shape = line, size = (4, 10), colour = black
                        Let frame4_leg2_seg1 be an object with shape = line, size = (8, -9), colour = black
                        Let frame4_leg2_seg2 be an object with shape = line, size = (13, -21), colour = black
                        Let frame4_leg1_seg1 own frame4_leg1_seg2 at (25, -5, 0)
                        Let frame4_leg2_seg1 own frame4_leg2_seg2 at (8, -9, 0)
                        Let frame4_torso own frame4_arm1_seg1 at (-7, 52, -1), own frame4_arm2_seg1 at (42,62,-1), own frame4_leg1_seg1 at (-12,-5, 0), own frame4_leg2_seg1 at (50, 0, 0)
            \s
            \s
                        Let canvas be an object with shape = rectangle, size = (600, 200), colour = white
                        Let frame1 be an image on canvas placing head at (82, 132, 1), placing frame1_torso at (72, 48, 0)
                        Let frame2 be an image on canvas placing head at (214, 132, 1), placing frame2_torso at (204, 48, 0)
                        Let frame3 be an image on canvas placing head at (346, 132, 1), placing frame3_torso at (336, 48, 0)
                        Let frame4 be an image on canvas placing head at (478, 132, 1), placing frame4_torso at (468, 48, 0)
            \s
            \s
            \s
                        REPEAT
                            ANIMATE frame1 -> frame2 -> frame3 -> frame4 FOR 1 seconds
                        FOR 5""";

    public static void main(String[] args) {
        try {
            GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString(interestingExample));
            lexer.reset();
            TokenStream tokens = new CommonTokenStream(lexer);
            GraphicalParser parser = new GraphicalParser(tokens);
            ParseTreeToAST visitor = new ParseTreeToAST();
            Node parsedProgram = parser.program().accept(visitor);
            Evaluator evaluator = new Evaluator();
            StringBuilder sb = new StringBuilder();
            String actual = parsedProgram.accept(sb, evaluator);

            // create a temp file
            File temp = File.createTempFile("temp", "py");

            // write contents to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
            writer.write(actual);
            writer.close();

            System.out.println(actual);

            String pythonPath = "C:/Users/Andrew/AppData/Local/Programs/Python/Python311/python.exe"; // TODO find python path dynamically
            // construct the run command
            String[] command = { pythonPath, temp.getAbsolutePath() };

            ProcessBuilder pb = new ProcessBuilder(command);
            pb.inheritIO();
            pb.environment().put("DISPLAY", ":0.0");
            Process process = pb.start(); // start the process

            String line;
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            // wait for the process to finish
            process.waitFor();
            System.out.println("process finished");

            // delete the temp file
            temp.delete();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
