package dynamicProgramming.practice;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0)
			return 0;
		long power = calculateMinimumHP(dungeon, 0, 0);
		System.out.println(power + ", " + Long.MIN_VALUE);
		if (power <= Integer.MIN_VALUE || power >= 0)
			return dungeon[0][0] < 0 ? (-1 * dungeon[0][0] + 1) : 1;
		power = Math.abs(power) + 1;
		return dungeon[0][0] < 0 ? Math.max(-1 * dungeon[0][0] + 1, (int) power) : (int) power;
	}

	private static long calculateMinimumHP(int[][] dungeon, int row, int col) {
		if (row >= dungeon.length - 1 && col >= dungeon[0].length - 1)
			return dungeon[row][col];
		long negativePower = Long.MIN_VALUE;
		if (row < dungeon.length - 1 && col < dungeon[0].length - 1) {
			long powerOnMovingDown = dungeon[row][col] + calculateMinimumHP(dungeon, row + 1, col);
			long powerOnMovingRight = dungeon[row][col] + calculateMinimumHP(dungeon, row, col + 1);
			if (powerOnMovingDown < 0)
				negativePower = Math.max(negativePower, powerOnMovingDown);
			if (powerOnMovingRight < 0)
				negativePower = Math.max(negativePower, powerOnMovingRight);
		} else if (col < dungeon[0].length - 1) {
			long powerOnMovingRight = dungeon[row][col] + calculateMinimumHP(dungeon, row, col + 1);
			if (powerOnMovingRight < 0)
				negativePower = Math.max(negativePower, powerOnMovingRight);
		} else if (row < dungeon.length - 1) {
			long powerOnMovingDown = dungeon[row][col] + calculateMinimumHP(dungeon, row + 1, col);
			if (powerOnMovingDown < 0)
				negativePower = Math.max(negativePower, powerOnMovingDown);
		}
		return negativePower;
	}

	public static void main(String[] args) {
		System.out.println(calculateMinimumHP(new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } }));
		System.out.println(calculateMinimumHP(new int[][] { { 2, 3, 3 }, { 5, 10, -1 }, { 10, 30, 5 } }));
		System.out.println(calculateMinimumHP(new int[][] { { 100 } }));
		System.out.println(calculateMinimumHP(new int[][] { { -3, 5 } }));
		System.out.println(calculateMinimumHP(new int[][] { { 0, 5 }, { -2, -3 } }));
	}
}
