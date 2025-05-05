
/*
 * This unit test has at least one @Test method for each of the 12 methods 
 * in SelectionFun.java. However, they are incomplete, and do not represent 
 * 100% code coverage. This is meant to encourage you to think of other 
 * needed test cases and add your own asserts. 
 * 
 * We will run a unit test that is much much larger than this starter unit test. 
 * 
 * We will also run your tests to see code coverage, which is part of your grade.
 * 
 * Think of as many test cases as you can
 * 
 * Programmers: Rick Mercer and Sebastian Arana
*/
import static org.junit.Assert.*;
import org.junit.Test;

public class SelectionFunTest {

	private SelectionFun myFun = new SelectionFun();

	@Test
	public void testCombostring() {
		assertEquals("hiHellohi", myFun.comboString("Hello", "hi"));
		assertEquals("hiHellohi", myFun.comboString("hi", "Hello"));
		assertEquals("testTeststest", myFun.comboString("test", "Tests"));
		assertEquals("yesFortniteyes", myFun.comboString("Fortnite", "yes"));
	}

	@Test
	public void testSalary() {
		assertEquals(1500.0, myFun.salary(9999.00), 0.01);
		assertEquals(1550.0, myFun.salary(11000.0), 0.01);
		assertEquals(2080.0, myFun.salary(21000.0), 0.01);
		assertEquals(2920.0, myFun.salary(31000.0), 0.01);
	}

	@Test
	public void testFirstofthree() {
		assertEquals("Ma", myFun.firstOf3Strings("Ma", "ma", "ma"));
		assertEquals("a", myFun.firstOf3Strings("a", "b", "c"));
		assertEquals("X", myFun.firstOf3Strings("X", "b", "c"));
		assertEquals("123", myFun.firstOf3Strings("123", "1231", "123 0"));
		assertEquals("", myFun.firstOf3Strings("a", "0", ""));
	}

	@Test
	public void testAnswerOrNot() {
		assertFalse(myFun.answerOrNot(true, true, true));
		assertFalse(myFun.answerOrNot(true, false, true));
		assertTrue(myFun.answerOrNot(true, true, false));
		assertFalse(myFun.answerOrNot(true, false, false));
		assertFalse(myFun.answerOrNot(false, true, true));
		assertFalse(myFun.answerOrNot(false, false, true));
		assertTrue(myFun.answerOrNot(false, true, false));
		assertTrue(myFun.answerOrNot(false, false, false));
	}

	@Test
	public void testFizzBuzz() {
		assertEquals("Fizz", myFun.fizzBuzz("f"));
		assertEquals("Buzz", myFun.fizzBuzz("b"));
		assertEquals("FizzBuzz", myFun.fizzBuzz("fb"));
		assertEquals("banana", myFun.fizzBuzz("banana"));
	}

	@Test
	public void testRomannumeralAllUpperCase() {
		assertEquals(1, myFun.romanNumeral('I'));
		assertEquals(1, myFun.romanNumeral('i'));
		assertEquals(5, myFun.romanNumeral('V'));
		assertEquals(5, myFun.romanNumeral('v'));
		assertEquals(10, myFun.romanNumeral('X'));
		assertEquals(10, myFun.romanNumeral('x'));
		assertEquals(50, myFun.romanNumeral('L'));
		assertEquals(50, myFun.romanNumeral('l'));
		assertEquals(100, myFun.romanNumeral('C'));
		assertEquals(100, myFun.romanNumeral('c'));
		assertEquals(500, myFun.romanNumeral('D'));
		assertEquals(500, myFun.romanNumeral('d'));
		assertEquals(1000, myFun.romanNumeral('M'));
		assertEquals(1000, myFun.romanNumeral('m'));
	}

	@Test
	public void testSeason12_1_2True() {
		assertEquals("Winter", myFun.season(12, true));
		assertEquals("Winter", myFun.season(1, true));
		assertEquals("Summer", myFun.season(1, false));
		assertEquals("Summer", myFun.season(2, false));
		assertEquals("Spring", myFun.season(3, true));
		assertEquals("Spring", myFun.season(5, true));
		assertEquals("Fall", myFun.season(5, false));
		assertEquals("Winter", myFun.season(6, false));
		assertEquals("Summer", myFun.season(7, true));
		assertEquals("Summer", myFun.season(8, true));
		assertEquals("Winter", myFun.season(8, false));
		assertEquals("Spring", myFun.season(9, false));
		assertEquals("Fall", myFun.season(10, true));
		assertEquals("Fall", myFun.season(11, true));
		assertEquals("Spring", myFun.season(11, false));
		assertEquals("Summer", myFun.season(12, false));
		// TODO: Add many, many, many, more assertions
	}

	@Test
	public void testThanksdate1() {
		assertEquals(25, myFun.thanksDate(1));
		assertEquals(24, myFun.thanksDate(2));
		assertEquals(23, myFun.thanksDate(3));
		assertEquals(22, myFun.thanksDate(4));
		assertEquals(28, myFun.thanksDate(5));
		assertEquals(27, myFun.thanksDate(6));
		assertEquals(26, myFun.thanksDate(7));
		assertEquals(-1, myFun.thanksDate(8));
	}

	@Test
	public void testDaynumber1() {
		assertEquals(1, myFun.dayNumber("01/01/2018"));
		assertEquals(3, myFun.dayNumber("01/03/2016"));
		assertEquals(365, myFun.dayNumber("12/31/2023"));
		assertEquals(366, myFun.dayNumber("12/31/2024"));
		assertEquals(-1, myFun.dayNumber("13/11/2020"));
		assertEquals(365, myFun.dayNumber("12/31/2100"));
		assertEquals(59, myFun.dayNumber("02/28/2025"));
		assertEquals(60, myFun.dayNumber("02/29/2024"));
		assertEquals(61, myFun.dayNumber("03/01/2024"));
		assertEquals(90, myFun.dayNumber("03/31/2023"));
	}

	@Test
	public void testDayofweek1() {
		assertEquals("Monday", myFun.dayOfWeek(1));
		assertEquals("Tuesday", myFun.dayOfWeek(2));
		assertEquals("Wednesday", myFun.dayOfWeek(3));
		assertEquals("Thursday", myFun.dayOfWeek(4));
		assertEquals("Friday", myFun.dayOfWeek(5));
		assertEquals("Saturday", myFun.dayOfWeek(6));
		assertEquals("Sunday", myFun.dayOfWeek(7));
	}

	@Test
	public void testDaysinmonthWhenNotALeapYear1() {
		assertEquals(31, myFun.daysInMonth(1, 2018));
		assertEquals(28, myFun.daysInMonth(2, 2018));
		assertEquals(31, myFun.daysInMonth(3, 2018));
		assertEquals(30, myFun.daysInMonth(4, 2018));
		assertEquals(31, myFun.daysInMonth(5, 2018));
		assertEquals(30, myFun.daysInMonth(6, 2018));
		assertEquals(31, myFun.daysInMonth(7, 2018));
		assertEquals(31, myFun.daysInMonth(8, 2018));
		assertEquals(30, myFun.daysInMonth(9, 2018));
		assertEquals(31, myFun.daysInMonth(10, 2018));
		assertEquals(30, myFun.daysInMonth(11, 2018));
		assertEquals(31, myFun.daysInMonth(12, 2018));
		assertEquals(29, myFun.daysInMonth(2, 2020));
		assertEquals(28, myFun.daysInMonth(2, 2100));
	}

	@Test
	public void testValidDate() {
		assertTrue(myFun.validDate("01/01/2018"));
		assertFalse(myFun.validDate("02/29/2100"));
		assertTrue(myFun.validDate("01/31/2016"));
		assertTrue(myFun.validDate("12/31/2017"));
		assertTrue(myFun.validDate("06/15/2018"));
		assertTrue(myFun.validDate("02/28/2019"));
		assertFalse(myFun.validDate("02/29/2019"));
		assertFalse(myFun.validDate("13/02/2019"));
		assertFalse(myFun.validDate("12/32/2019"));
	}
}