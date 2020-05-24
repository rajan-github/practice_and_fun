package arrays;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and
 * return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞.
 * 
 * @author rajan-c
 *
 */
public class PeakElement {
	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		else if (nums.length==1)
            return 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1])
					return i;
			} else if (i == nums.length - 1)
				return (nums[i - 1] < nums[i]) ? i : -1;
			else if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3, 1 }));
	}
}
