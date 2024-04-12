package ast.evaluators.util;

import ast.Id;

import java.util.*;

public class ImageFieldsHelper extends PositionMapHelper {
    private final Id backgroundId;
    private final List<Pair<Id, Triple<Integer, Integer, Integer>>> objectPositions;

    public ImageFieldsHelper(Id backgroundId, List<Pair<Id, Triple<Integer, Integer, Integer>>> objectPositions) {
        this.backgroundId = backgroundId;
        this.objectPositions = objectPositions;
    }

    public ImageFieldsHelper(String serialized) {
        String[] parts = serialized.split(";");
        backgroundId = new Id(parts[1]);
        List<Pair<Id, Triple<Integer, Integer, Integer>>> tempHolder = new ArrayList<>();
        for (int i = 2; i < parts.length; i++) {
            String[] objectParts = parts[i].split(",");
            tempHolder.add(new Pair<>(new Id(objectParts[0]),
                    new Triple<>(Integer.parseInt(objectParts[1]), Integer.parseInt(objectParts[2]),
                            Integer.parseInt(objectParts[3]))));
        }
        objectPositions = tempHolder;
    }

    public Id getBackgroundId() {
        return backgroundId;
    }

    public List<Pair<Id, Triple<Integer, Integer, Integer>>> getObjectPositions() {
        return objectPositions;
    }

    public String toScript(Id id, Id backgroundId) {
        StringBuilder sb = new StringBuilder();
        sb.append(id.getName()).append(" = ").append("Frame(").append(backgroundId.getName()).append(", [");
        return StringHelper.getString(sb, objectPositions);
    }

    // Serialize the object to a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FrameFieldsHelper;");
        sb.append(backgroundId.getName());
        ownershipToString(sb, objectPositions);
        return sb.toString();
    }
}
