lexer grammar BooleanExprLexer;

BOOL : 'true' | 'false';
INT : ([1-9][0-9]*)|'0';
OR : '||';
AND : '&&';
EQUAL : '==' | '!=';
REL : '>' | '<' | '>=' | '<=';
UNA : '!';
ADD : '+' | '-';
MULT : '*' | '/';
LPAREN : '(';
RPAREN : ')';
SPACE : [ \t\n\r] -> skip;