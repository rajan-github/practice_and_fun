package dynamicProgramming.examples;

public class LCS {

	public static int lcs(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return 0;
		int[][] memory = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {

				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					memory[i][j] = 1 + memory[i - 1][j - 1];
				else
					memory[i][j] = Math.max(memory[i - 1][j], memory[i][j - 1]);
			}
		}
		return memory[str1.length()][str2.length()];
	}

	public static void main(String[] args) {
		System.out.println(lcs("democrat", "republican"));
	}

}
