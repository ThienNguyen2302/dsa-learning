
public class Lab3_45 {
	public static int multiplePlus(int n) {
		if (n == 1)
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

	public static double chon(int n, int k) {
		if (n == k)
			return 1.0;
		return n * chon(n - 1, k);
	}

	public static double pheptinh(int n) {
		if (n == 1) {
			return 3.0;
		}
		return Math.pow(2, n) + n * n + pheptinh(n - 1);
	}

	public static int detobi(int a) {
		if (a == 0)
			return 0;
		return detobi(a / 2) * 10 + a % 2;
	}

	public static void main(String[] args) {
		System.out.println(multiplePlus(7));
		System.out.println(sumFactorial(7));
		System.out.println(multipleFactorial(4));
		System.out.println(chon(7, 3));
		System.out.println(pheptinh(7));
		System.out.println(detobi(7));

	}

}
