package dynamicProgramming.practice;

import auxiliaryMethods.CommonMethods;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * @author rajan-c
 *
 */
public class CountBits {
	public static int[] countBits(int num) {
		int[] bitCount = new int[num + 1];
		if (num >= 1)
			bitCount[1] = 1;
		if (num >= 2)
			bitCount[2] = 1;
		if (num >= 3)
			bitCount[3] = 2;
		if (num >= 4)
			bitCount[4] = 1;
		if (num >= 5)
			bitCount[5] = 2;
		for (int i = 6; i <= num; i++) {
			if ((i & 1) == 1)
				bitCount[i] = bitCount[i - 1] + 1;
			else
				bitCount[i] = bitCount[(i >> 1)];
		}
		return bitCount;
	}

	public static void main(String[] args) {
		CommonMethods.display(countBits(5));
		CommonMethods.display(countBits(2));
		CommonMethods.display(countBits(15));
	}
}
