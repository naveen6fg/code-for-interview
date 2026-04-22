package interview;

public class Palindrome {
    public static void main(String[] args) {

        String text = "madam".toLowerCase();

        StringBuffer bf = new StringBuffer();

        for (int i = text.length()-1; i>=0; i--){

          bf.append(text.charAt(i));
        }
        System.out.println(bf);
        System.out.println(text);
        if(bf.toString().equals(text)){

            System.err.println("Its a Palindrome");
        }else {
            System.err.println("Its not a Palindrome");

        }

    }
}
