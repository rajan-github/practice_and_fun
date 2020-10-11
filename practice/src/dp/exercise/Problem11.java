package dp.exercise;

import java.util.ArrayList;
import java.util.List;

public class Problem11 {
	private static List<String> minSlopPrinting(String text, int lineWidth) {
		String[] words = text.split(" ");
		int[] lengths = new int[words.length];
		for (int i = 0; i < words.length; i++)
			lengths[i] = words[i].length();
		int[] breakPoints = calculateMinSlop(lengths, lineWidth);
		List<String> brokenString = breakString(breakPoints, words, lineWidth);
		List<String> reverse = new ArrayList<>();
		for (int i = brokenString.size() - 1; i >= 0; i--) {
			reverse.add(brokenString.get(i));
		}
		return reverse;
	}

	private static int[] calculateMinSlop(int[] lengths, int lineLength) {
		int[] dp = new int[lengths.length + 1];
		int[] breakPoints = new int[lengths.length + 1];
		int[] extendedArray = new int[lengths.length + 1];
		for (int i = 0; i < lengths.length; i++)
			extendedArray[i + 1] = lengths[i];

		int index = 1;
		while (index < extendedArray.length) {
			int k = index;
			int minSlop = Integer.MAX_VALUE;
			while (k > 0) {
				int slop = calculateSlop(extendedArray, k, index, lineLength);
				if (slop < 0)
					break;
				int temp = slop + dp[k - 1];
				if (minSlop > temp) {
					minSlop = temp;
					breakPoints[index] = k;
				}
				k--;
			}
			dp[index] = minSlop;
			index++;
		}
		return breakPoints;
	}

	private static int calculateSlop(int[] lengths, int i, int j, int lineLength) {
		int wordLength = 0;
		for (int k = i; k <= j; k++)
			wordLength += lengths[k];
		return (int) Math.pow((lineLength - j + i - wordLength), 3);
	}

	private static List<String> breakString(int[] breakPoints, String[] words, int lineWidth) {
		List<String> brokenString = new ArrayList<>();
		int k = breakPoints[breakPoints.length - 1];
		int index = breakPoints.length - 1;
		boolean isLastLine = true;
		while (true) {
			k = breakPoints[index];
			if (k == 0)
				break;
			StringBuilder str = new StringBuilder();
			String seperator = "";

			for (int i = k; i <= index; i++) {
				str.append(seperator);
				str.append(words[i - 1]);
				seperator = computeSeperatorSpace(words, index, k, lineWidth);
			}

			if (isLastLine) {
				int length = str.length();
				for (int p = length; p <= lineWidth; p++)
					str.append(" ");
			}

			brokenString.add(str.toString());
			isLastLine = false;
			index = k - 1;
		}
		return brokenString;
	}

	private static String computeSeperatorSpace(String[] words, int index, int k, int lineWidth) {
		StringBuilder seperator = new StringBuilder();
		int wordLength = 0;
		for (int i = k; i <= index; i++)
			wordLength += words[i - 1].length();

		int spaceBetweenWords = (lineWidth - wordLength) / (index - k > 0 ? index - k : 1);
		for (int i = 0; i < spaceBetweenWords; i++)
			seperator.append(" ");
		return seperator.toString();
	}

	public static void main(String[] args) {
		List<String> list = minSlopPrinting("Geeks for Geeks presents word wrap problem", 15);
		for (String str : list)
			System.out.println(str);
		list = minSlopPrinting("aaa bb cc ddddd", 6);
		for (String str : list)
			System.out.println(str);
	}
}
