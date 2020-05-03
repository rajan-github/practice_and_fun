package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * @author rajan-c
 *
 */
public class PathSum2 {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<>();
		if (root == null)
			return paths;
		dfs(root, sum, new ArrayList<Integer>(), paths);
		return paths;
	}

	public static void dfs(TreeNode root, int sum, List<Integer> branch, List<List<Integer>> paths) {
		if (root == null)
			return;
		else if (root.left == null && root.right == null && root.val == sum) {
			branch.add(root.val);
			paths.add(cloneList(branch));
			branch.remove(branch.size() - 1);
			return;
		} else {
			if (root.left != null) {
				branch.add(root.val);
				dfs(root.left, sum - root.val, branch, paths);
				branch.remove(branch.size() - 1);
			}
			if (root.right != null) {
				branch.add(root.val);
				dfs(root.right, sum - root.val, branch, paths);
				branch.remove(branch.size() - 1);
			}
		}
	}

	private static List<Integer> cloneList(List<Integer> list) {
		List<Integer> clone = new ArrayList<>();
		for (int item : list)
			clone.add(item);
		return clone;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);

		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(-1);

		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(1);

		root.left.right.left = new TreeNode(-1);
		root.left.right.right = new TreeNode(0);

		root.right.left.left = new TreeNode(-1);
		root.right.left.right = new TreeNode(0);

		root.right.right.left = new TreeNode(1);
		root.right.right.right = new TreeNode(0);

		List<List<Integer>> paths = pathSum(root, 2);
		for (List<Integer> path : paths)
			System.out.println(path);
	}

}
