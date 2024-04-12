// Generated from C:/Users/Andrew/Desktop/Group19Project1/src/parser/GraphicalParser.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphicalParser}.
 */
public interface GraphicalParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GraphicalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GraphicalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GraphicalParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GraphicalParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_expr}.
	 * @param ctx the parse tree
	 */
	void enterLet_expr(GraphicalParser.Let_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_expr}.
	 * @param ctx the parse tree
	 */
	void exitLet_expr(GraphicalParser.Let_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_config}.
	 * @param ctx the parse tree
	 */
	void enterLet_config(GraphicalParser.Let_configContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_config}.
	 * @param ctx the parse tree
	 */
	void exitLet_config(GraphicalParser.Let_configContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_instantiate}.
	 * @param ctx the parse tree
	 */
	void enterLet_instantiate(GraphicalParser.Let_instantiateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_instantiate}.
	 * @param ctx the parse tree
	 */
	void exitLet_instantiate(GraphicalParser.Let_instantiateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(GraphicalParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(GraphicalParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_declare}.
	 * @param ctx the parse tree
	 */
	void enterLet_declare(GraphicalParser.Let_declareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_declare}.
	 * @param ctx the parse tree
	 */
	void exitLet_declare(GraphicalParser.Let_declareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_statement}.
	 * @param ctx the parse tree
	 */
	void enterLet_statement(GraphicalParser.Let_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_statement}.
	 * @param ctx the parse tree
	 */
	void exitLet_statement(GraphicalParser.Let_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_object}.
	 * @param ctx the parse tree
	 */
	void enterLet_object(GraphicalParser.Let_objectContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_object}.
	 * @param ctx the parse tree
	 */
	void exitLet_object(GraphicalParser.Let_objectContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_image}.
	 * @param ctx the parse tree
	 */
	void enterLet_image(GraphicalParser.Let_imageContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_image}.
	 * @param ctx the parse tree
	 */
	void exitLet_image(GraphicalParser.Let_imageContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#verbal_sep}.
	 * @param ctx the parse tree
	 */
	void enterVerbal_sep(GraphicalParser.Verbal_sepContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#verbal_sep}.
	 * @param ctx the parse tree
	 */
	void exitVerbal_sep(GraphicalParser.Verbal_sepContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_object_assignment}.
	 * @param ctx the parse tree
	 */
	void enterLet_object_assignment(GraphicalParser.Let_object_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_object_assignment}.
	 * @param ctx the parse tree
	 */
	void exitLet_object_assignment(GraphicalParser.Let_object_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#object_assign}.
	 * @param ctx the parse tree
	 */
	void enterObject_assign(GraphicalParser.Object_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#object_assign}.
	 * @param ctx the parse tree
	 */
	void exitObject_assign(GraphicalParser.Object_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#shape_assign}.
	 * @param ctx the parse tree
	 */
	void enterShape_assign(GraphicalParser.Shape_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#shape_assign}.
	 * @param ctx the parse tree
	 */
	void exitShape_assign(GraphicalParser.Shape_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#colour_assign}.
	 * @param ctx the parse tree
	 */
	void enterColour_assign(GraphicalParser.Colour_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#colour_assign}.
	 * @param ctx the parse tree
	 */
	void exitColour_assign(GraphicalParser.Colour_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#size_assign}.
	 * @param ctx the parse tree
	 */
	void enterSize_assign(GraphicalParser.Size_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#size_assign}.
	 * @param ctx the parse tree
	 */
	void exitSize_assign(GraphicalParser.Size_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#opacity_assign}.
	 * @param ctx the parse tree
	 */
	void enterOpacity_assign(GraphicalParser.Opacity_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#opacity_assign}.
	 * @param ctx the parse tree
	 */
	void exitOpacity_assign(GraphicalParser.Opacity_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#rotation_assign}.
	 * @param ctx the parse tree
	 */
	void enterRotation_assign(GraphicalParser.Rotation_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#rotation_assign}.
	 * @param ctx the parse tree
	 */
	void exitRotation_assign(GraphicalParser.Rotation_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#shear_assign}.
	 * @param ctx the parse tree
	 */
	void enterShear_assign(GraphicalParser.Shear_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#shear_assign}.
	 * @param ctx the parse tree
	 */
	void exitShear_assign(GraphicalParser.Shear_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#scale_assign}.
	 * @param ctx the parse tree
	 */
	void enterScale_assign(GraphicalParser.Scale_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#scale_assign}.
	 * @param ctx the parse tree
	 */
	void exitScale_assign(GraphicalParser.Scale_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_ownership_assignment}.
	 * @param ctx the parse tree
	 */
	void enterLet_ownership_assignment(GraphicalParser.Let_ownership_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_ownership_assignment}.
	 * @param ctx the parse tree
	 */
	void exitLet_ownership_assignment(GraphicalParser.Let_ownership_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#ownership_assign}.
	 * @param ctx the parse tree
	 */
	void enterOwnership_assign(GraphicalParser.Ownership_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#ownership_assign}.
	 * @param ctx the parse tree
	 */
	void exitOwnership_assign(GraphicalParser.Ownership_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#let_image_assignment}.
	 * @param ctx the parse tree
	 */
	void enterLet_image_assignment(GraphicalParser.Let_image_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#let_image_assignment}.
	 * @param ctx the parse tree
	 */
	void exitLet_image_assignment(GraphicalParser.Let_image_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#position_assign}.
	 * @param ctx the parse tree
	 */
	void enterPosition_assign(GraphicalParser.Position_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#position_assign}.
	 * @param ctx the parse tree
	 */
	void exitPosition_assign(GraphicalParser.Position_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#function_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunction_expr(GraphicalParser.Function_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#function_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunction_expr(GraphicalParser.Function_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#animate_call}.
	 * @param ctx the parse tree
	 */
	void enterAnimate_call(GraphicalParser.Animate_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#animate_call}.
	 * @param ctx the parse tree
	 */
	void exitAnimate_call(GraphicalParser.Animate_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#draw_call}.
	 * @param ctx the parse tree
	 */
	void enterDraw_call(GraphicalParser.Draw_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#draw_call}.
	 * @param ctx the parse tree
	 */
	void exitDraw_call(GraphicalParser.Draw_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#repeat_call}.
	 * @param ctx the parse tree
	 */
	void enterRepeat_call(GraphicalParser.Repeat_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#repeat_call}.
	 * @param ctx the parse tree
	 */
	void exitRepeat_call(GraphicalParser.Repeat_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(GraphicalParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(GraphicalParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#then_expr}.
	 * @param ctx the parse tree
	 */
	void enterThen_expr(GraphicalParser.Then_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#then_expr}.
	 * @param ctx the parse tree
	 */
	void exitThen_expr(GraphicalParser.Then_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#else_expr}.
	 * @param ctx the parse tree
	 */
	void enterElse_expr(GraphicalParser.Else_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#else_expr}.
	 * @param ctx the parse tree
	 */
	void exitElse_expr(GraphicalParser.Else_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#boolclause}.
	 * @param ctx the parse tree
	 */
	void enterBoolclause(GraphicalParser.BoolclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#boolclause}.
	 * @param ctx the parse tree
	 */
	void exitBoolclause(GraphicalParser.BoolclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#curr_frame_assert_expr}.
	 * @param ctx the parse tree
	 */
	void enterCurr_frame_assert_expr(GraphicalParser.Curr_frame_assert_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#curr_frame_assert_expr}.
	 * @param ctx the parse tree
	 */
	void exitCurr_frame_assert_expr(GraphicalParser.Curr_frame_assert_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#assert_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssert_expr(GraphicalParser.Assert_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#assert_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssert_expr(GraphicalParser.Assert_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#tuple_statement}.
	 * @param ctx the parse tree
	 */
	void enterTuple_statement(GraphicalParser.Tuple_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#tuple_statement}.
	 * @param ctx the parse tree
	 */
	void exitTuple_statement(GraphicalParser.Tuple_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#shapes}.
	 * @param ctx the parse tree
	 */
	void enterShapes(GraphicalParser.ShapesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#shapes}.
	 * @param ctx the parse tree
	 */
	void exitShapes(GraphicalParser.ShapesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#colours}.
	 * @param ctx the parse tree
	 */
	void enterColours(GraphicalParser.ColoursContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#colours}.
	 * @param ctx the parse tree
	 */
	void exitColours(GraphicalParser.ColoursContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#rgb_statement}.
	 * @param ctx the parse tree
	 */
	void enterRgb_statement(GraphicalParser.Rgb_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#rgb_statement}.
	 * @param ctx the parse tree
	 */
	void exitRgb_statement(GraphicalParser.Rgb_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#rgba_statement}.
	 * @param ctx the parse tree
	 */
	void enterRgba_statement(GraphicalParser.Rgba_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#rgba_statement}.
	 * @param ctx the parse tree
	 */
	void exitRgba_statement(GraphicalParser.Rgba_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#sizes}.
	 * @param ctx the parse tree
	 */
	void enterSizes(GraphicalParser.SizesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#sizes}.
	 * @param ctx the parse tree
	 */
	void exitSizes(GraphicalParser.SizesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphicalParser#rotations}.
	 * @param ctx the parse tree
	 */
	void enterRotations(GraphicalParser.RotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphicalParser#rotations}.
	 * @param ctx the parse tree
	 */
	void exitRotations(GraphicalParser.RotationsContext ctx);
}