package basic.premitive;

public class ReverseNumber {

	public static void main(String[] args) {

		int num = 12675;

		reverseNo(num);

	}

	private static void reverseNo(int num) {
		int collect = 0;

		while (num > 0) {
			int digit = num % 10;
			collect = collect * 10 + digit;
			num = num / 10;

		}
		 System.err.println(collect);

	}

}
