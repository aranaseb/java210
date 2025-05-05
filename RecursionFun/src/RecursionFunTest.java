import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RecursionFunTest {

	RecursionFun rf = new RecursionFun();

	@Test
	public void testCombinations() {
		assertEquals(2598960, rf.combinations(52, 5));
	}

	@Test
	public void testFactorial() {
		assertEquals(1, rf.factorial(0));
		assertEquals(1, rf.factorial(1));
		assertEquals(2, rf.factorial(2));
		assertEquals(6, rf.factorial(3));
		assertEquals(24, rf.factorial(4));
	}

	@Test
	public void testPalindrome() {
		assertTrue(rf.isPalindrome(""));
		assertTrue(rf.isPalindrome("x"));
		assertFalse(rf.isPalindrome("xy"));
		assertFalse(rf.isPalindrome("yx"));
		assertTrue(rf.isPalindrome("xx"));
		assertTrue(rf.isPalindrome("xxx"));
		assertTrue(rf.isPalindrome("xyx"));
		assertFalse(rf.isPalindrome("xyz"));
		assertTrue(rf.isPalindrome("racecar tacocat racecar"));
		assertFalse(rf.isPalindrome("xyxyxzxyz"));
	}

	@Test
	public void testUnderScore() {
		assertEquals("", rf.underScore(""));
		assertEquals("x", rf.underScore("x"));
		assertEquals("x_x", rf.underScore("xx"));
		assertEquals("x_xy", rf.underScore("xxy"));
		assertEquals("x_x_x", rf.underScore("xxx"));
		assertEquals("x_x_xyx_xyxy_y", rf.underScore("xxxyxxyxyy"));
	}

	@Test
	public void testHowMany() {
		assertEquals(0, rf.howMany('x', ""));
		assertEquals(1, rf.howMany('x', "x"));
		assertEquals(0, rf.howMany('x', "yzv"));
		assertEquals(1, rf.howMany('x', "zyzx"));
		assertEquals(3, rf.howMany('X', "xyzXYZXX"));
	}

	@Test
	public void testNumOfPairs() {
		assertEquals(0, rf.numberOfPairs(""));
		assertEquals(0, rf.numberOfPairs("x"));
		assertEquals(1, rf.numberOfPairs("xx"));
		assertEquals(1, rf.numberOfPairs("xxy"));
		assertEquals(2, rf.numberOfPairs("xxx"));
		assertEquals(4, rf.numberOfPairs("xxxyxxyxyy"));
	}

	@Test
	public void testReverseArray() {
		int[] x = { 1 };
		rf.reverseArray(x);
		assertEquals("[1]", Arrays.toString(x));
		int[] y = { 1, 2 };
		rf.reverseArray(y);
		assertEquals("[2, 1]", Arrays.toString(y));
		int[] z = { 1, 2, 3, 4, 5 };
		rf.reverseArray(z);
		assertEquals("[5, 4, 3, 2, 1]", Arrays.toString(z));
	}

	@Test
	public void testArrayRange() {
		assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
		assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
		assertEquals(0, rf.arrayRange(new int[] { 3 }));
		assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
	}

	@Test
	public void testIsSorted() {
		assertTrue(rf.isSorted(new int[] {}));
		assertTrue(rf.isSorted(new int[] { 1 }));
		assertTrue(rf.isSorted(new int[] { 1, 2 }));
		assertTrue(rf.isSorted(new int[] { 1, 1, 5 }));
		assertTrue(rf.isSorted(new int[] { -3, 5, 100 }));
		assertFalse(rf.isSorted(new int[] { 2, 1 }));
		assertFalse(rf.isSorted(new int[] { 1, 2, 1 }));
		assertFalse(rf.isSorted(new int[] { 1, 2, 3, 5, 5, 3 }));
		assertFalse(rf.isSorted(new int[] { 100, 0 }));
	}

	@Test
	public void testFound() {
		assertTrue(rf.found("x", new String[] { "x" }));
		assertTrue(rf.found("x", new String[] { "", "", "", "x" }));
		assertFalse(rf.found("x", new String[] { "" }));
		assertFalse(rf.found("x", new String[] { "", "b" }));

	}
}
