package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseArrayUsingStack {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack();

		int[] arr = { 2, 1, 8, 2, 6, 5 };
		Integer[] arr2 = { 2, 1, 8, 2, 6, 5 };

		for (int i : arr) {

			stack.push(i);
		}
		System.err.println(stack);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();

		}
		for (int i : arr) {
			System.err.println(i);
		}
	
		
		
	}
}
