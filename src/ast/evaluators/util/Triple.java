package ast.evaluators.util;

import java.util.Objects;

public class Triple<A, B, C> {
    private A a;
    private B b;
    private C c;

    public Triple(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

        if (!Objects.equals(a, triple.a))
            return false;
        if (!Objects.equals(b, triple.b))
            return false;
        return Objects.equals(c, triple.c);
    }
}
