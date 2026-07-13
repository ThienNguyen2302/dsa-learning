import java.util.Scanner;

public class SequenceOfCharacter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		System.out.println("nhap chuoi cua ban: ");
		n = sc.nextLine();
		sc.close();
		MyStack<Character> b = new MyStack<Character>();
		for (int i = 0; i < n.length(); i++) {
			b.push(n.charAt(i));
		}
		for (int i = 0; i < n.length(); i++) {
			System.out.println(b.pop());
		}
	}
}
