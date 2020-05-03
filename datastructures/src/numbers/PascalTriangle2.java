package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * 
 * @author rajan-c
 *
 */
public class PascalTriangle2 {
	public static List<Integer> generate(int rowIndex) {
		if (rowIndex >= 0) {
			List<Integer> level = new ArrayList<>(), previousLevel = null;
			level.add(1);
			previousLevel = level;
			for (int i = 0; i < rowIndex; i++) {
				level = new ArrayList<>();
				level.add(previousLevel.get(0));
				int size = previousLevel.size(), j = 0;
				for (j = 0; j < size - 1; j++) {
					level.add(previousLevel.get(j) + previousLevel.get(j + 1));
				}
				level.add(previousLevel.get(j));
				previousLevel = level;
			}
			return previousLevel;
		}
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		System.out.println(generate(4));
	}
}
