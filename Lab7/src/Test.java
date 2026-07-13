
public class Test {
	public static AVL createTree(String strKey) {
		AVL x = new AVL();
		String[] a = strKey.split(" ");
		for (int i = 0; i < a.length; i++) {
			x.insert(Integer.parseInt(a[i]));
		}
		return x;
	}

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.insert(17);
		tree.insert(19);
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(6);
		tree.NLR();
		System.out.println("\nchieu cao la " + tree.height());
		tree.deleteMax();
		tree.delNodepre(17);
		tree.NLR();
		System.out.println(tree.sum());
		AVL treestr = createTree("20 30 40 15 25 23");
		treestr.NLR();
	}
}
