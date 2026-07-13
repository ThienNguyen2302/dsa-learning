import java.util.NoSuchElementException;

public class Stack<E> {
	private Node<E> top;

	public Stack() {
		top = null;
	}

	public Stack(E item) {
		top = new Node<E>(item);
	}

	public E pop() {
		if (top == null)
			throw new NoSuchElementException("Can't remove form an empty stack");
		Node<E> tmp = top;
		top = top.getNext();
		return tmp.getData();
	}

	public void push(E item) {
		top = new Node<E>(item, top);
	}

	public E getPeek() {
		if (top == null)
			throw new NoSuchElementException("can't find element in an empty list");
		return top.getData();
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		return false;
	}
}
