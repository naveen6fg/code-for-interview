package two.pointer;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr ={2, 6, 7, 23, 17, 19};
        int left =0;
        int right = arr.length-1;
        int sum = 26;
        while (left<right){
            int target = arr[left]+arr[right];
            if(target==sum){
                System.out.println(arr[left]+"=="+arr[right]);
                return;
            } else if (left<right) {
                left++;
            } else if (left>right) {
                right--;
            }
        }



    }
}
