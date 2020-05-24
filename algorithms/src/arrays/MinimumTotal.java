package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle.
 * 
 * @author rajan-c
 *
 */
public class MinimumTotal {
	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;

		Integer[][] memory = new Integer[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
		for (int row = 0; row < memory.length; row++) {
			for (int col = 0; col < memory[0].length; col++)
				memory[row][col] = null;
		}

		memory[memory.length - 1][memory[0].length - 1] = 0;
		return minimumTotal(triangle, 0, 0, memory);
	}

	public static int minimumTotal(List<List<Integer>> triangle, int i, int j, Integer[][] memory) {
		if (i >= triangle.size())
			return 0;
		else if (memory[i][j] != null)
			return memory[i][j];
		else if (i == 0) {
			memory[i][j] = triangle.get(0).get(0) + minimumTotal(triangle, i + 1, j, memory);
			return memory[i][j];
		} else if (j == 0) {
			memory[i][j] = Math.min((triangle.get(i).get(j)) + minimumTotal(triangle, i + 1, j, memory),
					(triangle.get(i).get(j + 1) + minimumTotal(triangle, i + 1, j + 1, memory)));
			return memory[i][j];
		} else if (j < triangle.get(i).size() - 1) {
			memory[i][j] = min(Integer.MAX_VALUE, triangle.get(i).get(j) + minimumTotal(triangle, i + 1, j, memory),
					triangle.get(i).get(j + 1) + minimumTotal(triangle, i + 1, j + 1, memory));
			return memory[i][j];
		} else {
			memory[i][j] = Math.min(Integer.MAX_VALUE,
					triangle.get(i).get(j) + minimumTotal(triangle, i + 1, j, memory));
			return memory[i][j];
		}
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= c && b <= a)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);

		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);

		List<Integer> list3 = new ArrayList<>();
		list3.add(6);
		list3.add(5);
		list3.add(7);

		List<Integer> list4 = new ArrayList<>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);

		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);

		System.out.println(minimumTotal(triangle));
	}
}
