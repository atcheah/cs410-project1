package ast;

import java.util.List;
import java.util.Objects;

public class Animate extends Function {
    private final List<Id> ids;
    private final int duration;
    private final boolean isMinutes;

    public Animate(List<Id> ids, int duration_length, boolean isMinutes) {
        this.ids = ids;
        this.duration = duration_length;
        this.isMinutes = isMinutes;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isMinutes() {
        return isMinutes;
    }

    public List<Id> getIds() {
        return ids;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animate animate = (Animate) o;
        return duration == animate.duration && isMinutes == animate.isMinutes && Objects.equals(ids, animate.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, duration, isMinutes);
    }
}
