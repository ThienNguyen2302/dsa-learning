public class IntLinkedList {
	private Node head;

	public IntLinkedList() {
		this.head = null;
	}

	public void addFirst(int data) {
		this.head = new Node(data, this.head);
	}

	public boolean addLast(int data) {
		if (this.head == null) {
			this.addFirst(data);
			return true;
		}
		Node tmp = this.head;
		while (tmp.getNext() != null) {
			if (tmp.getData() == data)
				return false;
			tmp = tmp.getNext();
		}
		if (tmp.getData() == data)
			return false;
		tmp.setNext(new Node(data, null));
		return true;
	}

	public boolean removeAt(int position) {
		if (head == null) {
			return false;
		}
		int numNode = 1;
		Node tmp = head;
		Node tmp1 = tmp;
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
		Node tmp = head;
		while (tmp != null) {
			if (tmp.getData() == key)
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
		Node tmp = head;
		while (tmp != null) {
			numNode++;
			tmp = tmp.getNext();
		}
		int count = 0;
		while (tmp.getNext() != null) {
			Node tmp1 = tmp.getNext();
			if (tmp.getData() <= tmp1.getData()) {
				count++;
			}
			tmp = tmp.getNext();
		}
		while (tmp.getNext() != null) {
			Node tmp1 = tmp.getNext();
			if (tmp.getData() >= tmp1.getData()) {
				count++;
			}
		}
		if (count == numNode - 2)
			return true;
		return false;
	}

	public int countOdd() {
		int count = 0;
		Node tmp = head;
		while (tmp != null) {
			if (tmp.getData() % 2 == 1)
				count++;
			tmp = tmp.getNext();
		}
		return count;
	}

	public void print() {
		Node tmp = head;
		while (tmp != null) {
			System.out.print((int) tmp.getData() + "->");
			tmp = tmp.getNext();
		}
	}
}