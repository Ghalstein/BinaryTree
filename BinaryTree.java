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

	private TreeNode delete(T target, TreeNode targetNode, TreeNode prev) {
		if (target.compareTo(targetNode.data) > 0) {
			return delete(target, targetNode.right, targetNode);
		}
		else if (target.compareTo(targetNode.data) < 0) {
			return delete(target, targetNode.left, targetNode);
		}
		else {
			System.out.println("Target Node: " + targetNode);
			// when the node is found 
			if (prev.left == targetNode) {
				if (targetNode.right == null && targetNode.left == null) {
					prev.left = null;
				}
				TreeNode temp = targetNode;
				TreeNode trail = prev;
				while (temp.right != null) {
					trail = temp;
					temp = temp.right;
				}
				if (temp.left == null) {
					temp.left = targetNode.left;
					return targetNode;
				}
				else {
					TreeNode leftTemp = temp.left;
					while (leftTemp.right != null) {
						leftTemp = leftTemp.right;
					}
					leftTemp.right = targetNode.left;
				}
				temp.right = targetNode.right;
				prev.left = temp;
				trail.right = temp.left;	
				targetNode.left = null;
				targetNode.right = null;
				return targetNode;
			}
			else if (prev.right == targetNode) {

				if (targetNode.right == null && targetNode.left == null) {
					prev.left = null;
				}
				if (targetNode.right == null ) {
					prev.right = prev.left;
					return targetNode;
				}
				else if (targetNode.left != null) {
					TreeNode trail = targetNode;
					TreeNode temp = targetNode.left;
					while (temp.right != null) {
						trail = temp;
						temp = temp.right; 
					}
					temp.right = targetNode.right;
					prev.right = temp;
					trail.right = temp.left;
					temp.left = targetNode.left;
					targetNode.left = null;
					targetNode.right = null;
					return targetNode;
				}
			}
			return null;
		}
	}

	public TreeNode find(T target) {
		return find(target, root);
	}

	public TreeNode get(T target) {
		return find(target, root);
	} 

	public TreeNode delete(T target) {
		if (target.compareTo(root.data) > 0) {
			return delete(target, root.right, root);
		}
		else if (target.compareTo(root.data) < 0) {
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
		tree.delete(3);
		System.out.println("Deleted Node: " + tree.find(3));
		System.out.println("Other Nodes: " + tree.find(6).data);
		System.out.println("Other Nodes: " + tree.find(7).data);
		System.out.println("Root Node: " + tree.find(5));
	}
}