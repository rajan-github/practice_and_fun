package numbers;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Note that in some languages such as Java, there is no unsigned integer type.
 * In this case, both input and output will be given as signed integer type and
 * should not affect your implementation, as the internal binary representation
 * of the integer is the same whether it is signed or unsigned. In Java, the
 * compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 2 above the input represents the signed integer -3 and
 * the output represents the signed integer -1073741825.
 * 
 * @author rajan-c
 *
 */
public class ReverseBits {
	public static int reverseBits(int n) {
		int[] binary = convertToBinary(n);
		long reverseNumber = 0;
		int length = binary.length - 1, index = length;
		while (index >= 0) {
			reverseNumber += (binary[index] * Math.pow(2, length - index));
			index--;
		}
		return (int) reverseNumber;
	}

	private static int[] convertToBinary(long n) {
		int length = 32;
		boolean isNegative = n < 0;
		n = Math.abs(n);
		int[] binary = new int[length];
		int index = 0;
		while (n > 0) {
			binary[index++] = (int) (n & 1);
			n = n >> 1;
		}
		if (isNegative) {
			int carry = 0;
			index = 0;
			while (index < binary.length) {
				binary[index] = 1 - binary[index];
				if (index == 0) {
					carry = (binary[index] + 1) / 2;
					binary[index] = (binary[index] + 1) % 2;
				} else {
					int newCarry = (binary[index] + carry) / 2;
					binary[index] = (binary[index] + carry) % 2;
					carry = newCarry;
				}
				index++;
			}
		}
		return binary;
	}

	public static long convertToInteger(String str) {
		int length = str.length() - 1, index = length;
		long number = 0;
		while (index >= 0) {
			char c = str.charAt(index);
			number += (Character.digit(c, 2) * Math.pow(2, length - index));
			index--;
		}
		return number;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(-2147483648));
//		System.out.println(convertToInteger("11111111111111111111111111111101"));
//		System.out.println(convertToInteger("10000000000000000000000000000000"));
//		Display.display(convertToBinary(3));
	}
}
