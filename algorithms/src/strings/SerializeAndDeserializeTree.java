package strings;

/**
 * This solution is wrong. When tree has duplicate keys.
 * 
 * @author rajan-c
 *
 */
public class SerializeAndDeserializeTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder preorder = new StringBuilder(), inorder = new StringBuilder();
		inorder(root, inorder);
		preorder(root, preorder);
		StringBuilder serialize = new StringBuilder();
		serialize.append(preorder);
		serialize.append(":");
		serialize.append(inorder);
		return serialize.toString();
	}

	private void inorder(TreeNode root, StringBuilder inorder) {
		if (root == null)
			return;
		inorder(root.left, inorder);
		if (inorder.length() == 0)
			inorder.append(root.val);
		else {
			inorder.append(",");
			inorder.append(root.val);
		}
		inorder(root.right, inorder);
	}

	private void preorder(TreeNode root, StringBuilder preorder) {
		if (root == null)
			return;
		if (preorder.length() == 0)
			preorder.append(root.val);
		else {
			preorder.append(",");
			preorder.append(root.val);
		}
		preorder(root.left, preorder);
		preorder(root.right, preorder);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] orders = data.split(":");
		String[] preorderString = orders[0].split(",");
		String[] inorderString = orders[1].split(",");

		int[] preorder = new int[preorderString.length], inorder = new int[inorderString.length];
		for (int i = 0; i < preorderString.length; i++) {
			preorder[i] = Integer.parseInt(preorderString[i]);
			inorder[i] = Integer.parseInt(inorderString[i]);
		}
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
		if (startIn <= endIn && startPre <= endPre) {
			TreeNode root = new TreeNode(preorder[startPre]);
			int index = search(inorder, startIn, endIn, preorder[startPre]);
			int leftTreeSize = index - startIn + 1;
			if (leftTreeSize > 0)
				root.left = buildTree(preorder, inorder, startPre + 1, startPre + leftTreeSize, startIn, index);
			if (endIn - index - 1 > 0)
				root.right = buildTree(preorder, inorder, startPre + leftTreeSize + 1, endPre, index + 2, endIn);
			return root;
		}
		return null;
	}

	private int search(int[] inorder, int start, int end, int target) {
		for (int i = start; i <= end; i++)
			if (inorder[i] == target)
				return i - 1;
		return -1;
	}

	private boolean isTreeEqual(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && isTreeEqual(root1.left, root2.left) && isTreeEqual(root1.right, root2.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		SerializeAndDeserializeTree s = new SerializeAndDeserializeTree();
		String serialize = s.serialize(root);

		System.out.println(s.isTreeEqual(root, s.deserialize(serialize)));
	}
}
