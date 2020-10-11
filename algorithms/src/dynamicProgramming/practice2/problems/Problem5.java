package dynamicProgramming.practice2.problems;

public class Problem5 {
	public static String lcs(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return "";
		int memory[][] = new int[str1.length() + 1][str2.length() + 1];
		char directions[][] = new char[str1.length() + 1][str2.length() + 1];

		// compute subsequence length.
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				char c1 = str1.charAt(i - 1), c2 = str2.charAt(j - 1);
				if (c1 == c2) {
					memory[i][j] = 1 + memory[i - 1][j - 1];
					directions[i][j] = 'c';
				} else if (memory[i - 1][j] > memory[i][j - 1]) {
					memory[i][j] = memory[i - 1][j];
					directions[i][j] = 'u';
				} else {
					memory[i][j] = memory[i][j - 1];
					directions[i][j] = 'l';
				}
			}
		}

		StringBuilder commonSubsequence = new StringBuilder();
		// compute actual subsequence.
		int i = directions.length - 1, j = directions[0].length - 1;
		while (i > 0 && j > 0) {
			if (directions[i][j] == 'c') {
				commonSubsequence.insert(0, str1.charAt(i - 1));
				j--;
				i--;
			} else if (directions[i][j] == 'l')
				j--;
			else
				i--;
		}
		return commonSubsequence.toString();
	}

	public static String shortestCommonSupersequence(String str1, String str2) {
		if (str1 == null && str2 == null)
			return "";
		else if (str1 == null || str1.length() == 0)
			return str2;
		else if (str2 == null || str2.length() == 0)
			return str1;
		else if (str1.equals(str2))
			return str1;
		String lcs = lcs(str1, str2);

		StringBuilder superSequence1 = new StringBuilder(), superSequence2 = new StringBuilder();
		superSequence2.append(str2).append(str1);
		superSequence1.append(str1).append(str2);
		superSequence1 = deleteSubsequence(superSequence1, lcs);
		superSequence2 = deleteSubsequence(superSequence2, lcs);
		if (isSupersequence(superSequence1, str1, str2))
			return superSequence1.toString();
		return superSequence2.toString();
	}

	private static boolean isSupersequence(StringBuilder superSequence, String str1, String str2) {
		int str1Index = 0, str1Length = str1.length(), str2Index = 0, str2Length = str2.length(),
				superSequenceIndex = 0, superSequenceLength = superSequence.length();
		while (str1Index < str1Length && superSequenceIndex < superSequenceLength) {
			if (superSequence.charAt(superSequenceIndex) == str1.charAt(str1Index))
				str1Index++;
			superSequenceIndex++;
		}
		if (str1Index < str1Length)
			return false;
		superSequenceIndex = 0;
		while (str2Index < str2Length && superSequenceIndex < superSequenceLength) {
			if (superSequence.charAt(superSequenceIndex) == str2.charAt(str2Index))
				str2Index++;
			superSequenceIndex++;
		}
		if (str2Index < str2Length)
			return false;
		return true;
	}

	private static int remainingLengthAfterLCS(String str, String lcs) {
		int strIndex = 0, lcsIndex = 0, lcsLength = lcs.length();
		while (lcsIndex < lcsLength) {
			if (str.charAt(strIndex) == lcs.charAt(lcsIndex))
				lcsIndex++;
			strIndex++;
		}
		return str.length() - strIndex;
	}

	private static StringBuilder deleteSubsequence(StringBuilder superSequence, String commonSubsequece) {
		int lcsIndex = commonSubsequece.length() - 1, superSequenceIndex = superSequence.length() - 1;
		while (lcsIndex >= 0) {
			char c = superSequence.charAt(superSequenceIndex);
			if (c == commonSubsequece.charAt(lcsIndex)) {
				superSequence.delete(superSequenceIndex, superSequenceIndex + 1);
				lcsIndex--;
			}
			superSequenceIndex--;
		}
		return superSequence;
	}

	public static void main(String[] args) {
//		System.out.println(shortestCommonSupersequence("abcc", "ccat"));
//		System.out.println(shortestCommonSupersequence("abcp", "lambkc"));
//		System.out.println(shortestCommonSupersequence("abac", "cab"));
//		System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
		System.out.println(shortestCommonSupersequence("bcacaaab", "bbabaccc"));
	}
}
