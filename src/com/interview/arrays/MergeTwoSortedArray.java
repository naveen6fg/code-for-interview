package com.interview.arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 6, 8};
        int[] arr2 = {3, 4, 7, 8};

        int[] result = merge(arr1, arr2);

        System.out.println(Arrays.toString(result));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;

        int[] result = new int[arr1.length + arr2.length];

        // Compare and merge
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}