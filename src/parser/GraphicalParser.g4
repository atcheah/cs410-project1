parser grammar GraphicalParser;
options { tokenVocab=GraphicalLexer; }

// Grammar
program : expr* EOF;
expr : let_expr | function_expr | if_expr;

let_expr: LET_START id let_config;
let_config: let_instantiate | let_ownership_assignment;
let_instantiate: let_declare let_statement;
id : TEXT;
let_declare : LET_OBJ_DECL | LET_OBJ_DECL_ALT;
let_statement: let_object | let_image | id;
let_object: OBJECT let_object_assignment;
let_image: IMAGE LET_OBJ_RELATE id let_image_assignment;
verbal_sep : SEP | AND_SEP | OXFORD_COMMA_SEP;

let_object_assignment: (LET_OBJ_FIELDS object_assign (verbal_sep object_assign)*);
object_assign : shape_assign | colour_assign | size_assign | opacity_assign  | rotation_assign | shear_assign | scale_assign;
shape_assign : SHAPE_FIELD  shapes;
colour_assign : COLOUR_FIELD  colours;
size_assign : SIZE_FIELD sizes ;
opacity_assign : OPACITY NUMBER;
rotation_assign: ROTATION_FIELD  rotations;
shear_assign: SHEAR  tuple_statement;
scale_assign: SCALE  tuple_statement;

let_ownership_assignment : (ownership_assign (verbal_sep ownership_assign)*);
ownership_assign : OWNERSHIP position_assign;

let_image_assignment : (LET_OBJ_PLACEMENT position_assign (verbal_sep LET_OBJ_PLACEMENT? position_assign)*);
position_assign : id LET_OBJ_POSITION tuple_statement;

/* ALTERNATIVE DESIGN: with below code,
- logic that size cannot be assigned to colours is abstracted and would have to be done in semantic analysis
let_field_assignment : equality_assign | relational_assign;
equality_assign : equality_fields ASSIGNMENT equality_values;
ownership_assign: ownership_fields CONNECTOR ownership_values;
equality_fields: SHAPE_FIELD | COLOUR_FIELD | SIZE_FIELD | OPACITY
equality_values: shapes | colours | tuple_statement | NUMBER
ownership_fields: OWNERSHIP
ownership_values: id;
*/

function_expr : animate_call | draw_call | repeat_call;
animate_call : ANIMATE_START id (CONNECTOR id)* DURATION_LENGTH NUMBER (ANIMATE_DURATION_SECONDS | ANIMATE_DURATION_MINUTES);
draw_call : DRAW_START id;
repeat_call: REPEAT expr+ DURATION_LENGTH NUMBER;

// TODO: CHECK THIS OVER
if_expr: IF boolclause THEN OPENING_BRACE then_expr+ CLOSING_BRACE ELSE OPENING_BRACE else_expr+ CLOSING_BRACE;
then_expr: expr;
else_expr: expr;
boolclause: curr_frame_assert_expr | assert_expr;
curr_frame_assert_expr: CURRENT_FRAME id;
assert_expr: ASSERT id HAS object_assign;

tuple_statement : TUPLE_START TUPLE_VALUES TUPLE_END;
shapes : SQUARE | RECTANGLE | TRIANGLE | CIRCLE | LINE;
colours : RED | BLACK | BLUE | BROWN | GRAY | GREEN | ORANGE | PINK | PURPLE | WHITE | YELLOW | HEX_VALUE | rgb_statement | rgba_statement;
rgb_statement : COLOUR_TUPLE_START COLOUR_NUMBER COLOUR_SEP COLOUR_NUMBER COLOUR_SEP COLOUR_NUMBER COLOUR_TUPLE_END;
rgba_statement: COLOUR_TUPLE_START COLOUR_NUMBER COLOUR_SEP COLOUR_NUMBER COLOUR_SEP COLOUR_NUMBER COLOUR_SEP COLOUR_NUMBER_RGBA_DECIMAL COLOUR_TUPLE_END;
sizes : SIZE_NUMBER | SIZE_TUPLE;
rotations: ROTATION_VALUE;
