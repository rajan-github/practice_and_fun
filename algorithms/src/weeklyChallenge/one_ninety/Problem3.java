package weeklyChallenge.one_ninety;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree where node values are digits from 1 to 9. A path in the
 * binary tree is said to be pseudo-palindromic if at least one permutation of
 * the node values in the path is a palindrome.
 * 
 * Return the number of pseudo-palindromic paths going from the root node to
 * leaf nodes.
 * 
 * @author rajan-c
 *
 */
public class Problem3 {
	public static int pseudoPalindromicPaths(TreeNode root) {
		int[] count = new int[1];
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return 1;
		dfs(root, new ArrayList<>(), count);
		return count[0];
	}

	public static void dfs(TreeNode root, List<Integer> path, int[] count) {
		if (root.left == null && root.right == null) {
			path.add(root.val);
			if (isPalindromic(path))
				count[0] += 1;
			path.remove(path.size() - 1);
			return;
		}
		path.add(root.val);
		if (root.left != null)
			dfs(root.left, path, count);
		if (root.right != null)
			dfs(root.right, path, count);
		if (!path.isEmpty())
			path.remove(path.size() - 1);
	}

	private static boolean isPalindromic(List<Integer> nums) {
		Map<Integer, Integer> frequencies = new HashMap<>();
		for (int item : nums) {
			if (frequencies.containsKey(item))
				frequencies.replace(item, frequencies.get(item) + 1);
			else
				frequencies.put(item, 1);
		}
		boolean isOddFrequencySeen = false;
		for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
			int f = entry.getValue();
			if ((f & 1) == 1)
				if (!isOddFrequencySeen)
					isOddFrequencySeen = true;
				else
					return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(2);
//		root.left = new TreeNode(3);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(1);
//		root.right.right = new TreeNode(1);
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(2);
		root.left.right.right = new TreeNode(4);
		root.left.right.left.right = new TreeNode(8);
		root.left.right.left.right.right = new TreeNode(1);
		root.left.right.right.right = new TreeNode(7);
		System.out.println(pseudoPalindromicPaths(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
