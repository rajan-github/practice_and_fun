package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Sum of whole tree without recursion.
 * 
 * @author rajan-c
 *
 */
public class Problem26 {

	public static int sumOfTree(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		int sum = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			sum += node.getData();
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
		}
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(11);
		tree.insert(15);
		tree.insert(9);
		System.out.println(sumOfTree(tree.getRoot()));
	}
}
