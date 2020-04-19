package dynamicProgramming;

import java.util.Arrays;

/**
 * A numerical sequence is monotonically increasing if the ith element is at
 * least as big as the (i − 1)st element. The maximum monotone subsequence
 * problem seeks to delete the fewest num- ber of elements from an input string
 * S to leave a monotonically increasing subsequence. A longest increasing
 * subsequence of 243517698 is 23568.
 * 
 * @author rajan-c
 *
 */
public class MaximumMonotoneSubsequence {

	public static int getLCS(String str1, String str2) {
		int[][] memory = new int[str1.length() + 1][str2.length() + 1];
		//TODO
		return memory[str1.length()][str2.length()];
	}

	public static String maximumMonotoneSubsequence(String number) {
		int[] sortedNumbers = new int[number.length()];
		for (int i = 0; i < number.length(); i++)
			sortedNumbers[i] = Character.digit(number.charAt(i), 10);
		Arrays.sort(sortedNumbers);
		StringBuilder sortedString = new StringBuilder();
		for (int item : sortedNumbers)
			sortedString.append(item);

		return null;
	}

}
