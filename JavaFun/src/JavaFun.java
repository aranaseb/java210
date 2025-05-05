/*- The "-" after "/*" means Source > Format will not format the comment
 *
 * The class begins with 16 method stubs specified in comments above each stub. 
 * A method stub is a method heading followed by a block that returns a bogus value. 
 * These 16 methods are related only by the fact that CSC 210 students are learning 
 * how to develop methods and use the JUnit testing framework to test their functions. 
 * 
 * You will need to use a few Math functions and String methods.
 * You may use if and/or else if, but you don't need them.
 * If you can't find a string function or formula you think you need, Google it.
 *
 * You will need these Java's Boolean operators to write logical expressions:
 * 
 *   and: &&  (two ampersands)
 *   or:  ||  (two pipe symbols)
 *   not: !   (exclamation point)
 * 
 * Do not add any other methods to either file.
 * 
 * Programmers: Rick Mercer and Sebastian Arana
 */
public class JavaFun {

	/*-
	* Given the base and height of a triangle, return the area of the triangle.
	* Assume positive input since negative lengths do not make sense.
	* 
	* triangleArea (5.0, 5.0) returns 12.5
	* 
	* Precondition: base > 0 and height > 0
	*/
	public double triangleArea(double base, double height) {
		return base * height * 0.5;
	}

	/*
	 * Return a floating point number round to decimal decimal places. You will need
	 * Math.round and Math.pow.
	 * 
	 * round(3.4567, 0) returns 3 round(3.4567, 1) returns 3.5 round(3.4567, 2)
	 * returns 3.46 round(3.4567, 3) returns 3.457
	 * 
	 * Precondition: number >= 0 and decimals >= 0
	 */
	public double round(double number, int decimals) {
		double tens = Math.pow(10, decimals);
		return Math.round(number * tens) / tens;
	}

	/*-
	 * Complete range to determine the range of a projectile. range is defined as
	 * 
	 *   sin(2 * angle) * velocity * velocity / gravity
	 * 
	 * where angle is the angle of the projectile’s path in radians, velocity is the
	 * initial velocity of the projectile in meters per second, and gravity is
	 * acceleration at 9.8 meters per second. You will need Math.PI and
	 * Math.sin(double radians).
	 * 
	 * range(45.0, 100.0) returns 1020.4 after rounding the return value to 1 decimal.
	 * 
	 * An angle in degrees can be converted to radians by multiplying the number of
	 * degrees by π/180. 45° is 45.0 * Math.PI / 180.0 = 0.7853981633974483 radians.
	 * 
	 * Precondition: 90 <= degrees >= 0 and velocity >= 0
	 */
	public double range(double degrees, double velocity) {
		return Math.sin(2 * (degrees * (Math.PI / 180.0))) * velocity * velocity / 9.8;
	}

	/*-
	 * Given a non-negative number "num", return true if num is within 2 of a multiple
	 * of 10. Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2.
	 * 
	 * nearTen(12) returns true
	 * nearTen(17) returns false
	 * nearTen(18) returns true
	 * 
	 * Precondition: num >= 0;
	 */
	public boolean nearTen(int num) {
		return (num > 2) || (num % 10 <= 2 || num % 10 >= 8);
	}

	/*- 
	 * The number 6 is a truly great number. Given two integer arguments to a and b,
	 * return true if either argument is 6, if their sum is 6, or their difference is 6.
	 * 
	 * likeSix(6, 4) returns true 
	 * likeSix(4, 5) returns false
	 */
	public boolean likeSix(int a, int b) {
		return (a == 6 || b == 6 || a + b == 6 || a - b == 6);
	}

	/*-
	 * We have two monkeys, a and b, and the parameters aSmile and bSmile indicate
	 * if each is smiling. We are in trouble if they are both smiling or if neither
	 * of them smiling. Return true if we are in trouble.
	 * 
	 * inTrouble(true, true) returns true 
	 * inTrouble(false, false) returns true
	 * inTrouble(true, false) returns false
	 */
	public boolean inTrouble(boolean aSmile, boolean bSmile) {
		return (aSmile && bSmile) || !(aSmile || bSmile);
	}

	/*-
	 * Everyone knows that interplanetary space travel systems are fueled by letting
	 * matter and anti-matter mix. With this in mind, code a method that will take a
	 * String with the name of some thing or idea. Return a String with "Anti-"
	 * prepended to it. This method will tell us what to mix with that thing or idea
	 * so we can create a reaction to fuel our ships! Don't forget the dash! In
	 * short: Return the string matter references preceded by the string "Anti-".
	 * This is case sensitive.
	 * 
	 * antiMatter("lol") returns "Anti-lol"
	 * antiMatter("pollution") returns "Anti-pollution"
	 * antiMatter("") returns "Anti-"
	 */
	public String antiMatter(String matter) {
		return "Anti-" + matter;
	}

	/*- 
	 * Given two strings, a and b, put them together in the order abba.
	 * 
	 * abba("Hi", "Bye") returns "HiByeByeHi"
	 * abba("Yo", "Alice") returns "YoAliceAliceYo"
	 * abba("a", "b") returns "abba"
	 * 
	 */
	public String abba(String a, String b) {
		return a + b + b + a;
	}

	/*-
	 * Determine and return the middle two chars of the String argument. Return the middle
	 * 2 characters of the String argument. With an odd number of characters, favor the left.
	 * 
	 * middleTwo("abba") returns "bb" 
	 * middleTwo("ab") returns "ab" 
	 * middleTwo("abc") returns "ab"  // flavor the left
	 *
	 * Precondition: arg.length() >= 2
	 */
	public String middleTwo(String arg) {
		return arg.substring((arg.length() / 2) - 1, arg.length() / 2 + 1);
	}

	/*-
	 * This method takes in a string of length 2 or greater, and returns a string 
	 * with a space added into the middle of the string. If the string's length 
	 * is odd, the second half of the string will be longer than the first half.
	 * 
	 * splitString ("Wildcat") returns "Wil dcat"  // second half "dcat" is longer
	 * splitString ("ab") returns "a b"
	 * 
	 * Precondition: str.length() >= 2
	 */
	public String splitString(String str) {
		return str.substring(0, str.length() / 2) + " " + str.substring(str.length() / 2);
	}

	/*-
	 * Given a string, return a new string where the last 3 chars are now in upper
	 * case. Note that str.toUpperCase() returns the uppercase version of a string.
	 * You will also need String's length and substring methods.
	 * 
	 * endCAP("Hello") returns "HeLLO" 
	 * endCAP("hi there") returns "hi thERE"
	 * endCAP("hip") returns "HIP"
	 * 
	 * Precondition: str.length() >= 3
	 */
	public String endCAP(String str) {
		return str.substring(0, str.length() - 3) + str.substring(str.length() - 3).toUpperCase();
	}

	/*-
	 * The web is built with HTML elements like "<i>Yay</i>" which draws Yay as
	 * italic text. In this example, the "i" tag makes <i> and </i> which surround
	 * the text "Yay". Given tags such as i, b, strong ... and the text to surround,
	 * create the HTML with tags around the sentence. The begin tag is <tag> and the
	 * end tag has a / as in </tag>
	 * 
	 * makeTags("i", "Yay") returns "<i>Yay</i>" 
	 * makeTags("strong", "Some text") returns "<strong>Some text</strong>"
	 */
	public String makeTags(String tag, String text) {
		return "<" + tag + ">" + text + "</" + tag + ">";
	}

	/*-
	 * Aoccdrnig to a rscheearch at an Elingsh uinervtisy, it deosn't mttaer in waht
	 * oredr the ltteers in a wrod are the olny iprmoetnt tihng is taht frist and
	 * lsat ltteer is at the rghit pclae.
	 * 
	 * Create a method that will mix up the middle characters in a 5 letter word.
	 * The precondition states the word must have exactly 5 letters. If the argument
	 * is a different length, the method does not work.
	 * 
	 * Assuming the letters are indexed as 0-1-2-3-4, they should end up in the
	 * order 0-2-3-1-4. Your method will accept a 5-character string as an argument
	 * and return a 5-character string reordered as described.
	 * 
	 * inLat("apple") returns "aplpe" 
	 * inLat("gears") returns "gares" 
	 * inLat("prior") returns "piorr" 
	 * inLat ("scone") returns "sonce"
	 * 
	 * Precondition str.length() == 5
	 */
	public String inLat(String str) {
		return "" + str.charAt(0) + str.charAt(2) + str.charAt(3) + str.charAt(1) + str.charAt(4);
	}

	/*-
	 * A number is "alone" if it is in the range of 13..19 inclusive. Given 2 int
	 * values, return true if one or the other is alone, but not both.
	 * 
	 * alone(13, 99) returns true 
	 * alone(21, 19) returns true 
	 * alone(13, 13) returns false
	 * 
	 * Precondition: a >= 1 && b >= 1
	 */
	public boolean alone(int a, int b) {
		// Suggestion: Store aloneness as boolean local variables first. Boolean local
		// variables like this are a little rare, but here they work great.
		Boolean aloneA = a >= 13 && a <= 19;
		Boolean aloneB = b >= 13 && b <= 19;
		return !(aloneA && aloneB) && (aloneA || aloneB);
	}

	/*-
	 * Return true if the given non-negative number is 1 or 2 less than a 
	 * multiple of 20. So for example 38 and 39 return true, but 40 returns false. 
	 * 
	 * closeTo20(58) returns true
	 * closeTo20(60) returns false
	 * closeTo20(61) return false
	 * 
	 * Precondition: num >= 1
	 */
	public boolean closeTo20(int n) {
		return n % 20 >= 18 && n % 20 < 20;
	}

	/*-
	 * Complete method isLeapYear that returns true if the integer argument
	 * represents a leap year. A leap year is a positive integer that is evenly
	 * divisible by 4 except the last year of a century, which are those years
	 * evenly divisible by 100. Century years must also be divisible by 400. 
	 * 2000 was a leap year and 2400 will be, however 2100 will not be even 
	 * though 2100 is evenly divisible by 4. 2100 is not evenly divisible by 400.
	 * 
	 * isLeapYear(2023) returns false 
	 * isLeapYear(2024) returns true 
	 * isLeapYear(2100) returns false
	 * isLeapYear(2400) returns true
	 * 
	 * Precondition: year >= 0. Negative years can not, and should not, work.
	 */
	public boolean isLeapYear(int year) {
		// Do not use any library method. You will lose 5 points if you do. Instead,
		// return a complex Boolean expression using year as an operand. You may use
		// if and/or if else statements if you want, However you do not need ifs.
		return (year % 4 == 0) && !(year % 100 == 0 && year % 400 != 0);
	}

}