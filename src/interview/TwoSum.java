package interview;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = {2,4,7,8,10,76,86,90,100,200};

        int target = 204;

        int rightPointer =arr.length-1;

        int leftPointer =  0;
        for (; leftPointer<arr.length;){

            int sum = arr[leftPointer]+arr[rightPointer];

            if(target==sum){
                System.out.println(arr[leftPointer]+" + "+arr[rightPointer]+" = "+sum);
                return;
            } else if (leftPointer<rightPointer) {
                 leftPointer++;
            } else if (leftPointer>rightPointer) {
                rightPointer--;
            }
        }
    }
}
