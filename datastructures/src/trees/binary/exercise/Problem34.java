package trees.binary.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import auxiliarymethods.Display;
import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * zigzag tree traversal.
 * 
 * @author rajan-c
 *
 */
public class Problem34 {

	public static List<List<Integer>> zigzagTraversal(BinaryTreeNode<Integer> root) {
		List<List<Integer>> zigzagOrder = new ArrayList<>();
		if (root == null)
			return zigzagOrder;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		boolean clockwise = true;
		List<Integer> levelNodes = new ArrayList<>();
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.remove();
			if (node != null) {
				if (clockwise)
					levelNodes.add(node.getData());
				else
					levelNodes.add(0, node.getData());
				if (node.getLeft() != null)
					queue.add(node.getLeft());
				if (node.getRight() != null)
					queue.add(node.getRight());
			} else {
				zigzagOrder.add(levelNodes);
				if (!queue.isEmpty())
					queue.add(null);
				levelNodes = new ArrayList<>();
				clockwise = !clockwise;
			}
		}
		return zigzagOrder;
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

		List<List<Integer>> zigzag = zigzagTraversal(tree.getRoot());
		Display.display(zigzag);
	}

}
