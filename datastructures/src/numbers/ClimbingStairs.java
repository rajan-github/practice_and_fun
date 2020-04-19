package numbers;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * @author rajan-c
 *
 */
public class ClimbingStairs {
	public static int climbStairs(int n) {
		if (n <= 2)
			return n;
		int prev1 = 1, prev2 = 2, current = 3;
		for (int i = 3; i <= n; i++) {
			current = prev1 + prev2;
			prev1 = prev2;
			prev2 = current;
		}
		return current;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(0));
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
	}
}
