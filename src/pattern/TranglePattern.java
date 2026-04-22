package pattern;

public class TranglePattern {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.err.print(i * j + " ");
			}
			System.err.println();

		}

		System.err.println();

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.err.print("*");
			}
			System.err.println();

		}
		System.err.println();

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.err.print(i + " ");
			}
			System.err.println();

		}
		System.err.println();

		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.err.print(j + " ");
			}
			System.err.println();

		}

		System.err.println();
		int count = 1;
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.err.print(count + " ");
				count++;
			}
			System.err.println();

		}
	}
}
