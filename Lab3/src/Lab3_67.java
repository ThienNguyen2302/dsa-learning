
public class Lab3_67 {
	public static int minArray(int a[], int size) {
		int m = a[0];
		for (int i = 1; i < size; i++) {
			if (a[i] < m)
				m = a[i];
		}
		return m;
	}

	public static int sumArray(int a[], int size) {
		int m = 0;
		for (int i = 0; i < size; i++) {
			m += a[i];
		}
		return m;
	}

	public static int countEven(int a[], int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (a[i] % 2 == 0)
				count++;
		}
		return count;
	}

	public static int Min(int a[], int size) {
		if (size == 0)
			return -1;
		if (size == 1)
			return a[0];
		else {
			if (a[size - 1] < Min(a, size - 1))
				return a[size - 1];
			else
				return Min(a, size - 1);
		}
	}

	public static int Sum(int a[], int size) {
		if (size == 1)
			return a[0];
		return a[size - 1] + Sum(a, size - 1);
	}

	public static int count(int a[], int size) {
		if (size == 0)
			return 0;
		if (a[size - 1] % 2 == 0)
			return 1 + count(a, size - 1);
		return 0 + count(a, size - 1);
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 8, 4, 6 };
		System.out.println(minArray(a, a.length));
		System.out.println(sumArray(a, a.length));
		System.out.println(countEven(a, a.length));
		System.out.println(Min(a, a.length));
		System.out.println(Sum(a, a.length));
		System.out.println(count(a, a.length));
	}
}
