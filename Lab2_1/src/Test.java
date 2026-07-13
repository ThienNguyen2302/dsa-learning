
public class Test {
	public static void main(String[] args) {
		IntLinkedList p = new IntLinkedList();
		p.addFirst(7);
		p.addFirst(6);
		p.addFirst(3);
		p.addFirst(2);
		p.addFirst(5);
		p.print();
		System.out.println(p.addLast(1));
		p.print();
		System.out.println(p.removeAt(3));
		p.print();
		System.out.println(p.countOdd());
		System.out.println(p.searchKey(5));
		if (p.checkSorted()) {
			System.out.println("true");
		} else
			System.out.println("false");
	}
}
