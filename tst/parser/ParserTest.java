package parser;

import ast.*;
import ast.Object;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.CharStreams;
import org.testng.annotations.Test;
import parser.exceptions.GraphicalSyntaxException;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;


public class ParserTest {

    // Checks whether the parser in each test case throws exception or not. (They should.)
    public void ParserYesExceptionCheck(String input) {
        try {
            GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString(input));
            lexer.reset();
            TokenStream tokens = new CommonTokenStream(lexer);
            GraphicalParser parser = new GraphicalParser(tokens);
            parser.addErrorListener(new GraphicalErrorListener());
            ParseTreeToAST visitor = new ParseTreeToAST();
            Node parsedProgram = parser.program().accept(visitor);
            //Assert.fail("Failed to catch Parser exception.");
        } catch (GraphicalSyntaxException e) {
            System.out.println("Successfully caught exception! \n" + e);
        }
    }

    public Node ParserNoExceptionCheck(String input) {
        try {
            GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString(input));
            lexer.reset();
            TokenStream tokens = new CommonTokenStream(lexer);
            GraphicalParser parser = new GraphicalParser(tokens);
            parser.addErrorListener(new GraphicalErrorListener());
            ParseTreeToAST visitor = new ParseTreeToAST();
            return parser.program().accept(visitor);
        } catch (GraphicalSyntaxException e) {
            //Assert.fail("Caught Parser exception when not expected.");
            throw e;
        }
    }


    @Test
    public void RedefineCopiedShapeTest() {
        // TODO: TBD - should we allow shapes to copy another and then be redefined?
        String input = "Let orange2 be an orange1 with shape=circle,size=88";
        ParserYesExceptionCheck(input);
    }

    @Test
    public void CopyNonexistentShapeTest() {
        String input = "Let orange be a nonexistent_object";
        Node program = ParserNoExceptionCheck(input);

        Id expected_object_id = new Id("orange");
        Id expected_copied_id = new Id("nonexistent_object");
        Let expected_let = new Let(expected_object_id, expected_copied_id);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void ImageWithObjectAttributesTest() {
        String input = "Let crab be an image with shape = triangle, size = (10, 10)";
        ParserYesExceptionCheck(input);
    }

    @Test
    public void ImagePlacementOffCanvasTest() {
        String input = "Let frame be an image on canvas placing orange at (-100, -100)";
        Node program = ParserNoExceptionCheck(input);

        Id expected_image_id = new Id("frame");
        Id expected_object_id = new Id("canvas");
        Id expected_placed_object_id = new Id("orange");
        List<Integer> expected_placed_object_xy = Arrays.asList(-100, -100);
        Position expected_placed_object_position = new Position(expected_placed_object_id, expected_placed_object_xy);
        Image expected_image = new Image(expected_object_id, List.of(expected_placed_object_position));
        Let expected_let = new Let(expected_image_id, expected_image);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void ImageMultiplePlacementsTest() {
        String inputA = "Let frame be an image on canvas placing orange at (-100, -100), placing orange at (5, 5)";
        Node programA = ParserNoExceptionCheck(inputA);

        String inputB = "Let frame be an image on canvas placing orange at (-100, -100),and placing orange at (5, 5)";
        Node programB = ParserNoExceptionCheck(inputB);

        String inputC = "Let frame be an image on canvas placing orange at (-100, -100)     and placing orange at (5, 5)";
        Node programC = ParserNoExceptionCheck(inputC);

        Id expected_image_id = new Id("frame");
        Id expected_object_id = new Id("canvas");
        Id expected_placed_object_id = new Id("orange");
        Position first_position = new Position(expected_placed_object_id, Arrays.asList(-100, -100));
        Position second_position = new Position(expected_placed_object_id, Arrays.asList(5, 5));

        Image expected_image = new Image(expected_object_id, List.of(first_position, second_position));
        Let expected_let = new Let(expected_image_id, expected_image);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(programA, expected_program);
        assertEquals(programB, expected_program);
        assertEquals(programC, expected_program);
    }

    @Test
    public void ObjectOwnsObjectArbitraryTupleTest() {
        String input = "Let crab own apple at (10, 11, 12, 13, 14)";
        Node program = ParserNoExceptionCheck(input);

        Id expected_object_id = new Id("crab");
        Id expected_owned_object_id = new Id("apple");
        List<Integer> expected_ownership_positions = Arrays.asList(10, 11, 12, 13, 14);
        Position expected_position = new Position(expected_owned_object_id, expected_ownership_positions);
        Ownership expected_ownership = new Ownership(List.of(expected_position));
        Let expected_let = new Let(expected_object_id, expected_ownership);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void ObjectOwnsNonexistentObjectTest() {
        String input = "Let crab own nonexistent_object at (0,0)";
        Node program = ParserNoExceptionCheck(input);

        Id expected_object_id = new Id("crab");
        Id expected_owned_object_id = new Id("nonexistent_object");
        List<Integer> expected_ownership_positions = Arrays.asList(0, 0);
        Position expected_position = new Position(expected_owned_object_id, expected_ownership_positions);
        Ownership expected_ownership = new Ownership(List.of(expected_position));
        Let expected_let = new Let(expected_object_id, expected_ownership);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void ObjectOwnsMultipleTest() {
        String inputA = "Let crab owns first_object at (0,   0), and own second_object at (5,5)";
        Node programA = ParserNoExceptionCheck(inputA);

        String inputB = "Let crab own first_object at (0,0) and owns    second_object at (  5,5)";
        Node programB = ParserNoExceptionCheck(inputB);

        String inputC = "Let crab own first_object at (0,0), own second_object at (5,5)";
        Node programC = ParserNoExceptionCheck(inputC);

        Id expected_object_id = new Id("crab");
        Position first_expected_position = new Position(new Id("first_object"), Arrays.asList(0, 0));
        Position second_expected_position = new Position(new Id("second_object"), Arrays.asList(5,5));
        Ownership expected_ownership = new Ownership(List.of(first_expected_position, second_expected_position));
        Let expected_let = new Let(expected_object_id, expected_ownership);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(programA, expected_program);
        assertEquals(programB, expected_program);
        assertEquals(programC, expected_program);
    }

    @Test
    public void ObjectInstantiationThenOwnershipTest() {
        String input = "Let orange be an object with shape = circle, owns another_object at (0,0)";
        ParserYesExceptionCheck(input);
    }

    @Test
    public void ObjectOwnershipThenInstantiationTest() {
        String input = "Let orange own another_object at (0,0), shape = circle";
        ParserYesExceptionCheck(input);
    }

    @Test
    public void ObjectUnsupportedColourTest() {
        String input = "Let orange be an object with colour = cerulean";
        ParserYesExceptionCheck(input);
    }

    @Test
    public void ObjectNegativeSizeTest() {
        String input = "Let orange be an object with size = -9999";
        Node program = ParserNoExceptionCheck(input);

        Id expected_object_id = new Id("orange");
        Size expected_size = new Size(List.of(-9999));
        Object expected_object = new Object(List.of(expected_size));
        Let expected_let = new Let(expected_object_id, expected_object);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void ObjectNegativeOpacityTest() {
        String input = "Let orange be an object with opacity = -9999";
        Node program = ParserNoExceptionCheck(input);

        Id expected_object_id = new Id("orange");
        Opacity expected_size = new Opacity(Double.parseDouble("-9999"));
        Object expected_object = new Object(List.of(expected_size));
        Let expected_let = new Let(expected_object_id, expected_object);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_let));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void AnimateNonexistentImageTest() {
        String input = "ANIMATE frame1 -> frame2 FOR 1 second";
        Node program = ParserNoExceptionCheck(input);

        List<Id> expected_ids = new ArrayList<>(List.of(new Id("frame1"), new Id("frame2")));
        int expected_duration = 1;
        boolean expected_minutes = false;
        Animate expected_animation = new Animate(expected_ids, expected_duration, expected_minutes);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_animation));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void AnimateNegativeTimeTest() {
        String input = "ANIMATE frame1 -> frame2 FOR -1 minutes";
        Node program = ParserNoExceptionCheck(input);

        List<Id> expected_ids = new ArrayList<>(List.of(new Id("frame1"), new Id("frame2")));
        int expected_duration = -1;
        boolean expected_minutes = true;
        Animate expected_animation = new Animate(expected_ids, expected_duration, expected_minutes);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_animation));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void DrawNonexistentImageTest() {
        String input = "DRAW nonexistent_image";
        Node program = ParserNoExceptionCheck(input);

        Id expected_id = new Id("nonexistent_image");
        Draw expected_draw = new Draw(expected_id);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_draw));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void RepeatNegativeTimesTest() {
        String input = "REPEAT DRAW an_image FOR -5";
        Node program = ParserNoExceptionCheck(input);

        Id expected_id = new Id("an_image");
        Draw expected_draw = new Draw(expected_id);

        int expected_repeat_duration = -5;
        Repeat expected_repeat = new Repeat(List.of(expected_draw), expected_repeat_duration);

        List<Expression> expected_expressions = new ArrayList<>(List.of(expected_repeat));
        Program expected_program = new Program(expected_expressions);

        assertEquals(program, expected_program);
    }

    @Test
    public void CurrentFrameAssertionTest() {
        String input = """
                IF $current_frame = some_frame
                    THEN {Let orange be an object with shape = circle
                        Let orange2 be an orange}
                    ELSE {              Let orange be an object with shape = rectangle}
                """;
        Node program = ParserNoExceptionCheck(input);

        FrameAssert frameAssert = new FrameAssert(new Id("some_frame"));
        Id expected_object_id = new Id("orange");
        Object then_orange = new Object(List.of(new Shape("circle")));
        Let then_let = new Let(expected_object_id, then_orange);
        Let then_second_let = new Let(new Id("orange2"), expected_object_id);
        List<Expression> then_exprs = new ArrayList<>(List.of(then_let, then_second_let));
        Object else_orange = new Object(List.of(new Shape("rectangle")));
        Let else_let = new Let(expected_object_id, else_orange);
        List<Expression> else_exprs = new ArrayList<>(List.of(else_let));
        If conditional = new If(frameAssert, then_exprs, else_exprs);

        List<Expression> expected_expressions = new ArrayList<>(List.of(conditional));
        Program expected_program = new Program(expected_expressions);
        assertEquals(program, expected_program);
    }


    @Test
    public void ErroneousInputTest() {
        String input = "Let orange be an object with with with with with shape = circle";
        ParserYesExceptionCheck(input);
    }

    @Test
    public void FullProgramTest() {
        String input = """
                 Let orange1 be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
                 Let orange2 be an orange1
                 Let tree be an object with shape = rectangle, colour = #964b00, size = (10,40)

                 Let canvas be an object with shape = rectangle, colour = (255,255,255, 0.33), size = (100,100)

                 Let tree owns orange1 at (10,30), own orange2 at (50, 50)

                 Let frame1 be an image on canvas placing orange2 at (50,30) and placing tree at (50,0)
                 Let frame2 be an    image    on   canvas    placing    orange2    at    (50, 0, 1) and placing tree at (50,0, 5)

                 IF Assert that orange2 has size = 30
                      THEN    { ANIMATE frame1 -> frame2 -> frame1 FOR 5 seconds }
                      ELSE   {
                      
                      
                      
                      
                      DRAW frame2           }
                """;

        Node program = ParserNoExceptionCheck(input);

        Shape orange1_shape = new Shape("circle");
        Size orange1_size = new Size(List.of(30));
        Colour orange1_colour = new ColourText("orange");
        Rotation orange1_rotation = new Rotation(30, "degrees");
        Object orange1 = new Object(List.of(orange1_shape, orange1_size, orange1_colour, orange1_rotation));
        Id orange1_id = new Id("orange1");
        Let orange1_instantiation = new Let(orange1_id, orange1);

        Id orange2_id = new Id("orange2");
        Let orange2_instantiation = new Let(orange2_id, orange1_id);

        Shape tree_shape = new Shape("rectangle");
        Colour tree_colour = new Hex( "#964b00");
        Size tree_size = new Size(List.of(10, 40));
        Object tree = new Object(List.of(tree_shape, tree_colour, tree_size));
        Id tree_id = new Id("tree");
        Let tree_instantiation = new Let(tree_id, tree);

        Shape canvas_shape = new Shape("rectangle");
        Colour canvas_colour = new RGBA(List.of(255, 255, 255, 0.33));
        Size canvas_size = new Size(List.of(100, 100));
        Object canvas = new Object(List.of(canvas_shape, canvas_colour, canvas_size));
        Id canvas_id = new Id("canvas");
        Let canvas_instantiation = new Let(canvas_id, canvas);

        Position orange1_relative_position = new Position(orange1_id, Arrays.asList(10, 30));
        Position orange2_relative_position = new Position(orange2_id, Arrays.asList(50, 50));
        Ownership expected_ownership = new Ownership(List.of(orange1_relative_position, orange2_relative_position));
        Let tree_ownership = new Let(tree_id, expected_ownership);

        Id frame1_id = new Id("frame1");
        Position frame1_orange2_placement_position = new Position(orange2_id, Arrays.asList(50, 30));
        Position frame1_tree_placement_position = new Position(tree_id, Arrays.asList(50, 0));
        Image frame1_image = new Image(canvas_id, List.of(frame1_orange2_placement_position,
                frame1_tree_placement_position));
        Let frame1 = new Let(frame1_id, frame1_image);

        Id frame2_id = new Id("frame2");
        Position frame2_orange2_placement_position = new Position(orange2_id, Arrays.asList(50, 0, 1));
        Position frame2_tree_placement_position = new Position(tree_id, Arrays.asList(50, 0, 5));
        Image frame2_image = new Image(canvas_id, List.of(frame2_orange2_placement_position,
                frame2_tree_placement_position));
        Let frame2 = new Let(frame2_id, frame2_image);

        ast.Assert assertion = new ast.Assert(orange2_id, orange1_size);
        List<Id> animate_ids = new ArrayList<>(List.of(frame1_id, frame2_id, frame1_id));
        int expected_duration = 5;
        boolean expected_minutes = false;
        Animate then_animate = new Animate(animate_ids, expected_duration, expected_minutes);
        List<Expression> then_exprs = new ArrayList<>(List.of(then_animate));
        Draw else_draw = new Draw(frame2_id);
        List<Expression> else_exprs = new ArrayList<>(List.of(else_draw));
        If conditional = new If(assertion, then_exprs, else_exprs);

        List<Expression> expected_expressions = new ArrayList<>(List.of(orange1_instantiation, orange2_instantiation,
                tree_instantiation, canvas_instantiation, tree_ownership, frame1, frame2, conditional));
        Program expected_program = new Program(expected_expressions);
        assertEquals(program, expected_program);
    }


}