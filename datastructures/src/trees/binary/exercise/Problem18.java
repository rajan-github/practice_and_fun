package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the number of half nodes (nodes with only one
 * child) in the binary tree without using recursion. The set of all nodes with
 * either left or right child (but not both) are called half nodes.
 * 
 * @author rajan-c
 *
 */
public class Problem18 {

	public static int halfNodes(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		int halfNode = 0;

		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			if (node.getLeft() != null && node.getRight() != null) {
				queue.add(node.getLeft());
				queue.add(node.getRight());
			} else if (node.getLeft() != null) {
				halfNode++;
				queue.add(node.getLeft());
			} else if (node.getRight() != null) {
				halfNode++;
				queue.add(node.getRight());
			}
		}
		return halfNode;
	}

	public static int halfNodesRec(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		if (root.getLeft() != null && root.getRight() != null)
			return halfNodes(root.getLeft()) + halfNodes(root.getRight());
		else if (root.getLeft() != null)
			return 1 + halfNodes(root.getLeft());
		else
			return 1 + halfNodes(root.getRight());
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
//		tree.insert(9);

		System.out.println(halfNodes(tree.getRoot()));
		System.out.println(halfNodes(tree.getRoot()) == halfNodesRec(tree.getRoot()));
	}

}
