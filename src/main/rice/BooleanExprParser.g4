parser grammar BooleanExprParser;

options {
    tokenVocab = BooleanExprLexer;
}

start : booleanExpr EOF;

booleanExpr : booleanExpr OR orExpr #Or_Exp
            | orExpr #Or_Single_Exp
            ;

orExpr : orExpr AND andExpr #And_Exp
       | andExpr #And_Single_Exp
       ;

andExpr : andExpr EQUAL equalExpr #Equal_Exp
        | equalExpr #Equal_Single_Exp
        ;

equalExpr : UNA boolUnit #Unary
          | boolUnit #Unary_Single_Exp
          ;

boolUnit : LPAREN booleanExpr RPAREN #Paren_Bool
         | BOOL #Simple_Bool
         | numExpr #Numeric_Relation
         ;

numExpr : addExpr EQUAL addExpr #Numeric_Equal_Exp
        | addExpr REL addExpr #Numeric_Relation_Exp
        ;

addExpr : addExpr ADD multExpr #Add_Exp
        | multExpr #Add_Single_Exp
        ;

multExpr : multExpr MULT term #Mult_Exp
         | term #Mult_Single_Exp
         ;

term : LPAREN addExpr RPAREN #Numeric_Paren
     | INT #Simple_Number
     ;
