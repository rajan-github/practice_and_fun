package arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2.
 * 
 * @author rajan-c
 *
 */
public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums2Index = 0, nums1Index = 0, index = 0;
		int[] nums = new int[m + n];

		while (nums1Index < m && nums2Index < n) {
			if (nums1[nums1Index] <= nums2[nums2Index])
				nums[index++] = nums1[nums1Index++];
			else
				nums[index++] = nums2[nums2Index++];
		}

		while (nums1Index < m)
			nums[index++] = nums1[nums1Index++];

		while (nums2Index < n)
			nums[index++] = nums2[nums2Index++];
		for (index = 0; index < nums.length; index++)
			nums1[index] = nums[index];
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);

		for (int item : nums1)
			System.out.print(item + ", ");
		System.out.println();
//
//		nums = new int[] { 1, 0, 0, 0, 0, 0 };
//		nums2 = new int[] { 2, 5, 6 };
//		merge(nums, 1, nums2, 3);
//
//		for (int item : nums)
//			System.out.print(item + ", ");
//		System.out.println();
//
		nums1 = new int[] { 0, 0, 0, 0, 0, 0 };
		nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 0, nums2, 3);
//
		for (int item : nums1)
			System.out.print(item + ", ");
		System.out.println();

		nums1 = new int[] { 2, 0 };
		nums2 = new int[] { 1 };
		merge(nums1, 1, nums2, 1);

		for (int item : nums1)
			System.out.print(item + ", ");
		System.out.println();
	}
}
