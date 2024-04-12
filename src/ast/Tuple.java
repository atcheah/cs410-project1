package ast;

import java.util.List;

import static ast.evaluators.util.StringHelper.getString;

public class Tuple extends ObjectField {
    private final List<Integer> integers;

    public Tuple(List<Integer> dimensions) {
        this.integers = dimensions;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    @Override
    public <C, T> T accept(C context, GraphicalParserVisitor<C, T> v) {
        return v.visit(context, this);
    }

    @Override
    public String toString() {
        return getString(integers);
    }
}
