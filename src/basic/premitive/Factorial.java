package basic.premitive;

public class Factorial {

	public static void main(String[] args) {

		int n = 10;
		System.err.println(	factorial(n));
	}

	private static int factorial(int n) {

		if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
		
		int fact =1;
		for (int i = 1; i <= n ;i++) {
			fact = fact *i;
		}
		return fact;
	}
}
