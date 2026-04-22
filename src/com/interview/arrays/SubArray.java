package com.interview.arrays;

import java.util.*;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7};
        
        // Find and print all subarrays
        List<List<Integer>> subArrays = getAllSubArrays(arr);
        for (List<Integer> subArray : subArrays) {
            System.out.println(subArray);
        }
    }

    public static List<List<Integer>> getAllSubArrays(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Iterate through all possible starting points
        for (int start = 0; start < arr.length; start++) {
            List<Integer> subArray = new ArrayList<>();
            
            // Iterate through all possible ending points
            for (int end = start; end < arr.length; end++) {
                subArray.add(arr[end]); // Add element to the current subarray
                result.add(new ArrayList<>(subArray)); // Add the current subarray to the result
            }
        }
        
        return result;
    }
}
