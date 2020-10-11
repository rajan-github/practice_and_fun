package dynamicProgramming.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array, strs, with strings consisting of only 0s and 1s. Also two
 * integers m and n.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * @author rajan-c
 *
 */
public class OnesAndZeros {
	public static int findMaxForm(String[] strs, int zeros, int ones) {
		Map<Integer, int[]> stringZeroAndOneCount = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];
			int[] bitCount = new int[2];
			int stringLength = s.length();
			for (int index = 0; index < stringLength; index++) {
				char c = s.charAt(index);
				bitCount[Character.digit(c, 2)] += 1;
			}
			stringZeroAndOneCount.put(i, bitCount);
		}

		int[][][] memory = new int[strs.length][ones + 1][zeros + 1];
		for (int[][] item : memory) {
			int rows = item.length, cols = item[0].length;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++)
					item[i][j] = -1;
			}
		}
		return findMaxForm(stringZeroAndOneCount, ones, zeros, 0, memory);
	}

	private static int findMaxForm(Map<Integer, int[]> stringZeroAndOneCount, int ones, int zeros, int currentIndex,
			int[][][] memory) {
		if (currentIndex >= stringZeroAndOneCount.size())
			return 0;
		else if (memory[currentIndex][ones][zeros] >= 0)
			return memory[currentIndex][ones][zeros];
		int stringCount = 0;
		int[] count = stringZeroAndOneCount.get(currentIndex);
		int withoutIth = Integer.MIN_VALUE, withIth = Integer.MIN_VALUE;
		if (count[0] <= zeros && count[1] <= ones)
			withIth = 1
					+ findMaxForm(stringZeroAndOneCount, ones - count[1], zeros - count[0], currentIndex + 1, memory);
		withoutIth = findMaxForm(stringZeroAndOneCount, ones, zeros, currentIndex + 1, memory);
		stringCount += Math.max(0, Math.max(withIth, withoutIth));
		memory[currentIndex][ones][zeros] = stringCount;
		return stringCount;
	}

	public static void main(String[] args) {
		System.out.println(findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
		System.out.println(findMaxForm(new String[] { "10", "0001", "111001", "1", "0", "1", "0" }, 5, 3));
		System.out.println(findMaxForm(new String[] { "10", "0", "1" }, 1, 1));
	}

}
