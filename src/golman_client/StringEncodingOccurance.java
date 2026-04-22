package golman_client;

public class StringEncodingOccurance {

    public static void main(String[] args) {

        String str = "llloooooslllsmmmsmfnnf";

        char ch = str.charAt(0);
        int count = 1;
        StringBuffer bf = new StringBuffer();

        for (int i = 1; i < str.length(); i++) {

            if (ch == str.charAt(i)) {
                count++;
            } else {
                bf.append(ch).append(count);
                ch = str.charAt(i);
                count = 1;

            }
        }
        bf.append(ch).append(count);
        System.err.println(bf.toString());
    }
}
