package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for checking the existence of path with given sum. That
 * means, given a sum, check whether there exists a path from root to any of the
 * nodes.
 * 
 * @author rajan-c
 *
 */
public class Exercise24 {
	private static boolean doesPathWithSumExists(BinaryTreeNode<Integer> root, int sum) {
		if (root == null && sum == 0)
			return true;
		else if (root == null && sum != 0)
			return false;
		else if (root != null) {
			return doesPathWithSumExists(root.getLeft(), sum - root.getData())
					|| doesPathWithSumExists(root.getRight(), sum - root.getData());
		}
		return false;
	}

	public static void main(String[] args) {

		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(11);
		tree.insert(15);
		tree.insert(9);
		System.out.println(doesPathWithSumExists(tree.getRoot(), 21));
	}
}
