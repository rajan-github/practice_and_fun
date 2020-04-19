package strings;

public class EditDistance {

	private static int match(char c1, char c2) {
		return c1 == c2 ? 0 : 1;
	}

	private static int insdel(char c) {
		return 1;
	}

	public static int minDistance(String word1, String word2) {
		if (word1.length() == 0)
			return word2.length();
		else if (word2.length() == 0)
			return word1.length();
		else {

			int[][] memory = new int[word1.length() + 1][word2.length() + 1];

			for (int i = 0; i <= word2.length(); i++)
				memory[0][i] = i;

			for (int i = 0; i <= word1.length(); i++)
				memory[i][0] = i;

			for (int i = 1; i <= word1.length(); i++) {
				for (int j = 1; j <= word2.length(); j++) {
					int matchCost = memory[i - 1][j - 1] + match(word1.charAt(i - 1), word2.charAt(j - 1));
					int insertCost = memory[i][j - 1] + insdel('c');
					int deleteCost = memory[i - 1][j] + insdel('a');
					memory[i][j] = min(matchCost, insertCost, deleteCost);
				}
			}
			return memory[word1.length()][word2.length()];
		}
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= a && b <= c)
			return b;
		return c;
	}

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
		System.out.println(minDistance("intention", "execution"));
//		System.out.println(minDistance("intention", ""));
//		System.out.println(minDistance("", "execution"));
//		System.out.println(minDistance("intention", "execution"));
		System.out.println(minDistance("a", "b"));
	}
}
