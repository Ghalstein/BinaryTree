public class BinaryTree<T extends Comparable<T>> {

	// top node/ head of the tree
	private TreeNode root = null;

	public BinaryTree(T data) {
		this.root = new TreeNode(data);
	}

	// inner class of BinaryTree that consists of the nodes of the tree
	class TreeNode {
		TreeNode(T data) {
			this.data = data;
		}
		T data;
		TreeNode left, right = null;
	}

	// appends the node to the endd of a leaf
	private void append(T newData, TreeNode node) {
		// tersts whether the data gets passed to the right or left
		if (newData.compareTo(node.data) > 0) {
			if (node.right != null) {
				append(newData, node.right);
			}
			else {
				node.right = new TreeNode(newData);
			}
		}
		else if ((newData.compareTo(node.data) < 0)) {
			if (node.left != null) {
				append(newData, node.left);
			}
			else {
				node.left = new TreeNode(newData);
			}
		}
		// incase the data is equal to the node then have to send it as close as possible
		else {
			if (node.left != null) {
				TreeNode curr = node.left;
				while (curr.right != null) {
					curr = curr.right;
				}
				curr.right = new TreeNode	(newData);
			}
			else {
				node.left = new TreeNode(newData);
			}
		}
	}

	// encapsulates the append code
	public void append(T newData) {
		append(newData, root);
	}

	private TreeNode find(T target, TreeNode node) {
		if (target.compareTo(node.data) > 0) {
			if (node.right != null) {
				return find(target, node.right);
			}
			else {
				return null;
			}
		}
		else if ((target.compareTo(node.data) < 0)) {
			if (node.left != null) {
				return find(target, node.left);
			}
			else {
				return null;
			}
		}
		// incase the data is equal
		return node;
	}

	private TreeNode delete(T target, TreeNode forwardNode, TreeNode curr) {
		if (target.compareTo(forwardNode.data)) {
			return delete(target, forwardNode.right, forwardNode);
		}
		else if (target.compareTo(root.data)) {
			return delete(target, forwardNode.left, forwardNode);
		}
		else {
			// when the node is found 
			if (curr.left == forwardNode) {
				TreeNode temp = forwardNode;
				TreeNode trail = curr;
				while (temp.right != null) {
					trail = temp;
					temp = temp.right;
				}
				if (temp.left == null) {
					temp.left = forward.left;
					temp.right = forward.right;
				}
				temp.right = forwardNode.right;
				curr.right = temp;
				trail.right = temp.left;
				temp.left = forwardNode.left; 	 
			}
			else if (curr.right == forwardNode) {
				if (forwardNode.right == null ) {
					curr.right = curr.left;
				}
				else if (forwardNode.left != null) {
					TreeNode trail = forwardNode;
					TreeNode temp = forwardNode.left;
					while (temp.right != null) {
						trail = temp;
						temp = temp.right; 
					}
					temp.right = forwardNode.right;
					curr.right = temp;
					trail.right = temp.left;
					temp.left = forwardNode.left;
				}
			}
			return null;
		}
		return null;
	}

	public TreeNode find(T target) {
		return find(target, root);
	}

	public TreeNode get(T target) {
		return find(target, root);
	} 

	public TreeNode delete(T target) {
		if (target.compareTo(root.data)) {
			return delete(target, root.right, root);
		}
		else if (target.compareTo(root.data)) {
			return delete(target, root.left, root);
		}
		else {
			// removing root
			return root;
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>(5);
		tree.append(3);
		tree.append(6);
		tree.append(7);
		System.out.println(tree.find(1));
		System.out.println(tree.find(6));
	}
}