package dynamicProgramming;

/**
 * 
 * A sequence of numbers is called a zig-zag sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a zig-zag sequence.
 * 
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5
 * and 1,7,4,5,5 are not zig-zag sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, sequence, return the length of the longest
 * subsequence of sequence that is a zig-zag sequence. A subsequence is obtained
 * by deleting some number of elements (possibly zero) from the original
 * sequence, leaving the remaining elements in their original order.
 * 
 * @author rajan-c
 *
 */
public class Zigzag {
	public static int longestZigZag(int[] sequence) {
		if (sequence.length <= 1)
			return sequence.length;
		int[][] memory = new int[sequence.length][2];

		memory[0] = new int[] { 1, 0 };
		for (int i = 1; i < sequence.length; i++) {
			int previous = i - 1;
			while (previous > 0) {
				if ((memory[previous][1] == 1 && sequence[i] - sequence[previous] < 0)
						|| (memory[previous][1] == -1 && sequence[i] - sequence[previous] > 0))
					break;
				previous--;
			}

			if (previous >= 0 && sequence[i] != sequence[previous])
				memory[i] = new int[] { memory[previous][0] + 1, sequence[i] - sequence[previous] > 0 ? 1 : -1 };
			else if (sequence[i] != sequence[0])
				memory[i] = new int[] { memory[0][0], sequence[i] - sequence[0] > 0 ? 1 : -1 };
			else
				memory[i] = memory[i - 1];
		}

		return memory[sequence.length - 1][0];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 7, 4, 9, 2, 5 };
		System.out.println(longestZigZag(nums));
		nums = new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(longestZigZag(nums));

		nums = new int[] { 44 };
		System.out.println(longestZigZag(nums));

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(longestZigZag(nums));

		nums = new int[] { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		System.out.println(longestZigZag(nums));

		nums = new int[] { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568,
				188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(longestZigZag(nums));

		nums = new int[] { 0, 0 };
		System.out.println(longestZigZag(nums));

	}
}
