package weeklyChallenge.one_ninety_three;

import auxiliaryMethods.CommonMethods;

public class Problem3 {
	public static int minDays(int[] bloomDay, int m, int k) {
		int[][] memory = new int[bloomDay.length][bloomDay.length];

		for (int length = 0; length < k; length++) {
			for (int row = 0; row < bloomDay.length - length; row++) {
				int col = row + length;
				if (length == 0)
					memory[row][col] = bloomDay[row];
				else
					memory[row][col] = Math.max(memory[row][col - 1], memory[col][col]);
			}
		}

		int maxDays = Integer.MIN_VALUE;
		while (m > 0) {
			int minRow = 0, minCol = 0;
			for (int row = 0; row < (bloomDay.length - k + 1); row += (k - 1)) {
				int col = row + k - 1;
				if (memory[row][col] < memory[minRow][minCol]) {
					minRow = row;
					minCol = col;
				}
			}
			maxDays = Math.max(maxDays, memory[minRow][minCol]);
			memory[minRow][minCol] = Integer.MAX_VALUE;
			m--;
		}

		CommonMethods.display(memory);
		return maxDays;
	}

	public static void main(String[] args) {
		System.out.println(minDays(new int[] { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 }, 4, 3));
	}
}
