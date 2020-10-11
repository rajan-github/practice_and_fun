package dynamicProgramming.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoinChange2 {
	public static int change(int amount, int[] coins) {
		Arrays.sort(coins);
		Set<Integer> coinSet = new HashSet<>();
		for (int coin : coins)
			coinSet.add(coin);
		int[] memory = new int[amount + 1];
		for (int i = 0; i < memory.length; i++)
			memory[i] = -1;
		int[] changeCount = new int[amount + 1];
		Set<String> changeSet = new HashSet<>();
		change(amount, coinSet, new ArrayList<>(), changeSet, 0);
		return changeSet.size();
	}

	private static void change(int amount, Set<Integer> coins, List<Integer> changes, Set<String> changeSet, int sum) {
		if (amount == sum) {
			List<Integer> clone = new ArrayList<>();
			for (int item : changes)
				clone.add(item);
			Collections.sort(clone);
			StringBuilder str = new StringBuilder();
			for (int item : clone)
				str.append(item);
			changeSet.add(str.toString());
		} else if (sum > amount)
			return;

		for (int item : coins) {
			if (amount >= item + sum) {
				changes.add(item);
				change(amount, coins, changes, changeSet, sum + item);
				changes.remove(changes.size() - 1);
			} else
				break;
		}

	}

	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 5 };
		System.out.println(change(6, coins));
		System.out.println(change(7, coins));
		System.out.println(change(500, coins));
	}
}
