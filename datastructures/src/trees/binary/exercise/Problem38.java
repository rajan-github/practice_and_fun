package trees.binary.exercise;

/**
 * Given a tree with a special property where leaves are represented with ‘L’
 * and internal node with ‘I’. Also, assume that each node has either 0 or 2
 * children. Given preorder traversal of this tree, construct the tree. Example:
 * Given preorder string => ILILL
 * 
 * @author rajan-c
 *
 */
public class Problem38 {

	private static TreeNode getSubtree(StringBuilder preorder, int index) {
		if (index >= preorder.length())
			return null;
		char nodeType = preorder.charAt(index);
		if (nodeType == 'L') {
			TreeNode root = new TreeNode('L');
			return root;
		} else {
			TreeNode root = new TreeNode(preorder.charAt(index));
			TreeNode left = getSubtree(preorder, index + 1);
			root.left = left;
			root.right = getSubtree(preorder, index + 1 + size(left));
			return root;
		}
	}

	private static int size(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + size(root.left) + size(root.right);
	}

	private static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		StringBuilder preorder = new StringBuilder();
		preorder.append("IIILLILLL");
		TreeNode root = getSubtree(preorder, 0);
		preorder(root);

	}

}

class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;

	TreeNode(char c) {
		this.data = c;
	}
}
