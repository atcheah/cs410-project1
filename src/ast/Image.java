package ast;

import java.util.List;
import java.util.Objects;

public class Image extends Statement {
    private final Id id;
    private final List<Position> positions;

    public Image(Id id, List<Position> position_assign) {
        this.id = id;
        this.positions = position_assign;
    }

    public Id getId() {
        return id;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(positions, image.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, positions);
    }
}
