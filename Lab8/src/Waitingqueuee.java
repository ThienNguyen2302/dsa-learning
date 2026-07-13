import java.util.HashMap;

public class Waitingqueuee {
	public static void main(String[] args) {
		HashMap<Integer, String> queue = new HashMap<>();
		queue.put(3, "Alex");
		queue.put(2, "Pop");
		queue.put(6, "David");
		queue.put(1, "Susan");
		queue.put(4, "Kevin");
		queue.put(5, "Mike");
		queue.put(0, "Helen");
		queue.put(8, "Paul");
		queue.put(7, "Iris");
		MaxHeap priority = new MaxHeap(10);
		priority.insert(3);
		priority.insert(6);
		priority.insert(2);
		priority.insert(1);
		System.out.println(queue.get(priority.extractMax()));
		priority.insert(5);
		priority.insert(4);
		System.out.println(queue.get(priority.extractMax()));
		System.out.println(queue.get(priority.extractMax()));
		priority.insert(0);
		priority.insert(7);
		priority.insert(8);
		System.out.println(queue.get(priority.extractMax()));
	}

}
