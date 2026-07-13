
public class Sort {
	public static void BubbleSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] < a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	public static void SelectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int tmp = a[min];
			a[min] = a[i];
			a[i] = tmp;
		}
	}

	public static void InsertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			int key = a[i];
			while (j >= 0 && key < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 5, 4, 9, 6, 8, 7 };
		InsertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
