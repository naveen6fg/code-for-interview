package com.interview.arrays;

public class RightCyclicRoatateArrayOptimalSolution {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;

		k = k % arr.length;

		reverse(arr, 0, arr.length - k - 1);
		reverse(arr, arr.length - k, arr.length - 1);
		int rotatedArray[] = reverse(arr, 0, arr.length - 1);

		for (int i : rotatedArray) {
			System.err.println(i);
		}
	}

	public static int[] reverse(int[] arr, int start, int end) {

		while ((start <= end)) {

			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}
}
