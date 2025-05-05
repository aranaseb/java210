import java.util.Scanner;

/**
 * This class has methods related by the fact that CSC 210 students are learning
 * about Java arrays. You will have to write your own @Test methods with as many
 * assertions as needed to ensure the methods here are correct.
 * 
 * @author Rick Mercer and Sebastian Arana
 */
public class ArrayFun {

	//////////////////////////////////////////////////////////////////////////////
	// Return the number of times a pair occurs in an array. A pair is any two
	// String values that are equal (case sensitive) in consecutive array elements.
	// The array may be empty or have only one element, in these cases return 0.
	// Overlapping is allowed { "Mom", "Mom", "Mom"} has two pairs.
	//
	// numberOfPairs({"abba", "abba", "abba" , "abba" }) returns 3
	// numberOfPairs({"a", "b", "c" }) returns 0
	// numberOfPairs({"a", "A", "a"}) returns 0 Case sensitive
	// numberOfPairs({"aBc", "aBc", "Xyz", "Xyz" }) returns 2
	// numberOfPairs({"A", "A", "A", "Xyz" }) returns 2 (overlapping allowed)
	// numberOfPairs({ }) returns 0
	// numberOfPairs({"a"}) returns 0
	//
	public int numberOfPairs(String[] array) {
		int count = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].equals(array[i + 1])) {
				count++;
			}
		}
		return count;
	}

	/////////////////////////////////////////////////////////////////////////
	// Given a filled array of double array elements, return true if the sum
	// of all array elements is greater than the parameter sum. Return false
	// if the array is empty. The argument to parameter sum may be negative.
	//
	// sumGreaterThan( {double[] 1.1, 2.2, 3.3 }, 4.0) returns true 6.6 > 4.0
	//
	// sumGreaterThan( { 1.1, 2.2, 3.3 }, 6.6) returns false because the sum
	// 6.6 is equal to the 2nd argument, not greater than
	//
	// sumGreaterThan( { -1.1, -2.2, -3.3 }, -6.5) returns false because
	// -6.6 is not greater than the 2nd argument -6.5
	//
	// sumGreaterThan( { }, -1.0) returns false. An empty array has a sum of 0.
	//
	public boolean sumGreaterThan(double[] array, double sum) {
		double theSum = 0;
		for (double item : array) {
			theSum += item;
		}
		return theSum > sum;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Given a Scanner constructed with a String containing a stream of integers in
	// the range of 0..10 (like quiz scores), returns an array of 11 integers where
	// the first value (at index 0) is the number of 0s in the Scanner, the second
	// value (at index 1) is the number of 1s on the Scanner, and the 11th value
	// at index 10 is the number of tens in the Scanner. This was an AP (Advanced
	// Placement) CS question some years ago. The following assertions must pass.
	//
	// Scanner scanner = new Scanner("5 0 1 2 1 5 2");
	// int[] result = myFun.frequency(scanner);
	// assertEquals(11, result.length);
	// assertEquals(1, result[0]); // There was 1 zero
	// assertEquals(2, result[1]); // Two 1s
	// assertEquals(2, result[2]); // Two 2s
	// assertEquals(0, result[3]); // No 3s
	// assertEquals(0, result[4]); // No fives
	// assertEquals(2, result[5]); // There were 2 5s
	// for(int score = 6; score <= 10; score++) {
	//// assertEquals(0, result[score]); // There were zero 6s, 7s, 8s, 9s, 10s
	//
	// Precondition: scanner only has valid white spaced integers in the range 0..10
	//
	public int[] frequency(Scanner scanner) {
		int[] freqs = new int[11];
		String[] scores = scanner.nextLine().split(" ");
		for (String score : scores) {
			freqs[Integer.parseInt(score)]++;
		}
		return freqs;
	}

	///////////////////////////////////////////////////////////////////////////////
	// Return the number of elements in an array of Strings that equal valueToFind.
	// This is case sensitive.
	//
	// howMany( {"A", "a", "A", "a" }, "A" ) returns 2 // Case sensitive
	// howMany( {"B", "B", "B", "B" }, "B" ) returns 4
	// howMany( {"And", "there", "goes", "another"}, "another" ) returns 1
	// howMany( {"And", "there", "goes", "another"}, "Not Here" ) returns 0
	// howMany( { }, "empty array" ) returns 0
	//
	// Use .equals to compare two strings, not ==
	//
	public int howMany(String[] array, String valueToFind) {
		int count = 0;
		for (String item : array) {
			if (item.equals(valueToFind)) {
				count++;
			}
		}
		return count;
	}

	/*- Keeps the spaces with Source > Format
	///////////////////////////////////////////////////////////////////////////////
	// Modify the parameter array so it still contains the exact same numbers as the
	// given array, but rearranged so that all the even numbers come before all the
	// odd numbers. Other than that, the numbers can be in any order. You must
	// modify the array argument by changing array in method evensLeft. The array
	// may be empty or have only 1 element so no change should be made.
	//
	// Original Array            Modified Array using Rick's algorithm
	// {1, 0, 1, 0, 1, 1, 0}     { 0, 0, 0, 1, 1, 1, 1 }
	// {3, 3, 2}                 { 2, 3, 3 }
	// {2, 2, 2}                 { 2, 2, 2}
	// {1, -2, 3, -4, 6}         { -2, -4, 6 1 3 }
	//
	*/
	public void evensLeft(int[] array) {
		int evens = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				evens++;
			}
		}
		int[] clone = array.clone();
		int left = 0;
		int right = evens;
		for (int i = 0; i < clone.length; i++) {
			if (clone[i] % 2 == 0) {
				array[left] = clone[i];
				left++;
			} else {
				array[right] = clone[i];
				right++;
			}
		}

	}

	/*- to keep the spaces
	///////////////////////////////////////////////////////////////////////////////
	// Return a new char[] that is a copy of array with all occurrences of oldChar
	// replaced by newChar. The original array argument must remain unchanged.
	// The returned array must have exactly the same capacity as the array reference
	//  passed to the parameter referenced as array. This is case sensitive.
	//
	// replaced ({'A', 'B', 'C', 'D', 'B'}, 'B', '+') returns this new array:
	//           {'A', '+', 'C', 'D', '+'}
	//         
	// replaced( {'A', 'B', 'C', 'C', 'B'}, 'C', 'L' ) returns this new array:
	//           {'A', 'B', 'L', 'L', 'B' }
	//
	// replaced( {'n', 'N', 'n', 'N', 'n'}, 'n', 'T' ) returns this new array:
	//           {'T', 'N', 'T', 'N', 'T' }
	//
	// replaced( { }, 'n', 'T' ) returns this new array:
	//           { }
	*/
	public char[] replaced(char[] array, char oldChar, char newChar) {
		char[] result = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == oldChar) {
				result[i] = newChar;
			} else {
				result[i] = array[i];
			}
		}
		return result;
	}

	/*- keep the spaces with Source > Format
	// Modify parameter array so it is "left shifted" n times -- so
	// shiftNTimes({6, 2, 5, 3}, 1) changes the array argument to {2, 5, 3, 6}
	// and shiftNTimes({6, 2, 5, 3}, 2) changes the array argument to {5, 3, 6, 2}.
	// You must modify the array argument by changing the parameter array inside
	// method shiftNTimes. Remember, a change to the parameter inside the method
	// shiftNTimes changes the argument inside the @Test method.
	//
	// shiftNTimes( { 1, 2, 3, 4}, 1 ) modifies the array to this:
	//              { 2, 3, 4, 1 }
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 3 ) modifies the array to this:
	//              { 4, 5, 6, 7, 1, 2, 3 }
	//
	// shiftNTimes( { 1, 2, 3, 4, 5, 6, 7 }, 0 ) does not modify the array
	//
	// shiftNTimes( { 1, 2, 3 }, 5) modifies the array to this:
	//              { 3, 1, 2 }
	//
	// shiftNTimes( { 3 }, 5) modifies array to this:
	//              { 3 }
	*/
	public void shiftNTimes(int[] array, int numShifts) {
		int shifts = numShifts % array.length;
		int[] clone = array.clone();
		for (int i = 0; i < array.length; i++) {
			if (i < shifts) {
				array[array.length - shifts + i] = clone[i];
			} else {
				array[i - shifts] = clone[i];
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////
	// Return the range of the numbers in an array[]. The range is defined as the
	// maximum value - minimum value. Range is undefined for empty arrays.
	//
	// range ({1, 2, 3, 4}) returns 4 - 1 == 3
	// range ({1, 2, -3, 4}) returns 4 - (-3) == 7
	// range ({ 99 }) returns 0
	//
	// Precondition: x.length >= 1
	//
	public int range(int[] x) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : x) {
			if (num < min) {
				min = num;
			}
			if (num > max) {
				max = num;
			}
		}
		return max - min;
	}

	/////////////////////////////////////////////////////////////////////////////
	// Return true if search is found in the parameter strs or false if search is
	// not found in strs. This is case-sensitive, the strings must match exactly.
	//
	// found( "A", {"A","B","C"} ) returns true
	// found( "a", {"A","B","C"} ) returns false (case sensitive)
	// found( "x", {"a","b","c", "d"} ) returns false
	// found( "x", { } ) returns false
	//
	public boolean found(String search, String[] strs) {
		for (String item : strs) {
			if (item.equals(search)) {
				return true;
			}
		}
		return false;
	}

	/////////////////////////////////////////////////////////////////////
	// Consider the leftmost and rightmost appearances of some value in
	// an array. We'll say that the "width" is the number of elements
	// between the two inclusive. A single value has a width of 1. Return
	// the largest width found in the given array.
	//
	// largestWidth({ 1, 2, 1, 1, 3 }) returns 4 (index 0 through index 3)
	// largestWidth({ 1, 4, 2, 1, 4, 1, 4 }) returns 6 (index 0 through index 5)
	// largestWidth({ 5, 5, 5, 5 }) returns 4 (index 0 through index 3)
	// largestWidth({ 99 }) returns 1 (index 0 through index 0)
	// largestWidth({ }) returns 0
	//
	public int largestWidth(int[] nums) {
		int widths[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[nums.length - 1 - j]) {
					widths[i] = nums.length - i - j;
					break;
				}
			}
		}
		int maxWidth = 0;
		for (int width : widths) {
			maxWidth = Math.max(width, maxWidth);
		}
		return maxWidth;
	}

	/////////////////////////////////////////////////////////////////
	// Given an array of integers, return true if the array contains
	// either three even and/or three odd integers all next to each
	// other. Return false if nums.length < 3 because it is impossible
	// to compare three consecutive integers.
	//
	// threes( {2, 1, 3, 5} ) returns true
	// threes( {2, 1, 4, 6} ) returns false, three evens are not together
	// threes( {9, 2, 4, 2, 5} ) returns true
	// threes( {1, 3, 5, 2, 2, 2} ) returns true
	// threes( {-1, -3, -5"} ) returns true
	// threes( {1, 3} ) returns false
	// threes( {4} ) returns false nums.length < 3
	// threes( {} ) returns false
	//
	//
	public boolean threes(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] % 2 == 0) {
				if (nums[i + 1] % 2 == 0 && nums[i + 2] % 2 == 0) {
					return true;
				}
			} else {
				if (nums[i + 1] % 2 == 1 && nums[i + 2] % 2 == 1) {
					return true;
				}
			}
		}
		return false;
	}
}