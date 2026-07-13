public class Node {
	Integer key;
	Node left, right;
	int height;

	public Node(Integer key) {
		this.key = key;
		this.left = this.right = null;
		this.height = 0;
	}
}