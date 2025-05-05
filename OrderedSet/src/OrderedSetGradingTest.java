
/*
* A JUnit test for public class OrderedSet<Type extends Comparable<Type>>
*
* @author Rick Mercer
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrderedSetGradingTest {
	@Test
	public void testInsertSize() {
		OrderedSet<String> aSet = new OrderedSet<String>();
		assertEquals(0, aSet.size());
		assertTrue(aSet.insert("Madison"));
		assertTrue(aSet.insert("Devon"));
		assertTrue(aSet.insert("Chris"));
		assertTrue(aSet.insert("Me"));
		assertTrue(aSet.insert("Ash"));
		assertTrue(aSet.insert("Robin"));
		assertTrue(aSet.insert("Jamie"));
		assertEquals(7, aSet.size());

		assertFalse(aSet.insert("Madison")); // Already contained
		assertFalse(aSet.insert("Me")); // Already contained
		assertEquals(7, aSet.size());
		// Sanity check: use toString which is given, not graded
		assertEquals("Ash Chris Devon Jamie Madison Me Robin", aSet.toString());
	}

	@Test
	public void testContainsWhenShouldReturnTrue() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("d");
		set.insert(new String("b"));
		set.insert("e");
		set.insert("f");
		set.insert(new String("a"));
		set.insert("c");
		assertTrue(set.contains("a"));
		assertTrue(set.contains("b"));
		assertTrue(set.contains("c"));
		assertTrue(set.contains("d"));
		assertTrue(set.contains("e"));
		assertTrue(set.contains("f"));
	}

	@Test
	public void testContainsWhenShouldReturnFalse() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("d");
		set.insert("b");
		set.insert("e");
		set.insert("f");
		set.insert("a");
		set.insert("c");
		assertFalse(set.contains("?"));
		assertFalse(set.contains("X"));
		assertFalse(set.contains("A"));
	}

	@Test
	public void testMaxWhenEmpty() {
		OrderedSet<Integer> intTree = new OrderedSet<Integer>();
		assertNull(intTree.max());
	}

	@Test
	public void testMaxWhenSizeIsOne() {
		OrderedSet<Integer> intTree = new OrderedSet<Integer>();
		intTree.insert(3);
		assertEquals(3, intTree.max());
	}

	@Test
	public void testMaxAgain() {
		OrderedSet<Integer> intTree = new OrderedSet<Integer>();
		assertNull(intTree.max());
		intTree.insert(7);
		assertEquals(7, intTree.max());
		intTree.insert(5);
		assertEquals(7, intTree.max());
		intTree.insert(8);
		intTree.insert(-1);
		assertEquals(8, intTree.max());
	}

	@Test
	public void testMin() {
		OrderedSet<Integer> intTree = new OrderedSet<Integer>();
		assertNull(intTree.min());
		intTree.insert(5);
		assertEquals(5, intTree.min());
		intTree.insert(8);
		assertEquals(5, intTree.min());
		intTree.insert(-1);
		intTree.insert(4);
		assertEquals(-1, intTree.min());
	}

	@Test
	public void testHeight() {
		OrderedSet<String> set = new OrderedSet<String>();
		assertEquals(-1, set.height());
		set.insert("one");
		assertEquals(0, set.height());
		set.insert("two");
		assertEquals(1, set.height());
		set.insert("three");
		assertEquals(2, set.height());
		set.insert("THREE");
		assertEquals(2, set.height());
		set.insert("four");
		assertEquals(2, set.height());
		set.insert("FOUR");
		assertEquals(2, set.height());
		set.insert("y");
		assertEquals(2, set.height());
		set.insert("x");
		assertEquals(3, set.height());
		set.insert("z");
		assertEquals(3, set.height());
	}

	@Test
	public void testNodesAtLevel() {
		OrderedSet<String> set = new OrderedSet<String>();
		assertEquals(0, set.nodesAtLevel(0));
		set.insert("one");
		assertEquals(0, set.nodesAtLevel(1));
		set.insert("two");
		assertEquals(1, set.nodesAtLevel(1));
		set.insert("three");
		assertEquals(1, set.nodesAtLevel(2));
		set.insert("THREE");
		assertEquals(1, set.nodesAtLevel(2));
		set.insert("four");
		assertEquals(0, set.nodesAtLevel(3));
		set.insert("FOUR");
		assertEquals(0, set.nodesAtLevel(3));
		set.insert("y");
		assertEquals(4, set.nodesAtLevel(2));
		set.insert("x");
		assertEquals(4, set.nodesAtLevel(2));
		set.insert("z");
		assertEquals(2, set.nodesAtLevel(3));

		assertEquals(0, set.nodesAtLevel(4)); // No nodes on level 4
	}

	@Test
	public void testLeaves() {
		OrderedSet<String> set = new OrderedSet<String>();
		assertEquals(0, set.leaves());
		set.insert("m");
		assertEquals(1, set.leaves());
		set.insert("g");
		assertEquals(1, set.leaves());
		set.insert("r");
		assertEquals(2, set.leaves());
		set.insert("c");
		set.insert("j");
		assertEquals(3, set.leaves());
		set.insert("p");
		set.insert("x");
		assertEquals(4, set.leaves());
	}

	@Test
	public void testIntersectionWhenBothAreEmpty() {
		OrderedSet<String> set = new OrderedSet<String>();
		OrderedSet<String> set2 = new OrderedSet<String>();
		OrderedSet<String> result = set.intersection(set2);
		assertEquals(0, result.size());
	}

	@Test
	public void testIntersectionWhenOneIsEmpty() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("M");
		set.insert("N");
		set.insert("O");
		set.insert("P");
		set.insert("A");
		OrderedSet<String> set2 = new OrderedSet<String>();
		OrderedSet<String> result = set.intersection(set2);
		assertEquals(0, result.size());
	}

	@Test
	public void testIntersectionWhenBothHaveNoneTheSameElements() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("M");
		set.insert("N");
		set.insert("O");
		set.insert("P");
		set.insert("A");
		OrderedSet<String> set2 = new OrderedSet<String>();
		set2.insert("Qq");
		set2.insert("Nw");
		set2.insert("Pe");
		set2.insert("Ar");
		set2.insert("Rt");
		OrderedSet<String> result = set.intersection(set2);
		assertEquals(0, result.size());
	}

	@Test
	public void testIntersectionWhenBothHaveThreeOfTheSameElements() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("M");
		set.insert("N");
		set.insert("O");
		set.insert("P");
		set.insert("A");
		OrderedSet<String> set2 = new OrderedSet<String>();
		set2.insert("Q");
		set2.insert("N");
		set2.insert("P");
		set2.insert("A");
		set2.insert("R");
		OrderedSet<String> result = set.intersection(set2);
		assertEquals(3, result.size());
		assertTrue(set.contains("N"));
		assertTrue(set.contains("P"));
		assertTrue(set.contains("A"));
	}

	@Test
	public void testIntersectionWhenBothHaveTheSameElements() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("M");
		set.insert("N");
		set.insert("O");
		set.insert("P");
		set.insert("A");
		OrderedSet<String> set2 = new OrderedSet<String>();
		set2.insert("M");
		set2.insert("N");
		set2.insert("P");
		set2.insert("A");
		set2.insert("O");
		OrderedSet<String> result = set.intersection(set2);
		assertEquals(5, result.size());
		assertTrue(set.contains("M"));
		assertTrue(set.contains("N"));
		assertTrue(set.contains("P"));
		assertTrue(set.contains("A"));
		assertTrue(set.contains("O"));
	}

	@Test
	public void testUnionWhenBothAreEmpty() {
		OrderedSet<Integer> a = new OrderedSet<Integer>();
		OrderedSet<Integer> b = new OrderedSet<Integer>();
		OrderedSet<Integer> c = a.union(b);
		assertEquals(0, c.size());
	}

	@Test
	public void testUnion() {
		// The union of {2, 4, 6} and {2, 5, 9} is {2, 4, 5, 6, 9}
		OrderedSet<Integer> a = new OrderedSet<Integer>();
		a.insert(2);
		a.insert(4);
		a.insert(6);
		OrderedSet<Integer> b = new OrderedSet<Integer>();
		b.insert(2);
		b.insert(5);
		b.insert(9);
		OrderedSet<Integer> c = a.union(b);
		assertEquals(5, c.size());
		assertTrue(c.contains(2));
		assertTrue(c.contains(4));
		assertTrue(c.contains(5));
		assertTrue(c.contains(6));
		assertTrue(c.contains(9));
	}

	@Test
	public void testUnionWhenOneIsEmpty() {
		OrderedSet<Integer> a = new OrderedSet<Integer>();
		a.insert(2);
		a.insert(4);
		a.insert(6);
		OrderedSet<Integer> b = new OrderedSet<Integer>();
		OrderedSet<Integer> c = a.union(b);
		assertEquals(3, c.size());
		assertTrue(c.contains(2));
		assertTrue(c.contains(4));
		assertTrue(c.contains(6));
	}

	@Test
	public void testUnionWhenTheOtherIsEmpty() {
		OrderedSet<Integer> a = new OrderedSet<Integer>();
		OrderedSet<Integer> b = new OrderedSet<Integer>();
		b.insert(2);
		b.insert(5);
		b.insert(9);
		OrderedSet<Integer> c = a.union(b);
		assertEquals(3, c.size());
		assertTrue(c.contains(2));
		assertTrue(c.contains(5));
		assertTrue(c.contains(9));
	}

	@Test
	public void testUnionWhenBothSetsAreEqual() {
		OrderedSet<Integer> a = new OrderedSet<Integer>();
		a.insert(2);
		a.insert(5);
		a.insert(9);
		OrderedSet<Integer> b = new OrderedSet<Integer>();
		b.insert(2);
		b.insert(5);
		b.insert(9);
		OrderedSet<Integer> c = a.union(b);
		assertEquals(3, c.size());
		assertTrue(c.contains(2));
		assertTrue(c.contains(5));
		assertTrue(c.contains(9));
	}

	@Test
	public void testUnionWhenBothSetsAreUnique() {
		OrderedSet<Integer> a = new OrderedSet<Integer>();
		a.insert(2);
		a.insert(4);
		a.insert(6);
		OrderedSet<Integer> b = new OrderedSet<Integer>();
		b.insert(1);
		b.insert(3);
		b.insert(5);
		b.insert(7);
		b.insert(8);
		OrderedSet<Integer> c = a.union(b);
		assertEquals(8, c.size());
		assertTrue(c.contains(1));
		assertTrue(c.contains(2));
		assertTrue(c.contains(3));
		assertTrue(c.contains(4));
		assertTrue(c.contains(5));
		assertTrue(c.contains(6));
		assertTrue(c.contains(7));
		assertTrue(c.contains(8));
	}

	@Test
	public void testContainsAsTreeIsGrowing() {
		OrderedSet<String> aTree = new OrderedSet<String>();
		assertFalse(aTree.contains("M"));
		aTree.insert("M");
		assertTrue(aTree.contains("M"));
		assertFalse(aTree.contains("E"));
		aTree.insert("E");
		assertTrue(aTree.contains("E"));
		aTree.insert("A");
		aTree.insert("G");
		aTree.insert("H");
		aTree.insert("F");
		aTree.insert("D");
		aTree.insert("C");
		assertTrue(aTree.contains("A"));
		assertTrue(aTree.contains("G"));
		assertTrue(aTree.contains("F"));
		assertTrue(aTree.contains("H"));
		assertTrue(aTree.contains("D"));
		assertTrue(aTree.contains("C"));
	}

	@Test
	public void testSubSet() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(65);
		set.insert(90);
		assertEquals("25 50 65", set.subset(15, 75).toString());
	}

	@Test
	public void testSubSetWhenExclusiveIsInTheSet() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(65);
		set.insert(90);
		assertEquals("12 25 50 65 75 90", set.toString());
		assertEquals("25 50 65", set.subset(25, 75).toString());
	}

	@Test
	public void testSubSetWhenTheResultShouldBeAnEmptySet() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(65);
		set.insert(90);
		assertEquals("", set.subset(12, 12).toString()); // 12 not included
	}

	@Test
	public void testTestingRemoveWhenBSTIsEmpty() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertFalse(set.remove(50));
	}

	////////////////////// Test remove //////////////////////////
	@Test
	public void testRemoveWhenBSTIsEmpty() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertFalse(set.remove(50));
	}

	@Test
	public void testRemoveWhenElementIsNotInTreeWithFiveNodes() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(75);
		set.insert(7);
		set.insert(95);
		assertFalse(set.remove(51));
		assertFalse(set.remove(-1));
		assertFalse(set.remove(51));
		assertFalse(set.remove(97));
	}

	@Test
	public void testRemoveRightNodeWhenSizeIsTwo() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(75);
		set.remove(75);
		assertEquals("50", set.toString());
	}

	@Test
	public void testRemoveLeftNodeWhenTreeIsSizeIsTwo() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("B");
		set.insert("A");
		set.remove("A");
		assertEquals("B", set.toString());
	}

	@Test
	public void testRemoveRootWithOneRightNode() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(75);
		set.remove(50);
		assertEquals("75", set.toString());
	}

	@Test
	public void testRootWithNoChildren() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("M");
		assertEquals("M", set.toString());
		set.remove("M");
		assertEquals("", set.toString());
	}

	@Test
	public void testRootWithNoRightChild() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("M");
		set.insert("G");
		set.remove("M");
	}

	@Test
	public void testRemoveNoLeftChildAgain() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(75);
		set.insert(85);
		set.insert(90);
		assertEquals("50 75 85 90", set.toString());
		set.remove(85);
		assertEquals("50 75 90", set.toString());
	}

	@Test
	public void testRemoveWithLeftChildAgain() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(75);
		set.insert(85);
		set.insert(80);
		set.insert(90);
		assertEquals("25 50 75 80 85 90", set.toString());
		set.remove(85);
		assertEquals(5, set.size());
		assertEquals("25 50 75 80 90", set.toString());
	}

	@Test
	public void testRemoveNoRightChildFourthTry() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("C");
		set.insert("D");
		set.insert("B");
		set.insert("E");
		set.insert("A");
		assertEquals("A B C D E", set.toString());
		set.remove("A");
		assertEquals(4, set.size());
		assertEquals("B C D E", set.toString());
	}

	@Test
	public void testRemoveWhenRootChangesNoLeftChild() {
		OrderedSet<String> strings = new OrderedSet<String>();
		strings.insert("G");
		strings.insert("R");
		strings.insert("M");
		strings.insert("X");
		assertEquals("G M R X", strings.toString());
		strings.remove("G");
		assertEquals(3, strings.size());
		assertEquals("M R X", strings.toString());
	}

	@Test
	public void testRemoveFurtherDownNoLeftChild() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("R");
		set.insert("T");
		set.insert("S");
		set.insert("U");
		assertEquals("G R S T U", set.toString());
		assertTrue(set.remove("R"));
		assertEquals("G S T U", set.toString());
	}

	@Test
	public void testRemoveRootWithMoreToTheRight() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("R");
		set.insert("T");
		set.insert("S");
		set.insert("U");
		assertEquals("G R S T U", set.toString());
		assertTrue(set.remove("G"));
		assertEquals("R S T U", set.toString());
	}

	@Test
	public void testRemoveRootWithLeftTree() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("A");
		set.insert("D");
		set.insert("C");
		assertEquals("A C D G", set.toString());
		assertTrue(set.remove("G"));
		assertEquals("A C D", set.toString());
	}

	@Test
	public void testRemoveRootWithleftTreeAgain() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("J");
		set.insert("X");
		set.insert("A");
		set.insert("F");
		set.insert("E");
		assertTrue(set.remove("G"));
		assertEquals("A E F J X", set.toString());
	}

	@Test
	public void testRemoveRootWithleftTree() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("J");
		set.insert("A");
		assertEquals("A G J", set.toString());
		assertTrue(set.remove("G"));
		assertEquals("A J", set.toString());
	}

	@Test
	public void testRemoveRootWithLeftTreeAndRightTree() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("J");
		set.insert("D");
		set.insert("B");
		set.insert("C");
		assertEquals("B C D G J", set.toString());
		assertTrue(set.remove("G"));
		assertEquals("B C D J", set.toString());
	}

	@Test
	public void testRemoveWithLeftTree() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("R");
		set.insert("K");
		set.insert("J");
		set.insert("M");
		set.insert("L");
		set.insert("N");
		set.insert("T");
		set.insert("S");
		set.insert("W");
		assertTrue(set.remove("R"));
		assertEquals("G J K L M N S T W", set.toString());
	}

	@Test
	public void testRemoveNodeWithLeftTreeAgain() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("B");
		set.insert("R");
		set.insert("K");
		set.insert("J");
		set.insert("M");
		set.insert("L");
		set.insert("N");
		set.insert("T");
		set.insert("S");
		set.insert("W");
		assertTrue(set.remove("M"));
		assertEquals("B G J K L N R S T W", set.toString());
	}

	@Test
	public void testRemoveNodeWithLeftTree_18() {
		OrderedSet<String> set = new OrderedSet<String>();
		set.insert("G");
		set.insert("B");
		set.insert("R");
		set.insert("K");
		set.insert("J");
		set.insert("M");
		set.insert("L");
		set.insert("N");
		set.insert("T");
		set.insert("S");
		set.insert("W");
		assertTrue(set.remove("K"));
		assertEquals("B G J L M N R S T W", set.toString());
	}

}
