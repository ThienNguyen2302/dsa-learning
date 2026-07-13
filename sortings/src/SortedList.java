import java.util.ArrayList;

public class SortedList {
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private SortAlgorithm sort;

	public SortedList() {
		this.sort = new BubbleSort();
	}

	public void add(Integer number) {
		list.add(number);
	}

	public void sort() {
		sort.sort(list);
	}

	public static void main(String[] args) {
		SortedList s = new SortedList();
		s.sort();
	}
}
