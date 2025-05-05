
/** 
 * This class has @Test methods for testing all methods in ArrayFun.java.
 * The assertions are very limited, but each of the Java methods have an 
 * @Test method started.  Add more assertions to ensure your methods work.
 * 
 * @author Rick Mercer and Sebastian Arana
 * 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class ArrayFunTest {

	// If you include this instance variable, you can use myFun in all @Tests:
	private ArrayFun myFun = new ArrayFun();

	@Test
	public void testNumberOfPairs1() {
		String[] array = { "a", "b", "b", "a" };
		assertEquals(1, myFun.numberOfPairs(array));
		// Or pass a new array as the argument itself
		assertEquals(2, myFun.numberOfPairs(new String[] { "a", "a", "a" }));
		assertEquals(0, myFun.numberOfPairs(new String[] { "a", "b", "a" }));//
		assertEquals(0, myFun.numberOfPairs(new String[] { "c", "C", "s" }));//
		assertEquals(1, myFun.numberOfPairs(new String[] { "b", "a", "a" }));//
		assertEquals(4, myFun.numberOfPairs(new String[] { "a", "a", "a", "a", "a", "b" }));//
	}

	@Test
	public void testNumberOfPairs() {
		// You don't need to creat an array on a separate line, pass
		// a new array as an argument: new Type[] {val1, val2, val3}
		assertEquals(0, myFun.numberOfPairs(new String[] { "a", "A", "a" }));
		/* TODO: Add more assertions */
	}

	@Test
	public void testSumGreaterThan() {
		double[] x = { 1, 2, 3 };
		// sum of elements in x is 6
		assertFalse(myFun.sumGreaterThan(x, 6));
		assertFalse(myFun.sumGreaterThan(x, 7));
		assertTrue(myFun.sumGreaterThan(x, 5));
		assertTrue(myFun.sumGreaterThan(new double[] { 2.1 }, 2));
		assertTrue(myFun.sumGreaterThan(new double[] {}, -3));
	}

	@Test
	public void testFrequency1() {
		Scanner scanner = new Scanner("5 0 1 2 1 5 2");
		int[] result = myFun.frequency(scanner);
		assertEquals(11, result.length);
		Scanner scanner2 = new Scanner("5 0 1 2 1 5 2");
		int[] result2 = myFun.frequency(scanner2);
		assertEquals(11, result2.length);
		assertEquals(1, result2[0]); // There was 1 zero
		assertEquals(2, result2[1]); // Two 1s
		assertEquals(2, result2[2]); // Two 2s
		assertEquals(0, result2[3]); // No 3s
		assertEquals(0, result2[4]); // No fives
		assertEquals(2, result2[5]); // There were 2 5s
		for (int score = 6; score <= 10; score++) {
			assertEquals(0, result2[score]); // There were zero 6s, 7s, 8s, 9s, 10s
		}
	}

	@Test
	public void testHowMany() {
		String[] two = { "5", "5" };
		assertEquals(2, myFun.howMany(two, "5"));
		assertEquals(0, myFun.howMany(two, "sus"));
		assertEquals(2, myFun.howMany(new String[] { "sus", "sus!!", "sus" }, "sus"));
		assertEquals(3, myFun.howMany(new String[] { "a", "a", "a", "b" }, "a"));
		assertEquals(0, myFun.howMany(new String[] {}, "banana"));
	}

	@Test
	public void testEvensLeft() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		myFun.evensLeft(a);
		// Left side of the array at indexes 0..2 must all be even even
		for (int i = 0; i <= 3; i++) {
			assertEquals(0, a[i] % 2);
		}

		// Right side of the array at indexes 3..6 are odd
		for (int i = 4; i <= 7; i++) {
			assertEquals(1, a[i] % 2);
		}

		int[] b = { 1, 0, 1, 0, 1, 1, 0 };
		myFun.evensLeft(b);
		for (int i = 0; i <= 2; i++) {
			assertEquals(0, b[i] % 2);
		}
		for (int i = 3; i <= 6; i++) {
			assertEquals(1, b[i] % 2);
		}

		int[] c = { 3, 3, 2 };
		myFun.evensLeft(c);
		for (int i = 0; i <= 0; i++) {
			assertEquals(0, c[i] % 2);
		}
		for (int i = 1; i <= 2; i++) {
			assertEquals(1, c[i] % 2);
		}

		int[] d = { 2 };
		myFun.evensLeft(d);
		assertEquals(0, d[0] % 2);

		int[] e = { 1, -2, 3, -4, 6 };
		myFun.evensLeft(e);
		for (int i = 0; i <= 2; i++) {
			assertEquals(0, e[i] % 2);
		}
		for (int i = 3; i <= 4; i++) {
			assertEquals(1, e[i] % 2);
		}

	}

	@Test
	public void testReplace1() {
		char[] a = { 'A', 'B', 'C', 'D', 'B' };
		char[] a1 = myFun.replaced(a, 'B', 'Z');
		assertEquals('A', a1[0]);
		assertEquals('Z', a1[4]);
		char[] a2 = myFun.replaced(a, 'Z', 'H');
		assertEquals('A', a2[0]);
		assertEquals('B', a2[1]);
		char[] a3 = myFun.replaced(a, 'A', 'x');
		assertEquals('B', a3[4]);
		assertEquals('x', a3[0]);
	}

	@Test
	public void testShiftNTimes2() {
		int[] x = { 1, 2, 3, 4 };
		myFun.shiftNTimes(x, 2);
		assertEquals(3, x[0]);
		assertEquals(4, x[1]);
		assertEquals(1, x[2]);
		assertEquals(2, x[3]);
		int[] x2 = { 1, 2, 3, 4 };
		myFun.shiftNTimes(x2, 1);
		assertEquals(2, x2[0]);
		assertEquals(3, x2[1]);
		assertEquals(4, x2[2]);
		assertEquals(1, x2[3]);
		int[] x3 = { 1, 2, 3, 4, 5, 6, 7 };
		myFun.shiftNTimes(x3, 3);
		assertEquals(4, x3[0]);
		assertEquals(5, x3[1]);
		assertEquals(6, x3[2]);
		assertEquals(7, x3[3]);
		assertEquals(1, x3[4]);
		assertEquals(2, x3[5]);
		assertEquals(3, x3[6]);
		int[] x4 = { 1, 2, 3 };
		myFun.shiftNTimes(x4, 5);
		assertEquals(3, x4[0]);
		assertEquals(1, x4[1]);
		assertEquals(2, x4[2]);
		int[] x5 = { 3 };
		myFun.shiftNTimes(x5, 5);
		assertEquals(3, x5[0]);
	}

	@Test
	public void testFound1() {
		String[] a = { "A", "B", "C" };
		assertTrue(myFun.found("A", a));
		assertFalse(myFun.found("a", a));
		assertFalse(myFun.found("x", new String[] { "a", "b", "c", "d" }));
		assertFalse(myFun.found("x", new String[] {}));
		assertTrue(myFun.found("d", new String[] { "a", "b", "c", "d" }));

	}

	@Test
	public void testRange() {
		int[] x = { -1, 1, -2, 2, -3, 4, -4, 4 };
		assertEquals(8, myFun.range(x));
		assertEquals(3, myFun.range(new int[] { 1, 2, 3, 4 }));
		assertEquals(7, myFun.range(new int[] { 1, 2, -3, 4 }));
		assertEquals(0, myFun.range(new int[] { 99 }));

	}

	@Test
	public void testLargestWidth3() {
		int[] a = { 1, 2, 1, 1, 3 };
		int a1 = myFun.largestWidth(a);
		assertEquals(4, a1);
		int[] b = { 1, 2, 3, 4, 5, 6, 2, 66, 77, 3 };
		int b1 = myFun.largestWidth(b);
		assertEquals(8, b1);
		int[] c = { 1, 2, 3, 4, 5, 6 };
		int c1 = myFun.largestWidth(c);
		assertEquals(1, c1);
		int[] d = { 1, 4, 2, 1, 4, 1, 4 };
		int d1 = myFun.largestWidth(d);
		assertEquals(6, d1);
		int[] e = { 5, 5, 5, 5 };
		int e1 = myFun.largestWidth(e);
		assertEquals(4, e1);
		int[] f = {};
		int f1 = myFun.largestWidth(f);
		assertEquals(0, f1);

	}

	@Test
	public void testThrees() {
		assertFalse(myFun.threes(new int[] { 1, 2, 1, 2, 1 }));
		assertFalse(myFun.threes(new int[] { 9, 1, 2, 1, 3 }));
		assertFalse(myFun.threes(new int[] { 4, 2, 3, 4, 16 }));
		assertTrue(myFun.threes(new int[] { 1, 3, 1, 2, 1 }));
		assertTrue(myFun.threes(new int[] { 11, 21, 2, 4, 10 }));
		assertTrue(myFun.threes(new int[] { 2, 4, 6, 8, 10 }));
	}

}