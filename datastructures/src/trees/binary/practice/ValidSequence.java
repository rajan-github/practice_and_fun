package trees.binary.practice;

/**
 * Given a binary tree where each path going from the root to any leaf form a
 * valid sequence, check if a given string is a valid sequence in such binary
 * tree.
 * 
 * We get the given string from the concatenation of an array of integers arr
 * and the concatenation of all values of the nodes along a path results in a
 * sequence in the given binary tree.
 * 
 * @author rajan-c
 *
 */
public class ValidSequence {
	public static boolean isValidSequence(TreeNode root, int[] arr) {
		if (root == null && (arr == null || arr.length == 0))
			return true;
		else if (root == null)
			return false;
		else
			return isValidSequence(root, arr, 0);
	}

	private static boolean isValidSequence(TreeNode root, int[] arr, int index) {
		if (index >= arr.length)
			return root == null;
		else if (index < arr.length && root == null)
			return false;
		else if (root.val == arr[index] && root.left == null)
			return isValidSequence(root.right, arr, index + 1);
		else if (root.val == arr[index] && root.right == null)
			return isValidSequence(root.left, arr, index + 1);
		else if (root.val == arr[index] && root.right != null && root.left != null)
			return isValidSequence(root.left, arr, index + 1) || isValidSequence(root.right, arr, index + 1);
		else
			return false;

	}

}
