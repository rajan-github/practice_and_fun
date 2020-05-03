package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Find the least common ancestor of two given nodes in a tree.
 * 
 * @author rajan-c
 *
 */
public class Problem33 {

	public static BinaryTreeNode<Integer> leastCommonAncestor(BinaryTreeNode<Integer> root,
			BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
		if (root == null || node1 == null || node2 == null)
			return null;

		if (root.getLeft() == node1 || root.getRight() == node2)
			return root;

		BinaryTreeNode<Integer> left = leastCommonAncestor(root.getLeft(), node1, node2);
		BinaryTreeNode<Integer> right = leastCommonAncestor(root.getRight(), node1, node2);
		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(10);
		tree.insert(5);
		tree.insert(7);
		tree.insert(6);
		tree.insert(9);
		tree.insert(8);
		tree.insert(11);

		System.out.println(leastCommonAncestor(tree.getRoot(), tree.getRoot().getLeft().getLeft(),
				tree.getRoot().getRight().getRight()).getData());
	}
}
