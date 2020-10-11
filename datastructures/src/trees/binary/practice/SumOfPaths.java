package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, each node has value 0 or 1. Each root-to-leaf path
 * represents a binary number starting with the most significant bit. For
 * example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent
 * 01101 in binary, which is 13.
 * 
 * For all leaves in the tree, consider the numbers represented by the path from
 * the root to that leaf.
 * 
 * Return the sum of these numbers.
 * 
 * @author rajan-c
 *
 */
public class SumOfPaths {
	public int sumRootToLeaf(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return root.val;
		return sumRootToLeaf(root, new ArrayList<>());
	}

	private int sumRootToLeaf(TreeNode root, List<Integer> path) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {
			path.add(root.val);
			int index = path.size() - 1, size = index;
			int sum = 0;
			int previousPower = 1;
			while (index >= 0) {
				sum += (path.get(index) * previousPower);
				previousPower = previousPower << 1;
				index--;
			}
			path.remove(size);
			return sum;
		}
		path.add(root.val);
		int leftSum = sumRootToLeaf(root.left, path);
		int rightSum = sumRootToLeaf(root.right, path);
		path.remove(path.size() - 1);
		return leftSum + rightSum;
	}

	public static void main(String[] args) {

	}
}
