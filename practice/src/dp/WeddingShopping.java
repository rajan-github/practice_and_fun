package dp;

public class WeddingShopping {
	public static int maximumExpenditure(int budget, int[][] garments) {
		long maximumExpenditure = maximumExpenditure(budget, garments, 0);
		return (int) maximumExpenditure;
	}

	private static long maximumExpenditure(int budget, int[][] garments, int currentGarment) {
		if (currentGarment >= garments.length)
			return 0;

		if (budget <= 0)
			return Integer.MIN_VALUE;

		int[] models = garments[currentGarment];
		long expenditure = Integer.MIN_VALUE;
		for (int price : models) {
			if (price > budget)
				break;
			expenditure = Math.max(expenditure,
					price + maximumExpenditure(budget - price, garments, currentGarment + 1));
		}
		return expenditure;
	}

	public static void main(String[] args) {
		int ans = maximumExpenditure(20, new int[][] { { 4, 6, 8 }, { 5, 10 }, { 1, 3, 5, 5 } });
		System.out.println(ans);
		ans = maximumExpenditure(9, new int[][] { { 4, 6, 8 }, { 5, 10 }, { 1, 3, 5, 5 } });
		System.out.println(ans);
	}
}
