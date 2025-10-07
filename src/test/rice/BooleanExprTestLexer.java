package test.rice;

import main.rice.BooleanExprLexer;
import org.antlr.v4.runtime.*;

/**
 * Extend the lexer to prevent recovery on any lexical errors.
 * See "The Definitive ANTLR 4 Reference", pp.173
 */
public class BooleanExprTestLexer extends BooleanExprLexer {
    public BooleanExprTestLexer(CharStream input) {
        super(input);
    }

    @Override
    public void recover(LexerNoViableAltException e) {
        throw new RuntimeException(e); // Bail out
    }
}