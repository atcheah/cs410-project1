package ast;

import java.util.List;
import java.util.Objects;

public class RGBA extends RGB {
    private final double alphaValue;

    public RGBA(List<Number> values) {
        super(values);
        this.alphaValue = (double) values.get(3);
    }

    public double getAlphaValue() {
        return alphaValue;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    /**
     *
     * @return a string like: (r, g, b, a)
     */
    @Override
    public String toString() {
        return "(" + redValue + ", " + greenValue + ", " + blueValue + ", " + alphaValue + ")";
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RGBA rgba = (RGBA) o;
        return Double.compare(rgba.alphaValue, alphaValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), alphaValue);
    }
}
