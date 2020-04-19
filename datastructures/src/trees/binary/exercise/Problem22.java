package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for finding the level that has the maximum sum in the
 * binary tree.
 * 
 * @author rajan-c
 *
 */
public class Problem22 {
	public static int maximumSumLevel(BinaryTreeNode<Integer> root) {
		if (root == null)
			return -1;
		int maxSumLevel = -1, currentSum = root.getData(), currentLevel = 0, maxLevel = 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(null);
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			if (node != null) {
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
					currentSum += node.getLeft().getData();
				}

				if (node.getRight() != null) {
					queue.add(node.getRight());
					currentSum += node.getRight().getData();
				}
			} else {
				if (maxSumLevel < currentSum) {
					maxSumLevel = currentSum;
					maxLevel = currentLevel;
				}
				currentSum = 0;
				currentLevel++;
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return maxLevel;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(100);
		tree.insert(200);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);
		tree.insert(1);

		System.out.println(maximumSumLevel(tree.getRoot()));
	}
}
