package graph.exercise.chap22;

/**
 * Diameter of a binary tree.
 * 
 * @author rajan-c
 *
 */
public class DiameterOfTree {

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int diameterWithRoot = 0;
		int leftHeight = computeHeight(root.left), rightHeight = computeHeight(root.right);
		if (leftHeight >= 0)
			diameterWithRoot += (1 + leftHeight);
		if (rightHeight >= 0)
			diameterWithRoot += (1 + rightHeight);
		int diameterLeft = diameterOfBinaryTree(root.left);
		int diameterRight = diameterOfBinaryTree(root.right);
		return max(diameterWithRoot, diameterLeft, diameterRight);
	}

	private static int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= c && b >= a)
			return b;
		return c;
	}

	private static int computeHeight(TreeNode root) {
		if (root == null)
			return -1;
		else if (root.left == null && root.right == null)
			return 0;
		return 1 + Math.max(computeHeight(root.left), computeHeight(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(8);
		root.left.right.right.left = new TreeNode(11);
		root.left.right.right.right = new TreeNode(12);
		root.left.right.right.right.left = new TreeNode(13);

		root.left.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(7);
		root.left.left.right.left = new TreeNode(9);
		root.left.left.right.left.right = new TreeNode(10);

//		TreeNode root = new TreeNode(3);

		System.out.println(diameterOfBinaryTree(root));
	}
}
