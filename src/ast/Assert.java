package ast;

import java.util.List;
import java.util.Objects;

public class Assert extends BoolClause {
    private final Id id;
    private final ObjectField objectAssignment;

    public Assert(Id id, ObjectField objectAssignments) {
        this.id = id;
        this.objectAssignment = objectAssignments;
    }

    public Id getId() {
        return id;
    }

    public ObjectField getObjectAssignment() {
        return objectAssignment;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assert anAssert = (Assert) o;
        return Objects.equals(id, anAssert.id) && Objects.equals(objectAssignment, anAssert.objectAssignment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objectAssignment);
    }
}
