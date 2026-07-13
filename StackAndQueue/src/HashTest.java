import java.util.Stack;

public class HashTest {
	public static void println(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode<Integer> node = stack.pop();
			System.out.print(node + " ");
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}
	}

	public static void main(String[] args) {

	}
}