class TreeNode<T> {
    public T data;
    public TreeNode<T> left, right;

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return data.toString();
    }
}