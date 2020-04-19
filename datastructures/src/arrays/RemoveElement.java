package arrays;

/**
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * @author rajan-c
 *
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		if (nums != null && nums.length > 0) {
			int newLength = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == val)
					continue;
				else {
					nums[newLength++] = nums[i];
				}
			}
			return newLength;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 1,1,1,1,1 };
		int length = removeElement(data, 2);
		for (int item : data) {
			System.out.print(item + ", ");
		}
		System.out.println("\nLength is: " + length);
	}
}
