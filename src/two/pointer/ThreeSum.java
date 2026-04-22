package two.pointer;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr ={2, 6, 7, 23, 17, 19,20};
        int left =1;

        int right = arr.length-1;
        int sum = 28;

        for (int i=0;i< arr.length;i++){

            int target = arr[i]+arr[left]+arr[right];

            if (target==sum){
                System.out.println(arr[i]+"+"+arr[left]+"+"+arr[right]);
                return;
            }
            if (left<right){
                i++;
                left++;
            } else if (right>left) {
                right--;
            }
        }
    }
}
