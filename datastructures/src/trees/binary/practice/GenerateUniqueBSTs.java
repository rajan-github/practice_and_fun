package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * @author rajan-c
 *
 */
public class GenerateUniqueBSTs {
	public static List<TreeNode> generateTrees(int n) {
		if (n <= 0)
			return new ArrayList<TreeNode>();
		return generateTrees(1, n);
	}

	private static List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> trees = new ArrayList<>();
		if (start > end) {
			trees.add(null);
			return trees;
		} else {
			for (int i = start; i <= end; i++) {
				List<TreeNode> leftTree = generateTrees(start, i - 1);
				List<TreeNode> rightTree = generateTrees(i + 1, end);
				for (TreeNode leftsub : leftTree) {
					for (TreeNode rightsub : rightTree) {
						TreeNode tree = new TreeNode(i);
						tree.left = leftsub;
						tree.right = rightsub;
						trees.add(tree);
					}
				}
			}
			return trees;
		}
	}

	private static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		List<TreeNode> trees = generateTrees(3);
		for (TreeNode tree : trees) {
			preorder(tree);
			System.out.println();
		}

	}
}
