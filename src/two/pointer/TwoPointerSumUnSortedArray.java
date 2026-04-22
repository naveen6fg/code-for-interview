package two.pointer;

public class TwoPointerSumUnSortedArray {

	public static void main(String[] args) {

		int[] num = {8,1,2,3, 5, 6, 7, 9 };
		int traget = 15;

		elementOfTarget(num, traget);

	}

	private static void elementOfTarget(int[] num, int traget) {

		for (int i = 0; i < num.length; i++) {
			int j=i+1;

			while (j<num.length){

				int sum = num[i] + num[j];
				if (traget==sum){
					System.out.println(num[i]+ " + " +num[j]+" = "+sum);

				}
				j++;
			}
		}

	}
}
