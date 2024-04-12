package ast;

import java.util.Objects;

public class ColourText extends Colour{
    protected final String colourText;

    public ColourText(String colourText) {
        this.colourText = colourText;
    }

    public String getColourText() {
        return colourText;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColourText that = (ColourText) o;
        return Objects.equals(colourText, that.colourText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colourText);
    }
}
