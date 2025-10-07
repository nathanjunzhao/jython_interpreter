package main.rice;

public class EvalVisitor extends BooleanExprParserBaseVisitor<Boolean> {

    // create an instance of NumericEvalVisitor for arithmetic evaluations
    private final NumericEvalVisitor numericVisitor = new NumericEvalVisitor();

    @Override
    public Boolean visitStart(BooleanExprParser.StartContext ctx) {
        return visit(ctx.booleanExpr());
    }

    // -- boolean expression visitors

    // booleanExpr : booleanExpr OR orExpr #Or_Exp
    @Override
    public Boolean visitOr_Exp(BooleanExprParser.Or_ExpContext ctx) {
        Boolean left = visit(ctx.booleanExpr());
        Boolean right = visit(ctx.orExpr());
        return left || right;
    }

    // booleanExpr : orExpr #Or_Single_Exp
    @Override
    public Boolean visitOr_Single_Exp(BooleanExprParser.Or_Single_ExpContext ctx) {
        return visit(ctx.orExpr());
    }

    // orExpr : orExpr AND andExpr #And_Exp
    @Override
    public Boolean visitAnd_Exp(BooleanExprParser.And_ExpContext ctx) {
        Boolean left = visit(ctx.orExpr());
        Boolean right = visit(ctx.andExpr());
        return left && right;
    }

    // orExpr : andExpr #And_Single_Exp
    @Override
    public Boolean visitAnd_Single_Exp(BooleanExprParser.And_Single_ExpContext ctx) {
        return visit(ctx.andExpr());
    }

    // andExpr : andExpr EQUAL equalExpr #Equal_Exp
    @Override
    public Boolean visitEqual_Exp(BooleanExprParser.Equal_ExpContext ctx) {
        Boolean left = visit(ctx.andExpr());
        Boolean right = visit(ctx.equalExpr());
        String op = ctx.EQUAL().getText();

        if ("==".equals(op)) {
            return left.equals(right);
        }
        else if ("!=".equals(op)) {
            return !left.equals(right);
        }
        else {
            throw new RuntimeException("unknown operator in Equal_Exp");
        }
    }

    // andExpr : equalExpr #Equal_Single_Exp
    @Override
    public Boolean visitEqual_Single_Exp(BooleanExprParser.Equal_Single_ExpContext ctx) {
        return visit(ctx.equalExpr());
    }

    // equalExpr : UNA boolUnit #Unary
    @Override
    public Boolean visitUnary(BooleanExprParser.UnaryContext ctx) {
        return !visit(ctx.boolUnit());
    }

    // equalExpr : boolUnit #Unary_Single_Exp
    @Override
    public Boolean visitUnary_Single_Exp(BooleanExprParser.Unary_Single_ExpContext ctx) {
        return visit(ctx.boolUnit());
    }

    // boolUnit : LPAREN booleanExpr RPAREN #Paren_Bool
    @Override
    public Boolean visitParen_Bool(BooleanExprParser.Paren_BoolContext ctx) {
        return visit(ctx.booleanExpr());
    }

    // boolUnit : BOOL #Simple_Bool
    @Override
    public Boolean visitSimple_Bool(BooleanExprParser.Simple_BoolContext ctx) {
        return Boolean.parseBoolean(ctx.BOOL().getText());
    }

    // boolUnit : numExpr #Numeric_Relation
    @Override
    public Boolean visitNumeric_Relation(BooleanExprParser.Numeric_RelationContext ctx) {
        return visit(ctx.numExpr());
    }

    // -- numeric expression visitors

    // numExpr : addExpr EQUAL addExpr #Numeric_Equal_Exp
    @Override
    public Boolean visitNumeric_Equal_Exp(BooleanExprParser.Numeric_Equal_ExpContext ctx) {
        int left = numericVisitor.visit(ctx.addExpr(0));
        int right = numericVisitor.visit(ctx.addExpr(1));

        String op = ctx.EQUAL().getText();

        if ("==".equals(op)) {
            return left == right;
        }
        else if ("!=".equals(op)) {
            return left != right;
        }
        else {
            throw new RuntimeException("unknown operator in Numeric_Equal_Exp");
        }
    }

    // numExpr : addExpr REL addExpr #Numeric_Relation_Exp
    @Override
    public Boolean visitNumeric_Relation_Exp(BooleanExprParser.Numeric_Relation_ExpContext ctx) {
        int left = numericVisitor.visit(ctx.addExpr(0));
        int right = numericVisitor.visit(ctx.addExpr(1));

        String op = ctx.REL().getText();

        switch (op) {
            case ">":
                return left > right;
            case "<":
                return left < right;
            case ">=":
                return left >= right;
            case "<=":
                return left <= right;
            default:
                throw new RuntimeException("unknown relational operator");
        }
    }
}
