package golman_client;

public class SubtringUseCase {
    public static void main(String[] args) {

        String str = "ABC93467";
        String str1 = "";
        System.out.println(str.substring(0, 0));
        if(str.substring(0, 0).isEmpty() && str1.isEmpty()){

            System.out.println(str.substring(0, 1));
            System.out.println(str.substring(0, 2));
            System.out.println(str.substring(0, 3));
        }

        System.err.println(str.substring(2));
        System.err.println(str.substring(3));
        System.err.println("Extact potion of Text (Empty) : "+str.substring(3,3)); //since both indexes pointing at same loaction so it will return empty
        System.err.println("Extact potion of Text (Empty): "+str.substring(4,4));

        String text  = "a";


        System.err.println("Empty Text : "+text.substring(0,0));
        System.err.println("Empty Text : "+text.substring(1,1));
        System.err.println("Empty Text : "+text.substring(1));
        System.err.println("Empty Text : "+text.substring(0));

    }
}
