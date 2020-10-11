package dp.exercise;

public class Problem7 {
	public static boolean isSubsequence(String subseq, String string) {
		if (string == null)
			return false;
		int length = string.length();
		int subseqLength = subseq.length();
		int subseqIndex = 0;
		for (int i = 0; i < length && subseqIndex < subseqLength; i++) {
			if (string.charAt(i) == subseq.charAt(subseqIndex))
				subseqIndex++;
		}
		if (subseqIndex == subseqLength)
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("PPAP", "PENPINEAPPLEAPPLEPEN"));
	}
}
