import java.util.NoSuchElementException;

public class MyQueue<E> implements QueueInterface<E> {
	private Node<E> front;
	private Node<E> rear;
	private int numNode;

	public MyQueue() {
		front = null;
		rear = front;
		numNode = 0;
	}

	@Override
	public void enQueue(E item) {
		if (front == null) {
			front = new Node<E>(item, front);
			rear = front.getNext();
			numNode++;
		} else {
			Node<E> tmp = front;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(new Node<E>(item));
			rear = tmp.getNext();
			numNode++;
		}

	}

	@Override
	public E deQueue() {
		if (front == null) {
			throw new NoSuchElementException("can't find element in an empty queue");
		} else {
			Node<E> tmp = front;
			front = front.getNext();
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
		if (front == null)
			throw new NoSuchElementException("can't find element in an empty queue");
		else {
			Node<E> tmp = front;
			while (tmp.getNext() != null) {
				if (tmp.getData() == item) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public void print() {
		if (front != null) {
			Node<E> tmp = front;
			System.out.print("Queue: " + tmp.getData());
			tmp = tmp.getNext();
			while (tmp != null) {
				System.out.print(" -> " + tmp.getData());
				tmp = tmp.getNext();
			}
		}

	}

	@Override
	public boolean isEmpty() {
		if (front == null)
			return true;
		return false;
	}

	@Override
	public E getFront() {
		return front.getData();
	}

}
