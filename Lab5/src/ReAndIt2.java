
public class ReAndIt2 {
	public static double twoPow(int n) {
		if (n == 1)
			return 2;
		return 2 * twoPow(n - 1);
	}

	public static double recur1(int n) {
		if (n == 1)
			return 2;
		return twoPow(n) + recur1(n - 1);
	}

	public static double iter1(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + twoPow(i);
		}
		return sum;
	}

	public static double recur2(int n) {
		if (n == 0)
			return 0.5;
		return (n + 1) / 2.0 + recur2(n - 1);
	}

	public static double iter2(int n) {
		double sum = 0;
		for (int i = 0; i <= n; i++) {
			sum += (i + 1) / 2.0;
		}
		return sum;
	}

	public static double factorialRecur(int n) {
		if (n == 1 || n == 0)
			return 1;
		return n * factorialRecur(n - 1);
	}

	public static double recur3(int n) {
		if (n == 1)
			return 1;
		return factorialRecur(n) / factorialRecur(n - 1) + recur3(n - 1);
	}

	public static double iter3(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = sum + factorialRecur(i) / factorialRecur(i - 1);
		}
		return sum;
	}

	public static double recur4(int n) {
		if (n == 1)
			return 0;
		return (n * (n - 1)) + recur4(n - 1);
	}

	public static double iter4(int n) {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i * (i - 1);
		}
		return sum;
	}

	public static double factorialIter(int n) {
		double prod = 1;
		for (int i = 1; i <= n; i++)
			prod = prod * i;
		return prod;
	}

	public static void main(String[] args) {
		System.out.println(recur1(9));
		System.out.println(iter1(9));
		System.out.println(recur2(9));
		System.out.println(iter2(9));
		System.out.println(recur3(9));
		System.out.println(iter3(9));
		System.out.println(recur4(9));
		System.out.println(iter4(9));
		System.out.println(factorialRecur(9));
		System.out.println(factorialIter(9));
	}
}
