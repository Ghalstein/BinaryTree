public class BinaryTree<T extends Comparable<T>> {

	private TreeNode root = null;

	public BinaryTree(T data) {
		this.root = new TreeNode(data);
	}

	class TreeNode {
		TreeNode(T data) {
			this.data = data;
		}
		T data;
		TreeNode left, right = null;
	}

	private void append(T newData, TreeNode node) {
		
	}


	public void append(T newData) {
		append(newData, root);
	}

	public static void main(String[] args) {

	}
}