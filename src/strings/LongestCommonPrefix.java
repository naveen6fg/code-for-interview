package strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] str = {"flow", "flaw", "fly"};

        if (str == null || str.length == 0) {
            System.out.println("");
            return;
        }

        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {

           // "flaw".indexOf("flow") retun   //both lenth have same ,return -1

            while (str[i].indexOf(prefix) != 0) {  //prefix.length() is reducing
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    System.out.println("");
                    return;
                }
            }
        }

        System.out.println(prefix);
    }
}