package strings;

class MissingCharcterInPalimdrome {

    public static void main(String[] args) {
        String s = "abmam";

        String result = makePalindrome(s);
        System.out.println(result);
    }

    public static String makePalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (isPalindrome(s, i, n - 1)) {
                String prefix = s.substring(0, i);
                StringBuilder sb = new StringBuilder(prefix);
                sb.reverse();

                return s + sb.toString();
            }
        }
        return s;
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}