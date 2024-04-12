package ast;

import java.util.List;
import java.util.Objects;

public class If extends Expression {
    private final BoolClause boolClause;
    private final List<Expression> thenExpr;
    private final List<Expression> elseExpr;

    public If(BoolClause boolClause, List<Expression> thenExpr, List<Expression> elseExpr) {
        this.boolClause = boolClause;
        this.thenExpr = thenExpr;
        this.elseExpr = elseExpr;
    }

    public BoolClause getBoolClause() {
        return boolClause;
    }

    public List<Expression> getElseExpr() {
        return elseExpr;
    }

    public List<Expression> getThenExpr() {
        return thenExpr;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        If anIf = (If) o;
        return Objects.equals(boolClause, anIf.boolClause) && Objects.equals(thenExpr, anIf.thenExpr) && Objects.equals(elseExpr, anIf.elseExpr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boolClause, thenExpr, elseExpr);
    }
}
