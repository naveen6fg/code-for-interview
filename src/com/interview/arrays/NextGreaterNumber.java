package com.interview.arrays;

public class NextGreaterNumber {

    public static int nextGreater(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int i = digits.length - 2;

        // Step 1: Find first decreasing element
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) return -1; // no greater number possible

        // Step 2: Find just greater element
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse right part
        reverse(digits, i + 1, digits.length - 1);

        return Integer.parseInt(new String(digits));
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreater(746)); // Output: 764
    }
}