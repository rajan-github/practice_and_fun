package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the number of full nodes in the binary tree
 * without using recursion.
 * 
 * @author rajan-c
 *
 */
public class Exercise17 {

	public static int countFullNodes(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		int fullNodes = 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			if (node.getRight() != null && node.getLeft() != null) {
				fullNodes++;
				queue.add(node.getLeft());
				queue.add(node.getRight());
			} else if (node.getLeft() != null)
				queue.add(node.getLeft());
			else if (node.getRight() != null)
				queue.add(node.getRight());
		}
		return fullNodes;
	}

	public static int countFullNodesRec(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		if (root.getLeft() != null && root.getRight() != null)
			return 1 + countFullNodes(root.getLeft()) + countFullNodes(root.getRight());
		else if (root.getRight() != null)
			return countFullNodes(root.getRight());
		else
			return countFullNodes(root.getLeft());
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
		tree.insert(9);

		System.out.println(countFullNodes(tree.getRoot()));
		System.out.println(countFullNodes(tree.getRoot()) == countFullNodesRec(tree.getRoot()));
	}

}
