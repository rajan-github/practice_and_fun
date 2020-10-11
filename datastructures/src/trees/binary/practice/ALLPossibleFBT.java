package trees.binary.practice;

import java.util.ArrayList;
import java.util.List;

public class ALLPossibleFBT {
	public List<TreeNode> allPossibleFBT(int n) {
		List<TreeNode> trees = new ArrayList<>();
		if (n <= 0 || (n & 1) == 0)
			return trees;
		else
//			return allPossibleFBTrees(n, new ArrayList<>());
			return null;
	}

	public TreeNode allPossibleFBTrees(int n, List<TreeNode> trees) {
		return null;
	}
}
