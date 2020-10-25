package disjointsets;

public class TreeNode {
	TreeNode parent;
	int data;
	int rank;

	public TreeNode(int x) {
		this.data = x;
		rank = 1;
	}

	@Override
	public String toString() {
		return "" + data;
	}
}
