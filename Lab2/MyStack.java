import java.util.NoSuchElementException;

public class MyStack<E> implements StackInterface<E> {
	private Node<E> top;
	private int numNode;

	public MyStack() {
		top = null;
		numNode = 1;
	}

	public MyStack(E item) {
		top = new Node<E>(item);
		numNode = 1;
	}

	@Override
	public void push(E item) {
		if (top == null) {
			top = new Node<E>(item, top);
			numNode++;
		} else {
			Node<E> tmp = top;
			while (tmp.getNext() != null)
				tmp = tmp.getNext();
			tmp.setNext(new Node<E>(item));
			numNode++;
		}
	}

	@Override
	public E pop() {
		if (top == null)
			throw new NoSuchElementException("can't remove element form an empty stack");
		else {
			Node<E> tmp = top;
			Node<E> preNode = tmp;
			while (tmp.getNext() != null) {
				preNode = tmp;
				tmp = tmp.getNext();
			}
			preNode.setNext(tmp.getNext());
			tmp.setNext(null);
			numNode--;
			return tmp.getData();
		}
	}

	@Override
	public int size() {
		return numNode;
	}

	@Override
	public boolean contains(E item) {
		if (top == null)
			throw new NoSuchElementException("can't find element in an empty stack");
		else {
			Node<E> tmp = top;
			while (tmp.getNext() != null) {
				if (tmp.getData() == item) {
					return true;
				}
				tmp = tmp.getNext();
			}
			return false;
		}
	}

	@Override
	public void print() {
		if (top != null) {
			Node<E> tmp = top;
			System.out.print("Stack: " + tmp.getData());
			tmp = tmp.getNext();
			while (tmp != null) {
				System.out.print(" -> " + tmp.getData());
				tmp = tmp.getNext();
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if (numNode == 0) {
			return true;
		}
		return false;
	}

	@Override
	public E getPeek() {
		if (top == null)
			throw new NoSuchElementException("can't find element in an empty list");
		return top.getData();
	}
}