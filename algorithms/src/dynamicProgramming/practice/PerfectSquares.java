package dynamicProgramming.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * @author rajan-c
 *
 */
public class PerfectSquares {
	public static int numSquares(int n) {
		if (n == 0)
			return 0;
		Map<Integer, Integer> memory = new HashMap<>();
		return numSquares(n, sqaureList(n), memory);
	}

	private static int numSquares(int n, List<Integer> squares, Map<Integer, Integer> memory) {
		if (n == 0)
			return 0;
		if (memory.containsKey(n))
			return memory.get(n);
		int count = Integer.MAX_VALUE;
		for (int item : squares) {
			if (item <= n)
				count = Math.min(count, 1 + numSquares(n - item, squares, memory));
			else
				break;

		}
		memory.put(n, count);
		return count;
	}

	private static List<Integer> sqaureList(int n) {
		List<Integer> squares = new ArrayList<>();
		int sqrt = 1, square = 1;
		while (square <= n) {
			squares.add(square);
			sqrt += 1;
			square = sqrt * sqrt;
		}
		return squares;
	}

	public static int numSquaresBottom(int n) {
		if (n == 0)
			return 0;
		int memory[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			memory[i] = i;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				int next = j * j;
				memory[i] = Math.min(memory[i], 1 + memory[i - next]);
			}
		}

		return memory[n];
	}

	public static void main(String[] args) {
		System.out.println(numSquares(12) == numSquaresBottom(12));
		System.out.println(numSquares(13) == numSquaresBottom(13));
		System.out.println(numSquares(25) == numSquaresBottom(25));
	}

}
