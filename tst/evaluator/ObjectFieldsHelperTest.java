package evaluator;

import ast.Id;
import ast.evaluators.util.ObjectFieldsHelper;

import java.util.ArrayList;
import java.util.List;

import ast.evaluators.util.Pair;
import ast.evaluators.util.Triple;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ObjectFieldsHelperTest {

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
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();

        // check default values
        assert newObject.getColour() == null;
        assert newObject.getShape() == null;
        assert newObject.getSize_x() == 1;
        assert newObject.getSize_y() == 1;
        assert newObject.getOpacity() == 1.0;
        assert newObject.getRotation() == 0;
        assert newObject.getShear_x() == 0;
        assert newObject.getShear_y() == 0;
        assert newObject.getScale_x() == 1;
        assert newObject.getScale_y() == 1;
        assert newObject.getOwnershipList().isEmpty();
    }

    @Test
    public void testSetterCreation() {
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();

        String setColour = "black";
        newObject.setColour(setColour);

        String setShape = "circle";
        newObject.setShape(setShape);

        int setSize_x = 10;
        newObject.setSize_x(setSize_x);

        int setSize_y = 20;
        newObject.setSize_y(setSize_y);

        double opacity = 0.5;
        newObject.setOpacity(opacity);

        int rotation = 90;
        newObject.setRotation(rotation);

        int shear_x = 45;
        newObject.setShear_x(shear_x);

        int shear_y = 45;
        newObject.setShear_y(shear_y);

        int scale_x = 2;
        newObject.setScale_x(scale_x);

        int scale_y = 2;
        newObject.setScale_y(scale_y);

        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 3)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 6))));
        newObject.setOwnershipList(ownershipList);

        assert newObject.getColour().equals("#000000"); // "black" -> "#000000"
        assert newObject.getShape().equals(setShape);
        assert newObject.getSize_x() == setSize_x;
        assert newObject.getSize_y() == setSize_y;
        assert newObject.getOpacity() == opacity;
        assert newObject.getRotation() == rotation;
        assert newObject.getShear_x() == shear_x;
        assert newObject.getShear_y() == shear_y;
        assert newObject.getScale_x() == scale_x;
        assert newObject.getScale_y() == scale_y;
        assert comparePositionList(newObject.getOwnershipList(), ownershipList);
    }

    @Test
    public void testToStringNoOwner() {
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();
        String setColour = "black";
        newObject.setColour(setColour);
        String setShape = "circle";
        newObject.setShape(setShape);
        int setSize_x = 10;
        newObject.setSize_x(setSize_x);
        int setSize_y = 20;
        newObject.setSize_y(setSize_y);
        double opacity = 0.5;
        newObject.setOpacity(opacity);
        int rotation = 90;
        newObject.setRotation(rotation);
        int shear_x = 45;
        newObject.setShear_x(shear_x);
        int shear_y = 45;
        newObject.setShear_y(shear_y);
        int scale_x = 2;
        newObject.setScale_x(scale_x);
        int scale_y = 2;
        newObject.setScale_y(scale_y);

        String expected = "ObjectFieldsHelper;#000000;circle;10;20;0.5;90;45;45;2;2";
        String actual = newObject.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringOwner() {
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();
        String setColour = "black";
        newObject.setColour(setColour);
        String setShape = "circle";
        newObject.setShape(setShape);
        int setSize_x = 10;
        newObject.setSize_x(setSize_x);
        int setSize_y = 20;
        newObject.setSize_y(setSize_y);
        double opacity = 0.5;
        newObject.setOpacity(opacity);
        int rotation = 90;
        newObject.setRotation(rotation);
        int shear_x = 45;
        newObject.setShear_x(shear_x);
        int shear_y = 45;
        newObject.setShear_y(shear_y);
        int scale_x = 2;
        newObject.setScale_x(scale_x);
        int scale_y = 2;
        newObject.setScale_y(scale_y);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 3)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 6))));
        newObject.setOwnershipList(ownershipList);

        String expected = "ObjectFieldsHelper;#000000;circle;10;20;0.5;90;45;45;2;2;test1,1,2,3;test2,4,5,6";
        String actual = newObject.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testFromString() {
        ObjectFieldsHelper newObject = new ObjectFieldsHelper(
                "ObjectFieldsHelper;#000000;circle;10;20;0.5;90;45;45;2;2;test1,1,2,3;test2,4,5,6");

        assert newObject.getColour().equals("#000000");
        assert newObject.getShape().equals("circle");
        assert newObject.getSize_x() == 10;
        assert newObject.getSize_y() == 20;
        assert newObject.getOpacity() == 0.5;
        assert newObject.getRotation() == 90;
        assert newObject.getShear_x() == 45;
        assert newObject.getShear_y() == 45;
        assert newObject.getScale_x() == 2;
        assert newObject.getScale_y() == 2;
        assert comparePositionList(newObject.getOwnershipList(),
                new ArrayList<>(
                        List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 3)),
                                new Pair<>(new Id("test2"), new Triple<>(4, 5, 6)))));
    }

    @Test
    public void testFromPastObjectIgnore() {
        ObjectFieldsHelper pastObject = new ObjectFieldsHelper(
                "ObjectFieldsHelper;#000000;circle;10;20;0.5;90;45;45;2;2;test1,1,2,3;test2,4,5,6");
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();
        ObjectFieldsHelper mergedObject = new ObjectFieldsHelper(pastObject, newObject);

        assert mergedObject.getColour().equals("#000000");
        assert mergedObject.getShape().equals("circle");
        assert mergedObject.getSize_x() == 10;
        assert mergedObject.getSize_y() == 20;
        assert mergedObject.getOpacity() == 0.5;
        assert mergedObject.getRotation() == 90;
        assert mergedObject.getShear_x() == 45;
        assert mergedObject.getShear_y() == 45;
        assert mergedObject.getScale_x() == 2;
        assert mergedObject.getScale_y() == 2;
        assert comparePositionList(mergedObject.getOwnershipList(),
                new ArrayList<>());
    }

    @Test
    public void testFromPastObjectUpdate() {
        ObjectFieldsHelper pastObject = new ObjectFieldsHelper(
                "ObjectFieldsHelper;#000000;circle;10;20;0.5;90;45;45;2;2");

        ObjectFieldsHelper newObject = new ObjectFieldsHelper();
        newObject.setShape("rectangle");
        newObject.setColour("blue");
        newObject.setSize_x(30);
        newObject.setScale_x(3);
        newObject.setOwnershipList(new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 3)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 6)))));

        ObjectFieldsHelper mergedObject = new ObjectFieldsHelper(pastObject, newObject);
        assert mergedObject.getColour().equals("#0000FF");
        assert mergedObject.getShape().equals("rectangle");
        assert mergedObject.getSize_x() == 30;
        assert mergedObject.getSize_y() == 20;
        assert mergedObject.getOpacity() == 0.5;
        assert mergedObject.getRotation() == 90;
        assert mergedObject.getShear_x() == 45;
        assert mergedObject.getShear_y() == 45;
        assert mergedObject.getScale_x() == 3;
        assert mergedObject.getScale_y() == 2;
        assert comparePositionList(mergedObject.getOwnershipList(),
                new ArrayList<>(
                        List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 3)),
                                new Pair<>(new Id("test2"), new Triple<>(4, 5, 6)))));
    }

    @Test
    public void testSetColourTypes() {
        ObjectFieldsHelper object = new ObjectFieldsHelper();
        // setColour with colour name (for coverage)
        object.setColour("red");
        assert object.getColour().equals("#FF0000");
        object.setColour("black");
        assert object.getColour().equals("#000000");
        object.setColour("blue");
        assert object.getColour().equals("#0000FF");
        object.setColour("brown");
        assert object.getColour().equals("#6F4E37");
        object.setColour("gray");
        assert object.getColour().equals("#808080");
        object.setColour("grey");
        assert object.getColour().equals("#808080");
        object.setColour("green");
        assert object.getColour().equals("#008000");
        object.setColour("orange");
        assert object.getColour().equals("#FFA500");
        object.setColour("pink");
        assert object.getColour().equals("#FFC0CB");
        object.setColour("purple");
        assert object.getColour().equals("#800080");
        object.setColour("white");
        assert object.getColour().equals("#FFFFFF");
        object.setColour("yellow");
        assert object.getColour().equals("#FFFF00");

        // setColour with nonsense
        object.setColour("nonsense");
        assert object.getColour().equals("#FFFFFF");

        // setHexColour
        object.setHexColour("#FF0000");
        assert object.getColour().equals("#FF0000");
        object.setHexColour("#000000");
        assert object.getColour().equals("#000000");
        object.setHexColour("#0000FF");
        assert object.getColour().equals("#0000FF");

        // setRGBColour
        object.setRGBColour("(255, 0, 0)");
        assert object.getColour().equals("#FF0000");
        object.setRGBColour("(0, 0, 0)");
        assert object.getColour().equals("#000000");
        object.setRGBColour("(0, 0, 255)");
        assert object.getColour().equals("#0000FF");
        object.setRGBColour("(255, 255, 255)");
        assert object.getColour().equals("#FFFFFF");
        object.setRGBColour("(47, 79, 79)");
        assert object.getColour().equals("#2F4F4F");
        object.setRGBColour("(0, 128, 0)");
        assert object.getColour().equals("#008000");

        // setRGBAColour
        object.setRGBAColour("(255, 0, 0, 0.5)");
        assert object.getColour().equals("#FF0000");
        assert object.getOpacity() == 0.5;
        object.setRGBAColour("(0, 0, 0, 0.9)");
        assert object.getColour().equals("#000000");
        assert object.getOpacity() == 0.9;
        object.setRGBAColour("(0, 0, 255, 0.0)");
        assert object.getColour().equals("#0000FF");
        assert object.getOpacity() == 0.0;
        object.setRGBAColour("(255, 255, 255, 0.1)");
        assert object.getColour().equals("#FFFFFF");
        assert object.getOpacity() == 0.1;
    }

    @Test
    public void testSetFieldsFromString() {
        ObjectFieldsHelper object = new ObjectFieldsHelper();
        object.setSize("(30, 40)");
        assert object.getSize_x() == 30;
        assert object.getSize_y() == 40;
        object.setOpacity("0.5");
        assert object.getOpacity() == 0.5;
        object.setRotation("(90, degrees)");
        assert object.getRotation() == 90;
        object.setRotation("(1, radians)");
        assert object.getRotation() == 57;
        object.setShear("(45, 45)");
        assert object.getShear_x() == 45;
        assert object.getShear_y() == 45;
        object.setScale("(3, 4)");
        assert object.getScale_x() == 3;
        assert object.getScale_y() == 4;
    }

    @Test
    public void testRectangleToScript() {
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();
        newObject.setShape("rectangle");
        newObject.setColour("blue");
        newObject.setSize_x(30);
        newObject.setSize_y(40);
        newObject.setOpacity(0.5);
        newObject.setRotation(90);
        newObject.setShear_x(45);
        newObject.setShear_y(45);
        newObject.setScale_x(3);
        newObject.setScale_y(4);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 6)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 3))));
        newObject.setOwnershipList(ownershipList);

        String expected = "object = Object(\"#0000FF\", \"rectangle\", (30, 40), 0.5, 90, (45, 45), (3, 4), [(test1, (1, 2, 6)),(test2, (4, 5, 3)),])\n";
        String actual = newObject.toScript(new Id("object"));
        assertEquals(expected, actual);
    }

    @Test
    public void testCircleToScript() {
        ObjectFieldsHelper newObject = new ObjectFieldsHelper();
        newObject.setShape("circle");
        newObject.setColour("blue");
        newObject.setSize_x(30);
        newObject.setSize_y(40);
        newObject.setOpacity(0.5);
        newObject.setRotation(90);
        newObject.setShear_x(45);
        newObject.setShear_y(45);
        newObject.setScale_x(3);
        newObject.setScale_y(4);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 6)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 3))));
        newObject.setOwnershipList(ownershipList);

        String expected = "object = Object(\"#0000FF\", \"circle\", (30, 40), 0.5, 90, (45, 45), (3, 4), [(test1, (1, 2, 6)),(test2, (4, 5, 3)),])\n";
        String actual = newObject.toScript(new Id("object"));
        assertEquals(expected, actual);
    }

    @Test
    public void testTriangleToScript() {
        ObjectFieldsHelper objectFieldsHelper = new ObjectFieldsHelper();
        objectFieldsHelper.setShape("triangle");
        objectFieldsHelper.setColour("blue");
        objectFieldsHelper.setSize_x(30);
        objectFieldsHelper.setSize_y(40);
        objectFieldsHelper.setOpacity(0.5);
        objectFieldsHelper.setRotation(90);
        objectFieldsHelper.setShear_x(45);
        objectFieldsHelper.setShear_y(45);
        objectFieldsHelper.setScale_x(3);
        objectFieldsHelper.setScale_y(4);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 6)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 3))));
        objectFieldsHelper.setOwnershipList(ownershipList);

        String expected = "object = Object(\"#0000FF\", \"triangle\", (30, 40), 0.5, 90, (45, 45), (3, 4), [(test1, (1, 2, 6)),(test2, (4, 5, 3)),])\n";
        String actual = objectFieldsHelper.toScript(new Id("object"));
        assertEquals(expected, actual);
    }

    @Test
    public void testSquareToScript() {
        ObjectFieldsHelper objectFieldsHelper = new ObjectFieldsHelper();
        objectFieldsHelper.setShape("square");
        objectFieldsHelper.setColour("blue");
        objectFieldsHelper.setSize_x(30);
        objectFieldsHelper.setSize_y(40);
        objectFieldsHelper.setOpacity(0.5);
        objectFieldsHelper.setRotation(90);
        objectFieldsHelper.setShear_x(45);
        objectFieldsHelper.setShear_y(45);
        objectFieldsHelper.setScale_x(3);
        objectFieldsHelper.setScale_y(4);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 6)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 3))));
        objectFieldsHelper.setOwnershipList(ownershipList);

        String expected = "object = Object(\"#0000FF\", \"square\", (30, 40), 0.5, 90, (45, 45), (3, 4), [(test1, (1, 2, 6)),(test2, (4, 5, 3)),])\n";
        String actual = objectFieldsHelper.toScript(new Id("object"));
        assertEquals(expected, actual);
    }

    @Test
    public void testLineToScript() {
        ObjectFieldsHelper objectFieldsHelper = new ObjectFieldsHelper();
        objectFieldsHelper.setShape("line");
        objectFieldsHelper.setColour("blue");
        objectFieldsHelper.setSize_x(30);
        objectFieldsHelper.setSize_y(40);
        objectFieldsHelper.setOpacity(0.5);
        objectFieldsHelper.setRotation(90);
        objectFieldsHelper.setShear_x(45);
        objectFieldsHelper.setShear_y(45);
        objectFieldsHelper.setScale_x(3);
        objectFieldsHelper.setScale_y(4);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>(
                List.of(new Pair<>(new Id("test1"), new Triple<>(1, 2, 6)),
                        new Pair<>(new Id("test2"), new Triple<>(4, 5, 3))));
        objectFieldsHelper.setOwnershipList(ownershipList);

        String expected = "object = Object(\"#0000FF\", \"line\", (30, 40), 0.5, 90, (45, 45), (3, 4), [(test1, (1, 2, 6)),(test2, (4, 5, 3)),])\n";
        String actual = objectFieldsHelper.toScript(new Id("object"));
        assertEquals(expected, actual);
    }

}
