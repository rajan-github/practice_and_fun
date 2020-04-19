package trees.binary.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author rajan-c
 *
 */
public class BuildTreeFromInorderAndPostOrder {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);
		return buildTree(postorder, inorder, 0, inorder.length - 1, 0, inorder.length - 1, inorderMap);
	}

	private static TreeNode buildTree(int[] postorder, int[] inorder, int poststart, int postend, int instart,
			int inend, Map<Integer, Integer> inorderMap) {
		if (poststart >= 0 && postend >= poststart && instart >= 0 && inend >= instart) {

			TreeNode root = new TreeNode(postorder[postend]);
			Integer inorderPosition = inorderMap.get(postorder[postend]);
			if (inorderPosition != null) {
				root.left = buildTree(postorder, inorder, poststart, poststart + inorderPosition - instart - 1, instart,
						inorderPosition - 1, inorderMap);
				root.right = buildTree(postorder, inorder, poststart + inorderPosition - instart, postend - 1,
						inorderPosition + 1, inend, inorderMap);
			}
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode tree = buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
		System.out.println(tree);

		tree = buildTree(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 });
		System.out.println(tree);
	}
}
