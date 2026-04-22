package strings;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("All permutations of " + str + ":");
        findPermutations(str, "");
    }

    public static void findPermutations(String str, String answer) {
        if (str.length() == 0) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            findPermutations(remaining, answer + ch);

        }
    }
}