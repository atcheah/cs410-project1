package ast;

import java.util.Objects;

public class Let extends Expression {
    private final Id id;
    private final Config configExpr;

    public Let(Id id, Config configExpr) {
        this.id = id;
        this.configExpr = configExpr;
    }

    public Id getId() {
        return id;
    }

    public Config getConfigExpr() {
        return configExpr;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Let let = (Let) o;
        return Objects.equals(id, let.id) && Objects.equals(configExpr, let.configExpr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, configExpr);
    }

}
