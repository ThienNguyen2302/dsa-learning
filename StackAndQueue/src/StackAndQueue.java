
public class StackAndQueue {
	public static boolean checkPalindrome(int n) {
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> qu = new Queue<Integer>();
		while (n > 0) {
			int p = n % 10;
			st.push(p);
			qu.enQueue(p);
			n = n / 10;
		}
		while (!st.isEmpty()) {
			if (st.pop() != qu.deQueue())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPalindrome(1221));
	}

}
