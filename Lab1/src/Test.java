
public class Test {
	public static void main(String[] args) {
		MyLinkedList<Fraction> list = new MyLinkedList<Fraction>();
		Fraction new1 = new Fraction(1, 10);
		Fraction new2 = new Fraction(new1);
		Fraction new3 = new Fraction();
		list.addFirst(new1);
		list.addFirst(new2);
		list.addFirst(new3);
		list.print();
		IntegerLinkedList i = new IntegerLinkedList();
		System.out.println();
		i.addFirst(7);
		i.addFirst(3);
		i.addFirst(24);
		i.addFirst(8);
		i.addFirst(4);
		i.addSortedList(5);
		i.print();
		System.out.println(i.countEven());
		System.out.println(i.sumRecursive(i.getHead()));
	}
}
