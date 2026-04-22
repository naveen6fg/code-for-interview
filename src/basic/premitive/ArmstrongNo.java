package basic.premitive;

public class ArmstrongNo {

	public static void main(String[] args) {

		int num = 153;

		int digits = String.valueOf(num).length();

		System.out.println(isArmStringNo(num, digits) ? "Armstrong no" : "Not Armstrong no");
	}

	private static boolean isArmStringNo(int num, int digits) {
		int copy = num;
		int sum = 0;
		while (num > 0) {
			int lastDigit = num % 10;
			sum += Math.pow(lastDigit, digits);
			num = num / 10;
		}
		return copy == sum;
	}

}
