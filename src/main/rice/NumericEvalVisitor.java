package main.rice;

public class NumericEvalVisitor extends BooleanExprParserBaseVisitor<Integer> {

    // addExpr : addExpr ADD multExpr #Add_Exp
    @Override
    public Integer visitAdd_Exp(BooleanExprParser.Add_ExpContext ctx) {
        int left = visit(ctx.addExpr());
        int right = visit(ctx.multExpr());

        String op = ctx.ADD().getText();

        if ("+".equals(op)) {
            return left + right;
        }
        else if ("-".equals(op)) {
            return left - right;
        }
        else {
            throw new RuntimeException("unknown operator in Add_Exp");
        }
    }

    // addExpr : multExpr #Add_Single_Exp
    @Override
    public Integer visitAdd_Single_Exp(BooleanExprParser.Add_Single_ExpContext ctx) {
        return visit(ctx.multExpr());
    }

    // multExpr : multExpr MULT term #Mult_Exp
    @Override
    public Integer visitMult_Exp(BooleanExprParser.Mult_ExpContext ctx) {
        int left = visit(ctx.multExpr());
        int right = visit(ctx.term());

        String op = ctx.MULT().getText();

        if ("*".equals(op)) {
            return left * right;
        }
        else if ("/".equals(op)) {
            return left / right;
        }
        else {
            throw new RuntimeException("unknown operator in Mult_Exp");
        }
    }

    // multExpr : term #Mult_Single_Exp
    @Override
    public Integer visitMult_Single_Exp(BooleanExprParser.Mult_Single_ExpContext ctx) {
        return visit(ctx.term());
    }

    // term : LPAREN addExpr RPAREN #Numeric_Paren
    @Override
    public Integer visitNumeric_Paren(BooleanExprParser.Numeric_ParenContext ctx) {
        return visit(ctx.addExpr());
    }

    // term : INT #Simple_Number
    @Override
    public Integer visitSimple_Number(BooleanExprParser.Simple_NumberContext ctx) {
        return Integer.parseInt(ctx.INT().getText());
    }
}
