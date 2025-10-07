// Generated from /Users/natha/Documents/COMP_312/homework-1-nathanjunzhao/src/main/rice/BooleanExprParser.g4 by ANTLR 4.13.2
package main.rice;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BooleanExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOL=1, INT=2, OR=3, AND=4, EQUAL=5, REL=6, UNA=7, ADD=8, MULT=9, LPAREN=10, 
		RPAREN=11, SPACE=12;
	public static final int
		RULE_start = 0, RULE_booleanExpr = 1, RULE_orExpr = 2, RULE_andExpr = 3, 
		RULE_equalExpr = 4, RULE_boolUnit = 5, RULE_numExpr = 6, RULE_addExpr = 7, 
		RULE_multExpr = 8, RULE_term = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "booleanExpr", "orExpr", "andExpr", "equalExpr", "boolUnit", 
			"numExpr", "addExpr", "multExpr", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'||'", "'&&'", null, null, "'!'", null, null, "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOL", "INT", "OR", "AND", "EQUAL", "REL", "UNA", "ADD", "MULT", 
			"LPAREN", "RPAREN", "SPACE"
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
	public String getGrammarFileName() { return "BooleanExprParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BooleanExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BooleanExprParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			booleanExpr(0);
			setState(21);
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
	public static class BooleanExprContext extends ParserRuleContext {
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
	 
		public BooleanExprContext() { }
		public void copyFrom(BooleanExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Or_ExpContext extends BooleanExprContext {
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode OR() { return getToken(BooleanExprParser.OR, 0); }
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public Or_ExpContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitOr_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Or_Single_ExpContext extends BooleanExprContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public Or_Single_ExpContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitOr_Single_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		return booleanExpr(0);
	}

	private BooleanExprContext booleanExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, _parentState);
		BooleanExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_booleanExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Or_Single_ExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(24);
			orExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Or_ExpContext(new BooleanExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_booleanExpr);
					setState(26);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(27);
					match(OR);
					setState(28);
					orExpr(0);
					}
					} 
				}
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ParserRuleContext {
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
	 
		public OrExprContext() { }
		public void copyFrom(OrExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class And_ExpContext extends OrExprContext {
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public TerminalNode AND() { return getToken(BooleanExprParser.AND, 0); }
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public And_ExpContext(OrExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitAnd_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class And_Single_ExpContext extends OrExprContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public And_Single_ExpContext(OrExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitAnd_Single_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		return orExpr(0);
	}

	private OrExprContext orExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		OrExprContext _localctx = new OrExprContext(_ctx, _parentState);
		OrExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_orExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new And_Single_ExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(35);
			andExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_ExpContext(new OrExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_orExpr);
					setState(37);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(38);
					match(AND);
					setState(39);
					andExpr(0);
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ParserRuleContext {
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
	 
		public AndExprContext() { }
		public void copyFrom(AndExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Equal_ExpContext extends AndExprContext {
		public AndExprContext andExpr() {
			return getRuleContext(AndExprContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(BooleanExprParser.EQUAL, 0); }
		public EqualExprContext equalExpr() {
			return getRuleContext(EqualExprContext.class,0);
		}
		public Equal_ExpContext(AndExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitEqual_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Equal_Single_ExpContext extends AndExprContext {
		public EqualExprContext equalExpr() {
			return getRuleContext(EqualExprContext.class,0);
		}
		public Equal_Single_ExpContext(AndExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitEqual_Single_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		return andExpr(0);
	}

	private AndExprContext andExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExprContext _localctx = new AndExprContext(_ctx, _parentState);
		AndExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_andExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Equal_Single_ExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(46);
			equalExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equal_ExpContext(new AndExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_andExpr);
					setState(48);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(49);
					match(EQUAL);
					setState(50);
					equalExpr();
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualExprContext extends ParserRuleContext {
		public EqualExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalExpr; }
	 
		public EqualExprContext() { }
		public void copyFrom(EqualExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryContext extends EqualExprContext {
		public TerminalNode UNA() { return getToken(BooleanExprParser.UNA, 0); }
		public BoolUnitContext boolUnit() {
			return getRuleContext(BoolUnitContext.class,0);
		}
		public UnaryContext(EqualExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Unary_Single_ExpContext extends EqualExprContext {
		public BoolUnitContext boolUnit() {
			return getRuleContext(BoolUnitContext.class,0);
		}
		public Unary_Single_ExpContext(EqualExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitUnary_Single_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualExprContext equalExpr() throws RecognitionException {
		EqualExprContext _localctx = new EqualExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_equalExpr);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNA:
				_localctx = new UnaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(UNA);
				setState(57);
				boolUnit();
				}
				break;
			case BOOL:
			case INT:
			case LPAREN:
				_localctx = new Unary_Single_ExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				boolUnit();
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
	public static class BoolUnitContext extends ParserRuleContext {
		public BoolUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolUnit; }
	 
		public BoolUnitContext() { }
		public void copyFrom(BoolUnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_RelationContext extends BoolUnitContext {
		public NumExprContext numExpr() {
			return getRuleContext(NumExprContext.class,0);
		}
		public Numeric_RelationContext(BoolUnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitNumeric_Relation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Paren_BoolContext extends BoolUnitContext {
		public TerminalNode LPAREN() { return getToken(BooleanExprParser.LPAREN, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BooleanExprParser.RPAREN, 0); }
		public Paren_BoolContext(BoolUnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitParen_Bool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Simple_BoolContext extends BoolUnitContext {
		public TerminalNode BOOL() { return getToken(BooleanExprParser.BOOL, 0); }
		public Simple_BoolContext(BoolUnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitSimple_Bool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolUnitContext boolUnit() throws RecognitionException {
		BoolUnitContext _localctx = new BoolUnitContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_boolUnit);
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Paren_BoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(LPAREN);
				setState(62);
				booleanExpr(0);
				setState(63);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new Simple_BoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(BOOL);
				}
				break;
			case 3:
				_localctx = new Numeric_RelationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				numExpr();
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
	public static class NumExprContext extends ParserRuleContext {
		public NumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numExpr; }
	 
		public NumExprContext() { }
		public void copyFrom(NumExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_Relation_ExpContext extends NumExprContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public TerminalNode REL() { return getToken(BooleanExprParser.REL, 0); }
		public Numeric_Relation_ExpContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitNumeric_Relation_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_Equal_ExpContext extends NumExprContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(BooleanExprParser.EQUAL, 0); }
		public Numeric_Equal_ExpContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitNumeric_Equal_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumExprContext numExpr() throws RecognitionException {
		NumExprContext _localctx = new NumExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_numExpr);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new Numeric_Equal_ExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				addExpr(0);
				setState(70);
				match(EQUAL);
				setState(71);
				addExpr(0);
				}
				break;
			case 2:
				_localctx = new Numeric_Relation_ExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				addExpr(0);
				setState(74);
				match(REL);
				setState(75);
				addExpr(0);
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
	public static class AddExprContext extends ParserRuleContext {
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
	 
		public AddExprContext() { }
		public void copyFrom(AddExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Add_Single_ExpContext extends AddExprContext {
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public Add_Single_ExpContext(AddExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitAdd_Single_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Add_ExpContext extends AddExprContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public TerminalNode ADD() { return getToken(BooleanExprParser.ADD, 0); }
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public Add_ExpContext(AddExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitAdd_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		return addExpr(0);
	}

	private AddExprContext addExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExprContext _localctx = new AddExprContext(_ctx, _parentState);
		AddExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_addExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Add_Single_ExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(80);
			multExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Add_ExpContext(new AddExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_addExpr);
					setState(82);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(83);
					match(ADD);
					setState(84);
					multExpr(0);
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends ParserRuleContext {
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
	 
		public MultExprContext() { }
		public void copyFrom(MultExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Mult_ExpContext extends MultExprContext {
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public TerminalNode MULT() { return getToken(BooleanExprParser.MULT, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Mult_ExpContext(MultExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitMult_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Mult_Single_ExpContext extends MultExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Mult_Single_ExpContext(MultExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitMult_Single_Exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		return multExpr(0);
	}

	private MultExprContext multExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultExprContext _localctx = new MultExprContext(_ctx, _parentState);
		MultExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_multExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Mult_Single_ExpContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(91);
			term();
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Mult_ExpContext(new MultExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_multExpr);
					setState(93);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(94);
					match(MULT);
					setState(95);
					term();
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Simple_NumberContext extends TermContext {
		public TerminalNode INT() { return getToken(BooleanExprParser.INT, 0); }
		public Simple_NumberContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitSimple_Number(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Numeric_ParenContext extends TermContext {
		public TerminalNode LPAREN() { return getToken(BooleanExprParser.LPAREN, 0); }
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BooleanExprParser.RPAREN, 0); }
		public Numeric_ParenContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanExprParserVisitor ) return ((BooleanExprParserVisitor<? extends T>)visitor).visitNumeric_Paren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_term);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new Numeric_ParenContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(LPAREN);
				setState(102);
				addExpr(0);
				setState(103);
				match(RPAREN);
				}
				break;
			case INT:
				_localctx = new Simple_NumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(INT);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return booleanExpr_sempred((BooleanExprContext)_localctx, predIndex);
		case 2:
			return orExpr_sempred((OrExprContext)_localctx, predIndex);
		case 3:
			return andExpr_sempred((AndExprContext)_localctx, predIndex);
		case 7:
			return addExpr_sempred((AddExprContext)_localctx, predIndex);
		case 8:
			return multExpr_sempred((MultExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleanExpr_sempred(BooleanExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean orExpr_sempred(OrExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andExpr_sempred(AndExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addExpr_sempred(AddExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multExpr_sempred(MultExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\fm\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u001e\b\u0001\n\u0001\f\u0001!\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002)\b\u0002\n\u0002"+
		"\f\u0002,\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u00034\b\u0003\n\u0003\f\u00037\t\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004<\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005D\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006N\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007V\b"+
		"\u0007\n\u0007\f\u0007Y\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\ba\b\b\n\b\f\bd\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\tk\b\t\u0001\t\u0000\u0005\u0002\u0004\u0006\u000e\u0010\n\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0000l\u0000\u0014\u0001"+
		"\u0000\u0000\u0000\u0002\u0017\u0001\u0000\u0000\u0000\u0004\"\u0001\u0000"+
		"\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\b;\u0001\u0000\u0000\u0000"+
		"\nC\u0001\u0000\u0000\u0000\fM\u0001\u0000\u0000\u0000\u000eO\u0001\u0000"+
		"\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012j\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0005\u0000\u0000\u0001"+
		"\u0016\u0001\u0001\u0000\u0000\u0000\u0017\u0018\u0006\u0001\uffff\uffff"+
		"\u0000\u0018\u0019\u0003\u0004\u0002\u0000\u0019\u001f\u0001\u0000\u0000"+
		"\u0000\u001a\u001b\n\u0002\u0000\u0000\u001b\u001c\u0005\u0003\u0000\u0000"+
		"\u001c\u001e\u0003\u0004\u0002\u0000\u001d\u001a\u0001\u0000\u0000\u0000"+
		"\u001e!\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 \u0003\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000\"#\u0006\u0002\uffff\uffff\u0000#$\u0003\u0006\u0003"+
		"\u0000$*\u0001\u0000\u0000\u0000%&\n\u0002\u0000\u0000&\'\u0005\u0004"+
		"\u0000\u0000\')\u0003\u0006\u0003\u0000(%\u0001\u0000\u0000\u0000),\u0001"+
		"\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000"+
		"+\u0005\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0006\u0003"+
		"\uffff\uffff\u0000./\u0003\b\u0004\u0000/5\u0001\u0000\u0000\u000001\n"+
		"\u0002\u0000\u000012\u0005\u0005\u0000\u000024\u0003\b\u0004\u000030\u0001"+
		"\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u00006\u0007\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000089\u0005\u0007\u0000\u00009<\u0003\n\u0005\u0000:<\u0003\n"+
		"\u0005\u0000;8\u0001\u0000\u0000\u0000;:\u0001\u0000\u0000\u0000<\t\u0001"+
		"\u0000\u0000\u0000=>\u0005\n\u0000\u0000>?\u0003\u0002\u0001\u0000?@\u0005"+
		"\u000b\u0000\u0000@D\u0001\u0000\u0000\u0000AD\u0005\u0001\u0000\u0000"+
		"BD\u0003\f\u0006\u0000C=\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000"+
		"CB\u0001\u0000\u0000\u0000D\u000b\u0001\u0000\u0000\u0000EF\u0003\u000e"+
		"\u0007\u0000FG\u0005\u0005\u0000\u0000GH\u0003\u000e\u0007\u0000HN\u0001"+
		"\u0000\u0000\u0000IJ\u0003\u000e\u0007\u0000JK\u0005\u0006\u0000\u0000"+
		"KL\u0003\u000e\u0007\u0000LN\u0001\u0000\u0000\u0000ME\u0001\u0000\u0000"+
		"\u0000MI\u0001\u0000\u0000\u0000N\r\u0001\u0000\u0000\u0000OP\u0006\u0007"+
		"\uffff\uffff\u0000PQ\u0003\u0010\b\u0000QW\u0001\u0000\u0000\u0000RS\n"+
		"\u0002\u0000\u0000ST\u0005\b\u0000\u0000TV\u0003\u0010\b\u0000UR\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X\u000f\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000Z[\u0006\b\uffff\uffff\u0000[\\\u0003\u0012\t\u0000\\b\u0001"+
		"\u0000\u0000\u0000]^\n\u0002\u0000\u0000^_\u0005\t\u0000\u0000_a\u0003"+
		"\u0012\t\u0000`]\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\u0011\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000ef\u0005\n\u0000\u0000fg\u0003\u000e\u0007"+
		"\u0000gh\u0005\u000b\u0000\u0000hk\u0001\u0000\u0000\u0000ik\u0005\u0002"+
		"\u0000\u0000je\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u0013"+
		"\u0001\u0000\u0000\u0000\t\u001f*5;CMWbj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}