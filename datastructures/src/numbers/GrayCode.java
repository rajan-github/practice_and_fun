package numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rajan-c
 *
 */
public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<int[]> grayCodesBinary = new ArrayList<>();
		List<Integer> grayCodes = new ArrayList<>();
		if (n > 0) {
			grayStrings(0, new int[n], grayCodesBinary);

			for (int[] grayCode : grayCodesBinary)
				grayCodes.add(covertBinaryToDecimal(grayCode));
		} else if (n == 0)
			grayCodes.add(0);
		return grayCodes;
	}

	private static void grayStrings(int k, int[] nums, List<int[]> permutations) {
		if (k >= nums.length) {
			int[] grayCode = new int[nums.length];
			grayCode[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				grayCode[i] = (nums[i] ^ nums[i - 1]);
			}
			permutations.add(grayCode);
			return;
		}

		nums[k] = 0;
		grayStrings(k + 1, nums, permutations);
		nums[k] = 1;
		grayStrings(k + 1, nums, permutations);
	}

	private static int covertBinaryToDecimal(int[] binary) {
		int decimal = 0;
		int index = binary.length - 1;
		while (index >= 0) {
			decimal += binary[index] * (Math.pow(2, (binary.length - 1 - index)));
			index--;
		}
		return decimal;
	}

	public static void main(String[] args) {

		System.out.println(grayCode(2));
		System.out.println(grayCode(0));

//		System.out.println(covertBinaryToDecimal(new int[] { 1, 0 }));
	}
}
