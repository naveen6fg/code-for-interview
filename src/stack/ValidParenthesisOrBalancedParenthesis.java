package stack;

import java.util.Stack;

public class ValidParenthesisOrBalancedParenthesis {

	public static void main(String[] args) {

		String s1 = "{}[]()";
		String s2 = "[({})]";

		boolean check = isValid_OR_isBalance(s1);
		System.err.println(check);
	}

	private static boolean isValid_OR_isBalance(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (char ch : s.toCharArray()) { //The pop() method is used to remove and return the top element of the stack.

			if (ch == '[') {
				stack.push(']');
			} else if (ch == '(') {
				stack.push(')');
			} else if (ch == '{') {
				stack.push('}');              //   }  != } 
			} else if (stack.isEmpty() || stack.pop() != ch) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
