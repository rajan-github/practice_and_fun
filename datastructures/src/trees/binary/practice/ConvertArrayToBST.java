package trees.binary.practice;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author rajan-c
 *
 */
public class ConvertArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start <= end && start >= 0) {
			int middle = (start + end) / 2;
			TreeNode root = new TreeNode(nums[middle]);
			root.left = sortedArrayToBST(nums, start, middle - 1);
			root.right = sortedArrayToBST(nums, middle + 1, end);
			return root;
		}
		return null;
	}

	private static boolean isTreeBalanced(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		else if (Math.abs(height(root.left) - height(root.right)) > 1)
			return false;
		return isTreeBalanced(root.left) && isTreeBalanced(root.right);
	}

	private static int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args) {
		int[] array = new int[] { -10, -3, 0, 5, 9 };
		TreeNode root = sortedArrayToBST(array);
		System.out.println(isTreeBalanced(root));

		array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		root = sortedArrayToBST(array);
		System.out.println(isTreeBalanced(root));
	}
}
