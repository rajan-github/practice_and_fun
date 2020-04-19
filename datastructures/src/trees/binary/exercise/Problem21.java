package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Find maximum width(total number of nodes at one level) of the tree.
 * 
 * @author rajan-c
 *
 */
public class Problem21 {
	public static int maxWidth(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(null);
		queue.add(root);
		int maximum = 0, currentCount = 1;

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			if (node != null) {
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
					currentCount++;
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
					currentCount++;
				}
			} else {
				maximum = maximum < currentCount ? currentCount : maximum;
				currentCount = 0;
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return maximum;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);

		System.out.println(maxWidth(tree.getRoot()));
	}
}
