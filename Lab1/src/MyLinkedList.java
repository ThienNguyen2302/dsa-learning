import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numNode;

	public MyLinkedList() {
		head = null;
		numNode = 1;
	}

	public MyLinkedList(Node<E> note) {
		this.head = note;
		numNode = 1;

	}

	@Override
	public void addFirst(E item) {
		head = new Node<E>(item, head);
		numNode++;

	}

	@Override
	public void addAfter(E item, Node curr) {
		if (curr == null)
			head = new Node<E>(item, head);
		else {
			Node<E> newNode = new Node(item, curr.getNext());
			curr.setNext(newNode);
		}
		numNode++;
	}

	@Override
	public void addLast(E item) {
		if (head == null)
			addFirst(item);
		else {
			Node<E> tmp = head;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(new Node<E>(item));
			numNode++;
		}

	}

	@Override
	public E removeFist() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("can't remove element form an empty list");
		else {
			Node<E> tmp = head;
			head = head.getNext();
			numNode--;
			return tmp.getData();
		}

	}

	@Override
	public E removeAfter(Node curr) throws NoSuchElementException {
		if (curr == null)
			throw new NoSuchElementException("can't remove element form an empty list");
		else {
			Node<E> delNode = curr.getNext();
			if (delNode != null) {
				curr.setNext(delNode.getNext());
				numNode--;
				return delNode.getData();
			} else
				throw new NoSuchElementException("No next node to remove");
		}
	}

	@Override
	public E removeLast() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("can't remove element form an empty list");
		else {
			Node<E> tmp = head;
			Node<E> delpre = tmp;
			while (tmp.getNext() != null) {
				delpre = tmp;
				tmp = tmp.getNext();
			}
			delpre.setNext(tmp.getNext());
			tmp.setNext(null);
			return tmp.getData();
		}
	}

	@Override
	public void print() {
		if (head != null) {
			Node<E> tmp = head;
			System.out.print("List " + tmp.getData());
			tmp = tmp.getNext();
			while (tmp != null) {
				System.out.print(" -> " + tmp.getData());
				tmp = tmp.getNext();
			}
		}

	}

	@Override
	public boolean isEmpty() {
		if (numNode == 0)
			return true;
		else
			return false;
	}

	@Override
	public E getFrist() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("can't get element form an empty list");
		else {
			return head.getData();
		}
	}

	@Override
	public Node<E> getHead() {
		return head;
	}

	@Override
	public int size() {
		return numNode;
	}

	@Override
	public boolean contain(E item) {
		Node<E> tmp = head;
		while (tmp.getNext() != null) {
			if (tmp.getData() == item)
				return true;
			tmp = tmp.getNext();
		}
		return false;
	}

	@Override
	public E removeCurr(Node<E> curr) {
		if (head == null)
			throw new NoSuchElementException("can't remove element form an empty list");
		else {
			Node<E> tmp = head;
			Node<E> prevNode  = tmp;
			while (tmp.getNext() != curr) {
				prevNode = tmp;
				tmp = tmp.getNext();
			}
			prevNode.setNext(tmp.getNext());
			tmp.setNext(null);
			return tmp.getData();

		}
	}

}
