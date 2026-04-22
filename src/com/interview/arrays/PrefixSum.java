package com.interview.arrays;

public class PrefixSum {

    public static void main(String[] args) {

        int[] arr = {2, 4, 1, 7, 3};
        int n = arr.length;

        int[] prefix = new int[n + 1]; // extra space

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        int L = 1, R = 3;

        int sum = prefix[R + 1] - prefix[L];

        System.out.println(sum);
    }
}