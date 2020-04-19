package numbers;

public class ClosestDivisors {
	public int[] closestDivisors(int num) {
		int num1 = num + 1, num2 = num + 2;
		int divisors1 = 1, divisor2 = Integer.MAX_VALUE;
		for (int i = (int) Math.sqrt(num2); i >= 1; i--) {
			if (num1 % i == 0 || num2 % i == 0) {
				if (Math.abs(i - divisor2) <= Math.abs(divisors1 - divisor2)) {
					divisors1 = i;
					divisor2 = (num1 % i) == 0 ? (num1 / i) : (num2 / i);
				}
			}
		}
		return new int[] { divisor2, divisors1 };
	}

	public static void main(String[] args) {
		ClosestDivisors cd = new ClosestDivisors();
		int[] result = cd.closestDivisors(1);
		System.out.println(result[0] + ", " + result[1]);
	}
}
