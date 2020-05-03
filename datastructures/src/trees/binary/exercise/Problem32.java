package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Print all the ancestors of a node in a binary tree.
 * 
 * @author rajan-c
 *
 */
public class Problem32 {

	public static boolean printAncestors(BinaryTreeNode<Integer> root, int target) {
		if (root == null)
			return false;
		if (root.getData().equals(target)) {
			System.out.println(root.getData());
			return true;
		}
		if (printAncestors(root.getLeft(), target)) {
			System.out.println(root.getData());
			return true;
		} else if (printAncestors(root.getRight(), target)) {
			System.out.println(root.getData());
			return true;
		}
		return false;
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
		tree.insert(8);
		printAncestors(tree.getRoot(), 8);
	}

}
