// Generated from /Users/natha/Documents/COMP_312/homework-1-nathanjunzhao/src/main/rice/BooleanExprParser.g4 by ANTLR 4.13.2
package main.rice;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BooleanExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BooleanExprParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BooleanExprParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(BooleanExprParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or_Exp}
	 * labeled alternative in {@link BooleanExprParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_Exp(BooleanExprParser.Or_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or_Single_Exp}
	 * labeled alternative in {@link BooleanExprParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_Single_Exp(BooleanExprParser.Or_Single_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And_Exp}
	 * labeled alternative in {@link BooleanExprParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_Exp(BooleanExprParser.And_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And_Single_Exp}
	 * labeled alternative in {@link BooleanExprParser#orExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_Single_Exp(BooleanExprParser.And_Single_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal_Exp}
	 * labeled alternative in {@link BooleanExprParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual_Exp(BooleanExprParser.Equal_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal_Single_Exp}
	 * labeled alternative in {@link BooleanExprParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual_Single_Exp(BooleanExprParser.Equal_Single_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary}
	 * labeled alternative in {@link BooleanExprParser#equalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(BooleanExprParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unary_Single_Exp}
	 * labeled alternative in {@link BooleanExprParser#equalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_Single_Exp(BooleanExprParser.Unary_Single_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren_Bool}
	 * labeled alternative in {@link BooleanExprParser#boolUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_Bool(BooleanExprParser.Paren_BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Simple_Bool}
	 * labeled alternative in {@link BooleanExprParser#boolUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_Bool(BooleanExprParser.Simple_BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numeric_Relation}
	 * labeled alternative in {@link BooleanExprParser#boolUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_Relation(BooleanExprParser.Numeric_RelationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numeric_Equal_Exp}
	 * labeled alternative in {@link BooleanExprParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_Equal_Exp(BooleanExprParser.Numeric_Equal_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numeric_Relation_Exp}
	 * labeled alternative in {@link BooleanExprParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_Relation_Exp(BooleanExprParser.Numeric_Relation_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add_Single_Exp}
	 * labeled alternative in {@link BooleanExprParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_Single_Exp(BooleanExprParser.Add_Single_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add_Exp}
	 * labeled alternative in {@link BooleanExprParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_Exp(BooleanExprParser.Add_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult_Exp}
	 * labeled alternative in {@link BooleanExprParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_Exp(BooleanExprParser.Mult_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult_Single_Exp}
	 * labeled alternative in {@link BooleanExprParser#multExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_Single_Exp(BooleanExprParser.Mult_Single_ExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numeric_Paren}
	 * labeled alternative in {@link BooleanExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_Paren(BooleanExprParser.Numeric_ParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Simple_Number}
	 * labeled alternative in {@link BooleanExprParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_Number(BooleanExprParser.Simple_NumberContext ctx);
}