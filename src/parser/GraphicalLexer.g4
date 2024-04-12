lexer grammar GraphicalLexer;

// EXAMPLE PROGRAM
// ------------------------------------
// Let orange1 be an object with shape = circle, size = 30, colour = orange, rotation = 30 degrees
// Let orange2 be an orange1
// Let tree be an object with shape = rectangle, colour = #964b00, size = (10,40), owns orange1 at (10,30), rotation = 1 radians
// Let canvas be an object with shape = rectangle, colour = (255,255,255), size = (100,100)
//
// Let frame1 be an image on canvas with orange2 at (50,30) and tree at (50,0)
// Let frame2 be an    image    on   canvas    with    orange2    at    (50, 0) and tree at (50,0)
//
// IF Assert that orange2 has size = 30
//      THEN    ANIMATE frame1 -> frame2 FOR 5 seconds
//      ELSE    DRAW frame2

// (DEFAULT_MODE)
LET_START: 'Let' WS* -> mode(TYPE_MODE);
LET_OBJ_DECL: 'be' WS+ 'a' WS* -> mode(TYPE_MODE);
LET_OBJ_DECL_ALT: 'be' WS+ 'an' WS* -> mode(TYPE_MODE); // just to support natural language promise
LET_OBJ_FIELDS: 'with' WS*;
LET_OBJ_PLACEMENT: 'placing' WS* -> mode(TYPE_MODE);
LET_OBJ_RELATE: 'on' WS* -> mode(TYPE_MODE);
LET_OBJ_POSITION: 'at' WS*;

// FIELD LIST SEPERATORS
SEP: ',' WS*;
AND_SEP: 'and' WS*;
OXFORD_COMMA_SEP: SEP AND_SEP;

// FIELD DESCRIPTORS
CONNECTOR: '->' WS* -> mode(TYPE_MODE);
ASSIGNMENT: '=' WS*;
TUPLE_START: '(' WS* -> mode(TUPLE_MODE);

// POSSIBLE OBJECT FIELDS
SHAPE_FIELD: 'shape' WS* ASSIGNMENT WS* -> mode(SHAPE_MODE);
COLOUR_FIELD: 'colour' WS* ASSIGNMENT WS* -> mode(COLOUR_MODE);
SIZE_FIELD: 'size' WS* ASSIGNMENT WS* -> mode(SIZE_MODE);
OPACITY: 'opacity' WS* ASSIGNMENT WS* -> mode(NUMBER_MODE);
OWNERSHIP: 'own''s'?  WS* -> mode(TYPE_MODE);
ROTATION_FIELD: 'rotation' WS* ASSIGNMENT WS* -> mode(ROTATION_MODE);
SHEAR: 'shear' WS* ASSIGNMENT WS* -> mode(NUMBER_MODE);
SCALE: 'scale' WS* ASSIGNMENT WS* -> mode(NUMBER_MODE);

// FUNCTIONS / LOOP
ANIMATE_START: 'ANIMATE' WS* -> mode(TYPE_MODE);
DURATION_LENGTH: 'FOR' WS* -> mode(NUMBER_MODE);
ANIMATE_DURATION_SECONDS: 'second' | 'seconds';
ANIMATE_DURATION_MINUTES: 'minute' | 'minutes';
DRAW_START: 'DRAW' WS* -> mode(TYPE_MODE);
REPEAT: 'REPEAT' WS*;

// CONDITIONALS
OPENING_BRACE: '{' WS*;
CLOSING_BRACE: '}' WS*;
IF: 'IF' WS*;
CURRENT_FRAME: '$current_frame' WS* ASSIGNMENT -> mode(TYPE_MODE);
THEN: 'THEN' WS*;
ELSE: 'ELSE' WS*;
HAS: 'has' WS*;
ASSERT: 'Assert that' WS* -> mode(TYPE_MODE);

// Line breaks are ignored during tokenization (note that this rule only applies in DEFAULT_MODE, not IDENT_MODE)
WS : [\r\n\t ] -> channel(HIDDEN);

// Mode for handling arbitrary types of entities
mode TYPE_MODE;
OBJECT: 'object' -> mode(DEFAULT_MODE);
IMAGE: 'image' -> mode(DEFAULT_MODE);
MESH: 'mesh' -> mode(DEFAULT_MODE);
TEXT: ~[ {}[|\]\r\n]+ -> mode(DEFAULT_MODE);

mode NUMBER_MODE;
NUMBER: '-'?[0-9]+('.'[0-9]+)? -> mode(DEFAULT_MODE);

mode TUPLE_MODE;
TUPLE_VALUES: TUPLE_DIMENSION (TUPLE_SEP TUPLE_DIMENSION)*;
TUPLE_DIMENSION: '-'?[0-9]+('.'[0-9]+)? WS*;
TUPLE_SEP: ',' WS*;
TUPLE_END: ')' -> mode(DEFAULT_MODE);

mode COLOUR_MODE;
RED: 'red' -> mode(DEFAULT_MODE);
BLACK: 'black' -> mode(DEFAULT_MODE);
BLUE: 'blue' -> mode(DEFAULT_MODE);
BROWN: 'brown' -> mode(DEFAULT_MODE);
GRAY: ('gray' | 'grey') -> mode(DEFAULT_MODE);
GREEN: 'green' -> mode(DEFAULT_MODE);
ORANGE: 'orange' -> mode(DEFAULT_MODE);
PINK: 'pink' -> mode(DEFAULT_MODE);
PURPLE: 'purple' -> mode(DEFAULT_MODE);
WHITE: 'white' -> mode(DEFAULT_MODE);
YELLOW: 'yellow' -> mode(DEFAULT_MODE);
HEX_VALUE: '#' [a-fA-F0-9] [a-fA-F0-9] [a-fA-F0-9] [a-fA-F0-9] [a-fA-F0-9] [a-fA-F0-9] -> mode(DEFAULT_MODE);
COLOUR_TUPLE_START: '(' WS*;
COLOUR_NUMBER: [0-9]+;
COLOUR_NUMBER_RGBA_DECIMAL: '0' ('.' [0-9]+) | '1' ('.' '0'+);
COLOUR_SEP: ',' WS*;
COLOUR_TUPLE_END: ')' -> mode(DEFAULT_MODE);
COLOUR_TEXT:  ~[ {}()[|\]\r\n,]+ -> mode(DEFAULT_MODE);

mode ROTATION_MODE;
ROTATION_NUM: '-'?[0-9]+('.'[0-9]+)?;
// ROTATION UNITS
DEGREE: 'degree''s'?;
RADIAN: 'radian''s'?;
ROTATION_UNIT: (DEGREE | RADIAN);
ROTATION_VALUE: ROTATION_NUM WS* ROTATION_UNIT -> mode(DEFAULT_MODE);

mode SHAPE_MODE;
// PRE-EXISTING SHAPES
// (NOTE: semantic rules should state how size relates to shape
// i.e. a rectangle must have width & length but a circle must just have radius)
CIRCLE: 'circle' -> mode(DEFAULT_MODE);
LINE: 'line' -> mode(DEFAULT_MODE);
RECTANGLE: 'rectangle' -> mode(DEFAULT_MODE);
SQUARE: 'square' -> mode(DEFAULT_MODE);
TRIANGLE: 'triangle' -> mode(DEFAULT_MODE);
SHAPE_TEXT: ~[ {}[|\]\r\n,]+ -> mode(DEFAULT_MODE);

mode SIZE_MODE;
SIZE_NUMBER: NUMBER -> mode(DEFAULT_MODE);
SIZE_TUPLE: '(' WS* TUPLE_VALUES WS* ')' -> mode(DEFAULT_MODE);
