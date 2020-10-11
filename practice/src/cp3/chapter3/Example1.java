package cp3.chapter3;

/**
 * Find and display all pairs of 5-digit numbers that collectively use the
 * digits 0 through 9 once each, such that the first number divided by the
 * second is equal to an integer N, where 2 ≤ N ≤ 79. That is, abcde / fghij =
 * N, where each letter represents a different digit. The first digit of one of
 * the numbers is allowed to be zero, e.g. for N = 62, we have 79546 / 01283 =
 * 62; 94736 / 01528 = 62.
 * 
 * @author rajan-c
 *
 */
public class Example1 {
	public static void findNumber(int n) {
		System.out.println("Processing request-");
		for (int fghij = 1234; fghij < 98765 / n; fghij++) {
			int temp, used = fghij < 10000 ? 1 : 0;
			int abcde = fghij * n;
			temp = fghij;
			while (temp > 0) {
				used |= 1 << (temp % 10);
				temp = temp / 10;
			}

			temp = abcde;
			while (temp > 0) {
				used |= 1 << (temp % 10);
				temp = temp / 10;
			}
			if (used == (1 << 10) - 1)
				System.out.println(abcde + ", " + fghij);
		}

	}

	public static void main(String[] args) {
		findNumber(2);
	}
}