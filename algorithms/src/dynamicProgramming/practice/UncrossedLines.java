package dynamicProgramming.practice;

/**
 * We write the integers of A and B (in the order they are given) on two
 * separate horizontal lines.
 * 
 * Now, we may draw connecting lines: a straight line connecting two numbers
 * A[i] and B[j] such that:
 * 
 * A[i] == B[j]; The line we draw does not intersect any other connecting
 * (non-horizontal) line. Note that a connecting lines cannot intersect even at
 * the endpoints: each number can only belong to one connecting line.
 * 
 * Return the maximum number of connecting lines we can draw in this way. Input:
 * A = [1,4,2], B = [1,2,4] Output: 2
 * 
 * @author rajan-c
 *
 */
public class UncrossedLines {

	public static int maxUncrossedLinesIterative(int[] A, int[] B) {
		if (A == null || B == null || A.length == 0 || B.length == 0)
			return 0;
		int[][] memory = new int[A.length][B.length];
		for (int row = 0; row < memory.length; row++) {
			for (int col = 0; col < memory[0].length; col++) {
				if (A[row] == B[col]) {
					if (row > 0 && col > 0)
						memory[row][col] = 1 + memory[row - 1][col - 1];
					else
						memory[row][col] = 1;
				} else {
					if (row > 0 && col > 0)
						memory[row][col] = max(memory[row - 1][col], memory[row][col - 1], memory[row - 1][col - 1]);
					else if (row > 0)
						memory[row][col] = memory[row - 1][col];
					else if (col > 0)
						memory[row][col] = memory[row][col - 1];
				}
			}
		}
		return memory[A.length - 1][B.length - 1];
	}

	private static int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= c && b >= a)
			return b;
		return c;
	}

	public static int maxUncrossedLines(int[] A, int[] B) {
		if (A == null || B == null || A.length == 0 || B.length == 0)
			return 0;
		return maxUncrossedLines(A, B, 0, 0);
	}

	public static int maxUncrossedLines(int[] A, int[] B, int indexA, int indexB) {
		if (indexA >= A.length || indexB >= B.length)
			return 0;
		int index = findCross(A, B, indexA, indexB);
		if (index >= 0) {
			return Math.max(1 + maxUncrossedLines(A, B, indexA + 1, index + 1),
					maxUncrossedLines(A, B, indexA + 1, indexB));
		} else
			return maxUncrossedLines(A, B, indexA + 1, indexB);
	}

	private static int findCross(int[] A, int[] B, int indexA, int startIndexB) {
		int item = A[indexA];
		while (startIndexB < B.length && B[startIndexB] != item)
			startIndexB++;
		return startIndexB < B.length ? startIndexB : -1;
	}

	public static void main(String[] args) {
		int[] A = { 1, 4, 3 }, B = { 1, 2, 4 };
		System.out.println(maxUncrossedLines(A, B));
		System.out.println(maxUncrossedLinesIterative(A, B));
		A = new int[] { 2, 5, 1, 2, 5 };
		B = new int[] { 10, 5, 2, 1, 5, 2 };
		System.out.println(maxUncrossedLines(A, B));
		System.out.println(maxUncrossedLinesIterative(A, B));
		A = new int[] { 1, 3, 7, 1, 7, 5 };
		B = new int[] { 1, 9, 2, 5, 1 };
		System.out.println(maxUncrossedLines(A, B));
		System.out.println(maxUncrossedLinesIterative(A, B));
	}
}
