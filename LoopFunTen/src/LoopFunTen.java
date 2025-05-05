
/**
 * This class has ten methods related by the fact that CSC 210 students are
 * learning the algorithmic patterns Determinate Loop and Indeterminate Loop.
 * 
 * The methods will specifically use Java's for and while statements that
 * written in virtually all languages because these algorithmic patterns
 * occur so frequently while developing software.
 * 
 * @author Rick Mercer and Sebastian Arana
 * 
 */
import java.util.Scanner;

public class LoopFunTen {

	// One evening, while listening intently at the Very Large Array (VLA)
	// radio astronomy observatory 50 miles west of Socorro New Mexico
	// (337 miles northeast of Tucson), Ellie hears a powerful signal: a prime
	// number pattern emanating from Vega, confirmed by other Observatories
	// all the world over, undeniable, and strong in its pulsing power. What
	// Ellie recognized was the repeating series of the first 26 prime numbers.
	// This is someone near Vega trying to contact anyone on earth who is listening.
	//
	// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
	//
	// A prime number is a natural number greater than 1 that has no positive
	// divisors other than 1 and itself. Complete method isPrime to return
	// true if the argument is a prime number.
	//
	// Hint: Consider writing a loop that divides the parameter num by every
	// integer from 2 up to but not including, num-1. Return false if num
	// was found to be evenly divisible by any one of those integers. If another
	// divisor is not found, return true.
	//
	// Precondition: num >= 2
	//
	public boolean isPrime(int num) {
		// only 2 through the square root of num needs to be tested
		for (int i = 2; i < (int) (Math.sqrt(num) + 1); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// ABBA is a band, they have many songs including Dancing Queen, and
	// Fernando. ABBA is actually a Swedish band, so if we wanted to find
	// out howSwedish a String is, we could simply find out how many times
	// the String contains the substring "abba". We want to look for this
	// substring in a case insensitive manner. So "abba" counts, and so
	// does "aBbA". We also want to check for overlapping abba's such as
	// in the String "abbAbba" that contains "abba" twice.
	//
	// howSwedish("ABBA a b b a") returns 1
	// howSwedish("ab!abbabba!ba") returns 2
	//
	public int howSwedish(String str) {
		int count = 0;
		str = str.toLowerCase();
		for (int i = 0; i < str.length() - 3; i++) {
			if (str.substring(i, i + 4).equals("abba")) {
				count++;
			}
		}
		return count;
	}

	// In the movie "The Da Vinci Code" with Tom Hanks, this password
	// was used to unlock a much sought after artifact: 1 2 3 5 8 13 21.
	// These are the 2nd through 8th Fibonacci numbers. Fibonacci numbers
	// have so much interest, there exists a Fibonacci Quarterly
	//
	// http://www.fq.math.ca/
	//
	// Implement method fibonacci that returns the nth Fibonacci number. Fibonnaci
	// numbers can be computed as the sum of the preceding two. You should find it
	// useful to keep track the two previous Fibonacci numbers.
	//
	// fibonacci(1) returns 1
	// fibonacci(2) returns 1
	// fibonacci(3) returns 2
	// fibonacci(4) returns 3
	// fibonacci(5) returns 5
	// fibonacci(6) returns 8
	//
	// Note: This is harder than it looks.
	//
	// Precondition: n >= 1
	//
	public int fibonacci(int n) {
		int sum = 0;
		int prev = 0;
		int current = 1;
		for (int i = 1; i < n; i++) {
			sum = current + prev;
			prev = current;
			current = sum;
		}
		return sum;
	}

	// Given a Scanner constructed with a String containing valid
	// white space separated integers, return the range. Range is
	// the maximum integer – minimum integer.
	//
	// Scanner scannerOne = new Scanner("2 5 7 8");
	// rangeInScanner(scannerOne) returns 6, which is 8 - 2
	//
	// Scanner scannerTwo = new Scanner("2 5 -7 8");
	// rangeInScanner(scannerTwo) returns 15, which is 8 - (-7)
	//
	// Precondition: The Scanner object has a string argument that has one
	// or more white-space separated integers, all of which are valid integers.
	//
	public int rangeInScanner(Scanner scanner) {
		String[] values = scanner.nextLine().split(" ");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int num;
		for (String value : values) {
			num = Integer.parseInt(value);
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		return max - min;
	}

	// Given a Scanner constructed with a String containing white
	// space separated words, return the number of "words" found
	// in the scanner that .equals the 2nd parameter search.
	//
	// Scanner scannerOne = new Scanner("here are five words here");
	// howMany(scannerOne, "here") returns 2
	//
	// scannerOne = new Scanner("here are five words here");
	// howMany(scannerOne, "not") returns 0
	//
	// Scanner scannerTwo = new Scanner("a MMM b b a b 23 a b");
	// howMany(scannerTwo, "a") returns 3
	//
	// scannerTwo = new Scanner("a MMM b b a b 23 a b");
	// howMany(scannerTwo, "b") returns 4
	//
	public int howMany(Scanner scanner, String search) {
		String[] words = scanner.nextLine().split(" ");
		int count = 0;
		for (String word : words) {
			if (word.equals(search)) {
				count++;
			}
		}
		return count;
	}

	// Given a Scanner containing an unknown number of quiz scores,
	// return the percentage of 100s in the Scanner. If the Scanner
	// has these quiz scores where there are 4 100s out of 16 total,
	//
	// new Scanner ("80 90 100 72 65 49 90 88 90 100 90 100 100 74 93 99")
	//
	// perfectPercentage must return 4 / 16 or 0.25 meaning 25%.
	//
	// Remember: 4 / 16 == 0 so you need to multiply one, or two of your
	// variables by 1.0 to get a double.
	//
	// Precondition: scanner has a string argument that has one or more
	// white-space separated integers, all of which are valid integers.
	//
	public double perfectPercentage(Scanner scanner) {
		String[] scores = scanner.nextLine().split(" ");
		int count = 0;
		for (String score : scores) {
			if (Integer.parseInt(score) == 100) {
				count++;
			}
		}
		return count * 1.0 / scores.length;
	}

	// Given a string, return a new string that has every character duplicated
	// next to its original position.
	//
	// doubleUp("") return ""
	// doubleUp("M") return "MM"
	// doubleUp("abc") return "aabbcc"
	//
	public String doubleUp(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result += str.charAt(i);
			result += str.charAt(i);
		}
		return result;
	}

	// "How much wood could a woodchuck chuck" contains 11 vowels. How do we
	// know? Five of the 26 English alphabet letters are vowels: a, e, i, o,
	// and u. By looking at each letter in the woodchuck string, we find
	// 11 vowels. Complete method vowelCount that returns the number of vowels
	// in the given string argument. This is case insensitive. Upper and lower
	// case vowels count.
	//
	// vowelCount("a e i o u A E I O U") returns 10
	// vowelCount("y+_x1Y2x!y") returns 0
	//
	public int vowelCount(String str) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			for (char vowel : vowels) {
				if (str.charAt(i) == vowel) {
					count += 1;
				}
			}
		}
		return count;
	}

	// Calculates and returns the number of times two consecutive characters (pairs)
	// occur in the given string. A pair is defined as two adjacent characters that
	// are the same. This method is case-sensitive, which means 'A' and 'a' are
	// considered different characters.
	//
	// numberOfPairs ("") returns 0
	// numberOfPairs ("abc") returns 0
	// numberOfPairs ("aabbcc") returns 3
	// numberOfPairs ("!!!") returns 2
	// numberOfPairs ("mmmm") returns 3
	// numberOfPairs ("mmOmm") returns 2
	// numberOfPairs ("mMOzZ") returns 0 // This is case sensitive
	//
	public int numberOfPairs(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;
			}
		}
		return count;
	}

	// Given a String, return the same characters in the string except all
	// upper case "M"s must be to the left, from indexes 0 to the total number of
	// 'M's in the argument to str. Letters other than "M" may be in any order.
	//
	// allMsLeft("") returns ""
	// allMsLeft("M") returns "M"
	// allMsLeft("Moo") returns "Moo"
	// allMsLeft("MMmMmmM") returns "MMMMmmm",
	// allMsLeft("MOX") returns either "MOX" or "MXO"
	// allMsLeft("MbcMdaaaefMghiMM") returns "MMMMMbcdaaaefghi" if you use my
	// algorithm
	//
	// Important: Letters other than "M" can be in any order to the right of the Ms.
	//
	public String allMsLeft(String str) {
		String left = "";
		String right = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'M') {
				left += "M";
			} else {
				right += str.charAt(i);
			}
		}
		return left + right;
	}

}