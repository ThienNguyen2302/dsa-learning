
public class Recursion {
	public static double prod_recur(int a, int b) {
		if (b == 1)
			return a;
		return a + prod_recur(a, b - 1);
	}

	public static int bin2dec(int n, int exp) {
		if (n == 0)
			return n;
		return n % 10 + 2 * (bin2dec(n / 10, exp));
	}

	public static int maxDigit(int n) {
		if (n < 10)
			return n;
		return maxDigit(n / 10);
	}

	public static int maxElement(int a[], int n) {
		if (n == 0)
			return -1;
		if (n == 1)
			return a[0];
		if (a[n - 1] > maxElement(a, n - 1))
			return a[n - 1];
		return maxElement(a, n - 1);
	}

	public static int search(int a[], int n, int key) {
		if (n == 0)
			return -1;
		if (n == 1) {
			if (a[0] == key)
				return 1;
			else
				return -1;
		}
		if (a[n - 1] == key)
			return n;
		return search(a, n - 1, key);
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 5, 7, 8, 4 };
		System.out.println(maxElement(a, a.length));
		System.out.println(search(a, a.length, 7));
		System.out.println(prod_recur(192, 168));
		System.out.println(bin2dec(110011011, 0));
		System.out.println(maxDigit(9876));
	}
}
