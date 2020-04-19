package arrays;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] ==> Output: 6
 * 
 * @author rajan-c
 *
 */
public class TrappingRainWater {
	public static int trap(int[] height) {
		int area = 0;
		int index = 0;
		while (index < height.length && height[index] == 0)
			index++;
		while (index < height.length) {
			int nextIndex = getNextIndex(height, index);
			int h = height[index];
			if (nextIndex < height.length && height[nextIndex] < height[index])
				h = height[nextIndex];
			for (int i = index + 1; i < nextIndex && i < height.length; i++) {
				area += Math.abs(height[i] - h);
			}
			index = nextIndex;
		}
		return area;
	}

	/**
	 * Assuming index is within range and heights[index] is greater than zero.
	 * 
	 * @param heights
	 * @param index
	 * @return
	 */
	private static int getNextIndex(int[] heights, int index) {
		int nextIndex = -1;
		int maxIndex = index + 1;
		for (nextIndex = index + 1; nextIndex < heights.length; nextIndex++) {
			if (heights[nextIndex] >= heights[index]) {
				maxIndex = nextIndex;
				break;
			} else if (heights[nextIndex] > 0)
				if (heights[nextIndex] > heights[maxIndex])
					maxIndex = nextIndex;
		}
		return maxIndex;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(nums));
		nums = new int[] { 2, 0, 2 };
		System.out.println(trap(nums));
//
		nums = new int[] { 3, 0, 0, 2, 0, 4 };
//		System.out.println(getNextIndex(nums, 0));
		System.out.println(trap(nums));
		nums = new int[] { 3, 0, 0, 0, 0, 4 };
		System.out.println(trap(nums));
		
		nums = new int[] { 3, 0, 0, 0, 0, 1 };
		System.out.println(trap(nums));
	}
}
