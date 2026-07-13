import java.util.NoSuchElementException;

public class IntegerLinkedList extends MyLinkedList<Integer> {
	public IntegerLinkedList() {
		super();
	}

	public int countPrime() {
		int count = 0;
		Node<Integer> tmp = this.getHead();
		while (tmp != null) {
			int check = 0;
			for (int i = 2; i < Math.sqrt((int) tmp.getData()); i++) {
				if (tmp.getData() % i == 0) {
					check++;
				}
			}
			if (check == 0) {
				count++;
			}
			tmp = tmp.getNext();
		}
		return count;
	}

	public void addFirstEven(int item) {
		if (this.getHead() == null)
			throw new NoSuchElementException("can't remove element form an empty list");
		else {
			Node<Integer> tmp = this.getHead();
			Node<Integer> tmp1 = this.getHead();
			while (tmp.getNext() != null && (int) tmp.getData() % 2 != 0) {
				tmp1 = tmp;
				tmp = tmp.getNext();
			}
			if (tmp.getData() % 2 == 0) {
				this.addAfter(item, tmp1);
			} else
				this.addFirst(item);

		}
	}

	public int findMax() {
		Node<Integer> tmp = this.getHead();
		int max = tmp.getData();
		while (tmp != null) {
			if ((int) tmp.getData() > max)
				max = tmp.getData();
			tmp = tmp.getNext();
		}
		return max;
	}

	// phan lab 3
	public void addSortedList(int item) {
		if (this.getHead() == null) {
			this.addFirst(item);
		} else {
			Node<Integer> tmp = this.getHead();
			Node<Integer> tmp1 = new Node<Integer>();
			while (tmp != null && (int) tmp.getData() <= item) {
				tmp1 = tmp;
				tmp = tmp.getNext();
			}
			if (tmp.getData() > item) {
				this.addAfter(item, tmp1);
			} else
				this.addFirst(item);
		}
	}

	public int countEven() {
		int count = 0;
		Node<Integer> tmp = this.getHead();
		while (tmp != null) {
			if ((int) tmp.getData() % 2 == 0)
				count++;
			tmp = tmp.getNext();
		}
		return count;
	}

	public int sumRecursive(Node<Integer> note) {
		Node<Integer> tmp = note;
		if (tmp.getNext() == null)
			return tmp.getData();
		return tmp.getData() + sumRecursive(tmp.getNext());
	}

}
