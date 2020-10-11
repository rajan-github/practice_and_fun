package dynamicProgramming.practice2;

/**
 * Transform str1 to str2 with minimum cost. We have three operations and each
 * of the operation has same cost: 1 unit. Insertion is inserting a new
 * character, deletion is deleting a char and substitution is to substitute a
 * char in str1.
 * 
 * @author rajan-c
 *
 */
public class EditDistance {
	public static int editDistance(String str1, String str2) {
		if (str1 == null && str2 == null)
			return 0;
		else if (str1 == null)
			return str2.length();
		else if (str2 == null)
			return str1.length();
		return editDistance(str1, str2, str1.length() - 1, str2.length() - 1);
	}

	private static int editDistance(String str1, String str2, int i, int j) {
		if (i < 0)
			return j >= 0 ? j + 1 : 0;
		else if (j < 0)
			return i >= 0 ? i + 1 : 0;
		else if (i < 0 && j < 0)
			return 0;
		else if (str1.charAt(i) == str2.charAt(j))
			return editDistance(str1, str2, i - 1, j - 1);
		else {
			int substitution = 1 + editDistance(str1, str2, i - 1, j - 1);
			int insert = 1 + editDistance(str1, str2, i, j - 1);
			int delete = 1 + editDistance(str1, str2, i - 1, j);
			return min(substitution, insert, delete);
		}
	}

	private static int editDistanceIterative(String str1, String str2) {
		int[][] memory = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < memory.length; i++)
			memory[i][0] = i + 1;

		for (int i = 0; i < memory[0].length; i++)
			memory[0][i] = i + 1;

		if (str1.charAt(0) == str2.charAt(0))
			memory[0][0] = 0;

		for (int i = 1; i < str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j))
					memory[i][j] = memory[i - 1][j - 1];
				else
					memory[i][j] = 1 + min(memory[i - 1][j - 1], memory[i][j - 1], memory[i - 1][j]);
			}
		}

		return memory[str1.length() - 1][str2.length() - 1];
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= c && b <= a)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		System.out.println(
				editDistance("algorithm", "altruistic") + ", " + editDistanceIterative("algorithm", "altruistic"));
		System.out.println(
				editDistance("algorithm", "algorithm") + ", " + editDistanceIterative("algorithm", "algorithm"));

		System.out.println(
				editDistance("intention", "execution") + ", " + editDistanceIterative("intention", "execution"));
	}
}
