package serach;

public class BinarySearchForSortedArray {

	public static void main(String[] args) {

		int arr[] = { 2, 4, 7, 8, 9, 10, 16, 24 };
		int target = 10;
		System.err.println(arr[binarySearch(arr, target)]);
	}

	private static int binarySearch(int[] arr, int target) {

		int left = 0;
		int end = arr.length - 1;

		while (left <= end) {

			int mid =  (left + end) / 2;

			if (arr[mid] == target) {
				return mid;
			}
			
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		// TODO Auto-generated method stub
		return -1;
	}
}
