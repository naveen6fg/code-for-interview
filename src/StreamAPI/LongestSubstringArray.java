package StreamAPI;

public class LongestSubstringArray {
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; // Assuming ASCII characters
        int maxLength = 0;
        int start = 0; // Left boundary of the sliding window
        
        // Traverse the string with the 'end' pointer
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // Move the start pointer to the right of the last occurrence of the current character
            start = Math.max(start, index[currentChar]);
            
            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
            
            // Update the last occurrence index of the current character
            index[currentChar] = end + 1;
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(s));
    }
}
