import java.util.NoSuchElementException; 

public class Queue<E> {
	private Node<E> front;

	public Queue() {
		front = null;
	}

	public Queue(E item) {
		front = new Node<E>(item);
	}

	public void enQueue(E item) {
		if (front == null)
			front = new Node<E>(item, front);
		else {
			Node<E> tmp = front;
			while (tmp.getNext() != null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(new Node<E>(item));
		}
	}

	public E deQueue() {
		if (front == null)
			throw new NoSuchElementException("Can't remove form an empty Queue");
		Node<E> tmp = front;
		front = front.getNext();
		return tmp.getData();
	}
}
