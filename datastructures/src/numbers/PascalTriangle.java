package numbers;

import java.util.ArrayList;
import java.util.List;

import auxiliarymethods.Display;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 * 
 * @author rajan-c
 *
 */
public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		if (numRows > 0) {
			List<Integer> level = new ArrayList<>();
			level.add(1);
			triangle.add(level);
			for (int i = 1; i < numRows; i++) {
				List<Integer> previousLevel = triangle.get(triangle.size() - 1);
				level = new ArrayList<>();
				level.add(previousLevel.get(0));
				int size = previousLevel.size(), j = 0;
				for (j = 0; j < size - 1; j++) {
					level.add(previousLevel.get(j) + previousLevel.get(j + 1));
				}
				level.add(previousLevel.get(j));
				triangle.add(level);
			}
		}
		return triangle;
	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = generate(5);
		Display.display(triangle);
	}
}
