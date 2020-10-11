package trees.binary.practice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LeftViewTest {
	@Test
	public void testleftview() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);

		assertEquals(new ArrayList<>(), new LeftView().leftView(null));
		List<Integer> leftView = new ArrayList<>();
		leftView.add(1);
		leftView.add(2);
		leftView.add(4);
		leftView.add(8);
		assertEquals(leftView, new LeftView().leftView(root));
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		leftView = new ArrayList<>();
		leftView.add(1);
		leftView.add(2);
		leftView.add(3);
		assertEquals(leftView, new LeftView().leftView(root));
	}
}
