package com.interview.arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = { 2, 4, 5, 6, 8, 12, 44, 67 };

        int i=0;
        int j=arr.length-1;

        while (i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

        for (int k : arr){
            System.out.println(k);
        }
    }
}
