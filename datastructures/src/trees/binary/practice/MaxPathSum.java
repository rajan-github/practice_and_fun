package trees.binary.practice;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * 
 * @author rajan-c
 *
 */
public class MaxPathSum {
	private static int maxPathSum = Integer.MIN_VALUE;

	public static int pathSum(TreeNode root) {
		if (root == null)
			return 0;
		int left = pathSum(root.left);
		int right = pathSum(root.right);
		maxPathSum = Math.max(maxPathSum, left + right + root.val);
		return (int) Math.max(0, root.val + Math.max(left, right));
	}

	public static int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		pathSum(root);
		return maxPathSum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(maxPathSum(root));
	}
}
