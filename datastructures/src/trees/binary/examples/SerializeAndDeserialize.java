package trees.binary.examples;

import java.util.HashMap;
import java.util.Map;

/**
 * Taking so much time. Think about example of tree which is right skew and has
 * height 999.
 * 
 * @author rajan-c
 *
 */
public class SerializeAndDeserialize {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return null;
		Map<Integer, TreeNode> indexMap = new HashMap<>();
		Map<Integer, Integer> valueMap = new HashMap<>();
		int size = treeSize(root);
		indexMap.put(0, root);
		valueMap.put(0, root.val);
		int index = 0;
		while (indexMap.size() < size) {
			TreeNode node = indexMap.get(index);
			if (node != null && node.left != null) {
				int childIndex = leftChild(index);
				indexMap.put(childIndex, node.left);
				valueMap.put(childIndex, node.left.val);
			}
			if (node != null && node.right != null) {
				int childIndex = rightChild(index);
				indexMap.put(childIndex, node.right);
				valueMap.put(childIndex, node.right.val);
			}
			index++;
		}
		System.out.println(indexMap + "\n " + valueMap);
		return valueMap.toString();
	}

	private int leftChild(int index) {
		return (index << 1) + 1;
	}

	private int rightChild(int index) {
		return (index << 1) + 2;
	}

	private int parent(double index) {
		return (int) (Math.ceil(index / 2) - 1);
	}

	private int treeSize(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + treeSize(root.left) + treeSize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() <= 2)
			return null;
		Map<Integer, TreeNode> indexMap = new HashMap<>();
		data = data.substring(1, data.length() - 1);
		String[] nodes = data.split(",");
		for (String node : nodes) {
			String[] parts = node.split("=");
			int index = Integer.parseInt(parts[0].trim()), value = Integer.parseInt(parts[1].trim());
			indexMap.put(index, new TreeNode(value));
			int parent = parent(index);
			if (parent < 0)
				continue;
			if ((index & 1) == 0)
				indexMap.get(parent).right = indexMap.get(index);
			else
				indexMap.get(parent).left = indexMap.get(index);
		}
		return indexMap.get(0);
	}

	private void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + ", ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.left.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(400);
		root.left.right = new TreeNode(500);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		SerializeAndDeserialize k = new SerializeAndDeserialize();
		String tree = k.serialize(root);
		root = k.deserialize(tree);
		k.inorder(root);
	}
}
