package strings;

public class Anagram {

	public static void main(String[] args) {

		String str1 = "silent";
		String str2 = "listeN";
		
		boolean result = areAnagrams(str1, str2);
		System.err.println((result==true)?("Anagram"):("Not Anagram"));
	}
		private static boolean areAnagrams(String str1, String str2) {
		
			if(str1.length()!=str2.length()) {
				return false;
			}
			      //initially before increment        //   index-> 0,1,2,3,4,5,6,7,8,9......
			int[] arr = new int[26]; //arr will be like values -> [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0....]
			
			for (char ch : str1.toLowerCase().toCharArray()) {
				arr[ch-'a']++;
			}
			
			for (char ch : str2.toLowerCase().toCharArray()) {
				arr[ch-'a']--;
			}
			
			for (int i : arr) {
				if(i!=0) {
					return false;
				}
			}
				return true;
		}

}
