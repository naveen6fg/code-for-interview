package two.pointer;

public class ShiftZeroLeft {

	public static void main(String[] args) {
		
		int[] arr = {0,3,7,0,3,2,1,0,9,5};
		
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i]!=0) {
				arr[j]=arr[i];
				j++;
			}
		}
		while (j<arr.length) {
			arr[j]=0;
			j++;
		}
		
		for (int i : arr) {
			System.err.println(i);
		}
	}
}
