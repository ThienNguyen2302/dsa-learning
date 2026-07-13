public class BST {
	Node root;

	public BST() {
		this.root = null;
	}

	private Node insert(Node x, Integer key) {
		if (x == null) {
			x = new Node(key);
			return x;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = insert(x.left, key);
		else if (cmp > 0)
			x.right = insert(x.right, key);
		else
			x.key = key;
		return x;
	}

	public void NLR(Node x) {
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

	public void LNRde(Node x) {
		if (x != null) {
			LNRde(x.right);
			System.out.print(x.key + " ");
			LNRde(x.left);
		}
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

	private Node min(Node x) {
		if (x.left == null)
			return x;
		return min(x.left);
	}

	private Node max(Node x) {
		if (x.right == null)
			return x;
		return max(x.right);
	}

	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;
		x.left = deleteMin(x.left);
		return x;
	}

	private Node deleteMax(Node x) {
		if (x.right == null)
			return x.left;
		x.right = deleteMax(x.right);
		return x;
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
		return x;
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
		return x;
	}

	private int compareHeight(int a, int b) {
		if (a > b)
			return a;
		if (b > a)
			return b;
		return a;
	}

	private int height(Node x) {
		if (x == null)
			return -1;
		return compareHeight(height(x.left), height(x.right)) + 1;
	}

	public int height() {
		return this.height(this.root);
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

	public void LNRde() {
		LNRde(this.root);
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
