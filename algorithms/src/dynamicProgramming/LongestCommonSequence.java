package dynamicProgramming;

public class LongestCommonSequence {
	public static void getLcs(String s1, String s2) {
		int[][] memory = lcs(s1, s2);
		if (memory != null) {
			StringBuilder lcs = new StringBuilder();
			int row = memory.length - 1, column = memory[0].length - 1;
			while (row > 0 && column > 0) {
				if (s1.charAt(column - 1) == s2.charAt(row - 1)) {
					lcs.append(Character.toString(s2.charAt(row - 1)));
					row--;
					column--;
				} else if (memory[row - 1][column] > memory[row][column - 1]) {
					row--;
				} else {
					column--;
				}
			}
			System.out.println("LCS: " + lcs);
		} else {
			System.out.println("LCS: " + "");
		}

	}

	public static int[][] lcs(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
			return null;
		int s1Length = s1.length() + 1, s2Length = s2.length() + 1;
		int[][] memory = new int[s2Length][s1Length];
		for (int row = 0; row < s2Length - 1; row++) {
			for (int column = 0; column < s1Length - 1; column++) {
				if (s2.charAt(row) == s1.charAt(column)) {
					memory[row + 1][column + 1] += memory[row][column] + 1;
				} else {
					memory[row + 1][column + 1] = max(memory[row][column], memory[row][column + 1],
							memory[row + 1][column]);
				}
			}
		}
		return memory;
	}

	private static int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= a && b >= c)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		getLcs("ABCBDAB", "BDCABA");
	}
}
