package trees.binary.exercise;

import java.util.List;
import java.util.Map;

import trees.binary.examples.BinaryTreeNode;

/**
 * Given a binary tree, print out all its root-to-leaf paths.
 * 
 * @author rajan-c
 *
 */
public class Problem23 {

	public static void allPaths(BinaryTreeNode<Integer> root, List<Integer> currentPath, List<List<Integer>> paths) {

	}

	public static void dfs(BinaryTreeNode<Integer> root, List<Integer> branch,
			Map<BinaryTreeNode<Integer>, Integer> traversed) {
		if (root == null) {
			for (int item : branch)
				System.out.println(item + ", ");
			System.out.println("\n");
			return;
		}

		branch.add(root.getData());
		if (!traversed.containsKey(root.getLeft())) {
			traversed.put(root.getLeft(), 1);
			dfs(root.getLeft(), branch, traversed);
		}

		if (!traversed.containsKey(root.getRight())) {
			traversed.put(root.getRight(), 1);
			dfs(root.getRight(), branch, traversed);
		}
	}
}
