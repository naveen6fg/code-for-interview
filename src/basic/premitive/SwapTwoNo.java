package basic.premitive;

public class SwapTwoNo {

	public static void main(String[] args) {

		swapNums(2, 4);
		swapNumsWithTemp(3, 1);
		swapNumsWithTemps(4, 3);
	}

	private static void swapNums(int a, int b) {

		int temp = a;
		a = b;
		b = temp;

		System.err.println(a + "  " + b);
	}

	private static void swapNumsWithTemp(int a, int b) {

		a = a + b; // a now becomes 15 (5 + 10)
		b = a - b; // b becomes 5 (15 - 10)
		a = a - b; // a becomes 10 (15 - 5)

		System.err.println(a + "  " + b);
	}

	private static void swapNumsWithTemps(int a, int b) {

		a = a * b; // a = 50
		b = a / b; // b = 50 / 10 = 5
		a = a / b; // a = 50 / 5 = 10

		System.err.println(a + "  " + b);
	}
}
