
public class IntLinkedList {
	private Node<Integer> head;

	public IntLinkedList() {
		head = null;
	}

	public void addFirst(int data) {
		head = new Node<Integer>(data, head);
	}

	public boolean addLast(int data) {
		if (head == null) {
			this.addFirst(data);
			return true;
		}
		Node<Integer> tmp = head;
		while (tmp.getNext() != null) {
			if ((int) tmp.getData() == data)
				return false;
			tmp = tmp.getNext();
		}
		if ((int) tmp.getData() == data)
			return false;
		tmp.setNext(new Node<Integer>(data, null));
		return true;
	}

	public boolean removeAt(int position) {
		if (head == null) {
			return false;
		}
		int numNode = 1;
		Node<Integer> tmp = head;
		Node<Integer> tmp1 = tmp;
		while (tmp.getNext() != null && numNode != position) {
			tmp1 = tmp;
			tmp = tmp.getNext();
			numNode++;
		}
		if (numNode != position)
			return false;
		tmp1.setNext(tmp.getNext());
		tmp.setNext(null);
		return true;
	}

	public int searchKey(int key) {
		if (head == null)
			return -1;
		int numNode = 1;
		Node<Integer> tmp = head;
		while (tmp != null) {
			if ((int) tmp.getData() == key)
				return numNode;
			if (tmp.getNext() != null) {
				tmp = tmp.getNext();
				numNode++;
			}
		}
		return -1;
	}

	public boolean checkSorted() {
		if (head == null)
			return false;
		int numNode = 0;
		Node<Integer> tmp = head;
		while (tmp != null) {
			numNode++;
			tmp = tmp.getNext();
		}
		int count = 0;
		tmp = head;
		while (tmp.getNext() != null) {
			Node<Integer> tmp1 = tmp.getNext();
			if ((int) tmp.getData() <= (int) tmp1.getData()) {
				count++;
			}
			tmp = tmp.getNext();
		}
		if (count == numNode - 1)
			return true;
		tmp = head;
		count = 0;
		while (tmp.getNext() != null) {
			Node<Integer> tmp1 = tmp.getNext();
			if ((int) tmp.getData() >= (int) tmp1.getData()) {
				count++;
			}
			tmp = tmp.getNext();
		}
		if (count == numNode - 1)
			return true;
		return false;
	}

	public int countOdd() {
		int count = 0;
		Node<Integer> tmp = head;
		while (tmp != null) {
			if ((int) tmp.getData() % 2 == 1)
				count++;
			tmp = tmp.getNext();
		}
		return count;
	}

	public void print() {
		Node<Integer> tmp = head;
		while (tmp != null) {
			System.out.print((int) tmp.getData() + "->");
			tmp = tmp.getNext();
		}
	}
}
