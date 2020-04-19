package dynamicProgramming;

public class RodCutting {
	public int rodCuttingBruteForce(int[] prices, int length) {
		if (length == 0)
			return 0;
		int price = Integer.MIN_VALUE;
		for (int i = 1; i <= length; i++) {
			price = Math.max(price, prices[i] + rodCuttingBruteForce(prices, length - i));
		}
		return price;
	}

	private int[] cutLength = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public int rodCuttingMemoized(int[] prices, int length, int[] memory) {
		if (length == 0)
			return length;
		else if (memory[length] >= 0)
			return memory[length];
		else {
			int price = Integer.MIN_VALUE;
			for (int i = 1; i <= length; i++) {
				int newPrice = prices[i] + rodCuttingMemoized(prices, length - i, memory);
				if (newPrice > price) {
					price = newPrice;
					cutLength[length] = i;
				}

			}
			memory[length] = price;
			return price;
		}
	}

	public void getOptimizedrodCuts(int[] prices, int length) {
		int[] memory = new int[length + 1];
		for (int i = 0; i <= length; i++)
			memory[i] = Integer.MIN_VALUE;
		int price = rodCuttingMemoized(prices, length, memory);
		System.out.println("Max price is: " + price);
		while (length > 0) {
			System.out.print(cutLength[length] + ", ");
			length = length - cutLength[length];
		}
	}

	public static void main(String[] args) {
		RodCutting rc = new RodCutting();
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		rc.getOptimizedrodCuts(prices, 8);
	}
}
