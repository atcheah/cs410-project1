package ast;

import java.util.Objects;

public class Draw extends Function {
    private final Id id;

    public Draw(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Draw draw = (Draw) o;
        return Objects.equals(id, draw.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
