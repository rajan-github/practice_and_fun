package trees.binary.examples;

public class SearchBST {
	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null || root.val == val)
			return root;
		else if (root.val < val)
			return searchBST(root.right, val);
		else
			return searchBST(root.left, val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		System.out.println(searchBST(root, 2).val);
	}
}
