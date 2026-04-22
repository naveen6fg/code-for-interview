package com.interview.arrays;

public class LeftCyclicRoatationalArrayBruteForce {

	public static void main(String[] args) {

		int[] arr = { 5,7,1, 2, 3, 4, 5, 6 };

		int leftShift = 3;

		int temp[] = new int[leftShift];

		int j = 0;
		for (int i = arr.length-leftShift; i < arr.length; i++) {

			temp[j] = arr[i];
			j++;
		}

		int end = arr.length - 1;
		
		for (int i = arr.length-leftShift - 1; i >= 0; i--) {

			arr[end] = arr[i];
			end--;

		}
		for (int i = 0; i < temp.length; i++) {

			arr[i] = temp[i];
		}

		for (int i : arr) {
			System.err.println(i);
		}
	}

}
