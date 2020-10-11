package cp3.chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class Example2 {
	public static void subsets(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		if (nums.length == 6) {
			System.out.println(Arrays.toString(nums));
			return;
		}

		for (int i = 0; i < nums.length - 5; i++) {
			for (int j = i + 1; j < nums.length - 4; j++) {
				for (int k = j + 1; k < nums.length - 3; k++) {
					for (int l = k + 1; l < nums.length - 2; l++) {
						for (int m = l + 1; m < nums.length - 1; m++) {
							for (int n = m + 1; n < nums.length; n++) {
								System.out.println("[" + nums[i] + "," + nums[j] + "," + nums[k] + "," + nums[l] + ","
										+ nums[m] + "," + nums[n] + "]");
							}
						}
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int count = scanner.nextInt();
			int[] array = new int[count];
			for (int i = 0; i < count; i++)
				array[i] = scanner.nextInt();
			subsets(array);
		}
	}
}
