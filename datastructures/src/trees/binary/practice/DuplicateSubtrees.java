package trees.binary.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> duplicates = new ArrayList<>();
		if (root != null) {
			Set<TreeNode> subtrees = new HashSet<>();
			getSubtreeSet(subtrees, root);

			for (TreeNode root1 : subtrees) {
				for (TreeNode root2 : subtrees) {
					if (root1 != root2 && compareTrees(root1, root2))
						duplicates.add(root1);
				}
			}
		}
		return duplicates;
	}

	private static boolean compareTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;
		else
			return root1.val == root2.val && compareTrees(root1.left, root2.left)
					&& compareTrees(root1.right, root2.right);
	}

	private static void getSubtreeSet(Set<TreeNode> subTrees, TreeNode root) {
		if (root == null)
			return;
		subTrees.add(root);
		getSubtreeSet(subTrees, root.left);
		getSubtreeSet(subTrees, root.right);
	}
}
