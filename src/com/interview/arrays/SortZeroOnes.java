package com.interview.arrays;
public class SortZeroOnes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 0, 0, 1};
        sortZeroesOnes(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sortZeroesOnes(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Increment left index while we see 0 at left
            while (arr[left] == 0 && left < right) {
                left++;
            }

            // Decrement right index while we see 1 at right
            while (arr[right] == 1 && left < right) {
                right--;
            }

            // If left is less than right, swap arr[left] and arr[right]
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            
            // Swap the found 1 and 0
//            if (left < right) {
//            	arr[left] = 0;
//            	arr[right] = 1;
//                left++;
//                right--;
//            }
            
        }
    }
}
