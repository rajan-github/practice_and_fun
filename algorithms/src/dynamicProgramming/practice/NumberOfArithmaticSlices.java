package dynamicProgramming.practice;

import java.util.ArrayList;
import java.util.List;

public class NumberOfArithmaticSlices {
	public static int numberOfArithmeticSlices(int[] A) {
		int slicesCount = 0;
		if (A != null && A.length > 2) {
			List<int[]> arithmaticSlices = getArithmaticSequenceIndex(A);
			for (int[] slices : arithmaticSlices) {
				int sliceLength = slices[1] - slices[0] + 1;
				for (int i = 3; i <= sliceLength; i++) {
					if (i == 3)
						slicesCount += 1;
					else if (i == 4)
						slicesCount += 2;
					else
						slicesCount += (i - 2);
				}
			}
		}
		return slicesCount;
	}

	private static List<int[]> getArithmaticSequenceIndex(int[] array) {
		List<int[]> indexes = new ArrayList<>();
		int[] differences = new int[array.length - 1];
		for (int i = 1; i < array.length; i++)
			differences[i - 1] = array[i] - array[i - 1];

		int startIndex = 0, previousDiff = differences[0], i = 1;
		for (i = 1; i < differences.length; i++) {
			if (differences[i] != previousDiff) {
				if (i - startIndex >= 2)
					indexes.add(new int[] { startIndex, i });
				startIndex = i;
				previousDiff = differences[i];
			}
		}

		if (i - startIndex >= 2)
			indexes.add(new int[] { startIndex, i });

		return indexes;
	}

	public static void main(String[] args) {
		int count = numberOfArithmeticSlices(new int[] { 0, 1, 2, 3, 2, 4, 6, 7, 8, 9 });
		System.out.println(count);

		count = numberOfArithmeticSlices(new int[] { 7, 7, 7, 7, 7, 7 });
		System.out.println(count);

		count = numberOfArithmeticSlices(new int[] { 5, 4, 3, 2, 1 });
		System.out.println(count);
	}
}
