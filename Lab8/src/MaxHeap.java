import java.util.NoSuchElementException;

public class MaxHeap {
	int[] heap;
	int heapSize;
	int maxSize;

	public MaxHeap(int capacity) {
		heapSize = 0;
		this.maxSize = capacity + 1;
		heap = new int[maxSize];
		heap[0] = -1;
	}

	private int parent(int i) {
		return i / 2;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void insert(int key) {
		if (heapSize == maxSize) {
			throw new NoSuchElementException("Overflow Exception");
		}
		heapSize += 1;
		heap[heapSize] = key;
		shiftUp(heapSize);
	}

	private void shiftUp(int i) {
		while (i > 1 && heap[parent(i)] < heap[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	public int extractMax() {
		if (heapSize == 0) {
			throw new NoSuchElementException("Overflow Exception");
		}
		int max = heap[1];
		heap[1] = heap[heapSize];
		heapSize -= 1;
		shiftDown(1);
		return max;
	}

	private void shiftDown(int i) {
		while (i <= heapSize) {
			int max = heap[i];
			int max_id = i;
			if (left(i) <= heapSize && heap[left(i)] > max) {
				max = heap[left(i)];
				max_id = left(i);
			}
			if (right(i) <= heapSize && heap[right(i)] > max) {
				max = heap[right(i)];
				max_id = right(i);
			}
			if (max_id != i) {
				swap(i, max_id);
				i = max_id;
			} else {
				break;
			}
		}
	}

	public int[] heapSortDesc() {
		int[] b = new int[heapSize];
		int n = heapSize;
		for (int i = 0; i < n; i++) {
			b[i] = this.extractMax();
		}
		return b;
	}

	public int[] heapSortAsc() {
		int[] b = new int[heapSize];
		int n = heapSize;
		for (int i = 0; i < n; i++) {
			b[n - i - 1] = this.extractMax();
		}
		return b;
	}
}