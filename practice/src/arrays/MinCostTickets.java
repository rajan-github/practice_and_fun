package arrays;

import java.util.Arrays;

public class MinCostTickets {
	public static int mincostTickets(int[] days, int[] costs) {
		if (days == null || days.length == 0)
			return 0;
		int[] memory = new int[days.length];
		Arrays.fill(memory, -1);
		return mincostTickets(days, costs, 0, memory);
	}

	private static int mincostTickets(int[] days, int[] costs, int leaveIndex, int memory[]) {
		if (leaveIndex >= days.length)
			return 0;
		if (memory[leaveIndex] >= 0)
			return memory[leaveIndex];
		int mincost = Integer.MAX_VALUE;
		int nextIndex = nextDay(days, leaveIndex, 1);
		mincost = Math.min(mincost, mincostTickets(days, costs, nextIndex, memory) + costs[0]);
		nextIndex = nextDay(days, leaveIndex, 7);
		mincost = Math.min(mincost, mincostTickets(days, costs, nextIndex, memory) + costs[1]);
		nextIndex = nextDay(days, leaveIndex, 30);
		mincost = Math.min(mincost, mincostTickets(days, costs, nextIndex, memory) + costs[2]);
		memory[leaveIndex] = mincost;
		return mincost;
	}

	private static int nextDay(int[] days, int currentIndex, int dayCount) {
		int allowedLeave = days[currentIndex] + dayCount - 1, i = currentIndex + 1;
		for (; i < days.length;) {
			int nextLeave = days[i];
			if (allowedLeave >= nextLeave)
				i++;
			else
				break;
		}
		currentIndex = i;
		return currentIndex;
	}

	public static void main(String[] args) {
		int[] days = new int[] { 1, 4, 6, 7, 8, 20 };
		int[] costs = new int[] { 2, 7, 15 };
//		System.out.println(nextDay(days, 3, 7));
		System.out.println(mincostTickets(days, costs));
	}

}
