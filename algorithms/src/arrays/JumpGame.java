package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * @author rajan-c
 *
 */
public class JumpGame {
	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0 || nums[0] == nums.length - 1)
			return true;
		return canJump(nums, 0);
	}

	public static boolean canJump(int[] nums, int k) {
		if (k == nums.length - 1)
			return true;
		else if (k < nums.length) {
			int choices = nums[k];
			for (int i = Math.min(choices, nums.length - 1); i >= 1; i--) {
				if (canJump(nums, k + i))
					return true;
			}
		}
		return false;
	}

	public static boolean canJumpFast(int[] nums) {
		if (nums == null || nums.length == 0)
			return true;
		boolean[][] reachability = new boolean[nums.length][nums.length];
		int cols = reachability[0].length;
		for (int row = 0; row < reachability.length; row++) {
			int maxJump = nums[row];
			if (row == 0)
				reachability[0][0] = true;
			else
				reachability[row][row] = reachability[row - 1][row];
			if (reachability[row][row]) {
				for (int col = row + 1; col <= cols - 1; col++) {
					if (col <= (row + maxJump))
						reachability[row][col] = true;
					else if (row > 0 && col > (row + maxJump)) {
						reachability[row][col] = reachability[row - 1][col];
					}
					if (reachability[row][cols - 1])
						return true;
				}
			}
		}
		return reachability[nums.length - 1][nums.length - 1];
	}

	public static boolean canJumpFastest(int[] nums) {
		if (nums == null || nums.length == 0)
			return true;
		int lastIndex = nums.length - 1;
		int reachability = 0, index = 0, maxjump = nums[index];
		while (reachability < lastIndex && index <= reachability && index < lastIndex) {
			maxjump = nums[index];
			if (maxjump + index > reachability)
				reachability = maxjump + index;
			index++;
		}
		return reachability >= lastIndex;
	}

	public static void main(String[] args) {
		System.out.println(canJumpFast(new int[] { 3, 2, 1, 0, 4 }) == canJumpFastest(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(canJumpFast(new int[] { 2, 3, 1, 1, 4 }) == canJumpFastest(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(canJumpFast(new int[] { 2, 0, 0 }) == canJumpFastest(new int[] { 2, 0, 0 }));
		System.out.println(canJumpFast(new int[] { 2, 0, 0, 0 }) == canJumpFastest(new int[] { 2, 0, 0, 0 }));
		System.out.println(
				canJumpFast(new int[] { 3, 0, 8, 2, 0, 0, 1 }) == canJumpFastest(new int[] { 3, 0, 8, 2, 0, 0, 1 }));

		String data;
		try (BufferedReader br = Files
				.newBufferedReader(Paths.get("D:\\programming\\algorithms\\src\\arrays\\data.txt"))) {
			data = br.readLine();
			String[] numbers = data.split(",");
			int[] array = new int[numbers.length];
			for (int i = 0; i < numbers.length; i++) {
				array[i] = Integer.parseInt(numbers[i]);
			}
			System.out.println(canJumpFast(array) == canJumpFastest(array));
//			System.out.println(canJump(array));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
