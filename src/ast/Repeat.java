package ast;

import java.util.List;
import java.util.Objects;

public class Repeat extends Function{
    private final List<Expression> repeatExpressions;
    private final int duration;

    public Repeat(List<Expression> repeatExpressions, int duration_length) {
        this.repeatExpressions = repeatExpressions;
        this.duration = duration_length;
    }

    public List<Expression> getRepeatExpressions() {
        return repeatExpressions;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repeat repeat = (Repeat) o;
        return duration == repeat.duration && Objects.equals(repeatExpressions, repeat.repeatExpressions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repeatExpressions, duration);
    }
}
