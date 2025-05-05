/**
 * This collection class maintains a set of values in their natural order as
 * defined by compareTo. The only type that can be stored in this collection
 * must implement interface Comparable<T>
 *
 * Several methods (at the beginning) are given, another 11 methods must be
 * implemented. The JUnit test completely tests everything. Run code coverage at
 * the end to ensure 100% coverage and all assertions pass in 42 unit tests.
 *
 * To see a summary of TODOs, enter the following in Eclipse:
 *
 * ... Window > Show View > Tasks
 *
 * @author Rick Mercer and Sebastian Arana
 *
 * @param <Type> The type argument when constructed can be any type that
 *               implements Comparable.
 */
public class OrderedSet<Type extends Comparable<Type>> {
	// A private class that stores one node in a Binary Search Tree
	private class TreeNode {
		private TreeNode right;
		private Type data;
		private TreeNode left;

		public TreeNode(Type element) {
			left = null;
			data = element;
			right = null;
		}
	} // end class TreeNode

	private TreeNode root;
	private int size;

	// Create an empty OrderedSet
	public OrderedSet() {
		root = null;
		size = 0;
	}

	// Given: Insert element into this OrderedSet and return true keeping this an
	// OrderedSet. If element exists, do not change this OrderedSet and return
	// false. A set must have unique elements. Insert element into the correct
	// location to maintain a BinarySearchTree. This algorithm runs O(log n).
	//
	public boolean insert(Type element) {
		if (this.contains(element))
			return false;
		else {
			root = add(root, element);
			size++;
			return true;
		}
	}

	// Given: A private helper method for insert. Runs O(log)
	private TreeNode add(TreeNode t, Type el) {
		if (t == null)
			t = new TreeNode(el);
		else if (el.compareTo(t.data) < 0)
			t.left = add(t.left, el);
		else if (el.compareTo(t.data) > 0)
			t.right = add(t.right, el);
		return t;
	}

	/*- This different comment beginning keeps leading spaces in comments
	  Given: Return one string that concatenates all elements in this
	 OrderedSet as they are visited in order. Elements are are separated
	 by spaces as in "1 4 9". No space is at the end thanks to trim().
	    4
	   / \
	  1   9
	   
	 */
	@Override
	public String toString() {
		return getAll(root).trim(); // No leading or trailing whitespace
	}

	private String getAll(TreeNode t) {
		if (t == null)
			return "";
		else
			return getAll(t.left) + (t.data + " ") + getAll(t.right);
	}

	// 1) The number of elements in this OrderedSet, which should be 0 when
	// first constructed. This may run O(n) or O(1)--your choice.
	public int size() {
		return size;
	}

	//////////////////////////////////////////////////////////////////////////
	// 2) Return true if search equals an element in this OrderedSet.
	// If search is not found, return false.
	//
	public boolean contains(Type search) {
		return contains(root, search);
	}

	public boolean contains(TreeNode t, Type search) {
		if (t == null)
			return false;
		else if (t.data.compareTo(search) == 0)
			return true;
		else if (search.compareTo(t.data) < 0)
			return contains(t.left, search);
		else if (search.compareTo(t.data) > 0)
			return contains(t.right, search);
		return false;
	}

	//////////////////////////////////////////////////////////////////////////
	// 3) Return the element in this OrderedSet that is greater than all other
	// elements If this BST is empty, return null.
	//
	public Type max() {
		return max(root);
	}

	private Type max(TreeNode t) {
		if (t == null)
			return null;
		if (t.right == null)
			return t.data;
		return max(t.right);
	}

	//////////////////////////////////////////////////////////////////////////
	// 4) Return the element in this OrderedSet that is less than all other
	// elements. If this BST is empty, return null.
	//
	public Type min() {
		return min(root);
	}

	private Type min(TreeNode t) {
		if (t == null)
			return null;
		if (t.left == null)
			return t.data;
		return min(t.left);
	}

	//////////////////////////////////////////////////////////////////////////
	/*-   
	 *
	5) Return how many nodes are at the given level. If level > the height of the
	tree, return 0. Remember that an empty tree has a height of -1 (page 252).
	     4      There is 1 node on level 0
	   / \
	 3    7    There are 2 nodes on level 1
	/ \    \
	  1   5    9  There are 3 nodes in level 2.
	 
	There are 0 nodes at any levels >= 3
	*
	*/
	public int nodesAtLevel(int level) {
		return nodesAtLevel(level, root);
	}

	private int nodesAtLevel(int level, TreeNode t) {
		if (t == null)
			return 0;
		else if (level == 0)
			return 1 + nodesAtLevel(level - 1, t.left) + nodesAtLevel(level - 1, t.right);
		return nodesAtLevel(level - 1, t.left) + nodesAtLevel(level - 1, t.right);
	}

	//////////////////////////////////////////////////////////////////////////
	// 6) Return the height of the tree.
	//
	public int height() {
		if (root == null)
			return -1;
		return height(root) - 1;
	}

	public int height(TreeNode t) {
		if (t == null) {
			return 0;
		} else {
			int leftHeight = 0, rightHeight = 0;
			if (t.left != null)
				leftHeight = height(t.left);
			if (t.right != null)
				rightHeight = height(t.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	//////////////////////////////////////////////////////////////////////////
	// 7) Return the intersection of this OrderedSet and the other OrderedSet
	// as a new OrderedSet. Do not modify this OrderedSet or the other
	// OrderedSet that is passed as an argument to this method. The intersection
	// of two sets is the set of elements that are in both sets. For example,
	// the intersection of {2, 4, 5, 6, 88} and {2, 5, 6, 9} is {2, 5, 6}.
	// One or both OrderedSets may be empty.
	//
	public OrderedSet<Type> intersection(OrderedSet<Type> other) {
		OrderedSet<Type> intersection = new OrderedSet<Type>();
		intersection(root, other, intersection);
		return intersection;
	}

	private void intersection(TreeNode t, OrderedSet<Type> other, OrderedSet<Type> intersection) {
		if (t == null)
			return;
		if (other.contains(t.data)) {
			intersection.insert(t.data);
		}
		intersection(t.left, other, intersection);
		intersection(t.right, other, intersection);
	}

	//////////////////////////////////////////////////////////////////////////
	// 8) Return the union of this OrderedSet and the other OrderedSet as
	// a new OrderedSet. Do not modify this OrderedSet or the other OrderedSet.
	// The union of two sets is the set all distinct elements in the collection.
	// The union of {2, 4, 6} and {2, 5, 9} is {2, 4, 5, 6, 9}
	//
	public OrderedSet<Type> union(OrderedSet<Type> other) {
		OrderedSet<Type> union = new OrderedSet<Type>();
		union(root, union);
		union(other.root, union);
		return union;
	}

	private void union(TreeNode t, OrderedSet<Type> union) {
		if (t == null)
			return;
		else {
			union.insert(t.data);
			union(t.left, union);
			union(t.right, union);
		}
	}

	//////////////////////////////////////////////////////////////////////////
	// 9) Return an OrderedSet that contains all elements that are greater
	// than or equal to the first parameter inclusive and strictly less than
	// the second parameter exclusive.
	//
	public OrderedSet<Type> subset(Type inclusive, Type exclusive) {
		OrderedSet<Type> subset = new OrderedSet<Type>();
		subset(root, inclusive, exclusive, subset);
		return subset;
	}

	private void subset(TreeNode t, Type min, Type max, OrderedSet<Type> subset) {
		if (t == null)
			return;
		if (t.data.compareTo(min) >= 0 && t.data.compareTo(max) < 0) {
			subset.insert(t.data);
		}
		subset(t.left, min, max, subset);
		subset(t.right, min, max, subset);
	}

	//////////////////////////////////////////////////////////////////////////
	// 10) Return the number of leaves in this OrderedSet.
	// Reminder: leaves are the nodes on the last level of the tree.
	//
	public int leaves() {
		return leaves(root);
	}

	private int leaves(TreeNode t) {
		if (t == null)
			return 0;
		if (t.left == null && t.right == null)
			return 1;
		return leaves(t.left) + leaves(t.right);
	}

	//////////////////////////////////////////////////////////////////////////
	// 11) If element equals an element in this OrderedSet, remove it and
	// return true. Return false whenever an element is not found. In all cases,
	// this OrderedSet must retain its ordering property. Use the recommended
	// algorithm that was presented during a recent lecture.
	//
	// Warning: This is a challenging problem, especially when the node to
	// remove has two children.
	//
	public boolean remove(Type element) {
		TreeNode prev = new TreeNode(null);
		prev.right = root;
		return remove(root, prev, element);
	}

	public boolean remove(TreeNode t, TreeNode prev, Type element) {
		if (t == null) {
			System.out.println("not found");
			return false;
		} else {
			if (t.data.compareTo(element) > 0) {
				remove(t.left, t, element);
			} else if (t.data.compareTo(element) < 0) {
				remove(t.right, t, element);
			} else if (t.data == element) {
				if (t == root && t.left == null) {
					root = root.right;
					size--;
					return true;
				} else if (t.left == null) {
					if (t == prev.left) {
						prev.left = t.right;
						size--;
						return true;
					} else {
						prev.right = t.right;
						size--;
						return true;
					}
				} else {
					Type newData = max(t.left);
					t.data = newData;
					remove(t.left, t, newData);
				}
				return true;
			}
			return true;
		}

	}
}
