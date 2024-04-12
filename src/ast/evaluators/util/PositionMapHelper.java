package ast.evaluators.util;

import ast.Id;

import java.util.List;
import java.util.Map;

public class PositionMapHelper {

    public void ownershipToString(StringBuilder sb, List<Pair<Id, Triple<Integer, Integer, Integer>>> positions) {
        for (Pair<Id, Triple<Integer, Integer, Integer>> entry : positions) {
            sb.append(";");
            sb.append(entry.getA().getName());
            sb.append(",");
            sb.append(entry.getB().getA());
            sb.append(",");
            sb.append(entry.getB().getB());
            sb.append(",");
            sb.append(entry.getB().getC());
        }
    }
}
