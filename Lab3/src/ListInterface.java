import java.util.NoSuchElementException;
public interface ListInterface <E> {
	public void addFirst(E item);
	public void addAfter(E item, Node <E> curr);
	public void addLast(E item);
	public E removeFist() throws NoSuchElementException;
	public E removeAfter(Node <E> curr) throws NoSuchElementException;
	public E removeLast() throws NoSuchElementException;
	public void print();
	public boolean isEmpty();
	public E getFrist() throws NoSuchElementException;
	public Node <E> getHead();
	public int size();
	public boolean contain(E item);
	public E removeCurr(Node<E> curr);

}
