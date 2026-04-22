package basic.premitive;

public class LCM {

	public static void main(String[] args) {

		int hcf = calculateHCF(36, 24);
		System.err.println(hcf);
		int lcm = calculateLCM(36, 24, hcf);
		System.err.println(lcm);
	}

	private static int calculateHCF(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	private static int calculateLCM(int a, int b, int hcf) {
		return (a * b) / hcf;
	}

}
