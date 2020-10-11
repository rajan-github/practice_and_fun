package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle {
	private int[] nums;

	public Shuffle(int[] array) {
		this.nums = array;
	}

	public int[] reset() {
		return nums;
	}

	public int[] shuffle(int[] nums) {
		List<int[]> permutations = new ArrayList<>();
		permutation(nums, 0, permutations);
		int randomIndex = ThreadLocalRandom.current().nextInt(0, permutations.size());
		return permutations.get(randomIndex);
	}

	private void permutation(int[] nums, int index, List<int[]> permutations) {
		if (nums.length - index == 2) {
			int[] permutation = new int[nums.length];
			for (int i = 0; i < nums.length; i++)
				permutation[i] = nums[i];
			permutations.add(permutation);
			swap(nums, index, index + 1);
			permutation = new int[nums.length];
			for (int i = 0; i < nums.length; i++)
				permutation[i] = nums[i];
			swap(nums, index, index + 1);
			permutations.add(permutation);
		} else {
			for (int i = 0; i < nums.length; i++) {
				swap(nums, i, index);
				permutation(nums, index + 1, permutations);
				swap(nums, i, index);
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		List<int[]> permutations = new ArrayList<>();
		int[] nums = new int[] { 1, 2, 3 };
//		permutation(nums, 0, permutations);
		for (int[] permutation : permutations)
			System.out.println(Arrays.toString(permutation));
//		System.out.println(Arrays.toString(nums));
	}
}
