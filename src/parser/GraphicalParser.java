// Generated from C:/Users/Andrew/Desktop/Group19Project1/src/parser/GraphicalParser.g4 by ANTLR 4.13.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GraphicalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LET_START=1, LET_OBJ_DECL=2, LET_OBJ_DECL_ALT=3, LET_OBJ_FIELDS=4, LET_OBJ_PLACEMENT=5, 
		LET_OBJ_RELATE=6, LET_OBJ_POSITION=7, SEP=8, AND_SEP=9, OXFORD_COMMA_SEP=10, 
		CONNECTOR=11, ASSIGNMENT=12, TUPLE_START=13, SHAPE_FIELD=14, COLOUR_FIELD=15, 
		SIZE_FIELD=16, OPACITY=17, OWNERSHIP=18, ROTATION_FIELD=19, SHEAR=20, 
		SCALE=21, ANIMATE_START=22, DURATION_LENGTH=23, ANIMATE_DURATION_SECONDS=24, 
		ANIMATE_DURATION_MINUTES=25, DRAW_START=26, REPEAT=27, OPENING_BRACE=28, 
		CLOSING_BRACE=29, IF=30, CURRENT_FRAME=31, THEN=32, ELSE=33, HAS=34, ASSERT=35, 
		WS=36, OBJECT=37, IMAGE=38, MESH=39, TEXT=40, NUMBER=41, TUPLE_VALUES=42, 
		TUPLE_DIMENSION=43, TUPLE_SEP=44, TUPLE_END=45, RED=46, BLACK=47, BLUE=48, 
		BROWN=49, GRAY=50, GREEN=51, ORANGE=52, PINK=53, PURPLE=54, WHITE=55, 
		YELLOW=56, HEX_VALUE=57, COLOUR_TUPLE_START=58, COLOUR_NUMBER=59, COLOUR_NUMBER_RGBA_DECIMAL=60, 
		COLOUR_SEP=61, COLOUR_TUPLE_END=62, COLOUR_TEXT=63, ROTATION_NUM=64, DEGREE=65, 
		RADIAN=66, ROTATION_UNIT=67, ROTATION_VALUE=68, CIRCLE=69, LINE=70, RECTANGLE=71, 
		SQUARE=72, TRIANGLE=73, SHAPE_TEXT=74, SIZE_NUMBER=75, SIZE_TUPLE=76;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_let_expr = 2, RULE_let_config = 3, 
		RULE_let_instantiate = 4, RULE_id = 5, RULE_let_declare = 6, RULE_let_statement = 7, 
		RULE_let_object = 8, RULE_let_image = 9, RULE_verbal_sep = 10, RULE_let_object_assignment = 11, 
		RULE_object_assign = 12, RULE_shape_assign = 13, RULE_colour_assign = 14, 
		RULE_size_assign = 15, RULE_opacity_assign = 16, RULE_rotation_assign = 17, 
		RULE_shear_assign = 18, RULE_scale_assign = 19, RULE_let_ownership_assignment = 20, 
		RULE_ownership_assign = 21, RULE_let_image_assignment = 22, RULE_position_assign = 23, 
		RULE_function_expr = 24, RULE_animate_call = 25, RULE_draw_call = 26, 
		RULE_repeat_call = 27, RULE_if_expr = 28, RULE_then_expr = 29, RULE_else_expr = 30, 
		RULE_boolclause = 31, RULE_curr_frame_assert_expr = 32, RULE_assert_expr = 33, 
		RULE_tuple_statement = 34, RULE_shapes = 35, RULE_colours = 36, RULE_rgb_statement = 37, 
		RULE_rgba_statement = 38, RULE_sizes = 39, RULE_rotations = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "let_expr", "let_config", "let_instantiate", "id", 
			"let_declare", "let_statement", "let_object", "let_image", "verbal_sep", 
			"let_object_assignment", "object_assign", "shape_assign", "colour_assign", 
			"size_assign", "opacity_assign", "rotation_assign", "shear_assign", "scale_assign", 
			"let_ownership_assignment", "ownership_assign", "let_image_assignment", 
			"position_assign", "function_expr", "animate_call", "draw_call", "repeat_call", 
			"if_expr", "then_expr", "else_expr", "boolclause", "curr_frame_assert_expr", 
			"assert_expr", "tuple_statement", "shapes", "colours", "rgb_statement", 
			"rgba_statement", "sizes", "rotations"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'object'", "'image'", "'mesh'", null, null, null, null, null, 
			null, "'red'", "'black'", "'blue'", "'brown'", null, "'green'", "'orange'", 
			"'pink'", "'purple'", "'white'", "'yellow'", null, null, null, null, 
			null, null, null, null, null, null, null, null, "'circle'", "'line'", 
			"'rectangle'", "'square'", "'triangle'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LET_START", "LET_OBJ_DECL", "LET_OBJ_DECL_ALT", "LET_OBJ_FIELDS", 
			"LET_OBJ_PLACEMENT", "LET_OBJ_RELATE", "LET_OBJ_POSITION", "SEP", "AND_SEP", 
			"OXFORD_COMMA_SEP", "CONNECTOR", "ASSIGNMENT", "TUPLE_START", "SHAPE_FIELD", 
			"COLOUR_FIELD", "SIZE_FIELD", "OPACITY", "OWNERSHIP", "ROTATION_FIELD", 
			"SHEAR", "SCALE", "ANIMATE_START", "DURATION_LENGTH", "ANIMATE_DURATION_SECONDS", 
			"ANIMATE_DURATION_MINUTES", "DRAW_START", "REPEAT", "OPENING_BRACE", 
			"CLOSING_BRACE", "IF", "CURRENT_FRAME", "THEN", "ELSE", "HAS", "ASSERT", 
			"WS", "OBJECT", "IMAGE", "MESH", "TEXT", "NUMBER", "TUPLE_VALUES", "TUPLE_DIMENSION", 
			"TUPLE_SEP", "TUPLE_END", "RED", "BLACK", "BLUE", "BROWN", "GRAY", "GREEN", 
			"ORANGE", "PINK", "PURPLE", "WHITE", "YELLOW", "HEX_VALUE", "COLOUR_TUPLE_START", 
			"COLOUR_NUMBER", "COLOUR_NUMBER_RGBA_DECIMAL", "COLOUR_SEP", "COLOUR_TUPLE_END", 
			"COLOUR_TEXT", "ROTATION_NUM", "DEGREE", "RADIAN", "ROTATION_UNIT", "ROTATION_VALUE", 
			"CIRCLE", "LINE", "RECTANGLE", "SQUARE", "TRIANGLE", "SHAPE_TEXT", "SIZE_NUMBER", 
			"SIZE_TUPLE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GraphicalParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GraphicalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GraphicalParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1279262722L) != 0)) {
				{
				{
				setState(82);
				expr();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Let_exprContext let_expr() {
			return getRuleContext(Let_exprContext.class,0);
		}
		public Function_exprContext function_expr() {
			return getRuleContext(Function_exprContext.class,0);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				let_expr();
				}
				break;
			case ANIMATE_START:
			case DRAW_START:
			case REPEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				function_expr();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
				if_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_exprContext extends ParserRuleContext {
		public TerminalNode LET_START() { return getToken(GraphicalParser.LET_START, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Let_configContext let_config() {
			return getRuleContext(Let_configContext.class,0);
		}
		public Let_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_exprContext let_expr() throws RecognitionException {
		Let_exprContext _localctx = new Let_exprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_let_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(LET_START);
			setState(96);
			id();
			setState(97);
			let_config();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_configContext extends ParserRuleContext {
		public Let_instantiateContext let_instantiate() {
			return getRuleContext(Let_instantiateContext.class,0);
		}
		public Let_ownership_assignmentContext let_ownership_assignment() {
			return getRuleContext(Let_ownership_assignmentContext.class,0);
		}
		public Let_configContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_config; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_config(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_config(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_config(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_configContext let_config() throws RecognitionException {
		Let_configContext _localctx = new Let_configContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_let_config);
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET_OBJ_DECL:
			case LET_OBJ_DECL_ALT:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				let_instantiate();
				}
				break;
			case OWNERSHIP:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				let_ownership_assignment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_instantiateContext extends ParserRuleContext {
		public Let_declareContext let_declare() {
			return getRuleContext(Let_declareContext.class,0);
		}
		public Let_statementContext let_statement() {
			return getRuleContext(Let_statementContext.class,0);
		}
		public Let_instantiateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_instantiate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_instantiate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_instantiate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_instantiate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_instantiateContext let_instantiate() throws RecognitionException {
		Let_instantiateContext _localctx = new Let_instantiateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_let_instantiate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			let_declare();
			setState(104);
			let_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(GraphicalParser.TEXT, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_declareContext extends ParserRuleContext {
		public TerminalNode LET_OBJ_DECL() { return getToken(GraphicalParser.LET_OBJ_DECL, 0); }
		public TerminalNode LET_OBJ_DECL_ALT() { return getToken(GraphicalParser.LET_OBJ_DECL_ALT, 0); }
		public Let_declareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_declare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_declare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_declare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_declare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_declareContext let_declare() throws RecognitionException {
		Let_declareContext _localctx = new Let_declareContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_let_declare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==LET_OBJ_DECL || _la==LET_OBJ_DECL_ALT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_statementContext extends ParserRuleContext {
		public Let_objectContext let_object() {
			return getRuleContext(Let_objectContext.class,0);
		}
		public Let_imageContext let_image() {
			return getRuleContext(Let_imageContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Let_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_statementContext let_statement() throws RecognitionException {
		Let_statementContext _localctx = new Let_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_let_statement);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				let_object();
				}
				break;
			case IMAGE:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				let_image();
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				id();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_objectContext extends ParserRuleContext {
		public TerminalNode OBJECT() { return getToken(GraphicalParser.OBJECT, 0); }
		public Let_object_assignmentContext let_object_assignment() {
			return getRuleContext(Let_object_assignmentContext.class,0);
		}
		public Let_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_object(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_object(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_object(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_objectContext let_object() throws RecognitionException {
		Let_objectContext _localctx = new Let_objectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_let_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(OBJECT);
			setState(116);
			let_object_assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_imageContext extends ParserRuleContext {
		public TerminalNode IMAGE() { return getToken(GraphicalParser.IMAGE, 0); }
		public TerminalNode LET_OBJ_RELATE() { return getToken(GraphicalParser.LET_OBJ_RELATE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Let_image_assignmentContext let_image_assignment() {
			return getRuleContext(Let_image_assignmentContext.class,0);
		}
		public Let_imageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_image; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_image(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_image(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_image(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_imageContext let_image() throws RecognitionException {
		Let_imageContext _localctx = new Let_imageContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_let_image);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IMAGE);
			setState(119);
			match(LET_OBJ_RELATE);
			setState(120);
			id();
			setState(121);
			let_image_assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Verbal_sepContext extends ParserRuleContext {
		public TerminalNode SEP() { return getToken(GraphicalParser.SEP, 0); }
		public TerminalNode AND_SEP() { return getToken(GraphicalParser.AND_SEP, 0); }
		public TerminalNode OXFORD_COMMA_SEP() { return getToken(GraphicalParser.OXFORD_COMMA_SEP, 0); }
		public Verbal_sepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_verbal_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterVerbal_sep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitVerbal_sep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitVerbal_sep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Verbal_sepContext verbal_sep() throws RecognitionException {
		Verbal_sepContext _localctx = new Verbal_sepContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_verbal_sep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_object_assignmentContext extends ParserRuleContext {
		public TerminalNode LET_OBJ_FIELDS() { return getToken(GraphicalParser.LET_OBJ_FIELDS, 0); }
		public List<Object_assignContext> object_assign() {
			return getRuleContexts(Object_assignContext.class);
		}
		public Object_assignContext object_assign(int i) {
			return getRuleContext(Object_assignContext.class,i);
		}
		public List<Verbal_sepContext> verbal_sep() {
			return getRuleContexts(Verbal_sepContext.class);
		}
		public Verbal_sepContext verbal_sep(int i) {
			return getRuleContext(Verbal_sepContext.class,i);
		}
		public Let_object_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_object_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_object_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_object_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_object_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_object_assignmentContext let_object_assignment() throws RecognitionException {
		Let_object_assignmentContext _localctx = new Let_object_assignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_let_object_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(125);
			match(LET_OBJ_FIELDS);
			setState(126);
			object_assign();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
				{
				{
				setState(127);
				verbal_sep();
				setState(128);
				object_assign();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Object_assignContext extends ParserRuleContext {
		public Shape_assignContext shape_assign() {
			return getRuleContext(Shape_assignContext.class,0);
		}
		public Colour_assignContext colour_assign() {
			return getRuleContext(Colour_assignContext.class,0);
		}
		public Size_assignContext size_assign() {
			return getRuleContext(Size_assignContext.class,0);
		}
		public Opacity_assignContext opacity_assign() {
			return getRuleContext(Opacity_assignContext.class,0);
		}
		public Rotation_assignContext rotation_assign() {
			return getRuleContext(Rotation_assignContext.class,0);
		}
		public Shear_assignContext shear_assign() {
			return getRuleContext(Shear_assignContext.class,0);
		}
		public Scale_assignContext scale_assign() {
			return getRuleContext(Scale_assignContext.class,0);
		}
		public Object_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterObject_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitObject_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitObject_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_assignContext object_assign() throws RecognitionException {
		Object_assignContext _localctx = new Object_assignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_object_assign);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHAPE_FIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				shape_assign();
				}
				break;
			case COLOUR_FIELD:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				colour_assign();
				}
				break;
			case SIZE_FIELD:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				size_assign();
				}
				break;
			case OPACITY:
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				opacity_assign();
				}
				break;
			case ROTATION_FIELD:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				rotation_assign();
				}
				break;
			case SHEAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(140);
				shear_assign();
				}
				break;
			case SCALE:
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				scale_assign();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Shape_assignContext extends ParserRuleContext {
		public TerminalNode SHAPE_FIELD() { return getToken(GraphicalParser.SHAPE_FIELD, 0); }
		public ShapesContext shapes() {
			return getRuleContext(ShapesContext.class,0);
		}
		public Shape_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterShape_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitShape_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitShape_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shape_assignContext shape_assign() throws RecognitionException {
		Shape_assignContext _localctx = new Shape_assignContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_shape_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(SHAPE_FIELD);
			setState(145);
			shapes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Colour_assignContext extends ParserRuleContext {
		public TerminalNode COLOUR_FIELD() { return getToken(GraphicalParser.COLOUR_FIELD, 0); }
		public ColoursContext colours() {
			return getRuleContext(ColoursContext.class,0);
		}
		public Colour_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colour_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterColour_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitColour_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitColour_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Colour_assignContext colour_assign() throws RecognitionException {
		Colour_assignContext _localctx = new Colour_assignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_colour_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(COLOUR_FIELD);
			setState(148);
			colours();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Size_assignContext extends ParserRuleContext {
		public TerminalNode SIZE_FIELD() { return getToken(GraphicalParser.SIZE_FIELD, 0); }
		public SizesContext sizes() {
			return getRuleContext(SizesContext.class,0);
		}
		public Size_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterSize_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitSize_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitSize_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Size_assignContext size_assign() throws RecognitionException {
		Size_assignContext _localctx = new Size_assignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_size_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(SIZE_FIELD);
			setState(151);
			sizes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Opacity_assignContext extends ParserRuleContext {
		public TerminalNode OPACITY() { return getToken(GraphicalParser.OPACITY, 0); }
		public TerminalNode NUMBER() { return getToken(GraphicalParser.NUMBER, 0); }
		public Opacity_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opacity_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterOpacity_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitOpacity_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitOpacity_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Opacity_assignContext opacity_assign() throws RecognitionException {
		Opacity_assignContext _localctx = new Opacity_assignContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_opacity_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(OPACITY);
			setState(154);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rotation_assignContext extends ParserRuleContext {
		public TerminalNode ROTATION_FIELD() { return getToken(GraphicalParser.ROTATION_FIELD, 0); }
		public RotationsContext rotations() {
			return getRuleContext(RotationsContext.class,0);
		}
		public Rotation_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotation_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterRotation_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitRotation_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitRotation_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rotation_assignContext rotation_assign() throws RecognitionException {
		Rotation_assignContext _localctx = new Rotation_assignContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rotation_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ROTATION_FIELD);
			setState(157);
			rotations();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Shear_assignContext extends ParserRuleContext {
		public TerminalNode SHEAR() { return getToken(GraphicalParser.SHEAR, 0); }
		public Tuple_statementContext tuple_statement() {
			return getRuleContext(Tuple_statementContext.class,0);
		}
		public Shear_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shear_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterShear_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitShear_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitShear_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shear_assignContext shear_assign() throws RecognitionException {
		Shear_assignContext _localctx = new Shear_assignContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_shear_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(SHEAR);
			setState(160);
			tuple_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Scale_assignContext extends ParserRuleContext {
		public TerminalNode SCALE() { return getToken(GraphicalParser.SCALE, 0); }
		public Tuple_statementContext tuple_statement() {
			return getRuleContext(Tuple_statementContext.class,0);
		}
		public Scale_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scale_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterScale_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitScale_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitScale_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scale_assignContext scale_assign() throws RecognitionException {
		Scale_assignContext _localctx = new Scale_assignContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_scale_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(SCALE);
			setState(163);
			tuple_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_ownership_assignmentContext extends ParserRuleContext {
		public List<Ownership_assignContext> ownership_assign() {
			return getRuleContexts(Ownership_assignContext.class);
		}
		public Ownership_assignContext ownership_assign(int i) {
			return getRuleContext(Ownership_assignContext.class,i);
		}
		public List<Verbal_sepContext> verbal_sep() {
			return getRuleContexts(Verbal_sepContext.class);
		}
		public Verbal_sepContext verbal_sep(int i) {
			return getRuleContext(Verbal_sepContext.class,i);
		}
		public Let_ownership_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_ownership_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_ownership_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_ownership_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_ownership_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_ownership_assignmentContext let_ownership_assignment() throws RecognitionException {
		Let_ownership_assignmentContext _localctx = new Let_ownership_assignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_let_ownership_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(165);
			ownership_assign();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
				{
				{
				setState(166);
				verbal_sep();
				setState(167);
				ownership_assign();
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Ownership_assignContext extends ParserRuleContext {
		public TerminalNode OWNERSHIP() { return getToken(GraphicalParser.OWNERSHIP, 0); }
		public Position_assignContext position_assign() {
			return getRuleContext(Position_assignContext.class,0);
		}
		public Ownership_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ownership_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterOwnership_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitOwnership_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitOwnership_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ownership_assignContext ownership_assign() throws RecognitionException {
		Ownership_assignContext _localctx = new Ownership_assignContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_ownership_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(OWNERSHIP);
			setState(175);
			position_assign();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Let_image_assignmentContext extends ParserRuleContext {
		public List<TerminalNode> LET_OBJ_PLACEMENT() { return getTokens(GraphicalParser.LET_OBJ_PLACEMENT); }
		public TerminalNode LET_OBJ_PLACEMENT(int i) {
			return getToken(GraphicalParser.LET_OBJ_PLACEMENT, i);
		}
		public List<Position_assignContext> position_assign() {
			return getRuleContexts(Position_assignContext.class);
		}
		public Position_assignContext position_assign(int i) {
			return getRuleContext(Position_assignContext.class,i);
		}
		public List<Verbal_sepContext> verbal_sep() {
			return getRuleContexts(Verbal_sepContext.class);
		}
		public Verbal_sepContext verbal_sep(int i) {
			return getRuleContext(Verbal_sepContext.class,i);
		}
		public Let_image_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_image_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterLet_image_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitLet_image_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitLet_image_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_image_assignmentContext let_image_assignment() throws RecognitionException {
		Let_image_assignmentContext _localctx = new Let_image_assignmentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_let_image_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(177);
			match(LET_OBJ_PLACEMENT);
			setState(178);
			position_assign();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1792L) != 0)) {
				{
				{
				setState(179);
				verbal_sep();
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LET_OBJ_PLACEMENT) {
					{
					setState(180);
					match(LET_OBJ_PLACEMENT);
					}
				}

				setState(183);
				position_assign();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Position_assignContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LET_OBJ_POSITION() { return getToken(GraphicalParser.LET_OBJ_POSITION, 0); }
		public Tuple_statementContext tuple_statement() {
			return getRuleContext(Tuple_statementContext.class,0);
		}
		public Position_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterPosition_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitPosition_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitPosition_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Position_assignContext position_assign() throws RecognitionException {
		Position_assignContext _localctx = new Position_assignContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_position_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			id();
			setState(191);
			match(LET_OBJ_POSITION);
			setState(192);
			tuple_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_exprContext extends ParserRuleContext {
		public Animate_callContext animate_call() {
			return getRuleContext(Animate_callContext.class,0);
		}
		public Draw_callContext draw_call() {
			return getRuleContext(Draw_callContext.class,0);
		}
		public Repeat_callContext repeat_call() {
			return getRuleContext(Repeat_callContext.class,0);
		}
		public Function_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterFunction_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitFunction_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitFunction_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_exprContext function_expr() throws RecognitionException {
		Function_exprContext _localctx = new Function_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_function_expr);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ANIMATE_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				animate_call();
				}
				break;
			case DRAW_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				draw_call();
				}
				break;
			case REPEAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				repeat_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Animate_callContext extends ParserRuleContext {
		public TerminalNode ANIMATE_START() { return getToken(GraphicalParser.ANIMATE_START, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode DURATION_LENGTH() { return getToken(GraphicalParser.DURATION_LENGTH, 0); }
		public TerminalNode NUMBER() { return getToken(GraphicalParser.NUMBER, 0); }
		public TerminalNode ANIMATE_DURATION_SECONDS() { return getToken(GraphicalParser.ANIMATE_DURATION_SECONDS, 0); }
		public TerminalNode ANIMATE_DURATION_MINUTES() { return getToken(GraphicalParser.ANIMATE_DURATION_MINUTES, 0); }
		public List<TerminalNode> CONNECTOR() { return getTokens(GraphicalParser.CONNECTOR); }
		public TerminalNode CONNECTOR(int i) {
			return getToken(GraphicalParser.CONNECTOR, i);
		}
		public Animate_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_animate_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterAnimate_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitAnimate_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitAnimate_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Animate_callContext animate_call() throws RecognitionException {
		Animate_callContext _localctx = new Animate_callContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_animate_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(ANIMATE_START);
			setState(200);
			id();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONNECTOR) {
				{
				{
				setState(201);
				match(CONNECTOR);
				setState(202);
				id();
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			match(DURATION_LENGTH);
			setState(209);
			match(NUMBER);
			setState(210);
			_la = _input.LA(1);
			if ( !(_la==ANIMATE_DURATION_SECONDS || _la==ANIMATE_DURATION_MINUTES) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Draw_callContext extends ParserRuleContext {
		public TerminalNode DRAW_START() { return getToken(GraphicalParser.DRAW_START, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Draw_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_draw_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterDraw_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitDraw_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitDraw_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Draw_callContext draw_call() throws RecognitionException {
		Draw_callContext _localctx = new Draw_callContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_draw_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(DRAW_START);
			setState(213);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Repeat_callContext extends ParserRuleContext {
		public TerminalNode REPEAT() { return getToken(GraphicalParser.REPEAT, 0); }
		public TerminalNode DURATION_LENGTH() { return getToken(GraphicalParser.DURATION_LENGTH, 0); }
		public TerminalNode NUMBER() { return getToken(GraphicalParser.NUMBER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Repeat_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeat_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterRepeat_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitRepeat_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitRepeat_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Repeat_callContext repeat_call() throws RecognitionException {
		Repeat_callContext _localctx = new Repeat_callContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_repeat_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(REPEAT);
			setState(217); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(216);
				expr();
				}
				}
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1279262722L) != 0) );
			setState(221);
			match(DURATION_LENGTH);
			setState(222);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_exprContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GraphicalParser.IF, 0); }
		public BoolclauseContext boolclause() {
			return getRuleContext(BoolclauseContext.class,0);
		}
		public TerminalNode THEN() { return getToken(GraphicalParser.THEN, 0); }
		public List<TerminalNode> OPENING_BRACE() { return getTokens(GraphicalParser.OPENING_BRACE); }
		public TerminalNode OPENING_BRACE(int i) {
			return getToken(GraphicalParser.OPENING_BRACE, i);
		}
		public List<TerminalNode> CLOSING_BRACE() { return getTokens(GraphicalParser.CLOSING_BRACE); }
		public TerminalNode CLOSING_BRACE(int i) {
			return getToken(GraphicalParser.CLOSING_BRACE, i);
		}
		public TerminalNode ELSE() { return getToken(GraphicalParser.ELSE, 0); }
		public List<Then_exprContext> then_expr() {
			return getRuleContexts(Then_exprContext.class);
		}
		public Then_exprContext then_expr(int i) {
			return getRuleContext(Then_exprContext.class,i);
		}
		public List<Else_exprContext> else_expr() {
			return getRuleContexts(Else_exprContext.class);
		}
		public Else_exprContext else_expr(int i) {
			return getRuleContext(Else_exprContext.class,i);
		}
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterIf_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitIf_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitIf_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_if_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(IF);
			setState(225);
			boolclause();
			setState(226);
			match(THEN);
			setState(227);
			match(OPENING_BRACE);
			setState(229); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(228);
				then_expr();
				}
				}
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1279262722L) != 0) );
			setState(233);
			match(CLOSING_BRACE);
			setState(234);
			match(ELSE);
			setState(235);
			match(OPENING_BRACE);
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236);
				else_expr();
				}
				}
				setState(239); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1279262722L) != 0) );
			setState(241);
			match(CLOSING_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Then_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Then_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterThen_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitThen_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitThen_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Then_exprContext then_expr() throws RecognitionException {
		Then_exprContext _localctx = new Then_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_then_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Else_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterElse_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitElse_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitElse_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_exprContext else_expr() throws RecognitionException {
		Else_exprContext _localctx = new Else_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_else_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolclauseContext extends ParserRuleContext {
		public Curr_frame_assert_exprContext curr_frame_assert_expr() {
			return getRuleContext(Curr_frame_assert_exprContext.class,0);
		}
		public Assert_exprContext assert_expr() {
			return getRuleContext(Assert_exprContext.class,0);
		}
		public BoolclauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolclause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterBoolclause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitBoolclause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitBoolclause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolclauseContext boolclause() throws RecognitionException {
		BoolclauseContext _localctx = new BoolclauseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_boolclause);
		try {
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_FRAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				curr_frame_assert_expr();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				assert_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Curr_frame_assert_exprContext extends ParserRuleContext {
		public TerminalNode CURRENT_FRAME() { return getToken(GraphicalParser.CURRENT_FRAME, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Curr_frame_assert_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_curr_frame_assert_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterCurr_frame_assert_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitCurr_frame_assert_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitCurr_frame_assert_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Curr_frame_assert_exprContext curr_frame_assert_expr() throws RecognitionException {
		Curr_frame_assert_exprContext _localctx = new Curr_frame_assert_exprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_curr_frame_assert_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(CURRENT_FRAME);
			setState(252);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assert_exprContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(GraphicalParser.ASSERT, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode HAS() { return getToken(GraphicalParser.HAS, 0); }
		public Object_assignContext object_assign() {
			return getRuleContext(Object_assignContext.class,0);
		}
		public Assert_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterAssert_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitAssert_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitAssert_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assert_exprContext assert_expr() throws RecognitionException {
		Assert_exprContext _localctx = new Assert_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_assert_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(ASSERT);
			setState(255);
			id();
			setState(256);
			match(HAS);
			setState(257);
			object_assign();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Tuple_statementContext extends ParserRuleContext {
		public TerminalNode TUPLE_START() { return getToken(GraphicalParser.TUPLE_START, 0); }
		public TerminalNode TUPLE_VALUES() { return getToken(GraphicalParser.TUPLE_VALUES, 0); }
		public TerminalNode TUPLE_END() { return getToken(GraphicalParser.TUPLE_END, 0); }
		public Tuple_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterTuple_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitTuple_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitTuple_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tuple_statementContext tuple_statement() throws RecognitionException {
		Tuple_statementContext _localctx = new Tuple_statementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_tuple_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(TUPLE_START);
			setState(260);
			match(TUPLE_VALUES);
			setState(261);
			match(TUPLE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShapesContext extends ParserRuleContext {
		public TerminalNode SQUARE() { return getToken(GraphicalParser.SQUARE, 0); }
		public TerminalNode RECTANGLE() { return getToken(GraphicalParser.RECTANGLE, 0); }
		public TerminalNode TRIANGLE() { return getToken(GraphicalParser.TRIANGLE, 0); }
		public TerminalNode CIRCLE() { return getToken(GraphicalParser.CIRCLE, 0); }
		public TerminalNode LINE() { return getToken(GraphicalParser.LINE, 0); }
		public ShapesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shapes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterShapes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitShapes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitShapes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapesContext shapes() throws RecognitionException {
		ShapesContext _localctx = new ShapesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_shapes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColoursContext extends ParserRuleContext {
		public TerminalNode RED() { return getToken(GraphicalParser.RED, 0); }
		public TerminalNode BLACK() { return getToken(GraphicalParser.BLACK, 0); }
		public TerminalNode BLUE() { return getToken(GraphicalParser.BLUE, 0); }
		public TerminalNode BROWN() { return getToken(GraphicalParser.BROWN, 0); }
		public TerminalNode GRAY() { return getToken(GraphicalParser.GRAY, 0); }
		public TerminalNode GREEN() { return getToken(GraphicalParser.GREEN, 0); }
		public TerminalNode ORANGE() { return getToken(GraphicalParser.ORANGE, 0); }
		public TerminalNode PINK() { return getToken(GraphicalParser.PINK, 0); }
		public TerminalNode PURPLE() { return getToken(GraphicalParser.PURPLE, 0); }
		public TerminalNode WHITE() { return getToken(GraphicalParser.WHITE, 0); }
		public TerminalNode YELLOW() { return getToken(GraphicalParser.YELLOW, 0); }
		public TerminalNode HEX_VALUE() { return getToken(GraphicalParser.HEX_VALUE, 0); }
		public Rgb_statementContext rgb_statement() {
			return getRuleContext(Rgb_statementContext.class,0);
		}
		public Rgba_statementContext rgba_statement() {
			return getRuleContext(Rgba_statementContext.class,0);
		}
		public ColoursContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colours; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterColours(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitColours(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitColours(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColoursContext colours() throws RecognitionException {
		ColoursContext _localctx = new ColoursContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_colours);
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				match(RED);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				match(BLACK);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
				match(BLUE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(268);
				match(BROWN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(269);
				match(GRAY);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(270);
				match(GREEN);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(271);
				match(ORANGE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(272);
				match(PINK);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(273);
				match(PURPLE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(274);
				match(WHITE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(275);
				match(YELLOW);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(276);
				match(HEX_VALUE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(277);
				rgb_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(278);
				rgba_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rgb_statementContext extends ParserRuleContext {
		public TerminalNode COLOUR_TUPLE_START() { return getToken(GraphicalParser.COLOUR_TUPLE_START, 0); }
		public List<TerminalNode> COLOUR_NUMBER() { return getTokens(GraphicalParser.COLOUR_NUMBER); }
		public TerminalNode COLOUR_NUMBER(int i) {
			return getToken(GraphicalParser.COLOUR_NUMBER, i);
		}
		public List<TerminalNode> COLOUR_SEP() { return getTokens(GraphicalParser.COLOUR_SEP); }
		public TerminalNode COLOUR_SEP(int i) {
			return getToken(GraphicalParser.COLOUR_SEP, i);
		}
		public TerminalNode COLOUR_TUPLE_END() { return getToken(GraphicalParser.COLOUR_TUPLE_END, 0); }
		public Rgb_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rgb_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterRgb_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitRgb_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitRgb_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rgb_statementContext rgb_statement() throws RecognitionException {
		Rgb_statementContext _localctx = new Rgb_statementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_rgb_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(COLOUR_TUPLE_START);
			setState(282);
			match(COLOUR_NUMBER);
			setState(283);
			match(COLOUR_SEP);
			setState(284);
			match(COLOUR_NUMBER);
			setState(285);
			match(COLOUR_SEP);
			setState(286);
			match(COLOUR_NUMBER);
			setState(287);
			match(COLOUR_TUPLE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rgba_statementContext extends ParserRuleContext {
		public TerminalNode COLOUR_TUPLE_START() { return getToken(GraphicalParser.COLOUR_TUPLE_START, 0); }
		public List<TerminalNode> COLOUR_NUMBER() { return getTokens(GraphicalParser.COLOUR_NUMBER); }
		public TerminalNode COLOUR_NUMBER(int i) {
			return getToken(GraphicalParser.COLOUR_NUMBER, i);
		}
		public List<TerminalNode> COLOUR_SEP() { return getTokens(GraphicalParser.COLOUR_SEP); }
		public TerminalNode COLOUR_SEP(int i) {
			return getToken(GraphicalParser.COLOUR_SEP, i);
		}
		public TerminalNode COLOUR_NUMBER_RGBA_DECIMAL() { return getToken(GraphicalParser.COLOUR_NUMBER_RGBA_DECIMAL, 0); }
		public TerminalNode COLOUR_TUPLE_END() { return getToken(GraphicalParser.COLOUR_TUPLE_END, 0); }
		public Rgba_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rgba_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterRgba_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitRgba_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitRgba_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rgba_statementContext rgba_statement() throws RecognitionException {
		Rgba_statementContext _localctx = new Rgba_statementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_rgba_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(COLOUR_TUPLE_START);
			setState(290);
			match(COLOUR_NUMBER);
			setState(291);
			match(COLOUR_SEP);
			setState(292);
			match(COLOUR_NUMBER);
			setState(293);
			match(COLOUR_SEP);
			setState(294);
			match(COLOUR_NUMBER);
			setState(295);
			match(COLOUR_SEP);
			setState(296);
			match(COLOUR_NUMBER_RGBA_DECIMAL);
			setState(297);
			match(COLOUR_TUPLE_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SizesContext extends ParserRuleContext {
		public TerminalNode SIZE_NUMBER() { return getToken(GraphicalParser.SIZE_NUMBER, 0); }
		public TerminalNode SIZE_TUPLE() { return getToken(GraphicalParser.SIZE_TUPLE, 0); }
		public SizesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterSizes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitSizes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitSizes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizesContext sizes() throws RecognitionException {
		SizesContext _localctx = new SizesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sizes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_la = _input.LA(1);
			if ( !(_la==SIZE_NUMBER || _la==SIZE_TUPLE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RotationsContext extends ParserRuleContext {
		public TerminalNode ROTATION_VALUE() { return getToken(GraphicalParser.ROTATION_VALUE, 0); }
		public RotationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).enterRotations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphicalParserListener ) ((GraphicalParserListener)listener).exitRotations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphicalParserVisitor ) return ((GraphicalParserVisitor<? extends T>)visitor).visitRotations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotationsContext rotations() throws RecognitionException {
		RotationsContext _localctx = new RotationsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_rotations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(ROTATION_VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001L\u0130\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0001\u0000\u0005\u0000T\b\u0000\n\u0000\f\u0000W\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001^\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0003\u0003f\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007r\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0083\b\u000b\n\u000b\f\u000b\u0086"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u008f\b\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u00aa\b\u0014\n\u0014\f\u0014\u00ad\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u00b6\b\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00ba"+
		"\b\u0016\n\u0016\f\u0016\u00bd\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u00c6\b\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u00cc\b\u0019"+
		"\n\u0019\f\u0019\u00cf\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0004"+
		"\u001b\u00da\b\u001b\u000b\u001b\f\u001b\u00db\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0004\u001c\u00e6\b\u001c\u000b\u001c\f\u001c\u00e7\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0004\u001c\u00ee\b\u001c\u000b\u001c\f"+
		"\u001c\u00ef\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0003\u001f\u00fa\b\u001f\u0001 "+
		"\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0118\b$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0000\u0000)\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNP\u0000"+
		"\u0005\u0001\u0000\u0002\u0003\u0001\u0000\b\n\u0001\u0000\u0018\u0019"+
		"\u0001\u0000EI\u0001\u0000KL\u012a\u0000U\u0001\u0000\u0000\u0000\u0002"+
		"]\u0001\u0000\u0000\u0000\u0004_\u0001\u0000\u0000\u0000\u0006e\u0001"+
		"\u0000\u0000\u0000\bg\u0001\u0000\u0000\u0000\nj\u0001\u0000\u0000\u0000"+
		"\fl\u0001\u0000\u0000\u0000\u000eq\u0001\u0000\u0000\u0000\u0010s\u0001"+
		"\u0000\u0000\u0000\u0012v\u0001\u0000\u0000\u0000\u0014{\u0001\u0000\u0000"+
		"\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u008e\u0001\u0000\u0000\u0000"+
		"\u001a\u0090\u0001\u0000\u0000\u0000\u001c\u0093\u0001\u0000\u0000\u0000"+
		"\u001e\u0096\u0001\u0000\u0000\u0000 \u0099\u0001\u0000\u0000\u0000\""+
		"\u009c\u0001\u0000\u0000\u0000$\u009f\u0001\u0000\u0000\u0000&\u00a2\u0001"+
		"\u0000\u0000\u0000(\u00a5\u0001\u0000\u0000\u0000*\u00ae\u0001\u0000\u0000"+
		"\u0000,\u00b1\u0001\u0000\u0000\u0000.\u00be\u0001\u0000\u0000\u00000"+
		"\u00c5\u0001\u0000\u0000\u00002\u00c7\u0001\u0000\u0000\u00004\u00d4\u0001"+
		"\u0000\u0000\u00006\u00d7\u0001\u0000\u0000\u00008\u00e0\u0001\u0000\u0000"+
		"\u0000:\u00f3\u0001\u0000\u0000\u0000<\u00f5\u0001\u0000\u0000\u0000>"+
		"\u00f9\u0001\u0000\u0000\u0000@\u00fb\u0001\u0000\u0000\u0000B\u00fe\u0001"+
		"\u0000\u0000\u0000D\u0103\u0001\u0000\u0000\u0000F\u0107\u0001\u0000\u0000"+
		"\u0000H\u0117\u0001\u0000\u0000\u0000J\u0119\u0001\u0000\u0000\u0000L"+
		"\u0121\u0001\u0000\u0000\u0000N\u012b\u0001\u0000\u0000\u0000P\u012d\u0001"+
		"\u0000\u0000\u0000RT\u0003\u0002\u0001\u0000SR\u0001\u0000\u0000\u0000"+
		"TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000"+
		"\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XY\u0005\u0000"+
		"\u0000\u0001Y\u0001\u0001\u0000\u0000\u0000Z^\u0003\u0004\u0002\u0000"+
		"[^\u00030\u0018\u0000\\^\u00038\u001c\u0000]Z\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^\u0003\u0001\u0000"+
		"\u0000\u0000_`\u0005\u0001\u0000\u0000`a\u0003\n\u0005\u0000ab\u0003\u0006"+
		"\u0003\u0000b\u0005\u0001\u0000\u0000\u0000cf\u0003\b\u0004\u0000df\u0003"+
		"(\u0014\u0000ec\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000f\u0007"+
		"\u0001\u0000\u0000\u0000gh\u0003\f\u0006\u0000hi\u0003\u000e\u0007\u0000"+
		"i\t\u0001\u0000\u0000\u0000jk\u0005(\u0000\u0000k\u000b\u0001\u0000\u0000"+
		"\u0000lm\u0007\u0000\u0000\u0000m\r\u0001\u0000\u0000\u0000nr\u0003\u0010"+
		"\b\u0000or\u0003\u0012\t\u0000pr\u0003\n\u0005\u0000qn\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000r\u000f\u0001"+
		"\u0000\u0000\u0000st\u0005%\u0000\u0000tu\u0003\u0016\u000b\u0000u\u0011"+
		"\u0001\u0000\u0000\u0000vw\u0005&\u0000\u0000wx\u0005\u0006\u0000\u0000"+
		"xy\u0003\n\u0005\u0000yz\u0003,\u0016\u0000z\u0013\u0001\u0000\u0000\u0000"+
		"{|\u0007\u0001\u0000\u0000|\u0015\u0001\u0000\u0000\u0000}~\u0005\u0004"+
		"\u0000\u0000~\u0084\u0003\u0018\f\u0000\u007f\u0080\u0003\u0014\n\u0000"+
		"\u0080\u0081\u0003\u0018\f\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082"+
		"\u007f\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0017\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u008f\u0003\u001a\r\u0000\u0088\u008f\u0003\u001c\u000e\u0000\u0089\u008f"+
		"\u0003\u001e\u000f\u0000\u008a\u008f\u0003 \u0010\u0000\u008b\u008f\u0003"+
		"\"\u0011\u0000\u008c\u008f\u0003$\u0012\u0000\u008d\u008f\u0003&\u0013"+
		"\u0000\u008e\u0087\u0001\u0000\u0000\u0000\u008e\u0088\u0001\u0000\u0000"+
		"\u0000\u008e\u0089\u0001\u0000\u0000\u0000\u008e\u008a\u0001\u0000\u0000"+
		"\u0000\u008e\u008b\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0019\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0005\u000e\u0000\u0000\u0091\u0092\u0003F#\u0000\u0092"+
		"\u001b\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u000f\u0000\u0000\u0094"+
		"\u0095\u0003H$\u0000\u0095\u001d\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		"\u0010\u0000\u0000\u0097\u0098\u0003N\'\u0000\u0098\u001f\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0005\u0011\u0000\u0000\u009a\u009b\u0005)\u0000"+
		"\u0000\u009b!\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0013\u0000\u0000"+
		"\u009d\u009e\u0003P(\u0000\u009e#\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0005\u0014\u0000\u0000\u00a0\u00a1\u0003D\"\u0000\u00a1%\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u0015\u0000\u0000\u00a3\u00a4\u0003D\""+
		"\u0000\u00a4\'\u0001\u0000\u0000\u0000\u00a5\u00ab\u0003*\u0015\u0000"+
		"\u00a6\u00a7\u0003\u0014\n\u0000\u00a7\u00a8\u0003*\u0015\u0000\u00a8"+
		"\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a6\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ad\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac)\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0005\u0012\u0000\u0000\u00af\u00b0"+
		"\u0003.\u0017\u0000\u00b0+\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005\u0005"+
		"\u0000\u0000\u00b2\u00bb\u0003.\u0017\u0000\u00b3\u00b5\u0003\u0014\n"+
		"\u0000\u00b4\u00b6\u0005\u0005\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0003.\u0017\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b3\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc-\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0003\n\u0005\u0000\u00bf\u00c0\u0005\u0007\u0000\u0000\u00c0\u00c1"+
		"\u0003D\"\u0000\u00c1/\u0001\u0000\u0000\u0000\u00c2\u00c6\u00032\u0019"+
		"\u0000\u00c3\u00c6\u00034\u001a\u0000\u00c4\u00c6\u00036\u001b\u0000\u00c5"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c61\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0005\u0016\u0000\u0000\u00c8\u00cd\u0003\n\u0005\u0000\u00c9\u00ca\u0005"+
		"\u000b\u0000\u0000\u00ca\u00cc\u0003\n\u0005\u0000\u00cb\u00c9\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0001\u0000"+
		"\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\u0017"+
		"\u0000\u0000\u00d1\u00d2\u0005)\u0000\u0000\u00d2\u00d3\u0007\u0002\u0000"+
		"\u0000\u00d33\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u001a\u0000\u0000"+
		"\u00d5\u00d6\u0003\n\u0005\u0000\u00d65\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d9\u0005\u001b\u0000\u0000\u00d8\u00da\u0003\u0002\u0001\u0000\u00d9"+
		"\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0005\u0017\u0000\u0000\u00de"+
		"\u00df\u0005)\u0000\u0000\u00df7\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005"+
		"\u001e\u0000\u0000\u00e1\u00e2\u0003>\u001f\u0000\u00e2\u00e3\u0005 \u0000"+
		"\u0000\u00e3\u00e5\u0005\u001c\u0000\u0000\u00e4\u00e6\u0003:\u001d\u0000"+
		"\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u001d\u0000\u0000"+
		"\u00ea\u00eb\u0005!\u0000\u0000\u00eb\u00ed\u0005\u001c\u0000\u0000\u00ec"+
		"\u00ee\u0003<\u001e\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0005\u001d\u0000\u0000\u00f29\u0001\u0000\u0000\u0000\u00f3\u00f4\u0003"+
		"\u0002\u0001\u0000\u00f4;\u0001\u0000\u0000\u0000\u00f5\u00f6\u0003\u0002"+
		"\u0001\u0000\u00f6=\u0001\u0000\u0000\u0000\u00f7\u00fa\u0003@ \u0000"+
		"\u00f8\u00fa\u0003B!\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00f8"+
		"\u0001\u0000\u0000\u0000\u00fa?\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005"+
		"\u001f\u0000\u0000\u00fc\u00fd\u0003\n\u0005\u0000\u00fdA\u0001\u0000"+
		"\u0000\u0000\u00fe\u00ff\u0005#\u0000\u0000\u00ff\u0100\u0003\n\u0005"+
		"\u0000\u0100\u0101\u0005\"\u0000\u0000\u0101\u0102\u0003\u0018\f\u0000"+
		"\u0102C\u0001\u0000\u0000\u0000\u0103\u0104\u0005\r\u0000\u0000\u0104"+
		"\u0105\u0005*\u0000\u0000\u0105\u0106\u0005-\u0000\u0000\u0106E\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0007\u0003\u0000\u0000\u0108G\u0001\u0000"+
		"\u0000\u0000\u0109\u0118\u0005.\u0000\u0000\u010a\u0118\u0005/\u0000\u0000"+
		"\u010b\u0118\u00050\u0000\u0000\u010c\u0118\u00051\u0000\u0000\u010d\u0118"+
		"\u00052\u0000\u0000\u010e\u0118\u00053\u0000\u0000\u010f\u0118\u00054"+
		"\u0000\u0000\u0110\u0118\u00055\u0000\u0000\u0111\u0118\u00056\u0000\u0000"+
		"\u0112\u0118\u00057\u0000\u0000\u0113\u0118\u00058\u0000\u0000\u0114\u0118"+
		"\u00059\u0000\u0000\u0115\u0118\u0003J%\u0000\u0116\u0118\u0003L&\u0000"+
		"\u0117\u0109\u0001\u0000\u0000\u0000\u0117\u010a\u0001\u0000\u0000\u0000"+
		"\u0117\u010b\u0001\u0000\u0000\u0000\u0117\u010c\u0001\u0000\u0000\u0000"+
		"\u0117\u010d\u0001\u0000\u0000\u0000\u0117\u010e\u0001\u0000\u0000\u0000"+
		"\u0117\u010f\u0001\u0000\u0000\u0000\u0117\u0110\u0001\u0000\u0000\u0000"+
		"\u0117\u0111\u0001\u0000\u0000\u0000\u0117\u0112\u0001\u0000\u0000\u0000"+
		"\u0117\u0113\u0001\u0000\u0000\u0000\u0117\u0114\u0001\u0000\u0000\u0000"+
		"\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0116\u0001\u0000\u0000\u0000"+
		"\u0118I\u0001\u0000\u0000\u0000\u0119\u011a\u0005:\u0000\u0000\u011a\u011b"+
		"\u0005;\u0000\u0000\u011b\u011c\u0005=\u0000\u0000\u011c\u011d\u0005;"+
		"\u0000\u0000\u011d\u011e\u0005=\u0000\u0000\u011e\u011f\u0005;\u0000\u0000"+
		"\u011f\u0120\u0005>\u0000\u0000\u0120K\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0005:\u0000\u0000\u0122\u0123\u0005;\u0000\u0000\u0123\u0124\u0005="+
		"\u0000\u0000\u0124\u0125\u0005;\u0000\u0000\u0125\u0126\u0005=\u0000\u0000"+
		"\u0126\u0127\u0005;\u0000\u0000\u0127\u0128\u0005=\u0000\u0000\u0128\u0129"+
		"\u0005<\u0000\u0000\u0129\u012a\u0005>\u0000\u0000\u012aM\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0007\u0004\u0000\u0000\u012cO\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0005D\u0000\u0000\u012eQ\u0001\u0000\u0000\u0000\u0010"+
		"U]eq\u0084\u008e\u00ab\u00b5\u00bb\u00c5\u00cd\u00db\u00e7\u00ef\u00f9"+
		"\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}