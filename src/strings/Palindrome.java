package strings;

public class Palindrome {

	public static void main(String[] args) {

		String str = "Malayalam";

		char[] charArray = str.toLowerCase().toCharArray();

		int i = 0;
		int j = charArray.length - 1;

		System.err.println(checkPanagram(i, j, charArray));
	}

	private static String checkPanagram(int i, int j, char[] charArray) {

		while (i < j) {
			if (charArray[i] != charArray[j]) {
				return "No Panagram";
			}
			i++;
			j--;
		}
		return "Panagram";
	}
}
