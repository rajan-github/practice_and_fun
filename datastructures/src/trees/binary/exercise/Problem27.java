package trees.binary.exercise;

import java.util.List;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for converting a tree to its mirror. Mirror of a tree is
 * another tree with left and right children of all non-leaf nodes interchanged.
 * The trees below are mirrors to each other.
 * 
 * @author rajan-c
 *
 */
public class Problem27 {

	public static void treeMirror(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		BinaryTreeNode<Integer> temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		treeMirror(root.getLeft(), root.getRight());
	}

	private static void treeMirror(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null || root2 == null)
			return;
		else {
			BinaryTreeNode<Integer> temp = root1.getLeft();
			root1.setLeft(root2.getRight());
			root2.setRight(temp);
			temp = root1.getRight();
			root1.setRight(root2.getLeft());
			root2.setLeft(temp);
			treeMirror(root1.getLeft(), root1.getRight());
			treeMirror(root2.getLeft(), root2.getRight());
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		List<BinaryTreeNode<Integer>> levelOrder = tree.levelOrder();
		for (BinaryTreeNode<Integer> node : levelOrder)
			System.out.print(node.getData());
		treeMirror(tree.getRoot());
		System.out.println("\nMirror of the tree-");
		levelOrder = tree.levelOrder();
		for (BinaryTreeNode<Integer> node : levelOrder)
			System.out.print(node.getData());
	}
}
