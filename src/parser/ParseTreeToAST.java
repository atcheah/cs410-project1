package parser;

import ast.*;
import ast.Image;
import ast.Object;
import ast.Shape;

import java.awt.*;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseTreeToAST extends GraphicalParserBaseVisitor<Node> {

    // visiting Program
    @Override
    public Program visitProgram(GraphicalParser.ProgramContext ctx) {
        List<Expression> expressions = new ArrayList<>();
        for(GraphicalParser.ExprContext expr : ctx.expr()) {
            expressions.add((Expression) expr.accept(this));
        }
        return new Program(expressions);
    }

    // expression is abstract; telling it to visit children nodes
    @Override
    public Expression visitExpr(GraphicalParser.ExprContext ctx) {
        return (Expression) visitChildren(ctx);
    }

    // visiting Let
    @Override
    public Let visitLet_expr(GraphicalParser.Let_exprContext ctx) {
        return new Let((Id) ctx.id().accept(this), (Config) ctx.let_config().accept(this));
    }

    // config is abstract; telling it to visit children nodes
    @Override
    public Config visitLet_config(GraphicalParser.Let_configContext ctx) {
        return (Config) visitChildren(ctx);
    }

    // instantiate is abstract; telling it to visit children nodes
    @Override
    public Instantiate visitLet_instantiate(GraphicalParser.Let_instantiateContext ctx) {
        return (Instantiate) visitChildren(ctx);
    }

    // visiting Id
    @Override
    public Id visitId(GraphicalParser.IdContext ctx) {
        return new Id(ctx.TEXT().getText());
    }

    // statement is abstract; will visit children nodes for functionality
    @Override
    public Statement visitLet_statement(GraphicalParser.Let_statementContext ctx) {
        return (Statement) visitChildren(ctx);
    }

    // visiting Object
    @Override
    public Object visitLet_object(GraphicalParser.Let_objectContext ctx) {
        List<ObjectField> objectAssignments = new ArrayList<>();
        for (GraphicalParser.Object_assignContext o : ctx.let_object_assignment().object_assign()) {
            objectAssignments.add((ObjectField) o.accept(this));
        }
        return new Object(objectAssignments);
    }

    // objectfield is abstract; delegate to children nodes?
    @Override
    public ObjectField visitObject_assign(GraphicalParser.Object_assignContext ctx) {
        return (ObjectField) visitChildren(ctx);
    }

    // visiting Image
    @Override
    public Image visitLet_image(GraphicalParser.Let_imageContext ctx) {
        List<Position> positions = new ArrayList<>();
        for (GraphicalParser.Position_assignContext p : ctx.let_image_assignment().position_assign()) {
            positions.add((Position) p.accept(this));
        }
        return new Image((Id) ctx.id().accept(this), positions);
    }

    // visit Position
        @Override
    public Position visitPosition_assign(GraphicalParser.Position_assignContext ctx) {
        String positionTuples = ctx.tuple_statement().TUPLE_VALUES().getText();
        String[] split_tuple = positionTuples.split(",");
        List<Integer> dimensions = new ArrayList<>();
        for (String s : split_tuple) {
            dimensions.add(Integer.parseInt(s.strip()));
        }
        return new Position((Id) ctx.id().accept(this), dimensions);
    }

    /*
    *
    *
    * beginning object field assignments
    *
    *
    */

    @Override
    public Shape visitShape_assign(GraphicalParser.Shape_assignContext ctx) {
        return new Shape(ctx.shapes().getText());
    }

    /**
    Overrides colour assignment to parse as colour string, hex, rgb or rgba.
    If rgb/rgba, removes the tuple_start and tuple_end brackets and splits up the string by colour_sep before
    constructing the class.

     Returns one of RGBA, RGB, HEX, or ColourText
    **/
    @Override
    public Colour visitColour_assign(GraphicalParser.Colour_assignContext ctx) {
        if (ctx.colours().HEX_VALUE() != null) {
            return new Hex(ctx.colours().HEX_VALUE().getText());
        } else if (ctx.colours().rgb_statement() != null) {
            String tuple_statement = ctx.colours().rgb_statement().getText().replaceAll("[()]", "");
            String[] split_tuple = tuple_statement.split(",");
            List<Number> rgbValues = new ArrayList<>();
            for (String s : split_tuple) {
                rgbValues.add(Integer.parseInt(s.strip()));
            }
            return new RGB(rgbValues);
        } else if (ctx.colours().rgba_statement() != null) {
            String tuple_statement = ctx.colours().rgba_statement().getText().replaceAll("[()]", "");
            String[] split_tuple = tuple_statement.split(",");
            List<Number> rgbaValues = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                rgbaValues.add(Integer.parseInt(split_tuple[i].strip()));
            }
            rgbaValues.add(Double.parseDouble(split_tuple[3]));
            return new RGBA(rgbaValues);
        } else { // if a colour string
            return new ColourText(ctx.colours().getText());
        }
    }

    @Override
    public Size visitSize_assign(GraphicalParser.Size_assignContext ctx) {
        if (ctx.sizes().SIZE_NUMBER() != null) {
            return new Size(List.of(Integer.parseInt(ctx.sizes().SIZE_NUMBER().getText())));
        } else {
            String size_tuple = ctx.sizes().SIZE_TUPLE().getText().replaceAll("[()]", "");
            String[] split_tuple = size_tuple.split(",");
            List<Integer> size_dimensions = new ArrayList<>();
            for (String s : split_tuple) {
                size_dimensions.add(Integer.parseInt(s.strip()));
            }
            return new Size(size_dimensions);
        }
    }

    @Override
    public Opacity visitOpacity_assign(GraphicalParser.Opacity_assignContext ctx) {
        return new Opacity(Integer.parseInt(ctx.NUMBER().getText()));
    }

    @Override
    public Rotation visitRotation_assign(GraphicalParser.Rotation_assignContext ctx) {
        String rotationStatement = ctx.rotations().getText();
        String[] split_tuple = rotationStatement.split(" ");
        return new Rotation(Integer.parseInt(split_tuple[0].strip()), split_tuple[1].strip());
    }

    @Override
    public Shear visitShear_assign(GraphicalParser.Shear_assignContext ctx) {
        String shearStatement = ctx.tuple_statement().TUPLE_VALUES().getText();
        String[] split_tuple = shearStatement.split(",");
        List<Integer> shearDimensions = new ArrayList<>();
        for (String s : split_tuple) {
            shearDimensions.add(Integer.parseInt(s.strip()));
        }
        return new Shear(shearDimensions);
    }

    @Override
    public Scale visitScale_assign(GraphicalParser.Scale_assignContext ctx) {
        String scaleStatement = ctx.tuple_statement().TUPLE_VALUES().getText();
        String[] split_tuple = scaleStatement.split(",");
        List<Integer> scaleDimensions = new ArrayList<>();
        for (String s : split_tuple) {
            scaleDimensions.add(Integer.parseInt(s.strip()));
        }
        return new Scale(scaleDimensions);
    }

    /*
    end of object fields
     */


    // visiting Ownership

    @Override
    public Ownership visitLet_ownership_assignment(GraphicalParser.Let_ownership_assignmentContext ctx) {
        List<Position> positions = new ArrayList<>();
        for (GraphicalParser.Ownership_assignContext o : ctx.ownership_assign()) {
            positions.add((Position) o.position_assign().accept(this));
        }
        return new Ownership(positions);
    }


    // function is abstract; going to child nodes for functionality
    @Override
    public Function visitFunction_expr(GraphicalParser.Function_exprContext ctx) {
        return (Function) visitChildren(ctx);
    }

    // visiting Animate
    @Override
    public Animate visitAnimate_call(GraphicalParser.Animate_callContext ctx) {
        List<Id> ids = new ArrayList<>();
        for (GraphicalParser.IdContext i : ctx.id()) {
            ids.add((Id) i.accept(this));
        }
        boolean isMinutes = (ctx.ANIMATE_DURATION_MINUTES() != null);
        return new Animate(ids,Integer.parseInt(ctx.NUMBER().getText()),isMinutes);
    }

    // visiting Draw
    @Override
    public Draw visitDraw_call(GraphicalParser.Draw_callContext ctx) {
        return new Draw((Id) ctx.id().accept(this));
    }


    // visiting Repeat
    @Override
    public Repeat visitRepeat_call(GraphicalParser.Repeat_callContext ctx) {
        List<Expression> expressions = new ArrayList<>();
        for (GraphicalParser.ExprContext expr : ctx.expr()) {
            expressions.add(this.visitExpr(expr));
        }
        return new Repeat(expressions, Integer.parseInt(ctx.NUMBER().getText()));
    }

    // visiting If (and its children nodes)
    @Override
    public If visitIf_expr(GraphicalParser.If_exprContext ctx) {
        List<Expression> then_expr = new ArrayList<>();
        List<Expression> else_expr = new ArrayList<>();

        for(GraphicalParser.Then_exprContext t : ctx.then_expr()) {
            then_expr.add(visitThen_expr(t));
        }

        for(GraphicalParser.Else_exprContext e : ctx.else_expr()) {
            else_expr.add(visitElse_expr(e));
        }

        return new If(visitBoolclause(ctx.boolclause()), then_expr, else_expr);
    }

    @Override
    public Expression visitThen_expr(GraphicalParser.Then_exprContext ctx) {
        return (Expression) visitChildren(ctx);
    }

    @Override
    public Expression visitElse_expr(GraphicalParser.Else_exprContext ctx) {
        return (Expression) visitChildren(ctx);
    }

    // boolclause is abstract; visit child nodes for functionality
    @Override
    public BoolClause visitBoolclause(GraphicalParser.BoolclauseContext ctx) {
        return (BoolClause) visitChildren(ctx);
    }

    // visiting assert
    @Override
    public Assert visitAssert_expr(GraphicalParser.Assert_exprContext ctx) {
        return new Assert((Id) ctx.id().accept(this), visitObject_assign(ctx.object_assign()));
    }

    // visiting FrameAssert (curr_frame_assert_expr)
    @Override
    public FrameAssert visitCurr_frame_assert_expr(GraphicalParser.Curr_frame_assert_exprContext ctx) {
        return new FrameAssert((Id) ctx.id().accept(this));
    }

}
