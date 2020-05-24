package auxiliaryMethods;

public class CommonMethods {
	public static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}

	public static void display(int[][] nums) {
		for (int[] row : nums) {
			System.out.print("[");
			for (int item : row)
				System.out.print(item + ", ");
			System.out.println("]");
		}
	}
}
