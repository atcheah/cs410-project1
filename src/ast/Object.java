package ast;

import java.util.List;
import java.util.Objects;

public class Object extends Statement {
    private final List<ObjectField> objects;

    public Object(List<ObjectField> object_assignment) {
        this.objects = object_assignment;
    }

    public List<ObjectField> getObject() {
        return objects;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Object object = (Object) o;
        return Objects.equals(objects, object.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }
}
