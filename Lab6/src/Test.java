
public class Test {
	public static BST createTree(String strKey) {
		BST x = new BST();
		String[] a = strKey.split(" ");
		for (int i = 0; i < a.length; i++) {
			x.insert(Integer.parseInt(a[i]));
		}
		return x;
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(17);
		tree.insert(19);
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(6);
		tree.insert(9);
		tree.insert(14);
		tree.NLR();
		System.out.println("\nchieu cao la " + tree.height());
		tree.delNodepre(10);
		tree.NLR();
		System.out.println("\nchieu cao la " + tree.height());
		BST treeFromString = createTree("9 8 7 10 11 15 71 23 14");
		treeFromString.LNR();
		treeFromString.deleteMax();
		System.out.println();
		treeFromString.LNR();
		System.out.println("\n" + tree.sum());
		System.out.println(treeFromString.sum(treeFromString.root));
	}
}
