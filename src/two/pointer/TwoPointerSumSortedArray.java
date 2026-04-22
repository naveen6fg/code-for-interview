package two.pointer;

public class TwoPointerSumSortedArray {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 9;
		int[] elements = elementsArray(arr, target);

		for (int i : elements) {
			System.err.println("Postion of element not indexes :" + i);
		}
	}

	private static int[] elementsArray(int[] arr, int target) {

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			int sum = arr[i] + arr[j];

			if (sum == target) {
				return new int[] { i + 1, j + 1 };
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}

		return null;
	}
}
