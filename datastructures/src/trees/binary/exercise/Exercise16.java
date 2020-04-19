package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the number of leaves in the binary tree without
 * using recursion.
 * 
 * @author rajan-c
 *
 */
public class Exercise16 {

	public static int countLeaves(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		else if (root.getLeft() == null && root.getRight() == null)
			return 1;
		else {
			return countLeaves(root.getLeft()) + countLeaves(root.getRight());
		}
	}

	public static int countLeavesIterative(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		else if (root.getLeft() == null && root.getRight() == null)
			return 1;
		else {
			int leaves = 0;
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode<Integer> node = queue.remove();
				if (node.getLeft() != null)
					queue.add(node.getLeft());
				if (node.getRight() != null)
					queue.add(node.getRight());
				if (node.getLeft() == null && node.getRight() == null)
					leaves++;
			}
			return leaves;
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		tree.insert(2);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		tree.insert(3);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		tree.insert(4);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		tree.insert(5);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		tree.insert(6);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		tree.insert(7);
		System.out.println(countLeaves(tree.getRoot()) == countLeavesIterative(tree.getRoot()));
		System.out.println(countLeavesIterative(tree.getRoot()));
	}

}
