package trees.binary.practice;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * @author rajan-c
 *
 */
public class FlattenBinaryTree {
	public static void flatten(TreeNode root) {
		flattenTree(root);
	}

	private static TreeNode flattenTree(TreeNode root) {
		if (root != null) {
			TreeNode left = root.left, right = root.right;
			root.left = null;
			root.right = null;
			TreeNode temp = root;
			while (temp.right != null)
				temp = temp.right;
			temp.right = flattenTree(left);
			while (temp != null && temp.right != null)
				temp = temp.right;
			if (temp != null)
				temp.right = flattenTree(right);
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root = flattenTree(root);
		System.out.println(root);
	}
}
