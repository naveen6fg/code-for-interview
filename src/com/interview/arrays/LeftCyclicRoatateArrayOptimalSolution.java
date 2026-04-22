package com.interview.arrays;

public class LeftCyclicRoatateArrayOptimalSolution {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 5, 6, 8, 12, 44, 67 };
		int k = 2;
		k = k % arr.length;

		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
		int rotatedArray[] = reverse(arr, 0, arr.length - 1);

		for (int i : rotatedArray) {
			System.err.println(i);
		}
	}

	public static int[] reverse(int[] arr, int start, int end) {

		while (start <= end) {
			int temp = 0;
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}
}
