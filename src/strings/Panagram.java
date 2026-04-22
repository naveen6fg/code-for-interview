package strings;

public class Panagram {

	public static void main(String[] args) {

		String str = "The quick brown fox jumps over the lazy dog.";

		boolean isPanagram = checkPanagram(str);
		System.err.println(isPanagram);
	}

	private static boolean checkPanagram(String str) {
		int[] arr = new int[26];

		int start = 0;
		int end = arr.length - 1;

		for (char ch : str.toLowerCase().toCharArray()) {

			if (Character.isAlphabetic(ch)) {
				arr[ch - 97]++;
			}
		}

		for (int i : arr) {
			if (i == 0) {
				return false;
			}

		}
		return true;

	}
}
