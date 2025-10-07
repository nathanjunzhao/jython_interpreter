package test.rice;

import main.rice.*;
import main.rice.BooleanExprParser;
import main.rice.EvalVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test the correctness of the EvalVisitor class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EvalVisitorTest {
    private final static EvalVisitor visitor = new EvalVisitor();

    /**
     * Test that the visitor throws an exception when given an invalid string.
     */
    @Test
    @Tag("0.5")
    @Order(1)
    void testEmptyString() {
        invalidStringHelper("");
    }

    /**
     * Test that the visitor throws an exception when given a string of only parentheses.
     */
    @Test
    @Tag("0.25")
    @Order(2)
    void testEmptyParen() {
        invalidStringHelper("()");
    }

    /**
     * Test that the visitor throws an exception when given arbitrary alphabetical characters.
     */
    @Test
    @Tag("0.25")
    @Order(3)
    void testInvalidAlphabeticalCharacters() {
        invalidStringHelper("anwog");
    }

    /**
     * Test that the visitor throws an exception when given whitespace characters.
     */
    @Test
    @Tag("0.25")
    @Order(4)
    void testOnlyWhitespace() {
        invalidStringHelper("\t\n ");
    }

    /**
     * Test that the visitor throws an exception when parsing numbers with
     * leading zeros.
     */
    @Test
    @Tag("0.5")
    @Order(5)
    void testLeadingZeros() {
        invalidStringHelper("0954 == 954");
    }

    /**
     * Test that the visitor does not incorrectly accept handles an expression
     * with whitespace in the middle of tokens.
     */
    @Test
    @Tag("0.5")
    @Order(6)
    void testExpressionWithSpuriousWhitespace() {
        invalidStringHelper("tr ue");
    }

    /**
     * Test that the visitor does not incorrectly accept an expression that
     * partially matches the grammar specification.
     */
    @Test
    @Tag("2.0")
    @Order(7)
    void testExpressionWithPartialMatch() {
        invalidStringHelper("true INVALID");
    }

    /**
     * Test that the visitor throws an exception when given the keyword true
     * with incorrect capitalization.
     */
    @Test
    @Tag("0.5")
    @Order(8)
    void testTerminalTrueCaseSensitive() {
        invalidStringHelper("TRUE");
    }

    /**
     * Test that the visitor throws an exception when given the keyword false
     * with incorrect capitalization.
     */
    @Test
    @Tag("0.5")
    @Order(9)
    void testTerminalFalseCaseSensitive() {
        invalidStringHelper("False");
    }

    /**
     * Test that the visitor throws an exception when a number is compared to a
     * boolean.
     */
    @Test
    @Tag("1.0")
    @Order(10)
    void testNumComparedToBool() {
        invalidStringHelper("1 == true");
    }

    /**
     * Test that the visitor throws an exception when a boolean is compared to a
     * number.
     */
    @Test
    @Tag("1.0")
    @Order(11)
    void testBoolComparedToNum() {
        invalidStringHelper("true == 1");
    }

    /**
     * Test that the visitor correctly handles extra whitespace in expressions.
     */
    @Test
    @Tag("3.0")
    @Order(12)
    void testExpressionWithExtraWhitespace() {
        validStringHelper("\t true \r\n", true);
    }

    /**
     * Test that the visitor returns true when given the keyword true.
     */
    @Test
    @Tag("0.25")
    @Order(13)
    void testTerminalTrue() {
        validStringHelper("true", true);
    }

    /**
     * Test that the visitor returns false when given the keyword false.
     */
    @Test
    @Tag("0.25")
    @Order(14)
    void testTerminalFalse() {
        validStringHelper("false", false);
    }

    /**
     * Test that the visitor handles terminal booleans with parentheses correctly.
     */
    @Test
    @Tag("0.25")
    @Order(15)
    void testTerminalWithParen() {
        validStringHelper("(false)", false);
    }

    /**
     * Test that the visitor handles a logical and with two falses correctly.
     */
    @Test
    @Tag("0.25")
    @Order(16)
    void testLogicalAndNeitherTrue() {
        validStringHelper("false && false", false);
    }

    /**
     * Test that the visitor handles a logical and with one true and one false
     * correctly.
     */
    @Test
    @Tag("0.25")
    @Order(17)
    void testLogicalAndOneTrue() {
        validStringHelper("true && false", false);
    }

    /**
     * Test that the visitor handles a logical and with two trues correctly.
     */
    @Test
    @Tag("0.25")
    @Order(18)
    void testLogicalAndBothTrue() {
        validStringHelper("true && true", true);
    }

    /**
     * Test that the visitor handles a logical or with two falses correctly.
     */
    @Test
    @Tag("0.25")
    @Order(19)
    void testLogicalOrNeitherTrue() {
        validStringHelper("false || false", false);
    }

    /**
     * Test that the visitor handles a logical or with one true and one false
     * correctly.
     */
    @Test
    @Tag("0.25")
    @Order(20)
    void testLogicalOrOneTrue() {
        validStringHelper("false || true", true);
    }

    /**
     * Test that the visitor handles a logical or with two trues correctly.
     */
    @Test
    @Tag("0.25")
    @Order(21)
    void testLogicalOrBothTrue() {
        validStringHelper("true || true", true);
    }

    /**
     * Test that the visitor correctly handles the logical not of true.
     */
    @Test
    @Tag("0.25")
    @Order(22)
    void testLogicalNotTrue() {
        validStringHelper("!true", false);
    }

    /**
     * Test that the visitor correctly handles the logical not of false.
     */
    @Test
    @Tag("0.25")
    @Order(23)
    void testLogicalNotFalse() {
        validStringHelper("!false", true);
    }

    /**
     * Test that the visitor correctly handles operator precedence with logical
     * NOT correctly (it should be evaluated before other logical operators).
     */
    @Test
    @Tag("2.0")
    @Order(24)
    void testLogicalNotPrecedence() {
        validStringHelper("!false && false", false);
    }

    /**
     * Test that the visitor handles the equality operator correctly for booleans
     * when the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(25)
    void testBooleanEqTrue() {
        validStringHelper("false == false", true);
    }

    /**
     * Test that the visitor handles the equality operator correctly for booleans
     * when the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(26)
    void testBooleanEqFalse() {
        validStringHelper("false == true", false);
    }

    /**
     * Test that the visitor handles the not equals operator correctly for booleans
     * when the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(27)
    void testBooleanNeqTrue() {
        validStringHelper("false != true", true);
    }

    /**
     * Test that the visitor handles the not equals operator correctly for booleans
     * when the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(28)
    void testBooleanNeqFalse() {
        validStringHelper("false != false", false);
    }

    /**
     * Test that the visitor handles the less than operator correctly when the
     * expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(29)
    void testLessThanTrue() {
        validStringHelper("0 < 6", true);
    }

    /**
     * Test that the visitor handles the less than operator correctly when the
     * expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(30)
    void testLessThanFalse() {
        validStringHelper("1 < 1", false);
    }

    /**
     * Test that the visitor handles the less than or equal to operator
     * correctly when the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(31)
    void testLessThanOrEqTrue() {
        validStringHelper("2 <= 2", true);
    }

    /**
     * Test that the visitor handles the less than or equal to operator
     * correctly when the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(32)
    void testLessThanOrEqFalse() {
        validStringHelper("345 <= 344", false);
    }

    /**
     * Test that the visitor handles the equality operator correctly for numbers
     * when the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(33)
    void testNumEqTrue() {
        validStringHelper("0 == 0", true);
    }

    /**
     * Test that the visitor handles the equality operator correctly for numbers
     * when the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(34)
    void testNumEqFalse() {
        validStringHelper("960 == 1060", false);
    }

    /**
     * Test that the visitor handles the not equals operator correctly for numbers
     * when the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(35)
    void testNumNeqTrue() {
        validStringHelper("19304195 != 12940913", true);
    }

    /**
     * Test that the visitor handles the not equals operator correctly for numbers
     * when the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(36)
    void testNumNeqFalse() {
        validStringHelper("683 != 683", false);
    }

    /**
     * Test that the visitor handles the greater than or equal to operator
     * correctly when the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(37)
    void testGreaterThanOrEqTrue() {
        validStringHelper("51385391 >= 1486543", true);
    }

    /**
     * Test that the visitor handles the greater than or equal to operator
     * correctly when the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(38)
    void testGreaterThanOrEqToFalse() {
        validStringHelper("1886 >= 1887", false);
    }

    /**
     * Test that the visitor handles the greater than operator correctly when
     * the expected result is true.
     */
    @Test
    @Tag("0.25")
    @Order(39)
    void testGreaterThanTrue() {
        validStringHelper("77 > 5", true);
    }

    /**
     * Test that the visitor handles the greater than operator correctly when
     * the expected result is false.
     */
    @Test
    @Tag("0.25")
    @Order(40)
    void testGreaterThanFalse() {
        validStringHelper("469 > 469", false);
    }

    /**
     * Test that the visitor handles a numeric relation with outer parentheses
     * correctly.
     */
    @Test
    @Tag("0.5")
    @Order(41)
    void testRelationWithOuterParens() {
        validStringHelper("(194 < 68)", false);
    }

    /**
     * Test that the visitor handles a numeric relation with inner parentheses
     * correctly.
     */
    @Test
    @Tag("0.5")
    @Order(42)
    void testRelationWithInnerParens() {
        validStringHelper("(67) < (0)", false);
    }

    /**
     * Test that the visitor handles a numeric relation with addition
     * correctly.
     */
    @Test
    @Tag("1.0")
    @Order(43)
    void testRelationWithAdd() {
        validStringHelper("1 + 1 == 2", true);
    }

    /**
     * Test that the visitor handles a numeric relation with subtraction
     * correctly.
     */
    @Test
    @Tag("1.0")
    @Order(44)
    void testRelationWithSub() {
        validStringHelper("2 == 3 - 1", true);
    }

    /**
     * Test that the visitor handles a numeric relation with subtraction
     * correctly.
     */
    @Test
    @Tag("1.0")
    @Order(45)
    void testRelationWithMult() {
        validStringHelper("3 * 3 == 9", true);
    }

    /**
     * Test that the visitor handles a numeric relation with subtraction
     * correctly.
     */
    @Test
    @Tag("1.0")
    @Order(46)
    void testRelationWithDiv() {
        validStringHelper("6 == 54 / 9", true);
    }

    /**
     * Test that the visitor treats multiplication with higher precedence than
     * addition.
     */
    @Test
    @Tag("1.5")
    @Order(47)
    void testRelationWithMultAndAdd() {
        validStringHelper("1 + 2 * 3 == 4 + 3 * 1", true);
    }

    /**
     * Test that the visitor treats multiplication with higher precedence than
     * subtraction.
     */
    @Test
    @Tag("1.5")
    @Order(48)
    void testRelationWithMultAndSub() {
        validStringHelper("10 - 2 * 3 == 4 - 0 * 3", true);
    }

    /**
     * Test that the visitor treats division with higher precedence than
     * addition.
     */
    @Test
    @Tag("1.5")
    @Order(49)
    void testRelationWithDivAndAdd() {
        validStringHelper("6 / 2 + 2 == 16 / 4 + 1", true);
    }

    /**
     * Test that the visitor treats division with higher precedence than
     * subtraction.
     */
    @Test
    @Tag("1.5")
    @Order(50)
    void testRelationWithDivAndSub() {
        validStringHelper("63 / 7 - 3 == 42 / 6 - 1", true);
    }

    /**
     * Test that the visitor treats division with higher precedence than
     * subtraction.
     */
    @Test
    @Tag("2.0")
    @Order(51)
    void testRelationWithChainedDiv() {
        validStringHelper("8 / 4 / 2 > 8 / 8 / 2", true);
    }

    /**
     * Test that the visitor treats division with higher precedence than
     * subtraction.
     */
    @Test
    @Tag("2.0")
    @Order(52)
    void testRelationWithChainedSub() {
        validStringHelper("8 - 4 - 2 > 8 - 5 - 4", true);
    }

    /**
     * Test that the visitor handles a logical expression with many parentheses
     * correctly.
     */
    @Test
    @Tag("4.0")
    @Order(53)
    void testManyParens() {
        validStringHelper("(true && false) || ((true && false) || true) && (true && (false || true))", true);
    }

    /**
     * Test that the visitor handles a logical expression with many numeric
     * relations correctly.
     */
    @Test
    @Tag("4.0")
    @Order(54)
    void testManyRelations() {
        validStringHelper("(1 < 2 || 2 >= 3) && (152 == 152 || 134 > 1055654) && (661 <= 3 || 5 != 6) ", true);
    }

    /**
     * Test that the visitor handles a logical expression with both numeric
     * relations and other boolean expressions correctly.
     */
    @Test
    @Tag("8.0")
    @Order(55)
    void testMixedExpression() {
        validStringHelper("(1 + 1 * 3 < 36 / 3 / 2 - 1 || 3 >= 1) && true && ((true && !false)) == true", true);
    }

    /**
     * Test that the visitor throws an exception when given an invalid string.
     * @param strToParse the string to parse
     */
    private static void invalidStringHelper(String strToParse) {
        BooleanExprLexer lexer = new BooleanExprTestLexer(CharStreams.fromString(strToParse));
        // Silence ANTLR's built-in error messages for strings that are invalid
        lexer.removeErrorListeners();
        BooleanExprParser parser = new BooleanExprParser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new BailErrorStrategy());
        parser.removeErrorListeners();

        try {
            // Try parsing, expecting that it will fail
            parser.start();
        } catch (RuntimeException e) {
            return;
        }

        fail("Expected an exception to be thrown during parsing.");
    }

    /**
     * Test that the visitor returns the expected result when given a valid
     * string.
     * @param strToParse the string to parse
     * @param expected the expected result from visiting the parse tree
     */
    private static void validStringHelper(String strToParse, Boolean expected) {
        BooleanExprLexer lexer = new BooleanExprTestLexer(CharStreams.fromString(strToParse));
        BooleanExprParser parser = new BooleanExprParser(new CommonTokenStream(lexer));
        parser.setErrorHandler(new BailErrorStrategy());

        try {
            ParseTree result = parser.start();
            // Call visitor on the parse tree
            Boolean actual = visitor.visit(result);
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}