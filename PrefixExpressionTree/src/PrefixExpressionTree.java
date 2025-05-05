
/*-
 * Contributers: Rick Mercer and Sebastian Arana
 * 
 * This type is a start to our PrefixExpression tree. Currently only
 * plus "+" and minus "-" operators work, the other three Java operators 
 * do not. So make this type works for all five of Java's integer operators.

 * Note: At first you will have compile time errors in the JUnit 
 * assertions because two methods must be added to this class. 
 * Additionally, no @Test will pass if it has / * or % as an operator
 * in the prefix expression. You must implement that functionality below.
 * 
 * Prefix expressions require that all operators precede the two operands
 * that they work on. If you do not understand prefix expressions after
 * looking at this class and the JUnit test, Google prefix expressions.
 * Here are some prefix expressions (there are many more in the JUnit test).
 * 
 *  "- 4 6" evaluates to -2
 *  "% 57 900" evaluates to 57
 *  "+ - + 7 3 8 9" evaluates to 11
 *  "+ - 7 3 * 8 9" evaluates to 76
 *  
 * For the last example above, 9 is the rightmost int, 7 is the leftmost.

    9
  *
    8
+
    3
  -
    7    
      
 * Also add the following two methods so all Assertions pass.
 * You will need to trim the return results to remove whitespace.
 * 
 *   public String inOrder()
 * 
 *   public String postOrder()
 * 
 */
import java.util.Scanner;

class PrefixExpressionTree {

	private class TreeNode {
		private String data;
		private TreeNode left;
		private TreeNode right;

		// Constructor 1
		public TreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}

		// Constructor 2
		public TreeNode(String elementReference, TreeNode leftLink, TreeNode rightLink) {
			data = elementReference;
			left = leftLink;
			right = rightLink;
		}
	}

	// Instance variables
	private TreeNode root;
	private Scanner scanner;

	// Accept a prefix expression to build an ExpressionTree.
	//
	// Precondition: Infix is a valid infix expression where the
	// Scanner only has one or more of the five Java operators or valid
	// integer constants like -2 123 0 or 999 separated by whitespace.
	//
	public PrefixExpressionTree(String infix) {
		infix = infix.trim(); // Remove leading and trailing white space.
		if (infix.length() == 0)
			root = null;
		else {
			scanner = new Scanner(infix);
			root = build();
		}
	}

	// A private helper method to build a PrefixExpressionTree
	private TreeNode build() {
		if (!scanner.hasNext())
			return null;

		String token = scanner.next(); // Get the next operand or operator.

		if (isOperand(token)) // Found an operand like 3 or -99, the base case.
			return new TreeNode(token);
		else { // Use recursive backtracking to build the binary tree
			TreeNode leftSubtree = build();
			TreeNode rightSubtree = build();
			return new TreeNode(token, leftSubtree, rightSubtree);
		}
	}

	// Return true only if token is a valid integer.
	private boolean isOperand(String token) {
		for (String operand : new String[] { "+", "-", "*", "/", "%" }) {
			if (token.contains(operand)) {
				return false;
			}
		}
		return "+ -".indexOf(token) == -1; // Can not find an operand in token.
	}

	// Return the value of an ExpressionTree where all five Java
	// operators work correctly for valid integer operands.
	//
	// All internal TreeNodes must be operators with valid integers as leafs.
	//
	public int valueOf() {
		return valueOf(root);
	}

	// A private helper method to evaluate the expression
	private int valueOf(TreeNode t) {
		if (t == null)
			return 0; // Must have reached an empty BinaryTree (null)
		else if (t.left == null && t.right == null) // must be an operand
			return Integer.parseInt(t.data);
		else if (t.data.equals("+"))
			return valueOf(t.left) + valueOf(t.right);
		else if (t.data.equals("-"))
			return valueOf(t.left) - valueOf(t.right);
		else if (t.data.equals("*"))
			return valueOf(t.left) * valueOf(t.right);
		else if (t.data.equals("/"))
			return valueOf(t.left) / valueOf(t.right);
		else if (t.data.equals("%"))
			return valueOf(t.left) % valueOf(t.right);
		else
			return Integer.MIN_VALUE;
	}

	public String preOrder() {
		return preOrder(root).trim();
	}

	private String preOrder(TreeNode t) {
		if (t == null)
			return "";
		else
			return t.data + " " + preOrder(t.left) + preOrder(t.right);
	}

	// Returns a String that is a "sideways" version of this binary tree
	public String sidewaysOrder() {
		return toStringHelper(root, 0);
	}

	private String toStringHelper(TreeNode node, int level) {
		if (node == null) {
			return "";
		}
		String outStr = "";
		outStr += toStringHelper(node.right, level + 1);
		for (int i = 0; i < level; i++) {
			outStr += "  "; // Add spaces to push nodes to the right
		}
		outStr += node.data + "\n"; // Add an operand or operator
		outStr += toStringHelper(node.left, level + 1);
		return outStr;
	}

	public String inOrder() {
		return inOrder(root).trim();
	}

	private String inOrder(TreeNode t) {
		if (t == null)
			return "";
		else
			return inOrder(t.left) + t.data + " " + inOrder(t.right);
	}

	public String postOrder() {
		return postOrder(root).trim();
	}

	private String postOrder(TreeNode t) {
		if (t == null)
			return "";
		else
			return postOrder(t.left) + postOrder(t.right) + t.data + " ";
	}

} // End class PrefixExpressionTree;