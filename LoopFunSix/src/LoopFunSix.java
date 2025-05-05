
/**
 *
 * This class has six method stubs related by the fact that CSC 210 students are
 * learning the algorithmic patterns Determinate Loop and Indeterminate Loop.
 * 
 * The methods will specifically use Java's for and while loop statements 
 * written in virtually all languages because these algorithmic patterns 
 * occur so frequently while developing software.
 * 
 * In two methods where the algorithm is not obvious, an algorithm is provided: 
 *    1. GCD(int, int) 
 *    2. sqrt(double) 
 *     
 * @authors Rick Mercer and Sebastian Arana
 * 
 */
import java.util.Scanner;

public class LoopFunSix {

	// In mathematics, the greatest common divisor (GCD) of two or more
	// integers, which are not all zero, is the largest positive integer
	// that divides each of the integers. For example, GCD(4, 12) is 4.
	//
	// Euclid's solution to finding the GCD is refuted to be the first
	// algorithm known to mankind. It is definitely old.
	//
	// GCD(a, b) can be computed as follows:
	//
	// while(b != 0):
	// .. other = a
	// .. a = b
	// .. b = other % b
	// a is the GCD
	//
	// GCD(378, 378) returns 378
	// GCD(378, 0) returns 378
	// GCD(0, 378) returns 378
	// GCD(3, 2) returns 1
	// GCD(10, 5) returns 5
	// GCD(15, 25) returns 5
	// GCD(25, 10) returns 5
	// GCD(-25, 10) returns 5
	// GCD(-25, -10) returns 5
	// GCD(25, -10) returns 5
	//
	// Either argument may be < 0
	//
	// Precondition: a or b can be 0, but not both. GCD(0, 0) is undefined.
	// We will not have an assert for GCD(0, 0) while grading.
	//
	public int GCD(int a, int b) {
		int other;
		while (b != 0) {
			other = a;
			a = b;
			b = other % b;
		}
		return Math.abs(a);

	}

	// The square root of a number >= 0 can be found by making successive
	// approximations towards correct square root until the approximation
	// is "close enough". Starting with an approximation (x or 16.0 below),
	// approximate the sqrt(x) until the approximation is extremely close
	// to the correct answer, or is the correct sqrt(x). To make the given
	// assertions pass in LoopFunSixTest, your return result must be within
	// 1E-15, or 0.00000000000001 of the square root.
	//
	// Feel free to use the Newton-Raphson algorithm until you are within
	// 1E-15 of the correct square root. Here is the general form:
	//
	// app[n+1] = (app[n] + x / app[n] ) / 2.0
	// app[n+2] = (app[n+1] + x / app[n+1] ) / 2.0
	//
	// For example, if x were 16.0:
	//
	// app[0] = 16.0
	// app[1] = (16.0 + 16.0 / 16.0) / 2.0 == 8.5
	// app[2] = (8.5 + 16.0 / 8.5) / 2.0 == 5.1911764706
	// app[3] = (5.1911764706 + 16.0 / 5.1911764706) / 2.0 == 4.1366647225
	// app[4] = (4.1366647225 + 16.0 / 4.1366647225) / 2.0 == 4.002257524797
	// app[5] = (4.002257524797 + 16.0 / 4.002257524797) / 2.0 == 4.00000063666
	// app[6] = (4.00000063666 + 16.0 / 4.00000063666) / 2.0); == 4.000000000000051
	//
	// 4.000000000000051 is only within 1E-14 of the correct sqrt(4.0). This
	// example algorithm needs another while loop iteration to get to 1E-15
	// precision,
	// the maximum precision for doubles, so 4.00000000000000 will be returned.
	//
	// No extra assertions are needed in the JUnit test
	//
	// Do not use Math.sqrt(double).
	//
	// Precondition x >= 0.0
	//
	public double sqrt(double x) {
		// Do not the built-in Math.sqrt(double). Get within 1E-15 of the answer
		double current = x;
		double prev = -1;
		// subtracts truncated current, measures length of decimals as string, makes
		// sure last decimal is not 0
		while (current != prev) {
			prev = current;
			current = (current + x / current) / 2.0;
		}
		return current;
	}

	// Given a Scanner constructed with a String of valid white space separated
	// integers, return the sum of all integers.
	//
	// Scanner scannerOne = new Scanner("2 5 -4 8");
	// sumInScanner(scannerOne) should return 11
	// Caution: scannerOne is now empty
	//
	// Preconditions: scanner has a string argument that has one or more
	// white-space separated integers, all of which are valid. Also, scanner
	// has not already been traversed in an earlier call (sum would be 0).
	//
	// Preconditions: scanner has only whitespace separated valid integers.
	// The scanner must not have been traversed earlier. Passing in empty
	// Scanner object would result in the return value
	//
	public int sumInScanner(Scanner scanner) {
		String[] values = scanner.nextLine().split(" ");
		int sum = 0;
		for (String value : values) {
			sum += Integer.parseInt(value);
		}
		return sum;
	}

	/////////////////////////////////////////////////
	// Suggestion: while loops above, for loops below
	/////////////////////////////////////////////////

	// Given an integer argument return n factorial, which is written as n!.
	// For example. 5! = 5*4*3*2*1 or in general, n! = n*(n-1)*(n-2) ... *2*1
	//
	// factorial(0) returns 1
	// factorial(1) returns 1
	// factorial(2) returns 2
	// factorial(4) returns 24, which is 4 * 3 * 2 * 1
	//
	// Precondition: n >= 0
	//
	public int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	// Given a String, return a reference to a new String that has
	// str's characters in reverse order.
	//
	// reverseString("") returns ""
	// reverseString("1") returns "1"
	// reverseString("1234") returns "4321"
	// reverseString("racecar") returns "racecar" // palindrome
	//
	public String reverseString(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result += str.charAt(str.length() - i - 1);
		}
		return result;
	}

	// Complete method charPipechar to return true if for every '!' (pipe) in str,
	// there are the same exact characters immediately before and after the pipe
	// symbol.
	// This is case sensitive. If there is no char before ! at the beginning of str
	// or after ! at the end of str, it is the same as if the same character were
	// there.
	// If this pattern is not found, return false.
	//
	// charPipechar("abc") returns true (there is no ! symbol)
	// charPipechar("y!z") returns false (2nd z should be y or the y should be a z)
	// charPipechar("xy!yz!z") returns true
	// charPipechar("!xa!az") returns true (no char to the left of "!x" is good)
	// charPipechar("XY!YYYY!Z!") returns false (last Y should be Z or the Z should
	// be Y)
	// charPipechar("XY!YYYY!Y!") returns true (no char to the right of "Y!" is
	// good)
	//
	public boolean charPipechar(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '!') {
				if (i != 0 && i != str.length()) {
					if ((str.charAt(i - 1) != str.charAt(i + 1)) && (str.charAt(i - 1) != '!')
							&& (str.charAt(i + 1) != '!')) {
						return false;
					}
				}
			}
		}
		return true;
	}

}