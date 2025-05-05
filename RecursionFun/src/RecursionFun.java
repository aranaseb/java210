
/**
 * Complete these ten methods using recursion, no loops. The array processing
 * algorithms require private helper method(s).
 * 
 * The comment specifications sometimes uses rf as an instance of this class
 * with the recursive method assuming your JUnit test has this instance
 * variable.
 * 
 * RecursionFun rf = new RecursionFun();
 * 
 * An important negative and easy way to lose points: -6 out of 7 points If you
 * use a loop instead of recursion even though your method works.
 *
 * @author Rick Mercer and Sebastian Arana
 */
public class RecursionFun {

	///////////////////////////////////////////////////////////////////////////////
	// Complete recursive method combinations that returns from n choose k.
	// See presentation 15_SimpleRecursion.pdf for an explanation and definition.
	// This presentation is linked on the course outline for Wednesday, 14-March.
	//
	// rf.combinations(5, 1) returns 5
	// rf.combinations(5, 5) returns 1
	// rf.combinations(52, 5) returns 2598960
	//
	// Precondition n >= 1 and k >= 1
	//
	public int combinations(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		return combinations(n - 1, k) + combinations(n - 1, k - 1);
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return n! Use recursion, do not use a loop.
	//
	// rf.factorial(0) returns 1
	// rf.factorial(1) returns 1
	// rf.factorial(2) returns 2
	// rf.factorial(5) returns 5*4*3*2*1
	//
	public int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return true if str is a palindrome, a string that reads the same in reverse
	// order in a case sensitive fashion. Use recursion, do not use a loop.
	//
	// rf.isPalindrome("") returns true
	// rf.isPalindrome("X") returns true
	// rf.isPalindrome("racecar") returns true
	// rf.isPalindrome("abba") returns true
	// rf.isPalindrome("aBba") returns false
	//
	public boolean isPalindrome(String str) {
		if (str.length() <= 1) {
			return true;
		}
		if (str.charAt(0) != str.charAt(str.length() - 1)) {
			return false;
		}
		return isPalindrome(str.substring(1, str.length() - 1));
	}

	///////////////////////////////////////////////////////////////////////////////
	// Place an underscore between any two characters that are == and next to each
	// other. Use recursion, do not use a loop.
	//
	// rf.underScore("xxyy")) returns x_xy_y
	// rf.underScore("abc")) returns abc
	// rf.underScore("hello")) returns "hel_lo"
	// rf.underScore("aaaa") returns "a_a_a_a"
	//
	public String underScore(String str) {
		if (str.length() <= 1) {
			return str;
		}
		if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "_" + underScore(str.substring(1));
		}
		return str.charAt(0) + underScore(str.substring(1));
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return the number of time char ch exists in the given string.
	// This is case sensitive 'c' does not match 'C'.
	// Use recursion, do not use a loop.
	//
	// assertEquals(0, rf.howMany('X', "abcde"));
	// assertEquals(1, rf.howMany('a', "abcde"));
	// assertEquals(3, rf.howMany('a', "abacdea"));
	// assertEquals(2, rf.howMany('C', "CcC")); // Case Sensitive
	//
	public int howMany(char ch, String str) {
		if (str.length() == 0) {
			return 0;
		}
		if (str.charAt(0) == ch) {
			return 1 + howMany(ch, str.substring(1));
		}
		return howMany(ch, str.substring(1));
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return the number of times a pair occurs in a string. This is case
	// sensitive. 'a' != 'A'. A pair is any two character values that are
	// equal and next to each other.
	//
	// rf.numberOfPairs("") returns 0
	// rf.numberOfPairs("a") returns 0
	// rf.numberOfPairs("aaa") returns 2
	// rf.numberOfPairs("ababa") returns 0
	// rf.numberOfPairs("aabbbaa") returns 4
	// rf.numberOfPairs("aAbBb") returns 0
	//
	public int numberOfPairs(String str) {
		if (str.length() <= 1) {
			return 0;
		} else if (str.charAt(0) == str.charAt(1)) {
			return 1 + numberOfPairs(str.substring(1));
		}
		return numberOfPairs(str.substring(1));
	}

	///////////////////////////////////////////////////////////////////////////
	/////// array processing where private helper methods are required ////////
	///////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////////////////////////
	// Complete recursive method reverseArray that reverses the array elements
	// in a filled array of ints. Use recursion, do not use a loop.
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// You'll need a private helper method.
	//
	// Precondition: x.length > 0
	//
	public void reverseArray(int[] x) {
		reverseArrayHelper(x, 0);
	}

	public void reverseArrayHelper(int[] x, int i) {
		if (i < x.length - 1 - i) {
			int temp = x[i];
			x[i] = x[x.length - 1 - i];
			x[x.length - 1 - i] = temp;
			reverseArrayHelper(x, i + 1);
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	// Write recursive method arrayRange that returns the maximum integer minus
	// the minimum integer in the filled array of ints. Use recursion; do not
	// use a loop. The following assertions must pass (note the shortcut way to
	// pass a reference to a new array--it saves your writing a bit of code:
	//
	// assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
	// assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
	// assertEquals(0, rf.arrayRange(new int[] { 3 }));
	// assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
	//
	// You'll need two private helper methods
	//
	// Precondition: a.length > 0
	//
	public int arrayRange(int[] a) {
		return arrayRangeMax(a, 0, Integer.MIN_VALUE) - arrayRangeMin(a, 0, Integer.MAX_VALUE);
	}

	private int arrayRangeMin(int[] a, int i, int min) {
		if (i < a.length) {
			if (a[i] < min) {
				return arrayRangeMin(a, i + 1, a[i]);
			}
			return arrayRangeMin(a, i + 1, min);
		}
		return min;
	}

	private int arrayRangeMax(int[] a, int i, int max) {
		if (i < a.length) {
			if (a[i] > max) {
				return arrayRangeMax(a, i + 1, a[i]);
			}
			return arrayRangeMax(a, i + 1, max);
		}
		return max;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return true if nums has all int elements in ascending order.
	// If not sorted, return false. You'll need a private helper method.
	//
	public boolean isSorted(int[] nums) {
		return isSortedHelper(nums, 0);
	}

	private boolean isSortedHelper(int[] nums, int i) {
		if (i < nums.length - 1) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
			return isSortedHelper(nums, i + 1);
		}
		return true;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Complete method found to return true if search is found in strs.
	// If not found, return false. You will need a private helper method
	public boolean found(String search, String[] strs) {
		return foundHelper(search, strs, 0);
	}

	private boolean foundHelper(String search, String[] strs, int i) {
		if (i < strs.length) {
			if (strs[i].equals(search)) {
				return true;
			}
			return foundHelper(search, strs, i + 1);
		}
		return false;
	}

}