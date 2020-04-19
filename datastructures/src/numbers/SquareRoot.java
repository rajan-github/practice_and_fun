package numbers;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 * 
 * @author rajan-c
 *
 */
public class SquareRoot {
	public static int mySqrt(int x) {
		if (x == 0)
			return 0;
		long sqrt = 1;
		while ((sqrt << 8) * (sqrt << 8) < x) {
			long temp = sqrt << 8;
			if (temp < Integer.MAX_VALUE)
				sqrt <<= 8;
			else
				break;
		}

		while ((sqrt << 4) * (sqrt << 4) < x) {
			long temp = sqrt << 4;
			if (temp < Integer.MAX_VALUE)
				sqrt <<= 4;
			else
				break;
		}

		while ((sqrt << 2) * (sqrt << 2) < x) {
			long temp = sqrt << 2;
			if (temp < Integer.MAX_VALUE)
				sqrt <<= 2;
			else
				break;
		}

		while ((sqrt << 1) * (sqrt << 1) < x) {
			long temp = sqrt << 1;
			if (temp < Integer.MAX_VALUE)
				sqrt <<= 1;
			else
				break;
		}

		while ((sqrt + 1) * (sqrt + 1) <= x) {
			long temp = sqrt + 1;
			if (temp < Integer.MAX_VALUE)
				sqrt += 1;
			else
				break;
		}

		if (sqrt * sqrt > x)
			sqrt--;
		return (int) sqrt;
	}

	public static void main(String[] args) {
		System.out.println(mySqrt(4) == Math.sqrt(4));
		System.out.println(mySqrt(1) == Math.sqrt(1));
		System.out.println(mySqrt(8) == (int) Math.sqrt(8));
		System.out.println(mySqrt(10) == (int) Math.sqrt(10));
		System.out.println(mySqrt(10000000) == (int) Math.sqrt(10000000));
		System.out.println(mySqrt(Integer.MAX_VALUE) == (int) Math.sqrt(Integer.MAX_VALUE));
	}
}
