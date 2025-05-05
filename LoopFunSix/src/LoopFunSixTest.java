
/**
 * This unit test is a beginning of a JUnit test for the 6 methods in the
 * file LoopFunSix.java. You do not need to add assertions to testSqrt().
 * 
 * @author Rick Mercer and Sebastian Arana
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class LoopFunSixTest {

	// The one instance variable that is accessible to all methods
	private LoopFunSix loopFun = new LoopFunSix();

	@Test
	public void testGCDWhen() {
		assertEquals(3, loopFun.GCD(3, 0));
		assertEquals(4, loopFun.GCD(-4, -16));
		assertEquals(5, loopFun.GCD(15, 20));
		assertEquals(6, loopFun.GCD(-12, 18));
		assertEquals(7, loopFun.GCD(0, 7));
		assertEquals(8, loopFun.GCD(-16, -24));
		assertEquals(9, loopFun.GCD(27, -72));
	}

	@Test
	public void testSqrt() {
		// These are the same assertions we will use to grade. Make these pass and your
		// sqrt is correct as long as you use an error factor of 1E-15 to terminate.
		assertEquals(4.0, loopFun.sqrt(16.0));
		assertEquals(10.0, loopFun.sqrt(100));
		assertEquals(1.414213562373095, loopFun.sqrt(2));
		assertEquals(1.457189074897283, loopFun.sqrt(2.1234));
		System.out.println(Math.sqrt(10.0));
		assertEquals(3.162277660168379, loopFun.sqrt(10.0));
		assertEquals(1000.0, loopFun.sqrt(1000000.0));
		assertEquals(2.0, loopFun.sqrt(4.0));
	}

	@Test
	public void sumInScanner() {
		Scanner streamOne = new Scanner("3 1 2 4");
		assertEquals(10, loopFun.sumInScanner(streamOne));

		// You need a new scanner because streamOne.hasNext() is now false.
		Scanner streamTwo = new Scanner("-3 1 -2");
		assertEquals(-4, loopFun.sumInScanner(streamTwo));
		Scanner streamThree = new Scanner("3 6 -3");
		assertEquals(6, loopFun.sumInScanner(streamThree));
		Scanner streamFour = new Scanner("11");
		assertEquals(11, loopFun.sumInScanner(streamFour));
		Scanner streamFive = new Scanner("-3 1");
		assertEquals(-2, loopFun.sumInScanner(streamFive));
	}

	@Test
	public void testFactorial() {
		assertEquals(6, loopFun.factorial(3));
		assertEquals(24, loopFun.factorial(4));
		assertEquals(2, loopFun.factorial(2));
		assertEquals(120, loopFun.factorial(5));
		assertEquals(720, loopFun.factorial(6));
		assertEquals(5040, loopFun.factorial(7));
	}

	@Test
	public void testReverseString() {
		assertEquals("654321", loopFun.reverseString("123456"));
		assertEquals("65432abc", loopFun.reverseString("cba23456"));
		assertEquals("banana", loopFun.reverseString("ananab"));
		assertEquals("tacocat", loopFun.reverseString("tacocat"));
		assertEquals("pool", loopFun.reverseString("loop"));
		assertEquals("a", loopFun.reverseString("a"));
	}

	@Test
	public void charPipechar() {
		// Rick is providing edge cases that could possibly be misinterpreted
		assertTrue(loopFun.charPipechar("")); // there is no !
		assertTrue(loopFun.charPipechar("s")); // there is no !
		assertTrue(loopFun.charPipechar("!")); // no char before and after ! is good
		assertTrue(loopFun.charPipechar("!s")); // okay
		assertTrue(loopFun.charPipechar("s!s"));
		assertTrue(loopFun.charPipechar("ts!s"));
		assertFalse(loopFun.charPipechar("t!s"));
		assertFalse(loopFun.charPipechar("S!s!s"));
		assertFalse(loopFun.charPipechar("S!s"));
		assertTrue(loopFun.charPipechar("s!s!s!s"));
		assertTrue(loopFun.charPipechar("s!!!s"));
		assertTrue(loopFun.charPipechar("!!s"));
	}

}