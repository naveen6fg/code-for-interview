package com.interview.arrays;

public class MaxSumWindow {
    // Function to find the maximum sum of a subarray of size k
    public static int maxSumSubarray(int[] arr, int k) {
        // Edge case: if k is larger than array length
        if (arr.length < k) {
            throw new IllegalArgumentException("k should not be larger than the array length");
        }
        
        // Calculate the sum of the first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        // Initialize the maximum sum as the first window sum
        int maxSum = windowSum;
        
        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            // Slide the window by subtracting the element that goes out of the window
            // and adding the new element that comes into the window
            windowSum += arr[i] - arr[i - k];
            
            // Update the maximum sum
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        
        // Find the maximum sum of a subarray of size k
        int result = maxSumSubarray(arr, k);
        
        // Print the result
        System.out.println("Maximum sum of a subarray of size " + k + " is: " + result);
    }
}
