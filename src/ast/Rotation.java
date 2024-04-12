package ast;

import java.util.Objects;

public class Rotation extends ObjectField {
    private final int rotation;
    private final String rotation_unit;

    public Rotation(int rotation, String rotation_unit) {
        this.rotation = rotation;
        this.rotation_unit = rotation_unit;
    }

    public int getRotation() {
        return rotation;
    }

    public String getRotation_unit() {
        return rotation_unit;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public String toString() {
        return "(" + rotation + "," + rotation_unit + ")";
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rotation rotation1 = (Rotation) o;
        return rotation == rotation1.rotation && Objects.equals(rotation_unit, rotation1.rotation_unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rotation, rotation_unit);
    }
}
