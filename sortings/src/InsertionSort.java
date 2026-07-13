import java.util.ArrayList;

public class InsertionSort implements SortAlgorithm {
    public void sort(ArrayList<Integer> list) {
        // TODO: implement insertion sort.
    	for (int i = 1; i < list.size(); i++) {
			int j = i - 1;
			int key = list.get(i);
			while (j >= 0 && key < list.get(j)) {
				list.set(j + 1, list.get(j));
				j--;
			}
			list.set(j + 1, key);
		}
    }
}