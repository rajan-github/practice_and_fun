package bst;

import java.util.Stack;

public class Tree {
	public static void inorderWithStack(Node root) {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			if (root.getLeft() != null) {
				stack.push(root.getLeft());
				root = root.getLeft();
			} else {
				if (root.getRight() != null)
					root = root.getRight();
				else {
					while (!stack.isEmpty()) {
						Node temp = stack.pop();
						System.out.print(temp.getData() + ", ");
						if (temp.getRight() != null) {
							root = temp.getRight();
							stack.push(root);
							break;
						}
					}
				}
			}
		}
	}

	public static void inorderWithPointerComparison(Node root) {

	}

	public static Node min(Node root) {
		if (root == null)
			return root;
		if (root.getLeft() != null)
			return min(root.getLeft());
		else
			return root;
	}

	public static Node max(Node root) {
		if (root == null)
			return root;
		if (root.getRight() != null)
			return max(root.getRight());
		else
			return root;
	}

	public static Node predecessor(Node node) {
		if (node.getLeft() != null)
			return max(node.getLeft());
		Node parent = node.getParent();
		while (node != null && parent.getLeft() == node) {
			node = parent;
			parent = node.getParent();
		}
		return parent;
	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.setRight(new Node(4));
		root.getRight().setParent(root);
		root.getRight().setRight(new Node(5));
		root.getRight().getRight().setParent(root.getRight());
		root.setLeft(new Node(1));
		root.getLeft().setParent(root);
		Node predecessor = predecessor(root.getRight().getRight());
		System.out.println(predecessor.getData());
	}
}
