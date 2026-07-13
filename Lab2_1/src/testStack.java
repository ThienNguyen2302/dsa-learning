
public class testStack {
	public static void main(String[] args) {
		MyStack<Fraction> b = new MyStack<Fraction>();
		b.push(new Fraction(2, 3));
		b.push(new Fraction(3, 4));
		b.print();
		System.out.print("\n" + (b.pop()).toString());
	}

}
