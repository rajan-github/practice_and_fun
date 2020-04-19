package backtracking;

public class Subsets {
	public static void generateSubsets(String subset, String rest) {
		if (rest == null || rest.length() == 0) {
			System.out.println(subset);
			return;
		}

		generateSubsets(subset, rest.substring(1));
		generateSubsets(subset + rest.charAt(0), rest.substring(1));
	}

	public static void main(String[] args) {
		generateSubsets("", "abc");
	}
}
