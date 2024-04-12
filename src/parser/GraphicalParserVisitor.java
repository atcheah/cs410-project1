// Generated from C:/Users/Andrew/Desktop/Group19Project1/src/parser/GraphicalParser.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GraphicalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GraphicalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GraphicalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GraphicalParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_expr(GraphicalParser.Let_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_config(GraphicalParser.Let_configContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_instantiate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_instantiate(GraphicalParser.Let_instantiateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(GraphicalParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_declare(GraphicalParser.Let_declareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_statement(GraphicalParser.Let_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_object(GraphicalParser.Let_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_image}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_image(GraphicalParser.Let_imageContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#verbal_sep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerbal_sep(GraphicalParser.Verbal_sepContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_object_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_object_assignment(GraphicalParser.Let_object_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#object_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject_assign(GraphicalParser.Object_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#shape_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape_assign(GraphicalParser.Shape_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#colour_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColour_assign(GraphicalParser.Colour_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#size_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize_assign(GraphicalParser.Size_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#opacity_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpacity_assign(GraphicalParser.Opacity_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#rotation_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotation_assign(GraphicalParser.Rotation_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#shear_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShear_assign(GraphicalParser.Shear_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#scale_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScale_assign(GraphicalParser.Scale_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_ownership_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_ownership_assignment(GraphicalParser.Let_ownership_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#ownership_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwnership_assign(GraphicalParser.Ownership_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#let_image_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_image_assignment(GraphicalParser.Let_image_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#position_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition_assign(GraphicalParser.Position_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#function_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_expr(GraphicalParser.Function_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#animate_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnimate_call(GraphicalParser.Animate_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#draw_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDraw_call(GraphicalParser.Draw_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#repeat_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_call(GraphicalParser.Repeat_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#if_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(GraphicalParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#then_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen_expr(GraphicalParser.Then_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#else_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_expr(GraphicalParser.Else_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#boolclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolclause(GraphicalParser.BoolclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#curr_frame_assert_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCurr_frame_assert_expr(GraphicalParser.Curr_frame_assert_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#assert_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssert_expr(GraphicalParser.Assert_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#tuple_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple_statement(GraphicalParser.Tuple_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#shapes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapes(GraphicalParser.ShapesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#colours}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColours(GraphicalParser.ColoursContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#rgb_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRgb_statement(GraphicalParser.Rgb_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#rgba_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRgba_statement(GraphicalParser.Rgba_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#sizes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSizes(GraphicalParser.SizesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphicalParser#rotations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotations(GraphicalParser.RotationsContext ctx);
}