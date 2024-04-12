package ast;

public class Id extends Statement {
    private final String text;

    public Id(String text) {
        this.text = text;
    }

    public String getName() {
        return text;
    }

    @Override
    public <C, T> T accept(C context, GraphicalParserVisitor<C, T> v) {
        return v.visit(context, this);
    }
    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Id other)) {
            return false;
        }

        return text.equals(other.getName());
    }
}
