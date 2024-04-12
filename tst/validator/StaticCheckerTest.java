package validator;

import ast.Node;
import ast.Program;
import checker.StaticChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.testng.annotations.Test;
import parser.GraphicalLexer;
import parser.GraphicalParser;
import parser.ParseTreeToAST;

import static org.testng.AssertJUnit.assertEquals;


//import ast;

public class StaticCheckerTest {

    @Test
    public void validASTTest() {
        String input =
                """
                        Let orange1 be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
                        Let orange2 be an orange1
                        Let canvas be an object with shape = rectangle, colour = (255,255,255), size = (100,100)
                        Let frame1 be an image on canvas placing orange2 at (50,30, 0) and placing orange1 at (50,0, 0)
                        """;
        String expectedOutput = "";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker checker = new StaticChecker();

        String output = checker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void undeclaredVariableTest() {
        String input =
                """
                        Let orange1 be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
                        Let orange2 be an orange
                        """;
        String expectedOutput = "orange was not declared\n";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void invalidRGBTest() {
        String input =
                "Let orange1 be an object with shape = circle, size = 30, colour = (124,126,258), rotation = 30 degrees\n";
        String expectedOutput = "B Colour input is invalid. Inputted n, valid values should be in range of: [0, 255].";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void invalidRGBATest() {
        String input =
                "Let orange1 be an object with shape = circle, size = 30, colour = (124,126,258, 0.1), rotation = 30 degrees\n";
        String expectedOutput = "B Colour input is invalid. Inputted n, valid values should be in range of: [0, 255].";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void invalidSizeTest() {
        String input =
                "Let orange1 be an object with shape = circle, size = -30, colour = (124,126,253), rotation = 30 degrees\n";
        String expectedOutput = "Invalid Size Input\n";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void invalidShapeTest() {
        String input =
                "Let orange1 be an object with shape = oval, colour=green \n";
        String expectedOutput = "Invalid Shape Input";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void invalidPositionTest() {
        String input = """ 
                Let orange1 be an object with shape = circle, size = 30
                Let canvas be an object with shape = rectangle, size = (300, 300)
                Let canvas own orange1 at (10, -10)
                """;
        String expectedOutput = "Invalid position input! Need 3 values.";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void multipleErrorsTest() {
        String input =
                """
                        Let orange1 be an object with shape = circle, size = -30, colour = (124,126,253), rotation = 30 degrees
                        Let orange2 be an object with shape = rectangle, size = 50, colour = #91251F
                        Let canvas be an object with colour = (0,0,0), size = (100,100), shape = rectangle
                        Let frame1 be an image on canvas placing orange at (10,40)""";
        String expectedOutput = """
                Invalid Size Input
                Tried to set position of orange when it was not declared
                """;

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void drawUndeclaredTest() {
        String input = "DRAW orange";
        String expectedOutput = "Tried to draw orange when it was not declared\n";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void noShapeGivenTest() {
        String input = "Let orange be an object with size = 30 \n" +
                        "DRAW orange";
        String expectedOutput = "";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void noColourGivenTest() {
        String input = "Let orange be an object with size = 30, shape=circle \n" +
                "DRAW orange";
        String expectedOutput = "";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void undeclaredOwnerTest() {
        String input = "Let orange be an object with size = 30, shape = circle\n" +
                "Let canvas own orange at (30, 50, 0)";
        String expectedOutput = "canvas was not declared\n";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void undeclaredPossessionTest() {
        String input = """
                Let orange be an object with size = 30, shape = circle, colour=orange
                Let canvas be an object with size = (100, 100), shape = rectangle, colour=blue
                Let canvas own orange1 at (30, 50)""";
        String expectedOutput = "Tried to set position of orange1 when it was not declared\n";

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void undeclaredOwnerAndPossessionTest() {
        String input = "Let orange be an object with size = 30, shape = circle, colour=orange\n" +
                "Let canvas own orange1 at (30, 50)";
        String expectedOutput = """
                canvas was not declared
                Tried to set position of orange1 when it was not declared
                """;

        GraphicalLexer lexer  = new GraphicalLexer(CharStreams.fromString(input));
        lexer.reset();
        TokenStream tokens = new CommonTokenStream(lexer);
        GraphicalParser parser = new GraphicalParser(tokens);
        ParseTreeToAST visitor = new ParseTreeToAST();
        Node parsedProgram = parser.program().accept(visitor);

        StaticChecker staticChecker = new StaticChecker();

        String output = staticChecker.checkProgram((Program) parsedProgram);

        assertEquals(expectedOutput, output);
    }
}
