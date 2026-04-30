package com.interview.arrays;

import java.util.*;

class SuffixPrefixProduct {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        // Step 1: Prefix array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Step 2: Suffix array
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Step 3: Final result
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        System.out.println(Arrays.toString(result));
    }
}