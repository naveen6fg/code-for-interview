package basic.premitive;

public class HCF {

	public static void main(String[] args) {

		//int hcf = calculateHCF(24, 36);
		int hcf = calculateHCF(36 , 24);
		System.err.println(hcf);

	}

	private static int calculateHCF(int a, int b) {

		while (b != 0) {
			
			int temp = b;
			b = a % b;
			a = temp;

		}
		return a;
	}
}
