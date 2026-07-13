import java.util.Scanner;

public class StackandQueue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		MyStack<Character> b = new MyStack<Character>();
		MyStack<Character> c = new MyStack<Character>();
		System.out.println("nhap chuoi n: ");
		n = sc.nextLine();
		sc.close();
		for (int i = 0; i < n.length(); i++) {
			b.push(n.charAt(i));
			c.push(b.pop());
			System.out.println(c.pop());
		}
	}
}
