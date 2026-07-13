
public class SortArray {
	public static void print(int a[]) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
			print(a);
		}
	}

	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int m = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[m] > a[j])
					m = j;
			}
			int tmp = a[m];
			a[m] = a[i];
			a[i] = tmp;
			print(a);
		}
	}

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && key < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			print(a);
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 3, 4, 2, 6, 1 };
		bubbleSort(a);
		int[] b = { 3, 1, 4, 6, 2, 5 };
		selectionSort(b);
		int[] c = { 5, 1, 2, 6, 4, 3 };
		insertionSort(c);
	}
}
