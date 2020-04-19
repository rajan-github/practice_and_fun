package numbers;

public class ReverseNumber {
	public static int reverseNumber(int n) {
		int reverse = 0;
		long temp;
		while (n != 0) {
			temp = (long) reverse * 10 + (n % 10);
			if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
				reverse = 0;
				break;
			} else {
				reverse = (int) temp;
				n = n / 10;
			}
		}
		return reverse;
	}

	public static void main(String[] args) {
		System.out.println(reverseNumber(1534236469));
		System.out.println(Integer.MAX_VALUE);
	}
}
