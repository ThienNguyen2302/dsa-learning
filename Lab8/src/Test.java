public class Test {
	public static MaxHeap buildHeap(String str) {
		String[] b = str.split(", ");
		MaxHeap a = new MaxHeap(b.length);
		for (int i = 0; i < b.length; i++) {
			int tmp = Integer.parseInt(b[i]);
			a.insert(tmp);
		}
		return a;
	}

	public static MinHeap buildMinHeap(String str) {
		String[] b = str.split(", ");
		MinHeap a = new MinHeap(b.length);
		for (int i = 0; i < b.length; i++) {
			int tmp = Integer.parseInt(b[i]);
			a.insert(tmp);
		}
		return a;
	}

	public static void main(String[] args) {
		String tmp = "15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39";
		int[] n, m = new int[100];
		MaxHeap max = buildHeap(tmp);
		MinHeap min = buildMinHeap(tmp);
		n = max.heapSortDesc();
		m = min.heapSortAsc();
		for (int i = 0; i < m.length; i++) {
			System.out.println(m[i] + " ");
			// System.out.println(ma.heap[i]+" ");
		}
	}
}