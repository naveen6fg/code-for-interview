package sliding.window;

import java.util.*;

public class LongestSubstring {

    public static void main(String[] args) {

        String str = "abcdabcde";
        int maxLength = 0;
        int left = 0;

        Set<Character> set = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {

            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}