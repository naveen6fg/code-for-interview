package two.pointer;

public class ReverseOnlyCharacters {

    public static void main(String[] args) {

        String str = "abc%$def+lp"; //output = plf%$edc+ba

        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            if (!Character.isLetter(arr[left])) {
                left++;
            } 
            else if (!Character.isLetter(arr[right])) {
                right--;
            } 
            else {
                // swap
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        System.out.println(new String(arr));
    }
}