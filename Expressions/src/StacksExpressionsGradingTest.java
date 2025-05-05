
/**
 * A unit test for the two methods in class Expressions: 
 * 
 *  int valueOf(post) 
 *  String inToPost(infix)
 *  
 *  author Rick Mercer
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class StacksExpressionsGradingTest {

	Expressions e = new Expressions(); // Send messages to e

	@Test
	public void testBothTogether() {
		// TODO Run this last
		assertEquals(-24, e.valueOf("2 -4 3 * *"));
		assertEquals("1 2 * 3 - 4 +", e.inToPost("1 * 2 - 3 + 4"));
		// Begin with an infix expression converted to post, and evaluated to 3
		assertEquals(3, e.valueOf(e.inToPost("1 * 2 - 3 + 4")));
	}

	@Test
	public void testvalueOfEvalOneOperator() {
		assertEquals(5, e.valueOf("2 3 +"));
		assertEquals(-1, e.valueOf("2 3 -"));
		assertEquals(6, e.valueOf("2 3 *"));
		assertEquals(1, e.valueOf("3 2 /"));
		assertEquals(2, e.valueOf("2 3 %"));
	}

	@Test
	public void testvalueOfEvalTwoOperators() {
		assertEquals(9, e.valueOf("4 2 3 + +"));
		assertEquals(7, e.valueOf("6 2 3 - -"));
		assertEquals(-24, e.valueOf("2 -4 3 * *"));
		assertEquals(6, e.valueOf("12 5 2 / /"));
		assertEquals(1, e.valueOf("11 2 5 % %"));
	}

	@Test
	public void testvalueOfEvalThreeOperators() {
		assertEquals(9, e.valueOf("4 2 + 3 +"));
		assertEquals(1, e.valueOf("6 2 - 3 -"));
		assertEquals(-24, e.valueOf("2 -4 * 3 *"));
		assertEquals(3, e.valueOf("15 4 % 5 %"));
	}

	@Test
	public void testvalueOfEvalMixOfOperators() {
		assertEquals(-18, e.valueOf("4 2 + 3 6 - *"));
		assertEquals(7, e.valueOf("1 2 3 4 5 6 + - + - +"));
		assertEquals(-2, e.valueOf("-3 2 * 4 +"));
		assertEquals(0, e.valueOf("12 3 % 2 *"));
		assertEquals(-2, e.valueOf("1 2 - 3 5 - "));
	}

	@Test
	public void testvalueOfEvalFromSlides() {
		assertEquals(-16, e.valueOf("3 4 - 5 3 * -"));
		assertEquals(-2, e.valueOf("2 3 4 + 2 6 - / *"));
		assertEquals(-12, e.valueOf("4 2 3 6 * - +"));
	}

	@Test
	public void testvalueOfExceptions() {
		assertThrows(EmptyStackException.class, () -> e.valueOf("3 4 - 5 3 * - -"));
	}

	@Test
	public void testvalueOfExceptions2() {
		assertThrows(EmptyStackException.class, () -> e.valueOf("3 *"));
	}

	@Test
	public void testIn2Post() {
		assertEquals("3 2 +", e.inToPost("3 + 2"));
		assertEquals("3 2 -", e.inToPost("3 - 2"));
		assertEquals("3 2 *", e.inToPost("3 * 2"));
		assertEquals("3 2 /", e.inToPost("3 / 2"));
		assertEquals("3 2 %", e.inToPost("3 % 2"));
	}

	@Test
	public void testIn2PostWithParenthesies() {
		assertEquals("3 2 +", e.inToPost("( 3 + 2 )"));
		assertEquals("3 2 -", e.inToPost("( 3 - 2 )"));
		assertEquals("3 2 *", e.inToPost("( 3 * 2 )"));
		assertEquals("3 2 /", e.inToPost("( 3 / 2 )"));
		assertEquals("3 2 %", e.inToPost("( 3 % 2 )"));
	}

	@Test
	public void testIn2PostWithParenthesies2() {
		assertEquals("3 2 +", e.inToPost("( ( 3 + 2 ) )"));
		assertEquals("3 2 -", e.inToPost("( ( ( 3 - 2 ) ) )"));
		assertEquals("3 2 *", e.inToPost("( ( 3 * 2 ) )"));
		assertEquals("3 2 /", e.inToPost("( ( 3 / 2 ) )"));
		assertEquals("3 2 %", e.inToPost("( ( 3 % 2 ) )"));
	}

	@Test
	public void testInToPostEvalMixOfOperators() {
		assertEquals("4 2 + 3 6 * -", e.inToPost("4 + 2 - 3 * 6"));
		assertEquals(-12, e.valueOf(e.inToPost("4 + 2 - 3 * 6")));
	}

	@Test
	public void testInToPostEvalMixOfOperators2() {
		assertEquals("4 2 3 6 * - +", e.inToPost("4 + ( 2 - ( 3 * 6 ) )"));
		assertEquals(-12, e.valueOf("4 2 3 6 * - +"));
	}

	@Test
	public void testInToPostEvalMixOfOperators3() {
		assertEquals("4 2 + 3 6 * %", e.inToPost("( 4 + 2 ) % ( 3 * 6 )"));
		assertEquals(6, e.valueOf("4 2 + 3 6 * %"));
	}

	@Test
	public void testInToPostEvalMixOfOperators4() {
		assertEquals("3 4 5 + 3 6 * - *", e.inToPost("3 * ( ( 4 + 5 ) - ( 3 * 6 ) )"));
		assertEquals(-27, e.valueOf("3 4 5 + 3 6 * - *"));
	}

	@Test
	public void testInToPostEvalMixOfOperators5() {
		assertEquals(27, e.valueOf(e.inToPost("3 * ( 4 + 5 )")));
		assertEquals("-12 7 +", e.inToPost("-12 + 7"));

		assertEquals("-12 7 +", e.inToPost("  ( -12 + 7 ) "));
		assertEquals(-5, e.valueOf(e.inToPost(" -12 + 7    ")));

	}

	@Test
	public void testInToPostEvalMixOfOperators1() {
		assertEquals("4 2 + 3 6 * -", e.inToPost("4 + 2 - 3 * 6"));
		assertEquals(-12, e.valueOf(e.inToPost("4 + 2 - 3 * 6")));
	}

	@Test
	public void testInToPostEvalMixOfOperators6() {
		assertEquals("3", e.inToPost("3"));
	}

	@Test
	public void testInToPostEvalMixOfOperators7() {
		assertEquals("1 2 * 3 - 4 + 5 99 % 3 / +", e.inToPost(" 1 * 2 - 3 + 4 + 5 % 99 / 3"));
	}

	@Test
	public void lastOne() {
		assertEquals("1 2 * 3 - 4 +", e.inToPost("1 * 2 - 3 + 4"));
		assertEquals(3, e.valueOf(e.inToPost("1 * 2 - 3 + 4")));
	}

	@Test
	public void testIn2PostFromSlides() {
		assertEquals("2 3 4 + 2 / 6 - *", e.inToPost("2 * ( ( 3 + 4 ) / 2 - 6 )"));
		assertEquals(-6, e.valueOf("2 3 4 + 2 / 6 - *"));
	}

	@Test
	public void testIn2PostFromSlides2() {
		assertEquals("2 3 4 + 2 / * 4 % 7 2 / -", e.inToPost("2 * ( ( 3 + 4 ) / 2 ) % 4 - 7 / 2"));
		assertEquals(-3, e.valueOf("2 3 4 + 2 / * 3 % 7 2 / -"));
	}
}