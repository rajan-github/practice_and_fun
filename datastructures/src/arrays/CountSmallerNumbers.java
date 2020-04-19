package arrays;

public class CountSmallerNumbers {
	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] smallerCount = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int smaller = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					smaller++;
				}
			}
			smallerCount[i] = smaller;
		}
		return smallerCount;
	}

	public static void main(String[] args) {
		int[] nums = { 7, 7, 7, 7 };
		int[] smaller = smallerNumbersThanCurrent(nums);
		for (int item : smaller) {
			System.out.print(item + ", ");
		}
	}
}
