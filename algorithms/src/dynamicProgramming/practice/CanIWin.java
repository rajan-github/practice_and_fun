package dynamicProgramming.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CanIWin {
	public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		List<Integer> commonPool = new LinkedList<>();
		for (int i = 1; i <= maxChoosableInteger; i++)
			commonPool.add(i);
		return canIWin(commonPool, true, desiredTotal);
	}

	private static boolean canIWin(List<Integer> commonPool, boolean isFirstPlayerTurn, int desiredTotal) {
		if (isFirstPlayerTurn && getMax(commonPool) >= desiredTotal)
			return true;
		else if ((commonPool.isEmpty() && desiredTotal > 0)
				|| (!isFirstPlayerTurn && getMax(commonPool) >= desiredTotal))
			return false;

		boolean canWin = !isFirstPlayerTurn;
		List<Integer> newSet = new ArrayList<>(commonPool);
		for (int i : newSet) {
			commonPool.remove(new Integer(i));
			if (isFirstPlayerTurn) {
				canWin = canWin || canIWin(commonPool, !isFirstPlayerTurn, desiredTotal - i);
				if (canWin) {
					commonPool.add(i);
					break;
				}
			} else
				canWin = canWin && canIWin(commonPool, !isFirstPlayerTurn, desiredTotal - i);
			commonPool.add(i);
		}
		return canWin;
	}

	private static int getMax(List<Integer> pool) {
		int max = Integer.MIN_VALUE;
		for (int i : pool)
			if (max < i)
				max = i;
		return max;
	}

	public static void main(String[] args) {
		System.out.println(canIWin(10, 11));
		System.out.println(canIWin(20, 1000));
		System.out.println(canIWin(20, 10));
		System.out.println(canIWin(10, 40));
		System.out.println(canIWin(18, 79));
	}
}
