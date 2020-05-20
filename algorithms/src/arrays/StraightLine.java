package arrays;

/**
 * Check whether give coordinates fall in one line or not.
 * 
 * @author rajan-c
 *
 */
public class StraightLine {
	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length <= 2)
			return true;
		int x = coordinates[0][0], y = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1],
				x2 = coordinates[2][0], y2 = coordinates[2][1];

		for (int i = 2; i < coordinates.length; i++) {
			x2 = coordinates[i][0];
			y2 = coordinates[i][1];
			if ((y - y1) * (x2 - x1) != (x - x1) * (y2 - y1))
				return false;
			x = x1;
			y = y1;
			x1 = x2;
			y1 = y2;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] line = new int[][] { { -3, -2 }, { -1, -2 }, { 2, -2 }, { -2, -2 }, { 0, -2 } };
		System.out.println(checkStraightLine(line));
		System.out.println("-----------------------------");
		line = new int[][] { { 0, 1 }, { 1, 3 }, { -4, -7 }, { 5, 11 } };
		System.out.println(checkStraightLine(line));

		System.out.println("-----------------------------");
		line = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 } };
		System.out.println(checkStraightLine(line));

		System.out.println("-----------------------------");
		line = new int[][] { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 } };
		System.out.println(checkStraightLine(line));

		System.out.println("-----------------------------");
		line = new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
		System.out.println(checkStraightLine(line));
	}
}
