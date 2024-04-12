package ast.evaluators.util;

import ast.Id;

import java.util.List;

public class StringHelper {
    // turns list of integers into string like so (1,2,3,4)
    public static String getString(List<Integer> integers) {
        StringBuilder ret = new StringBuilder("(");
        for (Integer integer : integers) {
            ret.append(integer).append(",");
        }
        ret.deleteCharAt(ret.length() - 1);
        ret.append(")");
        return ret.toString();
    }

    static String getString(StringBuilder sb, List<Pair<Id, Triple<Integer, Integer, Integer>>> entries) {
        for (Pair<Id, Triple<Integer, Integer, Integer>> entry : entries) {
            sb.append("(").append(entry.getA().getName()).append(", (")
                    .append(entry.getB().getA()).append(", ")
                    .append(entry.getB().getB()).append(", ")
                    .append(entry.getB().getC()).append(")),");
        }
        sb.append("])\n");

        return sb.toString();
    }
}
