package numbers;

/**
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * @author rajan-c
 *
 */
public class Division {

	public int divide(int dividend, int divisor) {
		if (divisor == 1) {
			return dividend;
		} else {
			long quotient = 0, dividendL = dividend, divisorL = divisor;
			int sign = ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ? -1 : 1;
			dividendL = Math.abs(dividendL);
			divisorL = Math.abs(divisorL);
			while (dividendL >= divisorL) {
				dividendL -= divisorL;
				quotient++;
			}
			int quotientInt = (int) quotient;
			return quotientInt == quotient ? (quotientInt * sign) : ((int) (Math.pow(2, 31) - 1));
		}
	}

	public static void main(String[] args) {
		System.out.println(new Division().divide(10, 1));
		System.out.println(new Division().divide(-7, -3));
		System.out.println(new Division().divide(-2147483648, -1));
		System.out.println(new Division().divide(-2147483648, 1));
		System.out.println(new Division().divide(Integer.MIN_VALUE, -2));
	}
}
