package trees.binary.practice;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * @author rajan-c
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		else if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		else
			return root1.val == root2.val && isSymmetric(root1.left, root2.right)
					&& isSymmetric(root1.right, root2.left);
	}
}
