package dynamicProgramming.practice2.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * In a previous life, you worked as a cashier in the lost Antarctican colony of
 * Nadiria, spending the better part of your day giving change to your
 * customers. Because paper is a very rare and valuable resource in Antarctica,
 * cashiers were required by law to use the fewest bills possible whenever they
 * gave change. Thanks to the numerological predilections of one of its
 * founders, the currency of Nadiria, called Dream-Dollars, was available in the
 * following denominations: $1, $4, $7, $13, $28, $52, $91, and $365.
 * 
 * @author rajan-c
 *
 */
public class Problem1 {
	private static int[] bills = new int[] { 1, 4, 7, 13, 28, 52, 91, 365 };

	/**
	 * Greedy method implementation.
	 * 
	 * @param amount
	 * @return
	 */
	public static int minimumBillsGreedy(int amount) {
		int billCount = 0;
		while (amount > 0) {
			int bill = getLargestBill(amount);
			amount -= bill;
			billCount++;
		}
		return billCount;
	}

	private static int getLargestBill(int amount) {
		for (int index = bills.length - 1; index >= 0; index--)
			if (bills[index] <= amount)
				return bills[index];
		return -1;
	}

	public static int minimumBillsRecursive(int amount) {
		Set<Integer> denominations = new HashSet<>();
		for (int bill : bills)
			denominations.add(bill);
		if (amount <= 0)
			return 0;
		return minimumBillsRecursive(amount, denominations);
	}

	private static int minimumBillsRecursive(int amount, Set<Integer> denominations) {
		if (amount == 0)
			return 0;
		else if (denominations.contains(amount))
			return 1;
		int index = 0, billCount = Integer.MAX_VALUE;
		while (bills[index] <= amount) {
			billCount = Math.min(billCount, 1 + minimumBillsRecursive(amount - bills[index], denominations));
			index++;
		}
		return billCount;
	}

	public static int minimumBills(int amount) {
		if (amount <= 0)
			return 0;
		long[] billCount = new long[amount + 1];
		for (int i = 0; i < billCount.length; i++)
			billCount[i] = Integer.MAX_VALUE;
		billCount[0] = 0;
		for (int i = 0; i < bills.length && bills[i] < billCount.length; i++)
			billCount[bills[i]] = 1;

		for (int i = 1; i <= amount; i++) {
			int j = 0;
			long count = Integer.MAX_VALUE;
			while (j < bills.length && bills[j] <= i) {
				count = Math.min(count, 1 + billCount[i - bills[j]]);
				j++;
			}
			billCount[i] = count;
		}

		return (int) billCount[amount];
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 1000; i++) {
			if (minimumBillsGreedy(i) != minimumBills(i)) {
				System.out.println(i);
//				return;
			}
		}
	}
}
