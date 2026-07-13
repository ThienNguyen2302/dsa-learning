
public class AVL {
	Node root;

	public AVL() {
		this.root = null;
	}

	public int height(Node x) {
		if (x == null)
			return -1;
		return x.height;
	}

	private int checkBalance(Node x) {
		return height(x.left) - height(x.right);
	}

	private Node rotateLeft(Node x) {
		Node y = x.right;
		x.right = y.left;
		y.left = x;
		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}

	private Node rotateRight(Node x) {
		Node y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = 1 + Math.max(height(x.left), height(x.right));
		y.height = 1 + Math.max(height(y.left), height(y.right));
		return y;
	}

	private Node balance(Node x) {
		if (checkBalance(x) < -1) {
			if (checkBalance(x.right) > 0) {
				x.right = rotateRight(x.right);
			}
			x = rotateLeft(x);
		} else if (checkBalance(x) > 1) {
			if (checkBalance(x.left) < 0) {
				x.left = rotateLeft(x.left);
			}
			x = rotateRight(x);
		}
		return x;
	}

	private Node insert(Node x, Integer key) {
		if (x == null)
			return new Node(key);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = insert(x.left, key);
			x.height = 1 + Math.max(height(x.left), height(x.right));
		} else if (cmp > 0) {
			x.right = insert(x.right, key);
			x.height = 1 + Math.max(height(x.left), height(x.right));
		} else
			x.key = key;
		return balance(x);
	}

	private void NLR(Node x) {
		if (x != null) {
			System.out.print(x.key + " ");
			NLR(x.left);
			NLR(x.right);
		}
	}

	public void LRN(Node x) {
		if (x != null) {
			LRN(x.left);
			LRN(x.right);
			System.out.print(x.key + " ");
		}
	}

	public void LNR(Node x) {
		if (x != null) {
			LNR(x.left);
			System.out.print(x.key + " ");
			LNR(x.right);
		}
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		return max(x.right);
	}

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	private Node search(Node x, Integer key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return search(x.left, key);
		if (cmp > 0)
			return search(x.right, key);
		else
			return x;
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		return balance(x);
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		return balance(x);
	}

	private Node delNode(Node x, Integer key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delNode(x.left, key);
		else if (cmp > 0)
			x.right = delNode(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node tmp = x;
			x = min(tmp.right);
			x.right = deleteMin(tmp.right);
			x.left = tmp.left;
		}
		return balance(x);
	}

	private Node delNodepre(Node x, Integer key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = delNodepre(x.left, key);
		else if (cmp > 0)
			x.right = delNodepre(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node tmp = x;
			x = max(tmp.left);
			x.left = deleteMax(tmp.left);
			x.right = tmp.right;
		}
		return balance(x);
	}

	public void insert(Integer key) {
		this.root = insert(this.root, key);
	}

	public boolean contains(Integer key) {
		if (search(this.root, key) == null)
			return false;
		return true;
	}

	public int min() {
		Node tmp = min(this.root);
		return tmp.key;
	}

	public int max() {
		Node tmp = max(this.root);
		return tmp.key;
	}

	public void deleteMax() {
		this.root = deleteMax(this.root);
	}

	public void deleteMin() {
		this.root = deleteMin(this.root);
	}

	public void delNode(Integer key) {
		this.root = delNode(this.root, key);
	}

	public void delNodepre(Integer key) {
		this.root = delNodepre(this.root, key);
	}

	public void LRN() {
		LRN(this.root);
	}

	public void LNR() {
		LNR(this.root);
	}

	public int height() {
		return height(this.root);
	}

	public void NLR() {
		NLR(this.root);
	}

	public int sum(Node x) {
		if (x == null)
			return 0;
		return x.key + sum(x.left) + sum(x.right);
	}

	public int sum() {
		return sum(this.root);
	}

}
