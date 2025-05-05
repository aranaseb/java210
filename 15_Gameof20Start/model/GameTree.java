package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// A model for the Game of 20 Questions. This type can be used to build the
// required console based game and optionally play a given GUI based game.
//
// @author Rick Mercer and Sebastian Arana
//
public class GameTree {

	private class TreeNode {
		private String data;
		private TreeNode left;
		private TreeNode right;

		public TreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}

		public TreeNode(String elementReference, TreeNode leftLink, TreeNode rightLink) {
			data = elementReference;
			left = leftLink;
			right = rightLink;
		}
	}

	private String currentFileName;
	private TreeNode root;
	private Scanner inFile = null;
	private TreeNode current;

	// Constructor needed to create the game. It should open the input file and
	// call the recursive method build(). The String parameter name is the name
	// of the file from which we need to read the game questions and answers from.
	public GameTree(String fileName) {
		currentFileName = fileName;
		try {
			inFile = new Scanner(new File(currentFileName));
		} catch (FileNotFoundException e) {
		}
		root = build();
		inFile.close();
		current = root;
	}

	// Build a GameTree in preOrder fashion and return the root of the tree
	private TreeNode build() {
		if (!inFile.hasNext())
			return null;

		String token = inFile.nextLine().trim();

		if (!endsWith(token, '?'))
			return new TreeNode(token);
		else {
			TreeNode leftSubtree = build();
			TreeNode rightSubtree = build();
			return new TreeNode(token, leftSubtree, rightSubtree);
		}
	}

	private boolean endsWith(String token, char character) {
		return token.charAt(token.length() - 1) == character;
	}

	/*- Return a string to print out a text version of the game file sideways like this:
	 
	 - - rattle snake
	 Feathers?
	 - - duck
	 
	*/
	public String toString() {
		// Precondition: newQuestion.endsWith("?")
		return toStringHelper(root, 0);
	}

	private String toStringHelper(TreeNode node, int level) {
		if (node == null) {
			return "";
		}
		String outStr = "";
		outStr += toStringHelper(node.right, level + 1);
		for (int i = 0; i < level; i++) {
			outStr += "- ";
		}
		outStr += node.data + "\n";
		outStr += toStringHelper(node.left, level + 1);
		return outStr;
	}

	/*-
	 Add a new question and answer at the currentNode. If currentNode
	 is referencing the answer "parrot", theGame.add("Does it swim?", "duck");
	 should change the GameTree on the left to the GameTree on the right:
	
	             Feathers?                Feathers?
	             /      \                /        \
	currentNode--> parrot   horse      Does it swim?  horse
	                                 /     \
	                              duck    parrot
	
	 @param newQuestion: The question to add where the old answer was.
	 @param newAnswer: The new yes answer to the new question.
	*/
	// Precondition: newQuestion.endsWith("?")
	public void add(String newQuestion, String newAnswer) {
		String oldAnswer = getCurrent();
		current.data = newQuestion.trim();
		current.left = new TreeNode(newAnswer.trim());
		current.right = new TreeNode(oldAnswer);
	}

	// Return true if getCurrent() references an answer rather than a question.
	// Return false if the current node is a question rather than a leaf.
	public boolean foundAnswer() {
		return current.left == null;
	}

	// Return the data for the current node that could be a question or an answer.
	public String getCurrent() {
		return current.data;
	}

	// Ask the game to update the current node in the tree by going left for
	// Choice.YES or right for Choice.NO
	//
	// Example code: theGame.playerSelected(Choice.YES);
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo == Choice.YES) {
			current = current.left;
		} else {
			current = current.right;
		}
	}

	// Begin a game at the root of the tree. Simply done by letting getCurrent()
	// return the question at the root of this GameTree.
	public void reStart() {
		current = root;
	}
}