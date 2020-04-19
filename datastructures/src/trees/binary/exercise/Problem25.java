package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the sum of all elements in binary tree.
 * 
 * @author rajan-c
 *
 */
public class Problem25 {
	public static int sumOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		else
			return root.getData() + sumOfTree(root.getLeft()) + sumOfTree(root.getRight());
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
//		tree.insert(5);
//		tree.insert(4);
//		tree.insert(7);
//		tree.insert(11);
//		tree.insert(15);
//		tree.insert(9);
		System.out.println(sumOfTree(tree.getRoot()));
	}
}
