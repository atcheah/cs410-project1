package lexer;

import org.antlr.v4.runtime.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import parser.GraphicalErrorListener;
import parser.GraphicalLexer;
import parser.exceptions.GraphicalSyntaxException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LexerTest {

    // Checks whether lexer in each test case throws exception or not. (They should not.)
    public void LexerNoExceptionCheck(GraphicalLexer lexer) {
        // Need to create clone of lexer so that our tokens won't have been consumed in the original
        // passed in lexer.
        String lexerInput = lexer.getInputStream().toString();
        GraphicalLexer lexerClone = new GraphicalLexer(CharStreams.fromString(lexerInput));
        lexerClone.addErrorListener(new GraphicalErrorListener());
        try {
            // Fill tokens without consuming.
            lexerClone.getAllTokens();
            // Should fall through.
        } catch (GraphicalSyntaxException e) {
            // Should not go here.
            Assert.fail("Caught Lexer Exception when not expected.");
        }
    }

    // Checks whether lexer in each test case throws exception or not. (They should.)
    public void LexerYesExceptionCheck(GraphicalLexer lexer) {
        // Need to create clone of lexer so that our tokens won't have been consumed in the original
        // passed in lexer.
        String lexerInput = lexer.getInputStream().toString();
        GraphicalLexer lexerClone = new GraphicalLexer(CharStreams.fromString(lexerInput));
        lexerClone.addErrorListener(new GraphicalErrorListener());
        try {
            // Fill tokens without consuming.
            lexerClone.getAllTokens();
            Assert.fail("Failed to catch Lexer Exception.");
        } catch (GraphicalSyntaxException e) {
            // Should get here.
            System.out.println("Successfully Caught exception! \n" + e);
        }
    }

    @Test
    public void SimpleLexerTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let orange2 be an orange1
                """));

        LexerNoExceptionCheck(lexer);

        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(4, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("orange2",tokens.get(1).getText());
        assertEquals("be an ",tokens.get(2).getText());
        assertEquals("orange1",tokens.get(3).getText());
        assertEquals(tokens.get(1).getType(), tokens.get(3).getType());
    }

    @Test
    public void SimpleLexerNoWSTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Letorange2 be anorange1 withshape=circle,size=88
                """));

        LexerNoExceptionCheck(lexer);

        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(10, tokens.size());
        assertEquals("Let",tokens.get(0).getText());
        assertEquals("orange2",tokens.get(1).getText());
        assertEquals("be an",tokens.get(2).getText());
        assertEquals("orange1",tokens.get(3).getText());
        assertEquals("with",tokens.get(4).getText());
        assertEquals("shape=",tokens.get(5).getText());
        assertEquals("circle",tokens.get(6).getText());
        assertEquals(",",tokens.get(7).getText());
        assertEquals("size=",tokens.get(8).getText());
        assertEquals("88",tokens.get(9).getText());
    }
    @Test
    public void SimpleLexerExcessWSTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let      orange2    be      an   orange1
                """));

        LexerNoExceptionCheck(lexer);

        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(4, tokens.size());
        assertEquals("Let      ",tokens.get(0).getText());
        assertEquals("orange2",tokens.get(1).getText());
        assertEquals("be      an   ",tokens.get(2).getText());
        assertEquals("orange1",tokens.get(3).getText());
    }

    @Test
    public void SimpleLexerFieldDefineTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let orange1 be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
                """));
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(16, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("orange1",tokens.get(1).getText());
        assertEquals("be an ",tokens.get(2).getText());
        assertEquals("object",tokens.get(3).getText());
        assertEquals("with ",tokens.get(4).getText());
        assertEquals("shape = ",tokens.get(5).getText());
        assertEquals("circle",tokens.get(6).getText());
        assertEquals(", ",tokens.get(7).getText());
        assertEquals("size = ",tokens.get(8).getText());
        assertEquals("30",tokens.get(9).getText());
        assertEquals(", ",tokens.get(10).getText());
        assertEquals(tokens.get(10).getType(), tokens.get(7).getType());
        assertEquals("30 degrees", tokens.get(15).getText());
    }

    @Test
    public void SimpleLexerAnimateTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                IF Assert that orange2 has size = 30
                THEN ANIMATE frame1 -> frame2 FOR 5 seconds
                ELSE DRAW frame2
                """));
        LexerNoExceptionCheck(lexer);

        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(17, tokens.size());
        assertEquals("IF ",tokens.get(0).getText());
        assertEquals("Assert that ",tokens.get(1).getText());
        assertEquals("orange2",tokens.get(2).getText());
        assertEquals("has ",tokens.get(3).getText());
        assertEquals("size = ",tokens.get(4).getText());
        assertEquals("30",tokens.get(5).getText());
        assertEquals("THEN ",tokens.get(6).getText());
        assertEquals("ANIMATE ",tokens.get(7).getText());
        assertEquals("frame1",tokens.get(8).getText());
        assertEquals("-> ",tokens.get(9).getText());
        assertEquals("frame2",tokens.get(10).getText());
        assertEquals("FOR ",tokens.get(11).getText());
        assertEquals("5",tokens.get(12).getText());
        assertEquals("seconds",tokens.get(13).getText());
        assertEquals("ELSE ",tokens.get(14).getText());
        assertEquals("DRAW ",tokens.get(15).getText());
        assertEquals("frame2",tokens.get(16).getText());

    }

    @Test
    public void ColourModeTupleInputTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let apple be an object with colour = (255, 0, 0)
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(13, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("apple",tokens.get(1).getText());
        assertEquals("be an ",tokens.get(2).getText());
        assertEquals("object",tokens.get(3).getText());
        assertEquals("with ",tokens.get(4).getText());
        assertEquals("colour = ",tokens.get(5).getText());
        assertEquals("(",tokens.get(6).getText());
        assertEquals("255",tokens.get(7).getText());
        assertEquals(", ",tokens.get(8).getText());
        assertEquals("0",tokens.get(9).getText());
        assertEquals(", ",tokens.get(10).getText());
        assertEquals("0",tokens.get(11).getText());
        assertEquals(")",tokens.get(12).getText());
    }

    @Test
    public void ColourModeTupleInputNoWSTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Letapple be anobject withcolour=(255,0,0)
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(13, tokens.size());
        assertEquals("Let",tokens.get(0).getText());
        assertEquals("apple",tokens.get(1).getText());
        assertEquals("be an",tokens.get(2).getText());
        assertEquals("object",tokens.get(3).getText());
        assertEquals("with",tokens.get(4).getText());
        assertEquals("colour=",tokens.get(5).getText());
        assertEquals("(",tokens.get(6).getText());
        assertEquals("255",tokens.get(7).getText());
        assertEquals(",",tokens.get(8).getText());
        assertEquals("0",tokens.get(9).getText());
        assertEquals(",",tokens.get(10).getText());
        assertEquals("0",tokens.get(11).getText());
        assertEquals(")",tokens.get(12).getText());
    }

    @Test
    public void ColourModeTextInputTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let apple be an object with colour = red
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(7, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("apple",tokens.get(1).getText());
        assertEquals("be an ",tokens.get(2).getText());
        assertEquals("object",tokens.get(3).getText());
        assertEquals("with ",tokens.get(4).getText());
        assertEquals("colour = ",tokens.get(5).getText());
        assertEquals("red",tokens.get(6).getText());
    }

    @Test
    public void CircleSizeModeTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab be an object with shape = circle and size = 10
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(10, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("crab",tokens.get(1).getText());
        assertEquals("be an ",tokens.get(2).getText());
        assertEquals("object",tokens.get(3).getText());
        assertEquals("with ",tokens.get(4).getText());
        assertEquals("shape = ",tokens.get(5).getText());
        assertEquals("circle",tokens.get(6).getText());
        assertEquals("and ",tokens.get(7).getText());
        assertEquals("size = ",tokens.get(8).getText());
        assertEquals("10",tokens.get(9).getText());
    }

    @Test
    public void TriangleSizeModeTest() {
        // Assume size = (b, h)
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab be an image with shape = triangle, size = (10, 10)
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(10, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("crab",tokens.get(1).getText());
        assertEquals("be an ",tokens.get(2).getText());
        assertEquals("image",tokens.get(3).getText());
        assertEquals("with ",tokens.get(4).getText());
        assertEquals("shape = ",tokens.get(5).getText());
        assertEquals("triangle",tokens.get(6).getText());
        assertEquals(", ",tokens.get(7).getText());
        assertEquals("size = ",tokens.get(8).getText());
        assertEquals("(10, 10)",tokens.get(9).getText());
    }

    @Test
    public void SimpleObjectOwnsObjectTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab own apple at (10, 10, 1)
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(8, tokens.size());
        assertEquals("Let ",tokens.get(0).getText());
        assertEquals("crab",tokens.get(1).getText());
        assertEquals("own ",tokens.get(2).getText());
        assertEquals("apple",tokens.get(3).getText());
        assertEquals("at ",tokens.get(4).getText());
        assertEquals("(",tokens.get(5).getText());
        assertEquals("10, 10, 1",tokens.get(6).getText());
        assertEquals(")",tokens.get(7).getText());
    }

    @Test
    public void DecimalAndNegativeInputTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let sun be a mesh with shape = circle, opacity = 0.5, shear = -10.0, scale = 9.88
                """));
        LexerNoExceptionCheck(lexer);
        List<? extends Token> tokens = lexer.getAllTokens();
        // Ignore hidden tokens
        tokens.removeIf(t -> t.getChannel() != 0);

        assertEquals(16, tokens.size());
    }

    @Test
    public void SimpleSyntaxErrorTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab own apple at (10, 10, 1) ahoyy mate arr arr.
                """));
        LexerYesExceptionCheck(lexer);
    }

    @Test
    public void LexerOwnPosInputTypeErrorTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab own apple at pizzahut
                """));
        LexerYesExceptionCheck(lexer);
    }

    @Test
    public void LexerRotInputTypeErrorTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab be an image with shape = rectangle and rotation = 30 deg """));
        // deg != (degree|degrees). Should correctly first recognize whitespace between '30' and 'deg'
        // is untokenizable. (WS are not hidden/recognized in ROTATION_MODE)
        LexerYesExceptionCheck(lexer);
    }

    @Test
    public void InvalidFieldAssignmentTest() {
        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
                Let crab be an object with shap = rectangle"""));
        LexerYesExceptionCheck(lexer);
    }

    // Commented out this test since it might be better to check for valid Shape values in
    // our validator (or static checker)
//    @Test
//    public void BadShapeValueTest() {
//        GraphicalLexer lexer = new GraphicalLexer(CharStreams.fromString("""
//                Let crab be an object with shape = avjj
//                """));
//        lexer.addErrorListener(new LexerErrorListener());
//        try {
//            List<? extends Token> tokens = lexer.getAllTokens();
//            Assert.fail("Failed to catch LexerSyntaxException.");
//        } catch (LexerSyntaxException e) {
//            // Should go here.
//            System.out.println("Correctly caught exception: \n" + e);
//        }
//    }
}