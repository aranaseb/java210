/*
 * This class has 12 methods related by the fact that CSC 210 students 
 * are learning to implement the algorithmic patterns Guarded Selection, 
 * Alternative Selection, Multiple Selection in Java Programming.
 * 
 * The methods will specifically use if and if..else statements that are
 * part of virtually all languages because these algorithmic patterns occur
 * so frequently while developing software. There are several contrived 
 * methods and several other possibly useful methods.
 * 
 * @author Rick Mercer and Sebastian Arana
 */
public class SelectionFun {

	// Given 2 strings, a and b, return a string of the form short+long+short, with
	// the
	// shorter string on the outside and the longer string on the inside. The
	// strings
	// must not be the same length. Only a or b may be empty (length()==0), not
	// both.
	//
	// comboString("Hello", "hi") returns "hiHellohi"
	// comboString("hi", "Hello") returns "hiHellohi"
	// comboString("aaa", "b") returns "baaab"
	//
	// Precondition: a.length() != b.length()
	//
	public String comboString(String a, String b) {
		if (a.length() > b.length()) {
			return b + a + b;
		} else {
			return a + b + a;
		}
	}

	// Given three String arguments, return the String that lexicographically
	// precedes or is equal to the other two string arguments.
	//
	// firstOf3Strings("a", "b", "c") returns "a"
	// firstOf3Strings("X", "b", "c") returns "X"
	// firstOf3Strings("123", "1231", "123 0") returns "123"
	// firstOf3Strings("a", "0", "") returns ""
	//
	// You must use String's compareTo method
	//
	public String firstOf3Strings(String a, String b, String c) {
		if (a.compareTo(b) <= 0 && a.compareTo(c) <= 0) {
			return a;
		} else if (b.compareTo(a) <= 0 && b.compareTo(c) <= 0) {
			return b;
		} else {
			return c;
		}
	}

	// Your cell phone rings. Return true if you should answer it.
	// Normally you answer, except in the morning you only answer
	// if it is your mom calling. In all cases, if you are asleep,
	// you do not answer.
	//
	// answerCell(false, false, false) returns true
	// answerCell(false, false, true) returns false
	// answerCell(true, false, false) returns false
	//
	//
	public boolean answerOrNot(boolean isMorning, boolean isMom, boolean isAsleep) {
		return (!isAsleep) && (!isMorning || isMom);
	}

	/*-
	 * Given a string str,if the string starts with "f", return "Fizz". If the
	 * string ends with "b", return "Buzz". If both the "f" and "b" conditions are
	 * true, return "FizzBuzz". In all other cases,return the string unchanged.
	 * 
	 * fizzString("fig") returns "Fizz"
	 * fizzString("dib") returns "Buzz"
	 * fizzString("fib") returns "FizzBuzz"
	 * 
	 * Precondition str.length() >= 1
	 */
	public String fizzBuzz(String str) {
		String result = "";
		if (str.charAt(0) == 'f')
			result += "Fizz";
		if (str.charAt(str.length() - 1) == 'b')
			result += "Buzz";
		if (result.equals(""))
			return str;
		return result;
	}

	/*-
	 * Complete salary to returns a salesperson’s salary
	 * for the month according to the following policy:
	 * 
	 * Sales   Not
	 * Over    Over     Monthly Salary
	 * ======= =======  ==============
	 * 0       10,000   Base salary
	 * 10,000  20,000   Base salary plus 5% of sales over 10,000
	 * 20,000  30,000   Base salary plus 500.00 plus 8% of sales over 20,000
	 * 30,000           Base salary plus 1300.00 plus 12% of sales over 30,000
	 * 
	 * The base salary is $1,500.00, which means salary returns a value that
	 * is never less than 1500.00. When sales are over $10,000, commission is
	 * added to the base salary. For example, when sales equals 10001, the
	 * monthly salary is $1,500.00 + 5% of $1.00 for a total of $1,500.05,
	 * and when sales is 20001, the monthly salary is $1,500.00 + $500.00 + 8%
	 * of $1.00 for a total of $2,000.08.
	 *   
	 * Precondition: sales >= 0.0 (never negative)
	 */
	public double salary(double sales) {
		double salary = 1500.0;
		if (sales > 30000) {
			salary += 1300.0;
			salary += (sales - 30000) * 0.12;
		} else if (sales > 20000) {
			salary += 500.0;
			salary += (sales - 20000) * 0.08;
		} else if (sales > 10000) {
			salary += (sales - 10000) * 0.05;
		}
		return salary;
	}

	/*- 
	* Complete romanNumeral that returns the numeric
	* equivalent of an upper- or lower-case Roman numeral, which is actually
	* a char. Roman numerals and their decimal equivalents are
	*
	* 'I' (or 'i') = 1
	* 'V' (or 'v') = 5
	* 'X' (or 'x') = 10
	* 'L' (or 'l') = 50
	* 'C' (or 'c') = 100
	* 'D' (or 'd') = 500
	* 'M' (or 'm') = 1,000
	*
	* Hint: Convert any lower case letter to it's upper case equivalent with -= 32
	* 
	* if ((ch >= 'a') && (ch <= 'z')) {
	*   ch -= 32;  // 'i' == 105, 'I' == 73
	* }
	*
	* Precondition: numeral is one of the valid 14 Roman numerals shown above
	*/
	public int romanNumeral(char numeral) {
		if (numeral == 'I' || numeral == 'i') {
			return 1;
		}
		if (numeral == 'V' || numeral == 'v') {
			return 5;
		}
		if (numeral == 'X' || numeral == 'x') {
			return 10;
		}
		if (numeral == 'L' || numeral == 'l') {
			return 50;
		}
		if (numeral == 'C' || numeral == 'c') {
			return 100;
		}
		if (numeral == 'D' || numeral == 'd') {
			return 500;
		} else {
			return 1000;
		}
	}

	///////////////////////////////////////
	// And now for some Calendar methods //
	///////////////////////////////////////

	// dayOfWeek returns the string "Monday" if the int argument passed to the
	// parameter dayNumber is 1, return "Tuesday" if the argument 2, and so on up
	// through returning "Sunday" if the argument is 7. This is case sensitive.
	//
	// dayOfWeek(1) returns "Monday"
	// dayOfWeek(2) returns "Tuesday"
	// dayOfWeek(3) returns "Wednesday"
	// dayOfWeek(4) returns "Thursday"
	// dayOfWeek(5) returns "Friday"
	// dayOfWeek(6) returns "Saturday"
	// dayOfWeek(7) returns "Sunday"
	//
	// Precondition: dayNumber is in the range of 1 through 7
	//
	public String dayOfWeek(int dayNumber) {
		String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		return days[dayNumber - 1];
	}

	// In the US, Thanksgiving falls on the 4th Thursday of each November. Complete
	// method thanksDate that determines the day of the month that Thanksgiving
	// falls on no matter the day on which November begins. November can begin on
	// any day where 1 represents Monday, through 7 that represents Sunday. A valid
	// call would be thanksDate(2) to indicate the first day of November is Tuesday.
	// thanksDate should then return the day of the month upon which Thanksgiving
	// falls. The argument can be any valid integer so return -1 if the argument to
	// the parameter to day is outside the range of 1 through 7 inclusive.
	//
	// thanksDate(2) returns 24 1-Nov is Tuesday
	// thanksDate(5) returns 28 1-Nov is Friday
	// thanksDate(7) returns 26 1-Nov is Sunday
	// thanksDate(0) returns -1
	// thanksDate(8) returns -1
	//
	public int thanksDate(int day) {
		if (day > 4 && day <= 7) {
			return 28 + 5 - day;
		} else if (day <= 4 && day > 0) {
			return 22 + 4 - day;
		}
		return -1;
	}

	/*-
	 * Given an integer for the month (1 is January and 12 is December) and a
	 * Boolean argument that when true represents the northern hemisphere, 
	 * return the current season in that hemisphere using the table below.
	 * 
	 * month          inNorthernHemisphere  !inNorthernHemisphere
	 * ============   ====================  =====================
	 * 12, 1, or 2    "Winter"              "Summer"
	 * 3, 4, or 5     "Spring"              "Fall"
	 * 6, 7, or 8     "Summer"              "Winter"
	 * 9, 10, or 11   "Fall"                "Spring"
	 *   
	 *  Precondition: month is in the range of 1 through 12 inclusive.
	*/
	public String season(int month, boolean inNorthernHemisphere) {
		if ((inNorthernHemisphere && (month == 12 || month == 1 || month == 2))
				|| (!inNorthernHemisphere && (month == 6 || month == 7 || month == 8))) {
			return "Winter";
		}
		if ((inNorthernHemisphere && (month == 3 || month == 4 || month == 5))
				|| (!inNorthernHemisphere && (month == 9 || month == 10 || month == 11))) {
			return "Spring";
		}
		if ((inNorthernHemisphere && (month == 6 || month == 7 || month == 8))
				|| (!inNorthernHemisphere && (month == 12 || month == 1 || month == 2))) {
			return "Summer";
		} else {
			return "Fall";
		}
	}

	// Complete daysInMonth to return the number of days in a month for
	// the given year. There are 30 days in the months September, April,
	// June, and November, or months 9, 4, 6, and 11. February has 28 days
	// unless it is a leap year when it has 29. All other months 1 (January),
	// 3, 5, 7, 8, 10, and 12 (December) have 31 days. Assume the year is
	// always >= 1582, the year the Gregorian Calendar started.
	//
	// daysInMonth(1, 2020) returns 31
	// daysInMonth(2, 2023) returns 28
	// daysInMonth(2, 2024) returns 29
	//
	// Preconditions: month is the range of 1 through 12 and year >= 1582
	//
	public int daysInMonth(int month, int year) {
		if (month != 2) {
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				return 30;
			}
			return 31;
		} else {
			if (isLeapYear(year)) {
				return 29;
			}
			return 28;
		}
	}

	// Complete method dayNumber to return how many days a valid date is into
	// the year. If the string argument is not a valid date, return -1.
	//
	// dayNumber("01/03/2016") returns 3
	// dayNumber("12/31/2023") returns 365
	// dayNumber("12/31/2024") returns 366
	// dayNumber("13/11/2020") returns -1
	//
	// Precondition: The argument to date has a length() of 10 with "/" at index 2
	// and 5, and only digits 0 through 9 in the other 8 indexes.
	//
	// Repeating: If the string argument is not a valid date, return -1!
	//
	public int dayNumber(String date) {
		if (validDate(date)) {
			int sum = 0;
			int month = Integer.parseInt(date.substring(0, 2));
			int day = Integer.parseInt(date.substring(3, 5));
			int year = Integer.parseInt(date.substring(6));
			for (int i = 1; i < month; i++) {
				sum += daysInMonth(i, year);
			}
			return sum + day;
		}
		return -1;
	}

	// Complete validDate to return true if the string argument is
	// a valid calendar date. The arguments always take the form of month,
	// day, and year as positive integers separated by / as in "mm/dd/yyyy".
	// If the String argument does not express a valid date, return false.
	//
	// You will need the static method Integer.parseInt(String possibleInt)
	// that returns the integer value of the string argument. For example,
	// Integer.parseInt("08") returns 8, Integer.parseInt("2021") returns 2021.
	//
	// validDate("01/31/2016") returns true
	// validDate("12/31/2017") returns true
	// validDate("06/15/2018") returns true
	// validDate("02/28/2019") returns true
	// validDate("02/29/2019") returns false
	// validDate("02/29/2100") returns false
	// validDate("13/02/2019") returns false
	// validDate("12/32/2019") returns false
	//
	// Precondition: date.length() == 10 with "/" at indexes 2 and 5,
	// and only digits 0 through 9 in the other 8 indexes.
	//
	public boolean validDate(String date) {
		int month = Integer.parseInt(date.substring(0, 2));
		int day = Integer.parseInt(date.substring(3, 5));
		int year = Integer.parseInt(date.substring(6));
		int[] longMonths = { 1, 3, 5, 7, 8, 10, 12 };
		if (month != 2 && month <= 12) {
			if (day == 31) {
				for (int longMonth : longMonths) {
					if (month == longMonth) {
						return true;
					}
				}
			}
			return (day <= 30);
		} else if (month == 2) {
			return (day <= 28) || (isLeapYear(year) && day == 29);
		}
		return false;
	}

	public boolean isLeapYear(int year) {
		return !(year % 100 == 0) && (year % 4 == 0) || year % 400 == 0;
	}

} // End class SelectionFun