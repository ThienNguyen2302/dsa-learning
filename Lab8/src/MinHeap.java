import java.util.NoSuchElementException;

public class MinHeap {
	int[] heap;
	int maxSize;
	int heapSize;

	public MinHeap(int capacity) {
		heapSize = 0;
		maxSize = capacity + 1;
		heap = new int[maxSize];
		heap[0] = -1;
	}

	private int parent(int i) {
		return i / 2;
	}

	private int left(int i) {
		return i * 2;
	}

	private int right(int i) {
		return i * 2 + 1;
	}

	private void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	public void insert(int key) {
		if (heapSize == maxSize)
			throw new NoSuchElementException("Overflow Exception");
		heapSize += 1;
		heap[heapSize] = key;
		shiftUp(heapSize);
	}

	private void shiftUp(int i) {
		while (i > 1 && heap[parent(i)] > heap[i]) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	public int extractMin() {
		if (heapSize == 0) {
			throw new NoSuchElementException("Overflow Exception");
		}
		int min = heap[1];
		heap[1] = heap[heapSize];
		heapSize -= 1;
		shiftDown(1);
		return min;
	}

	private void shiftDown(int i) {
		while (i < heapSize) {
			int min = heap[i];
			int min_id = i;
			if (left(i) < heapSize && heap[left(i)] < min) {
				min = heap[left(i)];
				min_id = left(i);
			}
			if (right(i) < heapSize && heap[right(i)] < min) {
				min = heap[right(i)];
				min_id = right(i);
			}
			if (min_id != i) {
				swap(min_id, i);
				i = min_id;
			} else
				break;
		}
	}

	public int[] heapSortDesc() {
		int[] b = new int[heapSize];
		int n = heapSize;
		for (int i = 0; i < n; i++) {
			b[i] = this.extractMin();
		}
		return b;
	}

	public int[] heapSortAsc() {
		int[] b = new int[heapSize];
		int n = heapSize;
		for (int i = 0; i < n; i++) {
			b[i] = this.extractMin();
		}
		return b;
	}
}
