package ast.evaluators.util;

import ast.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectFieldsHelper extends PositionMapHelper {
    private String colour; // always convert on getter to HEX i.e. #FFFFFF.
    private String shape;
    private int size_x = 1;
    private int size_y = 1;
    private double opacity = 1.0;
    private int rotation = 0; // degrees
    private int shear_x = 0;
    private int shear_y = 0;
    private int scale_x = 1;
    private int scale_y = 1;
    private List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList = new ArrayList<>();

    public ObjectFieldsHelper() {
    }

    public ObjectFieldsHelper(String serialized) {
        String[] parts = serialized.split(";");
        colour = parts[1].equals("null") ? null : parts[1];
        shape = parts[2].equals("null") ? null : parts[2];
        size_x = Integer.parseInt(parts[3]);
        size_y = Integer.parseInt(parts[4]);
        opacity = Double.parseDouble(parts[5]);
        rotation = Integer.parseInt(parts[6]);
        shear_x = Integer.parseInt(parts[7]);
        shear_y = Integer.parseInt(parts[8]);
        scale_x = Integer.parseInt(parts[9]);
        scale_y = Integer.parseInt(parts[10]);
        for (int i = 11; i < parts.length; i++) {
            String[] objectParts = parts[i].split(",");
            ownershipList.add(new Pair<>(new Id(objectParts[0]),
                    new Triple<>(Integer.parseInt(objectParts[1]), Integer.parseInt(objectParts[2]),
                            Integer.parseInt(objectParts[3]))));
        }
    }

    public ObjectFieldsHelper(ObjectFieldsHelper pastFields, ObjectFieldsHelper newFields) {
        // take the past fields and the new fields and merge them
        colour = newFields.colour != null ? newFields.colour : pastFields.colour;
        shape = newFields.shape != null ? newFields.shape : pastFields.shape;
        size_x = newFields.size_x != 1 ? newFields.size_x : pastFields.size_x;
        size_y = newFields.size_y != 1 ? newFields.size_y : pastFields.size_y;
        opacity = newFields.opacity != 1 ? newFields.opacity : pastFields.opacity;
        rotation = newFields.rotation != 0 ? newFields.rotation : pastFields.rotation;
        shear_x = newFields.shear_x != 0 ? newFields.shear_x : pastFields.shear_x;
        shear_y = newFields.shear_y != 0 ? newFields.shear_y : pastFields.shear_y;
        scale_x = newFields.scale_x != 1 ? newFields.scale_x : pastFields.scale_x;
        scale_y = newFields.scale_y != 1 ? newFields.scale_y : pastFields.scale_y;
        // ownershipList.addAll(pastFields.ownershipList); ownership shouldn't be
        // inherited otherwise you can't ever clear it
        ownershipList.addAll(newFields.ownershipList);
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        // Convert to HEX
        this.colour = convertColour(colour);
    }

    static public String convertColour(String colour) {
        return switch (colour) {
            case "red" -> "#FF0000";
            case "black" -> "#000000";
            case "blue" -> "#0000FF";
            case "brown" -> "#6F4E37";
            case "grey", "gray" -> "#808080";
            case "green" -> "#008000";
            case "orange" -> "#FFA500";
            case "pink" -> "#FFC0CB";
            case "purple" -> "#800080";
            case "yellow" -> "#FFFF00";
            default -> "#FFFFFF"; // white is default, should never have nonsense colour anyway
        };
    }

    public void setHexColour(String hexColour) {
        this.colour = hexColour;
    }

    public void setRGBColour(String rgbColour) {
        this.colour = convertRGBColour(rgbColour);
    }

    static public String convertRGBColour(String rgbColour) {
        // (255, 255, 255) convert to HEX
        String[] parts = rgbColour.split(",");
        return String.format("#%02X%02X%02X", Integer.parseInt(parts[0].split("\\(")[1]),
                Integer.parseInt(parts[1].trim()),
                Integer.parseInt(parts[2].split("\\)")[0].trim()));
    }

    public void setRGBAColour(String rgbaColour) {
        Pair<String, Double> rgbaValues = convertRGBAColour(rgbaColour);
        this.colour = rgbaValues.getA();
        this.opacity = rgbaValues.getB();
    }

    static public Pair<String, Double> convertRGBAColour(String rgbaColour) {
        // (255, 255, 255, 100) convert to HEX
        String[] parts = rgbaColour.split(",");
        String colour = String.format("#%02X%02X%02X", Integer.parseInt(parts[0].split("\\(")[1]),
                Integer.parseInt(parts[1].trim()),
                Integer.parseInt(parts[2].trim()));
        Double opacity = Double.parseDouble(parts[3].split("\\)")[0].trim());
        return new Pair<>(colour, opacity);
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }

    public void setSize(String size) {
        // (1, 1) or (1)
        if (!size.contains(",")) {
            this.size_x = Integer.parseInt(size.split("\\(")[1].split("\\)")[0]);
            this.size_y = this.size_x;
            return;
        }
        this.size_x = Integer.parseInt(size.split(",")[0].split("\\(")[1]);
        this.size_y = Integer.parseInt(size.split(",")[1].split("\\)")[0].trim());
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public void setOpacity(String opacity) {
        this.opacity = Double.parseDouble(opacity);
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public void setRotation(String rotation) {
        // (0, degrees) or (1, radians)
        String[] rotationSplits = rotation.split(",");
        String[] moreSplits = rotationSplits[0].split("\\(");
        String rotationAmount = moreSplits[1];
        this.rotation = Integer.parseInt(rotationAmount);
        if (rotation.contains("radians")) {
            this.rotation = (int) Math.toDegrees(this.rotation);
        }
    }

    public int getShear_x() {
        return shear_x;
    }

    public void setShear_x(int shear_x) {
        this.shear_x = shear_x;
    }

    public int getShear_y() {
        return shear_y;
    }

    public void setShear_y(int shear_y) {
        this.shear_y = shear_y;
    }

    public void setShear(String shear) {
        // (1, 1)
        this.shear_x = Integer.parseInt(shear.split(",")[0].split("\\(")[1]);
        this.shear_y = Integer.parseInt(shear.split(",")[1].split("\\)")[0].trim());
    }

    public int getScale_x() {
        return scale_x;
    }

    public void setScale_x(int scale_x) {
        this.scale_x = scale_x;
    }

    public void setScale(String scale) {
        // (1, 1) or (1)
        this.scale_x = Integer.parseInt(scale.split(",")[0].split("\\(")[1]);
        this.scale_y = Integer.parseInt(scale.split(",")[1].split("\\)")[0].trim());
    }

    public int getScale_y() {
        return scale_y;
    }

    public void setScale_y(int scale_y) {
        this.scale_y = scale_y;
    }

    public List<Pair<Id, Triple<Integer, Integer, Integer>>> getOwnershipList() {
        return ownershipList;
    }

    public void setOwnershipList(List<Pair<Id, Triple<Integer, Integer, Integer>>> ownershipList) {
        this.ownershipList = ownershipList;
    }

    public String toScript(Id id) {
        StringBuilder sb = new StringBuilder();
        sb.append(id.getName()).append(" = ").append("Object(\"");
        sb.append(colour == null ? "#FFFFFF" : colour).append("\", \"");
        sb.append(shape == null ? "rectangle" : shape).append("\", ");
        sb.append("(").append(size_x).append(", ").append(size_y).append("), ");
        sb.append(colour == null ? "0.0" : opacity).append(", ");
        sb.append(rotation).append(", ");
        sb.append("(").append(shear_x).append(", ").append(shear_y).append("), ");
        sb.append("(").append(scale_x).append(", ").append(scale_y).append("), [");
        return StringHelper.getString(sb, ownershipList);
    }

    // If object previously exists, to script behaves differently
    public String toScript(Id id, ObjectFieldsHelper pastFields) {
        // If the object previously existed, only write the fields that have changed
        StringBuilder sb = new StringBuilder();
        sb.append(id.getName()).append(" = ").append("Object(");
        sb.append(Objects.equals(pastFields.colour, colour) ? id.getName() + ".colour" : "\"" + colour + "\"")
                .append(", ");
        sb.append(Objects.equals(pastFields.shape, shape) ? id.getName() + ".shape" : "\"" + shape + "\"").append(", ");
        if (pastFields.size_x == size_x && pastFields.size_y == size_y) {
            sb.append(id.getName()).append(".size, ");
        } else {
            sb.append("(").append(size_x).append(", ").append(size_y).append("), ");
        }
        sb.append(pastFields.opacity == opacity ? id.getName() + ".opacity" : opacity).append(", ");
        sb.append(pastFields.rotation == rotation ? id.getName() + ".rotation" : rotation).append(", ");
        if (pastFields.shear_x == shear_x && pastFields.shear_y == shear_y) {
            sb.append(id.getName()).append(".shear, ");
        } else {
            sb.append("(").append(shear_x).append(", ").append(shear_y).append("), ");
        }
        if (pastFields.scale_x == scale_x && pastFields.scale_y == scale_y) {
            sb.append(id.getName()).append(".scale, [");
        } else {
            sb.append("(").append(scale_x).append(", ").append(scale_y).append("), [");
        }
        return StringHelper.getString(sb, ownershipList);
    }

    // Serialize the object to a string, even though some fields may not be
    // initialized
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectFieldsHelper;");
        sb.append(colour);
        sb.append(";");
        sb.append(shape);
        sb.append(";");
        sb.append(size_x);
        sb.append(";");
        sb.append(size_y);
        sb.append(";");
        sb.append(opacity);
        sb.append(";");
        sb.append(rotation);
        sb.append(";");
        sb.append(shear_x);
        sb.append(";");
        sb.append(shear_y);
        sb.append(";");
        sb.append(scale_x);
        sb.append(";");
        sb.append(scale_y);
        ownershipToString(sb, ownershipList);
        return sb.toString();
    }
}
