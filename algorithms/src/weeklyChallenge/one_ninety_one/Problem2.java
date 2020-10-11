package weeklyChallenge.one_ninety_one;

import java.util.Arrays;

/**
 * Given a rectangular cake with height h and width w, and two arrays of
 * integers horizontalCuts and verticalCuts where horizontalCuts[i] is the
 * distance from the top of the rectangular cake to the ith horizontal cut and
 * similarly, verticalCuts[j] is the distance from the left of the rectangular
 * cake to the jth vertical cut.
 * 
 * Return the maximum area of a piece of cake after you cut at each horizontal
 * and vertical position provided in the arrays horizontalCuts and verticalCuts.
 * Since the answer can be a huge number, return this modulo 10^9 + 7.
 * 
 * @author rajan-c
 *
 */
public class Problem2 {
	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		long maxCutHorizontal = biggestCut(horizontalCuts, h);
		long maxCutVertical = biggestCut(verticalCuts, w);
		return (int) ((maxCutHorizontal * maxCutVertical) % ((int) Math.pow(10, 9) + 7));
	}

	public static long biggestCut(int[] cuts, int height) {
		long maxCut = -1;
		int i = 0;
		for (i = 0; i < cuts.length; i++) {
			if (i == 0)
				maxCut = cuts[i];
			else {
				maxCut = Math.max(maxCut, cuts[i] - cuts[i - 1]);
			}
		}
		maxCut = Math.max(maxCut, height - cuts[i - 1]);
		return maxCut;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));
		System.out.println(maxArea(5, 4, new int[] { 3 }, new int[] { 3 }));
	}

}
