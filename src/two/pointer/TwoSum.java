package two.pointer;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {2, 6, 7, 12, 17, 19};
        int left = 0;
        int right = arr.length - 1;
        int target = 26;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum==target) {
                System.out.println(arr[left] + "==" + arr[right]);
                return;
            } else if (sum < target) {
                left++;
            } else
                right--;
            }
        }


}
