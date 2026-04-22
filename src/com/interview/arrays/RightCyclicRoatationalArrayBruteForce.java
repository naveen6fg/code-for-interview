package com.interview.arrays;

public class RightCyclicRoatationalArrayBruteForce {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3,4,6,3, 4, 5, 6 };

		int rightShift = 4;
		
		rightShift = (rightShift>arr.length)?rightShift%arr.length:rightShift;

		int temp[] = new int[rightShift];

		for (int i = 0; i < rightShift; i++) { // Copying first 'shift' elements to temp array: O(shift)

			temp[i] = arr[i];
		}

		int j = 0;

		for (int i = rightShift; i < arr.length; i++) { // Shifting elements in the original array: O(n - shift), where n
														// is the length of arr
			arr[j] = arr[i];
			j++;
		}

		for (int i = 0; i < temp.length; i++) { // Copying elements from temp back to the original array: O(shift)
			arr[j] = temp[i];
			j++;
		}

		for (int i : arr) {
			System.err.println(i);
		}

	}

}
