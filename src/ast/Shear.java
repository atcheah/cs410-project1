package ast;

import java.util.ArrayList;
import java.util.List;

import static ast.evaluators.util.StringHelper.getString;

public class Shear extends ObjectField{
    private final List<Integer> dimensions;

    public Shear(List<Integer> dimensions) {
        this.dimensions = dimensions;
    }

    public List<Integer> getDimensions() {
        return dimensions;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    public String toString() {
        return getString(dimensions);
    }
}
