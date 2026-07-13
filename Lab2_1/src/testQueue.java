
public class testQueue {
	public static void main(String[] args) {
		MyQueue<Fraction> b = new MyQueue<Fraction>();
		b.enQueue(new Fraction(2, 3));
		b.enQueue(new Fraction(3, 4));
		b.print();
		System.out.print("\n" + (b.deQueue()).toString());
	}
}
