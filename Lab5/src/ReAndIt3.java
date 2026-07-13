
public class ReAndIt3 {
	public static double recur1(int n) {
		if (n == 0)
			return 2;
		return 2 - recur1(n - 1) / 2.0;
	}

	public static double iter1(int n) {
		double sum = 2;
		for (int i = 1; i <= n; i++) {
			sum = 2 - sum / 2;
		}
		return sum;
	}

	public static double recur2(int n) {
		if (n < 10)
			return 1;
		return 1 + recur2(n / 10);
	}

	public static double iter2(int n) {
		int sum = 1;
		while (n >= 10) {
			sum = sum + 1;
			n = n / 10;
		}
		return sum;
	}

	public static double recur3(int n, int k) {
		if (k == 1)
			return n;
		return n + recur3(n, k - 1);
	}

	public static double iter3(int n, int k) {
		double sum = 0;
		for (int i = 1; i <= k; i++) {
			sum += n;
		}
		return sum;
	}

	public static double recur4(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return recur4(n - 1) + recur4(n - 2);
	}

	public static double iter4(int n) {
		int a = 0;
		int b = 1;
		if (n == 0)
			return a;
		for (int i = 2; i <= n; i++) {
			int tmp = a + b;
			a = b;
			b = tmp;
		}
		return b;
	}

	public static void main(String[] args) {
		System.out.println(recur1(9));
		System.out.println(iter1(9));
		System.out.println(recur2(548736));
		System.out.println(iter2(548736));
		System.out.println(recur3(9, 5));
		System.out.println(iter3(9, 5));
		System.out.println(recur4(9));
		System.out.println(iter4(9));
	}
}
