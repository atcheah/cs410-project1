package ast;

import java.util.List;
import java.util.Objects;

public class Ownership extends Config {
    private final List<Position> possessionsPositions;

    public Ownership(List<Position> possessionsPositions) {
        this.possessionsPositions = possessionsPositions;
    }

    public List<Position> getPositions() {
        return possessionsPositions;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ownership ownership = (Ownership) o;
        return Objects.equals(possessionsPositions, ownership.possessionsPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possessionsPositions);
    }
}
