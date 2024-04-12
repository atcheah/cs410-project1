package ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Colour extends ObjectField {

    @Override
    public <C,T> T accept(C context, GraphicalParserVisitor<C,T> v) {
        return v.visit(context, this);
    }

}
