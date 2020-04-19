package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import search.MergeSort;

/**
 * Develop an algorithm to find the longest monotonically increasing subsequence
 * within a sequence of n numbers.
 * 
 * @author rajan-c
 *
 */
public class LongestIncreasingSequence {
	/**
	 * Find the longest monotonically increasing subsequence length.
	 * 
	 * @param nums
	 * @return
	 */
	public static int longestIncreasingSequence(int[] nums) {
		int[] sortedSequence = MergeSort.mergeSort(nums, 0, nums.length - 1);
		LISEntry[][] memory = new LISEntry[nums.length + 1][nums.length + 1];
		rowInitialize(memory);
		colInitialize(memory);

		for (int i = 1; i < memory.length; i++) {
			for (int j = 1; j < memory.length; j++) {
				if (nums[i - 1] == sortedSequence[j - 1])
					memory[i][j] = new LISEntry(1 + memory[i - 1][j - 1].getLength(), Direction.BACK_UP);
				else {
					if (memory[i - 1][j].getLength() >= memory[i][j - 1].getLength())
						memory[i][j] = new LISEntry(memory[i - 1][j].getLength(), Direction.UP);
					else
						memory[i][j] = new LISEntry(memory[i][j - 1].getLength(), Direction.BACKWARD);
				}
			}
		}
		reconstructSolution(memory, nums);
		return memory[memory.length - 1][memory.length - 1].getLength();
	}

	/**
	 * Reconstruct the actual solution from the memory computed by
	 * longestIncreasingSequence method.
	 * 
	 * @param memory
	 * @param sortedInput
	 */
	private static void reconstructSolution(LISEntry[][] memory, int[] nums) {
		int row = memory.length - 1, col = memory.length - 1;
		List<Integer> number = new ArrayList<>();
		while (row > 0 && col > 0) {
			if (memory[row][col].getDirection().equals(Direction.BACK_UP)) {
				number.add(0, nums[row - 1]);
				row--;
				col--;
			} else if (memory[row][col].getDirection().equals(Direction.BACKWARD))
				col--;
			else
				row--;
		}
		System.out.println(number);
	}

	private static void rowInitialize(LISEntry[][] memory) {
		for (int i = 0; i < memory.length; i++)
			memory[0][i] = new LISEntry(0, Direction.UP);
	}

	private static void colInitialize(LISEntry[][] memory) {
		for (int i = 0; i < memory.length; i++)
			memory[i][0] = new LISEntry(0, Direction.BACKWARD);
	}

	public static void main(String[] args) {
		System.out.println(longestIncreasingSequence(new int[] { 2, 4, 3, 5, 1, 7, 6, 9, 8 }));
		System.out.println(longestIncreasingSequence(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
	}
}

class LISEntry {
	private int length;
	private Direction direction;

	public LISEntry(int len, Direction dir) {
		this.length = len;
		this.direction = dir;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}

enum Direction {
	BACKWARD, UP, BACK_UP;
}