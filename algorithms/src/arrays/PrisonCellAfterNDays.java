package arrays;

import java.util.Arrays;

public class PrisonCellAfterNDays {
	public static int[] prisonAfterNDays(int[] cells, int N) {
		if (cells == null || cells.length == 0)
			return cells;
		int[][] array = new int[2][cells.length];
		int cellsIndex = 0, cellsCopyIndex = 1;
		for (int i = 0; i < cells.length; i++)
			array[cellsIndex][i] = cells[i];

		for (int day = 1; day <= N; day++) {
			array[cellsCopyIndex][0] = 0;
			array[cellsCopyIndex][cells.length - 1] = 0;
			for (int i = 1; i < cells.length - 1; i++)
				array[cellsCopyIndex][i] = 1 - (array[cellsIndex][i - 1] ^ array[cellsIndex][i + 1]);

			cellsCopyIndex = 1 - cellsCopyIndex;
			cellsIndex = 1 - cellsIndex;
			 System.out.println(Arrays.toString(array[cellsIndex]));
		}
		return array[cellsIndex];
	}

	public static void main(String[] args) {
		int[] cells = new int[] { 1, 0, 0, 1, 0, 0, 1, 0 };
		System.out.println(Arrays.toString(prisonAfterNDays(cells, 300)));
	}
}
