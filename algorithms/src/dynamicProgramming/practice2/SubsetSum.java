package dynamicProgramming.practice2;

public class SubsetSum {
	public static boolean subsetSum(int[] array, int target) {
		if (array == null || array.length == 0)
			return false;
		Boolean[][] memory = new Boolean[array.length][target + 1];
		return subsetSum(array, 0, target, memory);
	}

	private static boolean subsetSum(int[] array, int index, int target, Boolean[][] memory) {
		if (target == 0)
			return true;
		else if (index >= array.length && target != 0)
			return false;
		else if (target < 0)
			return false;
		else if (memory[index][target] != null)
			return memory[index][target];
		else {
			memory[index][target] = subsetSum(array, index + 1, target, memory)
					|| subsetSum(array, index + 1, target - array[index], memory);

			return memory[index][target];
		}
	}

	private static boolean subsetSumIterative(int[] array, int target) {
		if (target == 0)
			return true;

		boolean[][] memory = new boolean[array.length + 1][target + 1];
//		for (int i = 0; i <= target; i++)
//			memory[memory.length - 1][i] = false;
		memory[memory.length - 1][0] = true;

		for (int i = array.length - 1; i >= 0; i--) {
			memory[i][0] = true;
			for (int t = 1; t <= target; t++) {
				memory[i][t] = memory[i + 1][t];
				int diff = t - array[i];
				if (diff >= 0)
					memory[i][t] = memory[i][t] || memory[i + 1][diff];
			}
		}
		return memory[0][target];
	}

	public static void main(String[] args) {
		int array[] = new int[] { 1, 2, 5 };
		System.out.println(subsetSum(array, 5) + ", " + subsetSumIterative(array, 5));
		System.out.println(subsetSum(array, 17) + ", " + subsetSumIterative(array, 17));
		System.out.println(subsetSum(array, 23) + ", " + subsetSumIterative(array, 23));
		System.out.println(subsetSum(array, 200) + ", " + subsetSumIterative(array, 200));
		System.out.println(subsetSum(array, 4) + ", " + subsetSumIterative(array, 4));
	}
}
