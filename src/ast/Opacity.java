package ast;

import java.util.Objects;

public class Opacity extends ObjectField {

    private final double opacity;

    public Opacity(double op) {
        this.opacity = op;
    }

    public double getOpacity() {
        return opacity;
    }

    @Override
    public <C, T> T accept(C context, GraphicalParserVisitor<C, T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opacity opacity1 = (Opacity) o;
        return Double.compare(opacity1.opacity, opacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(opacity);
    }
}
