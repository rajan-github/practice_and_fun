package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Find the height of the tree using the level order traversal.
 * 
 * @author rajan-c
 *
 */
public class Exercise12 {

	public static int height(BinaryTree<Integer> tree) {
		int height = 0;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		if (tree != null && tree.getRoot() != null) {
			queue.add(tree.getRoot());
			queue.add(null);
			while (!queue.isEmpty()) {
				BinaryTreeNode<Integer> node;
				while ((node = queue.remove()) != null) {
					if (node.getLeft() != null)
						queue.add(node.getLeft());
					if (node.getRight() != null)
						queue.add(node.getRight());
				}
				if (!queue.isEmpty())
					queue.add(null);
				height++;
			}
		}
		return height - 1;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
//		tree.insert(1);
//		tree.insert(2);
//		tree.insert(3);
//		tree.insert(4);
//		tree.insert(5);
//		tree.insert(6);
//		tree.insert(7);
//		tree.insert(8);
		System.out.println(height(tree));
	}
}
