package trees.nary.exercise;

import trees.nary.examples.TreeNode;

/**
 * Given a generic tree, give an algorithm for finding the sum of all the
 * elements of the tree.
 * 
 * @author rajan-c
 *
 */
public class Problem41 {
	public static int getSum(TreeNode root) {
		if (root == null)
			return 0;
		int sum = root.getData();
		TreeNode sibling = root.getSibling();
		while (sibling != null) {
			sum += getSum(sibling.getChild()) + sibling.getData();
			sibling = sibling.getSibling();
		}
		return sum + getSum(root.getChild());
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setChild(new TreeNode(2));
		root.getChild().setSibling(new TreeNode(3));
		root.getChild().getSibling().setSibling(new TreeNode(4));
		root.getChild().setChild(new TreeNode(5));

		System.out.println(getSum(root));
	}
}
