package sliding.window;

public class MaximumSumOfGivenSizeSubArray {

	public static void main(String[] args) {

		int[] arr = { 2, 7, 4, 9, 1, 2, 6, 9, 4, 1 };

		int size = 3;
		int maxSum = 0;

		for (int i = 0; i < size; i++) {
			maxSum += arr[i];
		}

		int currMax = maxSum;

		for (int i = size; i < arr.length; i++) {

			currMax =currMax + arr[i] - arr[i - size];
			maxSum = Math.max(maxSum, currMax);

		}
		System.err.println(maxSum);
	}

}
