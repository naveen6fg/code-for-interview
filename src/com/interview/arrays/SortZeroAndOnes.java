package com.interview.arrays;

import java.util.Iterator;

public class SortZeroAndOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0,1,1,1,0,0,1,0,1,0};
		
		int left =0;
		int right = arr.length-1;
		
		while (left<right) {
			
			while(arr[left]==0 && left< right) {
				left++;
			}
			while(arr[right]==1 && left< right) {
				right--;
			}
			
			if(left<right) {
				int temp = arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		for (int i : arr) {
			System.err.println(i);
		}
	}

}
