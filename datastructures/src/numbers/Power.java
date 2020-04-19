package numbers;

/**
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * 
 * @author rajan-c
 *
 */
public class Power {

	public static double myPow(double x, int n) {
		if (n == 0 || x == 1)
			return 1;
		else if (n < 0) {
			double temp = power(x, Math.abs(n));
			return (1 / temp);
		} else {
			return power(x, n);
		}
	}

	private static double power(double x, long n) {
		n = Math.abs(n);
		double result = x;
		long power = 1;

		while (power * 4 < n) {
			result *= (result * result * result);
			power *= 4;
		}
		n -= power;
		power = 1;

		double temp = x;
		while (power * 2 < n) {
			temp *= temp;
			power *= 2;
		}

		if (power > 1) {
			n -= power;
			result *= temp;
		}
		while (n > 0) {
			result *= x;
			n--;
		}
		return result;
	}

	public static void main(String[] args) {
//		System.out.println(myPow(2.00000, 10));
//		System.out.println(myPow(2.10000, 3));
//		System.out.println(myPow(2.00000, -2));
//		System.out.println(myPow(0.00001, 2147483647));
//		System.out.println(myPow(1, -2147483648));
//		System.out.println(myPow(2, -2147483648));

		System.out.println(myPow(2, 100) == Math.pow(2, 100));
		System.out.println(myPow(100, 1000) == Math.pow(100, 1000));
		System.out.println(myPow(25, 899) == Math.pow(25, 899));
		System.out.println(myPow(69, 9999) == Math.pow(69, 9999));
		System.out.println(myPow(8999, 7997) == Math.pow(8999, 7997));
		System.out.println(myPow(2, 100) == Math.pow(2, 100));
		System.out.println(myPow(2, 10));
		System.out.println(Math.pow(2, 10));
		System.out.println(myPow(2, Integer.MAX_VALUE) == Math.pow(2, Integer.MAX_VALUE));
		System.out.println(myPow(100, Integer.MAX_VALUE) == Math.pow(100, Integer.MAX_VALUE));
		System.out.println(myPow(2, Integer.MIN_VALUE) == Math.pow(2, Integer.MIN_VALUE));
		System.out.println(myPow(100, Integer.MIN_VALUE) == Math.pow(100, Integer.MIN_VALUE));
		System.out.println(myPow(-100, Integer.MIN_VALUE) == Math.pow(-100, Integer.MIN_VALUE));
	}
}
