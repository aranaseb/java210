package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** 
 * A JUnit test for ArrayPriorityList.
 * 
 *@author Rick Mercer and Sebastian Arana
*/

import model.ArrayPriorityList;
import model.PriorityList;

public class ArrayPriorityListTest {

	@Test
	public void testGenericity() {
		ArrayPriorityList<String> stringList = new ArrayPriorityList<String>();
		assertEquals(true, stringList.isEmpty());
		stringList.insertElementAt(0, "A");
		stringList.insertElementAt(1, "B");
		stringList.insertElementAt(2, "C");
		assertEquals(false, stringList.isEmpty());

		ArrayPriorityList<Integer> intList = new ArrayPriorityList<Integer>();
		intList.insertElementAt(0, 1);
		intList.insertElementAt(0, 2);
		intList.insertElementAt(0, 3);

		ArrayPriorityList<Double> doubleList = new ArrayPriorityList<Double>();
		doubleList.insertElementAt(0, 1.1);
		doubleList.insertElementAt(0, 2.2);
		doubleList.insertElementAt(0, 3.3);
	}

	@Test
	public void testInsertElementAt() {
		ArrayPriorityList<String> stringList = new ArrayPriorityList<String>();
		stringList.insertElementAt(0, "A");
		stringList.insertElementAt(1, "C");
		stringList.insertElementAt(2, "D");
		stringList.insertElementAt(1, "B");
		assertEquals(4, stringList.size());
		assertEquals("B", stringList.getElementAt(1));
		assertEquals("C", stringList.getElementAt(2));
		assertEquals("D", stringList.getElementAt(3));

		ArrayPriorityList<Integer> intList = new ArrayPriorityList<Integer>();
		intList.insertElementAt(0, 2);
		intList.insertElementAt(1, 3);
		intList.insertElementAt(2, 4);
		intList.insertElementAt(0, 1);
		assertEquals(1, intList.getElementAt(0));
		assertEquals(2, intList.getElementAt(1));
		assertEquals(3, intList.getElementAt(2));
		assertEquals(4, intList.getElementAt(3));
	}

	@Test
	public void testRemoveElementAt() {
		ArrayPriorityList<Integer> intList = new ArrayPriorityList<Integer>();
		intList.insertElementAt(0, 1);
		intList.insertElementAt(1, 2);
		intList.insertElementAt(2, 3);
		assertEquals(3, intList.size());
		intList.removeElementAt(1);
		assertEquals(2, intList.size());
		assertEquals(3, intList.getElementAt(1));

		ArrayPriorityList<Double> doubleList = new ArrayPriorityList<Double>();
		doubleList.insertElementAt(0, 1.1);
		doubleList.insertElementAt(1, 2.2);
		doubleList.insertElementAt(2, 3.3);
		assertEquals(3, doubleList.size());
		doubleList.removeElementAt(2);
		assertEquals(2, doubleList.size());
		assertEquals(2.2, doubleList.getElementAt(1));
		assertEquals(1.1, doubleList.getElementAt(0));
	}

	@Test
	public void testRaiseOrLowerPriority() {
		ArrayPriorityList<String> stringList = new ArrayPriorityList<String>();
		stringList.insertElementAt(0, "A");
		stringList.insertElementAt(1, "C");
		stringList.insertElementAt(2, "B");
		stringList.raisePriorityOf(2);
		assertEquals("B", stringList.getElementAt(1));
		assertEquals("C", stringList.getElementAt(2));
		stringList.raisePriorityOf(0);
		assertEquals("A", stringList.getElementAt(0));

		ArrayPriorityList<Integer> intList = new ArrayPriorityList<Integer>();
		intList.insertElementAt(0, 2);
		intList.insertElementAt(1, 1);
		intList.insertElementAt(2, 3);
		intList.lowerPriorityOf(0);
		assertEquals(1, intList.getElementAt(0));
		assertEquals(2, intList.getElementAt(1));
		intList.lowerPriorityOf(2);
		assertEquals(3, intList.getElementAt(2));
	}

	@Test
	public void testMoveToLastOrTop() {
		ArrayPriorityList<String> stringList = new ArrayPriorityList<String>();
		stringList.insertElementAt(0, "B");
		stringList.insertElementAt(1, "C");
		stringList.insertElementAt(2, "D");
		stringList.insertElementAt(3, "A");
		stringList.moveToTop(3);
		stringList.moveToTop(0);
		assertEquals("A", stringList.getElementAt(0));
		assertEquals("B", stringList.getElementAt(1));
		assertEquals("C", stringList.getElementAt(2));
		assertEquals("D", stringList.getElementAt(3));

		ArrayPriorityList<Integer> intList = new ArrayPriorityList<Integer>();
		intList.insertElementAt(0, 1);
		intList.insertElementAt(1, 4);
		intList.insertElementAt(2, 2);
		intList.insertElementAt(3, 3);
		intList.moveToLast(1);
		stringList.moveToLast(3);
		assertEquals(1, intList.getElementAt(0));
		assertEquals(2, intList.getElementAt(1));
		assertEquals(3, intList.getElementAt(2));
		assertEquals(4, intList.getElementAt(3));
	}

	// This is provided to test toArray that has proven difficult to understand
	@Test
	public void testToArrayReturnsACloneOfTheInstanceVariable() {
		PriorityList<Integer> list = new ArrayPriorityList<Integer>();

		list.insertElementAt(0, 77);
		list.insertElementAt(1, 88);
		list.insertElementAt(2, 99);

		Object[] result = list.toArray();
		// Make sure the new array built in toArray has capacity == n
		assertEquals(3, result.length);
		// Make sure the elements and indexes match in the Object[]
		assertEquals(77, result[0]);
		assertEquals(88, result[1]);
		assertEquals(99, result[2]);

		// Make sure you did simply not return a reference to data
		// because a change to result should NOT affect data
		result[0] = 12345678;
		result[1] = Integer.MAX_VALUE;
		result[2] = Integer.MIN_VALUE;
		// Cast need in the assertions
		assertEquals(77, (int) list.getElementAt(0));
		assertEquals(88, (int) list.getElementAt(1));
		assertEquals(99, (int) list.getElementAt(2));
	}

	// We'll discuss exceptions and -> lambdas in class (this is not in Rick's book)
	@Test
	public void testAddThrowsExpection() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "1st");
		assertThrows(IllegalArgumentException.class, () -> list.insertElementAt(2, "No"));
		assertThrows(IllegalArgumentException.class, () -> list.insertElementAt(-1, "No"));

		assertThrows(IllegalArgumentException.class, () -> list.getElementAt(1));
		assertThrows(IllegalArgumentException.class, () -> list.getElementAt(-1));

		assertThrows(IllegalArgumentException.class, () -> list.removeElementAt(1));
		assertThrows(IllegalArgumentException.class, () -> list.removeElementAt(-1));

		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(1));
		assertThrows(IllegalArgumentException.class, () -> list.raisePriorityOf(-1));

		assertThrows(IllegalArgumentException.class, () -> list.lowerPriorityOf(1));
		assertThrows(IllegalArgumentException.class, () -> list.lowerPriorityOf(-1));

		assertThrows(IllegalArgumentException.class, () -> list.moveToTop(1));
		assertThrows(IllegalArgumentException.class, () -> list.moveToTop(-1));

		assertThrows(IllegalArgumentException.class, () -> list.moveToLast(1));
		assertThrows(IllegalArgumentException.class, () -> list.moveToLast(-1));
	}

}