public class Lab3_4 {
	public static int multiplePlus(int n) {
		if (n == 3)
			return 3;
		return 2 * n + 1 + multiplePlus(n - 1);
	}

	public static double sumFactorial(int n) {
		double m = 1.0;
		if (n == 1) {
			return 1;
		}
		for (int i = 1; i <= n; i++) {
			m = m * i;
		}
		return m + sumFactorial(n - 1);
	}

	public static double multipleFactorial(int n) {
		double m = 1.0;
		if (n == 1) {
			return 1.0;
		}
		for (int i = 1; i <= n; i++) {
			m = m * i;
		}
		return m * multipleFactorial(n - 1);
	}

	public static double combination(int n, int k) {
		if (n == k)
			return 1.0;
		return n * combination(n - 1, k);
	}

	public static double pheptinh(int n) {
		if (n < 1) {
			throw new IllegalArgumentException("n must be >= 1");
		}
		if (n == 1) {
			return 3.0;
		} else {
			return Math.pow(2, n) + n * n + pheptinh(n - 1);
		}
	}
}