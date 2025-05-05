import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JavaFunTest {

	// Need an instance of a class to send messages to JavaFun messages
	JavaFun functions = new JavaFun();

	@Test
	public void testTriangleArea() {
		assertEquals(0.5, functions.triangleArea(1.0, 1.0));
		assertEquals(15.0, functions.triangleArea(5.0, 6.0));
		assertEquals(0.1, functions.triangleArea(0.05, 4.0));
		assertEquals(0.1, functions.triangleArea(4.0, 0.05));
	}

	@Test
	public void testRange() {
		// Use these three assertions. No need to add a 4th.
		assertEquals(1020.4, functions.range(45.0, 100.0), 0.01);
		assertEquals(0.0, functions.range(90.0, 100.0), 0.01);
		assertEquals(883.69, functions.range(30.0, 100.0), 0.01);
	}

	@Test
	public void testMiddleTwo() {
		assertEquals("ab", functions.middleTwo("ab"));
		assertEquals("er", functions.middleTwo("ergerrjn"));
		assertEquals("ab", functions.middleTwo("abc"));
		assertEquals("op", functions.middleTwo("stopper"));
	}

	@Test
	public void testAntimatter() {
		assertEquals("Anti-", functions.antiMatter(""));
		assertEquals("Anti-foot", functions.antiMatter("foot"));
		assertEquals("Anti-corn", functions.antiMatter("corn"));
		assertEquals("Anti-disestablishmentarianism", functions.antiMatter("disestablishmentarianism"));
	}

	@Test
	public void testAbba() {
		assertEquals("", functions.abba("", ""));
		assertEquals("abba", functions.abba("a", "b"));
		assertEquals("rr", functions.abba("r", ""));
		assertEquals(" yy ", functions.abba(" ", "y"));
	}

	@Test
	public void testRound() {
		assertEquals(0.0, functions.round(0.4, 0));
		assertEquals(4.15, functions.round(4.149, 2));
		assertEquals(3.141, functions.round(3.1406, 3));
		assertEquals(90, functions.round(89.96, 0));
	}

	@Test
	public void testMakeTags() {
		assertEquals("<i>Yay</i>", functions.makeTags("i", "Yay"));
		assertEquals("<ul>I am an unnumbered list</ul>", functions.makeTags("ul", "I am an unnumbered list"));
		assertEquals("<h1>php sucks</h1>", functions.makeTags("h1", "php sucks"));
		assertEquals("<title>My cool website</title>", functions.makeTags("title", "My cool website"));
	}

	@Test
	public void testSplitstring() {
		assertEquals("Wil dcat", functions.splitString("Wildcat"));
		assertEquals("space duster", functions.splitString("spaceduster"));
		assertEquals("3 am", functions.splitString("3am"));
		assertEquals("fort nite", functions.splitString("fortnite"));
	}

	@Test
	public void testInlat() {
		assertEquals("aplpe", functions.inLat("apple"));
		assertEquals("frton", functions.inLat("fortn"));
		assertEquals("a b c", functions.inLat("a  bc"));
		assertEquals("01234", functions.inLat("03124"));
	}

	@Test
	public void testInTrouble() {
		assertTrue(functions.inTrouble(true, true));
		assertTrue(functions.inTrouble(false, false));
	}

	@Test
	public void alone() {
		assertTrue(functions.alone(13, 99));
		assertTrue(functions.alone(99, 16));
		assertTrue(functions.alone(19, 12));
		assertTrue(functions.alone(13, 20));
	}

	@Test
	public void testNearTen() {
		assertTrue(functions.nearTen(1));
		assertTrue(functions.nearTen(99));
		assertTrue(functions.nearTen(22));
	}

	@Test
	public void testLikeSix() {
		assertTrue(functions.likeSix(6, 4));
		assertTrue(functions.likeSix(10, 4));
		assertTrue(functions.likeSix(3, 3));
	}

	@Test
	public void testEndCAP() {
		assertEquals("ELL", functions.endCAP("ell"));
		assertEquals("smELL", functions.endCAP("smell"));
		assertEquals("fortnitebattleroyALE", functions.endCAP("fortnitebattleroyale"));
	}

	@Test
	public void testCloseTo20() {
		assertFalse(functions.closeTo20(17));
		assertTrue(functions.closeTo20(58));
		assertTrue(functions.closeTo20(99));
		assertTrue(functions.closeTo20(418));
	}

	@Test
	public void testIsLeapYear() {
		assertTrue(functions.isLeapYear(2024));
		assertTrue(functions.isLeapYear(4));
		assertTrue(functions.isLeapYear(8000));
	}
}
