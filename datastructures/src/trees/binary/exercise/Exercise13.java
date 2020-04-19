package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the minimum depth of the binary tree.
 * 
 * @author rajan-c
 *
 */
public class Exercise13 {
	public int minHeight(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		return 1 + Math.min(minHeight(root.getLeft()), minHeight(root.getRight()));
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
//		tree.insert(6);
//		tree.insert(7);
//		tree.insert(8);
		System.out.println(new Exercise13().minHeight(tree.getRoot()));
	}
}
