package strings;

public class ReverseViaStringBuilder {

	public static void main(String[] args) {

		String str = "Naveen Kumar";

		String reverse = reverseString(str);
		System.err.println(reverse);
	}

	private static String reverseString( String str) {

		StringBuilder builder = new StringBuilder(); 

		for (int i = str.length()-1; i >= 0; i--) {

			builder.append( str.charAt(i));
		}

		return builder.toString();
	}
}
