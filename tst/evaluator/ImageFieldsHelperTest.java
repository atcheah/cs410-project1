package evaluator;

import ast.*;
import ast.evaluators.util.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ImageFieldsHelperTest {

    private boolean comparePositionList(List<Pair<Id, Triple<Integer, Integer, Integer>>> list1,
                                        List<Pair<Id, Triple<Integer, Integer, Integer>>> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getA().equals(list2.get(i).getA())) {
                return false;
            }
            if (!list1.get(i).getB().equals(list2.get(i).getB())) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testCreateBasic() {
        Id newId = new Id("backgroundId");
        List<Pair<Id, Triple<Integer, Integer, Integer>>> newPositions = new ArrayList<>();
        ImageFieldsHelper newFrame = new ImageFieldsHelper(newId, newPositions);

        assert newFrame.getBackgroundId().equals(newId);
        assert comparePositionList(newFrame.getObjectPositions(), newPositions);
    }

    @Test
    public void testCreateComplex() {
        Id newId = new Id("backgroundId");
        List<Pair<Id, Triple<Integer, Integer, Integer>>> newPositions = new ArrayList<>();
        newPositions.add(new Pair<>(new Id("test2"), new Triple<>(1, 2, 3)));
        newPositions.add(new Pair<>(new Id("test3"), new Triple<>(4, 5, 6)));
        ImageFieldsHelper newFrame = new ImageFieldsHelper(newId, newPositions);

        assert newFrame.getBackgroundId().equals(newId);
        assert comparePositionList(newFrame.getObjectPositions(), newPositions);
    }

    @Test
    public void testToString() {
        Id newId = new Id("backgroundId");
        List<Pair<Id, Triple<Integer, Integer, Integer>>> newPositions = new ArrayList<>();
        newPositions.add(new Pair<>(new Id("test2"), new Triple<>(1, 2, 3)));
        newPositions.add(new Pair<>(new Id("test3"), new Triple<>(4, 5, 6)));
        ImageFieldsHelper newFrame = new ImageFieldsHelper(newId, newPositions);

        String expected = "FrameFieldsHelper;backgroundId;test2,1,2,3;test3,4,5,6";
        String output = newFrame.toString();
        assertEquals(expected, output);
    }

    @Test
    public void testFromString() {
        String input = "FrameFieldsHelper;backgroundId;test2,1,2,3;test3,4,5,6";
        ImageFieldsHelper newFrame = new ImageFieldsHelper(input);

        Id newId = new Id("backgroundId");
        List<Pair<Id, Triple<Integer, Integer, Integer>>> newPositions = new ArrayList<>();
        newPositions.add(new Pair<>(new Id("test2"), new Triple<>(1, 2, 3)));
        newPositions.add(new Pair<>(new Id("test3"), new Triple<>(4, 5, 6)));
        ImageFieldsHelper expected = new ImageFieldsHelper(newId, newPositions);

        System.out.println(newFrame);
        assert newFrame.getBackgroundId().equals(expected.getBackgroundId());
        assert comparePositionList(newFrame.getObjectPositions(), newPositions);
    }

    @Test
    public void testToScript() {
        Id newId = new Id("backgroundId");

        List<Pair<Id, Triple<Integer, Integer, Integer>>> newPositions = new ArrayList<>();
        newPositions.add(new Pair<>(new Id("test2"), new Triple<>(1, 2, 6)));
        newPositions.add(new Pair<>(new Id("test3"), new Triple<>(4, 5, 2)));
        ImageFieldsHelper newFrame = new ImageFieldsHelper(newId, newPositions);

        String expected = "frame = Frame(canvas, [(test2, (1, 2, 6)),(test3, (4, 5, 2)),])\n";
        String output = newFrame.toScript(new Id("frame"), new Id("canvas"));
        assertEquals(expected, output);
    }
}
