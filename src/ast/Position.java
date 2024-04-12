package ast;

import ast.evaluators.util.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Position extends Expression {
    private final Id id;
    private final List<Integer> values;

    public Position(Id id, List<Integer> dimensions) {
        this.id = id;
        this.values = dimensions;
    }

    public Id getId() {
        return id;
    }

    public List<Integer> getValues() {
        return values;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public String toString() {
        return "(" + id.getName() + "," + StringHelper.getString(values) + ")";
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(id, position.id) && Objects.equals(values, position.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, values);
    }
}
