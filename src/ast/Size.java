package ast;

import ast.evaluators.util.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Size extends ObjectField {
    private final List<Integer> size_tuple;

    public Size(List<Integer> size_tuple) {
        this.size_tuple = size_tuple;
    }

    public List<Integer> getSize_tuple() {
        return size_tuple;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    public String toString() {
        return StringHelper.getString(size_tuple);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Size size = (Size) o;
        return Objects.equals(size_tuple, size.size_tuple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size_tuple);
    }
}
