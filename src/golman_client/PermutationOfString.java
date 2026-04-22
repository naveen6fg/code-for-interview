package golman_client;

public class PermutationOfString {

    public static void main(String[] args) {

        String str ="ABC";

        generatePermutation(str,"");
    }

    private static void generatePermutation(String str, String answer) {

        if (str.length()==0){
            System.err.println(answer);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String remaining = str.substring(0,i)+str.substring(i+1);
            generatePermutation(remaining,answer+ch);

        } // at every call of generatePermutation(),,  str= "remaining"  , answer="answer+ch"
    }
}
