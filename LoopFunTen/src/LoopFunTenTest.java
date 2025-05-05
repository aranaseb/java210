
/**
 * This class is a JUnit test to test the 10 methods in LoopFunTen
 * 
 * @author Rick Mercer and Sebastian Arana
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import org.junit.Test;

public class LoopFunTenTest {

	// The one instance variable that is accessible to all assertion below.
	// All messages should be in the form of loopFun.methodName(argument(s))
	private LoopFunTen loopFun = new LoopFunTen();

	@Test
	public void testRangeInScanner() {
		assertEquals(2, loopFun.rangeInScanner(new Scanner("2 3 4")));
		assertEquals(1, loopFun.rangeInScanner(new Scanner("2 2 3")));
		assertEquals(6, loopFun.rangeInScanner(new Scanner("-2 3 4")));
		assertEquals(0, loopFun.rangeInScanner(new Scanner("2")));
		assertEquals(22, loopFun.rangeInScanner(new Scanner("-20 2 -14")));
	}

	@Test
	public void testhowMany() {
		assertEquals(2, loopFun.howMany(new Scanner("test the first test"), "test"));
		assertEquals(1, loopFun.howMany(new Scanner("i love fortnite"), "fortnite"));
		assertEquals(0, loopFun.howMany(new Scanner("abcdef bcd bc b ab"), "a"));
		assertEquals(2, loopFun.howMany(new Scanner("a b c d l e f g m mm m"), "m"));
		assertEquals(3, loopFun.howMany(new Scanner("Im like so like tired like yeah"), "like"));
	}

	@Test
	public void testWordperfectPercentage() {
		assertEquals(0.333333, loopFun.perfectPercentage(new Scanner("1 2 100")), 0.00001);
		assertEquals(0, loopFun.perfectPercentage(new Scanner("44")), 0.00001);
		assertEquals(1.0, loopFun.perfectPercentage(new Scanner("100")), 0.00001);
		assertEquals(0.5, loopFun.perfectPercentage(new Scanner("100 100 99 99 99 100")), 0.00001);
		assertEquals(0.125, loopFun.perfectPercentage(new Scanner("1 2 100 99 1 4 5 99")), 0.00001);

	}

	@Test
	public void testFibonacci() {
		assertEquals(8, loopFun.fibonacci(6));
		assertEquals(13, loopFun.fibonacci(7));
		assertEquals(5, loopFun.fibonacci(5));
		assertEquals(233, loopFun.fibonacci(13));
		assertEquals(377, loopFun.fibonacci(14));
		assertEquals(610, loopFun.fibonacci(15));
	}

	@Test
	public void testIsPrime() {
		assertTrue(loopFun.isPrime(23));
		assertFalse(loopFun.isPrime(4));
		assertTrue(loopFun.isPrime(17));
		assertFalse(loopFun.isPrime(9));
		assertTrue(loopFun.isPrime(2));
		assertFalse(loopFun.isPrime(16));

	}

	@Test
	public void testhowSwedish() {
		assertEquals(2, loopFun.howSwedish("abbabba"));
		assertEquals(2, loopFun.howSwedish("abbasabba"));
		assertEquals(0, loopFun.howSwedish("abbbba"));
		assertEquals(3, loopFun.howSwedish("abbabbabba"));
		assertEquals(1, loopFun.howSwedish("banabba"));
	}

	@Test
	public void testDoubleUp() {
		assertEquals("aabbcc", loopFun.doubleUp("abc"));
		assertEquals("ffoorrttnniittee", loopFun.doubleUp("fortnite"));
		assertEquals("bbaaaannaaaannaaaa", loopFun.doubleUp("baanaanaa"));
		assertEquals("GGYYAAAAAAAATT", loopFun.doubleUp("GYAAAAT"));
		assertEquals("ddoouubblleeuupp", loopFun.doubleUp("doubleup"));
	}

	@Test
	public void testVowelCount() {
		assertEquals(10, loopFun.vowelCount("a e i o u A E I O U"));
		assertEquals(6, loopFun.vowelCount("banana BANANA"));
		assertEquals(7, loopFun.vowelCount("Fortnite is SO EPIC"));
		assertEquals(5, loopFun.vowelCount("no fortnite = SAD"));
		assertEquals(0, loopFun.vowelCount("lv frtnt"));
	}

	@Test
	public void testNumberOfPairs() {
		assertEquals(2, loopFun.numberOfPairs("abbba"));
		assertEquals(1, loopFun.numberOfPairs("fortniite"));
		assertEquals(3, loopFun.numberOfPairs("baanaanaa"));
		assertEquals(8, loopFun.numberOfPairs("LLLLLLLLL"));
		assertEquals(0, loopFun.numberOfPairs("abcdefgh!@"));
	}

	@Test
	public void testAllMsLeft() {
		// This line will be yellow and lose a point or 2 due to the || (or). However,
		// we are counting code coverage in LoopTenFun.java only, not this JUnit test.
		assertTrue("MBa".equals(loopFun.allMsLeft("BaM")) || "MaB".equals(loopFun.allMsLeft("BaM")));
		assertTrue("MMMM fortnite".equals(loopFun.allMsLeft(" MfMortMnitMe")));
		assertTrue("MMMMcccDonalds".equals(loopFun.allMsLeft("McMcMcDonaldsM")));
		assertTrue("MMonkey".equals(loopFun.allMsLeft("MonkMey")));
		assertTrue("Markiplier".equals(loopFun.allMsLeft("Markiplier")));
	}
}