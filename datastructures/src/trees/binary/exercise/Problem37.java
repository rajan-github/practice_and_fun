package trees.binary.exercise;

import java.util.ArrayList;
import java.util.List;

import trees.binary.examples.BinaryTreeNode;

/**
 * For Problem-36, how do we generate all different BSTs with n nodes?
 * 
 * @author rajan-c
 *
 */
public class Problem37 {

	public static List<BinaryTreeNode<Integer>> generateAllTrees(int n) {
		return generateAllTrees(1, n);
	}

	private static List<BinaryTreeNode<Integer>> generateAllTrees(int start, int end) {
		List<BinaryTreeNode<Integer>> trees = new ArrayList<>();
		if (start > end) {
			trees.add(null);
		} else {

			for (int i = start; i <= end; i++) {
				List<BinaryTreeNode<Integer>> leftTree = generateAllTrees(start, i - 1);
				List<BinaryTreeNode<Integer>> rightTree = generateAllTrees(i + 1, end);

				for (BinaryTreeNode<Integer> left : leftTree) {
					for (BinaryTreeNode<Integer> right : rightTree) {
						BinaryTreeNode<Integer> bst = new BinaryTreeNode<Integer>(i);
						bst.setLeft(left);
						bst.setRight(right);
						trees.add(bst);
					}
				}

			}
		}
		return trees;
	}

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			System.out.print(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public static void main(String[] args) {
		List<BinaryTreeNode<Integer>> trees = generateAllTrees(4);
		for (BinaryTreeNode<Integer> tree : trees) {
			preOrder(tree);
			System.out.println();
		}

	}

}
