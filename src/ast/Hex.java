package ast;

import java.util.Objects;

public class Hex extends Colour {
    private final String hexValue;
    public Hex(String hexValue) {
        this.hexValue = hexValue;
    }

    public String getHexValue() {
        return hexValue;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hex hex = (Hex) o;
        return Objects.equals(hexValue, hex.hexValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hexValue);
    }
}
