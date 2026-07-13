
public class Node<E> {
  private E data;
  private Node<E> next;

  public Node() {
    data = null;
    next = null;
  }

  public Node(E item) {
    data = item;
    next = null;
  }

  public Node(E item, Node<E> next) {
    data = item;
    this.next = next;
  }

  public E getData() {
    return this.data;
  }

  public Node<E> getNext() {
    return this.next;
  }

  public void setNext(Node<E> note) {
    this.next = note;
  }
}
