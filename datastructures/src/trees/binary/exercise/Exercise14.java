package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the deepest node of the binary tree.
 * 
 * @author rajan-c
 *
 */
public class Exercise14 {
	public static BinaryTreeNode<Integer> deepestNode(BinaryTreeNode<Integer> root) {
		if (root != null && (root.getLeft() != null || root.getRight() != null)) {
			BinaryTreeNode<Integer> deepestNode = null;
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				deepestNode = queue.remove();
				if (deepestNode.getLeft() != null)
					queue.add(deepestNode.getLeft());
				if (deepestNode.getRight() != null)
					queue.add(deepestNode.getRight());
			}
			return deepestNode;
		} else
			return root;
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
		BinaryTreeNode<Integer> node = deepestNode(tree.getRoot());
		System.out.println(node == null ? null : node.getData());
	}
}
