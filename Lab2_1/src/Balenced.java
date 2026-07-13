import java.util.Scanner;

public class Balenced {
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String n;
		MyStack<Character> b = new MyStack<Character>();
		MyStack<Character> c = new MyStack<Character>();
		System.out.println("nhap chuoi cua ban: ");
		n = sc.nextLine();
		sc.close();
		for (int i = 0; i < n.length(); i++) {
			b.push(n.charAt(i));
			System.out.println(b.pop());
		}

		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) == '(' || n.charAt(i) == '{' || n.charAt(i) == '[') {
				c.push(n.charAt(count));
				count++;
			}
			if (n.charAt(i) == ')') {
				if (c.pop() == '{' || c.pop() == '[') {
					System.out.println("String is not balanced");
					break;
				} else {
					count--;
				}
			}
			if (n.charAt(i) == ']') {
				if (c.pop() == '{' || c.pop() == '(') {
					System.out.println("String is not balanced");
					break;
				} else {
					count--;
				}
			}
			if (n.charAt(i) == '}') {
				if (c.pop() == '(' || c.pop() == '[') {
					System.out.println("String is not balanced");
					break;
				} else {
					count--;
				}
			}
			if (count == 0) {
				System.out.println("String is balanced");
				break;
			}

		}

	}
}
