package arrays;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram. Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3]. Input: [2,1,5,6,2,3] Output: 10
 * 
 * @author rajan-c
 *
 */
public class LargestRectangleInHistogram {
	public static int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			maxArea = Math.max(maxArea, computeArea(heights, i));
		}
		return maxArea;
	}

	private static int computeArea(int[] heights, int i) {
		int left = i, right = i + 1, count = 0;
		while (left >= 0 && heights[left] >= heights[i]) {
			count++;
			left--;
		}
		while (right < heights.length && heights[right] >= heights[i]) {
			count++;
			right++;
		}
		return count * heights[i];
	}

	public static void main(String[] args) {
		int[] heights = new int[] { 2, 1, 5, 6, 2, 5 };
		System.out.println(largestRectangleArea(heights));

		heights = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(largestRectangleArea(heights));
	}
}
