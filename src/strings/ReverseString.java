package strings;

public class ReverseString {

	public static void main(String[] args) {

		String str = "Naveen Kumar";
		char[] charArray = str.toCharArray();
		int i = 0;
		int j = str.length()-1;

		String reversedString = new String(reverseStr(charArray,i,j));
		
		System.err.println(reversedString);
	}
		private static char[] reverseStr(char[] charArray, int i, int j) {
			while (i < j) {
				char tempCh =charArray[i];
				charArray[i]=charArray[j];
				charArray[j]=tempCh;
				i++;
				j--;
			}
			return charArray;
	}
		
}
