package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the diameter of the binary tree. The diameter
 * of a tree (sometimes called the width) is the number of nodes on the longest
 * path between two leaves in the tree.
 * 
 * @author rajan-c
 *
 */
public class Exercise20<T> {

	public static int diameter(BinaryTreeNode<Integer> root, int diameter) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return diameter;
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		if (diameter < leftHeight + rightHeight + 2)
			diameter = leftHeight + rightHeight + 2;
		return Math.max(diameter(root.getLeft(), diameter), diameter(root.getRight(), diameter));
	}

	private static int height(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		System.out.println(height(tree.getRoot()));
		System.out.println(diameter(tree.getRoot(), Integer.MIN_VALUE));

	}
}
