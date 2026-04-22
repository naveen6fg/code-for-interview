package interview;

public class ZeroShift {
    public static void main(String[] args) {

        int[] arr = {1, 0, 3, 0, 2, 8, 0, 1, 0, 2};

        int i = 0;
        for (int j = 0; j < arr.length; j++) {

            if (arr[j] != 0) {
                arr[i++] = arr[j];
            }
        }

        while (i < arr.length) {

            arr[i++] = 0;

        }

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
