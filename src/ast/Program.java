package ast;


import java.util.List;
import java.util.Objects;

public class Program extends Node {
    List<Expression> expressions;

    public Program (List<Expression> expr) {
        this.expressions = expr;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(expressions, program.expressions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressions);
    }
}
