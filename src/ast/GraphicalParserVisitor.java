package ast;

public interface GraphicalParserVisitor<C,T> {
    T visit(C context, Program p);
    T visit(C context, Id i);
    T visit(C context, If i);
    T visit(C context, Let l);

    T visit(C context, Animate a);
    T visit(C context, Draw d);
    T visit(C context, Repeat r);

    T visit(C context, Assert a);
    T visit(C context, Image i);

    T visit(C context, Object o);
    T visit(C context, Opacity o);
    T visit(C context, Ownership o);
    T visit(C context, Colour c);
    T visit(C context, ColourText c);
    T visit(C context, Hex h);
    T visit(C context, RGB r);
    T visit(C context, RGBA ra);
    T visit(C context, Position p);
    T visit(C context, Rotation r);
    T visit(C context, Scale s);
    T visit(C context, Shape s);
    T visit(C context, Shear s);
    T visit(C context, Size s);

    T visit(C context, Tuple tuple);

    T visit(C context, FrameAssert frameAssert);
}
