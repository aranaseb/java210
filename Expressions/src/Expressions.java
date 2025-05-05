import java.util.Stack;

/**
 * This class contains two method stubs:
 * 
 * int valueOf(String post) returns the value of a valid postfix expression.
 * 
 * String inToPost(String infix) converts a valid infix expression into to its
 * postfix equivalent as a string.
 * 
 * @author Rick Mercer and Sebastian Arana
 * 
 */

public class Expressions {

	// Return the value of a valid postfix expression. If post is not valid,
	// there could be an EmptyStackException thrown. We have assertions for this.
	//
	// valueOf("2 2 +") returns 4
	// valueOf("15 4 % 5 %") returns 3
	//
	// Precondition: All tokens are separated by whitespace and each token is
	// either a valid integer or one of the five arithmetic operands: + - * / or %.
	// post must be a valid postfix expression.
	//
	public int valueOf(String post) {
		Stack<Integer> s = new Stack<Integer>();
		String[] values = post.split(" ");
		for (String value : values) {
			if (!isOperand(value)) {
				int right = s.pop();
				int left = s.pop();
				switch (value) {
				case "+":
					s.push(left + right);
					break;
				case "-":
					s.push(left - right);
					break;
				case "*":
					s.push(left * right);
					break;
				case "/":
					s.push(left / right);
					break;
				case "%":
					s.push(left % right);
					break;
				}
			} else {
				s.push(Integer.parseInt(value));
			}
		}
		return s.pop();
	}

	// From prefix expression tree assignment, now includes "(", ")"
	private boolean isOperand(String token) {
		for (String operand : new String[] { "+", "-", "*", "/", "%", "(", ")" }) {
			if (token.contains(operand) && token.length() == 1) {
				return false;
			}
		}
		return "+ -".indexOf(token) == -1;
	}

	// Given a valid infix expression, return the equivalent postfix expression
	//
	// e.inToPost("2 * 3")) returns "3 2 *"
	//
	// Precondition: infix has at least one space between each token. This means
	// you do not have to tokenize infix expressions into integers, parenthesis, and
	// operators. However, infix may not be a valid infix expression like "3 + 4 -"
	// or "(3 + 4 * (9 - 2)", both of which should be an error.
	//
	// Yes, you may use private helper methods
	//
	public String inToPost(String infix) {
		Stack<String> s = new Stack<String>();
		String[] values = infix.trim().split(" ");
		String postfix = "";
		for (String value : values) {
			if (isOperand(value)) {
				postfix += value + " ";
			} else if (value.equals("(")) {
				s.push(value);
			} else if (value.equals(")")) {
				while (!s.peek().equals("(")) {
					postfix += s.pop() + " ";
				}
				s.pop();
			} else {
				while (!s.isEmpty()) {
					if (!s.peek().equals("(") && !lowerPrecedence(s.peek(), value)) {
						postfix += s.pop() + " ";
					} else {
						break;
					}
				}
				s.push(value);
			}
		}
		while (!s.isEmpty()) {
			postfix += s.pop() + " ";
		}
		return postfix.trim();
	}

	// returns true if op1 is higher in PEMDAS than op2
	private boolean lowerPrecedence(String op1, String op2) {
		if (op1.equals("+") || op1.equals("-")) {
			return op2.equals("*") || op2.equals("/") || op2.equals("%");
		}
		return false;
	}

}