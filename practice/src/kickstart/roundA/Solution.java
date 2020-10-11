package kickstart.roundA;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class solution {
	public static int maxBeautiValue(List<int[]> stackList, int plates) {
		if (plates == 0)
			return 0;
		return 0;
	}

	private static int maxBeautiValue(List<int[]> stackList, int plates, int[] stackIndex) {
		int stackSize = stackList.get(0).length;
		int beautiValue = 0;
		int remainingPlates = plates;
		for (int stack = 0; stack < stackIndex.length; stack++) {
			int[] data = stackList.get(stack);

			if (remainingPlates > 0) {
				for (int plate = 0; plate <= stackSize; plate++) {
					stackIndex[stack] += plate;
					for (int j = 0; j < plate; j++)
						beautiValue += data[j];
					remainingPlates -= plate;
				}
			}

		}
		return 0;
	}

	public static void main(String[] args) {
		List<int[]> stackList = new ArrayList<>();
		try (Scanner scanner = new Scanner(System.in)) {
			int tests = scanner.nextInt();
			for (int i = 0; i < tests; i++) {
				int stackCount = scanner.nextInt();
				int stackSize = scanner.nextInt();
				int plates = scanner.nextInt();
				for (int j = 0; j < stackCount; j++) {
					int[] stack = new int[stackSize];
					stackList.add(stack);
					for (int k = 0; k < stackSize; k++) {
						stack[k] = scanner.nextInt();
					}
				}
			}
		}
	}
}
