package two.pointer;

public class ShiftZeroRight {

	public static void main(String[] args) {

		int[] arr = { 0, 3, 7, 0, 3, 2, 1, 0, 9, 5 };

		int j = arr.length-1;
		for (int i = arr.length-1; i >= 0; i--) {

			if (arr[i] != 0) {
				arr[j] = arr[i];
				j--;
			}
		}
		while (j > 0) {
			arr[j] = 0;
			j--;
		}

		for (int i : arr) {
			System.err.println(i);
		}
	}
}
