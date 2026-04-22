package stack;

import java.util.Stack;

public class BalancedParetnthesis {

	public static void main(String[] args) {

		String str = "{}[]()";
		System.err.println(checkBalance(str));
	}

	public static String checkBalance(String str) {
		Stack<Character> stack = new Stack();

		for (char ch : str.toCharArray()) {

			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
					return "no";
				}
			}
		}
		return stack.isEmpty()?"yes":"no";
	}

	private static boolean isMatch(char open, char close) {

		return (open == '{' && close == '}') || (open == '(' && close == ')') || (open == '[' && close == ']');
	}
}
