package trees.binary.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definition:
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each
 * next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Another variant of the problem is: What is tree is not perfect binary tree?
 * 
 * @author rajan-c
 *
 */

//Definition for a Node.
class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

class PopulateNextPointer {
	public static Node connect(Node root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		Node previous = null;
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node != null) {
				if (previous != null) {
					previous.next = node;
					previous = node;
				} else
					previous = node;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			} else {
				previous = null;
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return root;
	}

	/**
	 * Incorrect.
	 * 
	 * @param root
	 * @return
	 */
	public static Node connectRecursive(Node root) {
		if (root == null || root.left == null || root.right == null)
			return root;
		connectRecursive(root.left, root.right);
		return root;
	}

	public static void connectRecursive(Node left, Node right) {
		if (left == null || right == null)
			return;
		left.next = right;
		connectRecursive(left.left, left.right);
		if (left.right == null && left.left != null && right.left != null)
			connectRecursive(left.left, right.left);
		else if (right.left == null && right.right != null && left.right != null)
			connectRecursive(left.right, right.right);
		else if (left.left != null && left.right == null && right.left == null && right.right != null)
			connectRecursive(left.left, right.right);
		else
			connectRecursive(left.right, right.left);
		connectRecursive(right.left, right.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		connectRecursive(root);
		System.out.println(root);
	}
}