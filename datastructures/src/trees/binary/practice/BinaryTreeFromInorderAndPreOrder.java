package trees.binary.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author rajan-c
 *
 */
public class BinaryTreeFromInorderAndPreOrder {

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0)
			return null;
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);
		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd,
			Map<Integer, Integer> inorderMap) {
		if (preStart >= 0 && preStart <= preEnd && inStart >= 0 && inStart <= inEnd) {
			TreeNode root = new TreeNode(preorder[preStart]);
			Integer index = inorderMap.get(preorder[preStart]);
			if (index != null && index >= 0) {
				root.left = buildTree(preorder, inorder, preStart + 1, preStart + (index - inStart), inStart, index - 1,
						inorderMap);
				root.right = buildTree(preorder, inorder, preStart + (index - inStart) + 1, preEnd, index + 1, inEnd,
						inorderMap);
			}
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode root = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		System.out.println(root.val);

		root = buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
		System.out.println(root.val);
	}
}
