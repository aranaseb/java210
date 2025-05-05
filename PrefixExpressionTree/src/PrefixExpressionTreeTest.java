
// A JUnit test for out PreFixExpressionTree
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrefixExpressionTreeTest {

	@Test
	public void testEmptyTree() {
		PrefixExpressionTree et = new PrefixExpressionTree("");
		assertEquals(0, et.valueOf());
	}

	@Test
	public void testTreeWithOneValue() {
		PrefixExpressionTree et = new PrefixExpressionTree("987654");
		assertEquals(987654, et.valueOf());
	}

	@Test
	public void testTreeWithPlusEasy1() {
		// Let the constructor parse the argument to build a valid expression tree
		PrefixExpressionTree et = new PrefixExpressionTree("+ 3 2");
		assertEquals(5, et.valueOf());
	}

	@Test
	public void testTreeWithPlusEasy() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ + 1 2 3");
		assertEquals(6, et.valueOf());
	}

	@Test
	public void testTreeWithMinusEasy1() {
		PrefixExpressionTree et = new PrefixExpressionTree("- 8 6");
		assertEquals(2, et.valueOf());
	}

	@Test
	public void testTreeWithMinusEasy2() {
		PrefixExpressionTree et = new PrefixExpressionTree("- 6 8");
		assertEquals(-2, et.valueOf());
	}

	@Test
	public void testLongerExpression2() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + - 1 2 3 4 5");
		assertEquals(3, et.valueOf());
	}

	@Test
	public void testTravesals() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
		assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
	}

	@Test
	public void testTravesals2() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
		assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
	}

	@Test
	public void testTravesals3() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
		assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
	}

	@Test
	public void testTravesals4() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
		assertEquals("+ - + 7 3 8 9", et.preOrder().trim());
	}

	///////////// Now with * / and % or the assertions fail

	@Test
	public void testValue6() {
		PrefixExpressionTree et = new PrefixExpressionTree("* 7 2");
		assertEquals(14, et.valueOf());
	}

	@Test
	public void testValue7() {
		PrefixExpressionTree et = new PrefixExpressionTree("/ 7 2");
		assertEquals(3, et.valueOf());
	}

	@Test
	public void testValue8() {
		PrefixExpressionTree et = new PrefixExpressionTree("% 123 50");
		assertEquals(23, et.valueOf());
	}

	@Test
	public void testValue9() {
		PrefixExpressionTree et = new PrefixExpressionTree("* / % 12 7 2 99");
		assertEquals(198, et.valueOf());
	}

	@Test
	public void valueOf8() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
		assertEquals("7 + 3 - 8 + 9", et.inOrder().trim());
	}

	@Test
	public void testsideWaysOrder() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - + 7 3 8 9");
		assertEquals(11, et.valueOf());
		System.out.println("\n\n" + et.sidewaysOrder());
		/*-  9 is the rightmost operand, 7 is the leftmost
		
		  9
		+
		8
		  -
		  3
		+
		  7
		 
		*/
	}

	@Test
	public void testsideWaysOrderWithMix() {
		PrefixExpressionTree et = new PrefixExpressionTree("+ - 7 3 * 8 9");
		assertEquals(76, et.valueOf());
		System.out.println("\n\n" + et.sidewaysOrder());
		assertEquals("+ - 7 3 * 8 9", et.preOrder());
		assertEquals("7 - 3 + 8 * 9", et.inOrder());
		assertEquals("7 3 - 8 9 * +", et.postOrder());
		/*- 9 is the rightmost int, 7 is the leftmost
		
		    9
		  *
		    8
		+
		    3
		  -
		    7    
		     
		*/
	}
}
