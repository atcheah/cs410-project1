package ast;

import java.util.List;
import java.util.Objects;

public class RGB extends Colour {
    protected final int redValue;
    protected final int greenValue;
    protected final int blueValue;

    public RGB(List<Number> rgbValues) {
        this.redValue = (int) rgbValues.get(0);
        this.greenValue = (int) rgbValues.get(1);
        this.blueValue = (int) rgbValues.get(2);
    }

    public int getBlueValue() {
        return blueValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getRedValue() {
        return redValue;
    }


    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    /**
     *
     * @return a string like: (r, g, b)
     */
    @Override
    public String toString() {
        return "(" + redValue + ", " + greenValue + ", " + blueValue + ")";
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RGB rgb = (RGB) o;
        return redValue == rgb.redValue && greenValue == rgb.greenValue && blueValue == rgb.blueValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(redValue, greenValue, blueValue);
    }
}
