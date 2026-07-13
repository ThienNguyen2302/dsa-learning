import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String n;
		MyStack<Character> b = new MyStack<Character>();
		MyQueue<Character> c = new MyQueue<Character>();
		System.out.println("nhap chuoi n: ");
		n = sc.nextLine();
		sc.close();
		n = n.replaceAll("\\s", "");
		n = n.toLowerCase();
		n = n.replaceAll(",", "");
		n = n.replaceAll(".", "");
		n = n.replaceAll(":", "");
		for (int i = 0; i < n.length(); i++) {
			b.push(n.charAt(i));
			c.enQueue(n.charAt(i));
		}
		for (int i = 0; i < n.length(); i++) {
			if (b.pop() == c.deQueue()) {
				count++;
			}
		}
		if (count == n.length()) {
			System.out.println("String is palindrome");
		} else {
			System.out.println("String is not palindrome");
		}
	}
}
