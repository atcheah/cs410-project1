package ast;

import java.util.List;
import java.util.Objects;

public class Shape extends ObjectField {

    private Shapes shape;

    // Could extract enum into own file.
    public enum Shapes {
        circle,
        line,
        rectangle,
        square,
        triangle,
        invalid,
    }

    public Shape(String s) {
        switch (s.toUpperCase()) {
            case "CIRCLE" -> this.shape = Shapes.circle;
            case "LINE" -> this.shape = Shapes.line;
            case "RECTANGLE" -> this.shape = Shapes.rectangle;
            case "SQUARE" -> this.shape = Shapes.square;
            case "TRIANGLE" -> this.shape = Shapes.triangle;
            // Make all other inputs invalid shapes. (This will be caught in static checker.)
            // Perhaps redundant but nice to have.
            default -> this.shape = Shapes.invalid;
        }
    }
    public Shapes getShape() {
        return shape;
    }

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

    @Override
    public String toString() {
        return switch (shape) {
            case circle -> "circle";
            case line -> "line";
            case rectangle -> "rectangle";
            case square -> "square";
            case triangle -> "triangle";
            default -> "invalid shape.";
        };
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape1 = (Shape) o;
        return shape == shape1.shape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape);
    }
}
