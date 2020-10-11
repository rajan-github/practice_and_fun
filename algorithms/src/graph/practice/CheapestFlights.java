package graph.practice;

/**
 * There are n cities connected by m flights. Each flight starts from city u and
 * arrives at v with a price w.
 * 
 * Now given all the cities and flights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst with
 * up to k stops. If there is no such route, output -1.
 * 
 * @author rajan-c
 *
 */
public class CheapestFlights {
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[][] weights = new int[n][n];
		long[][] memory = new long[n][k + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					weights[i][j] = 0;
				else
					weights[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				memory[i][j] = -1;
			}
		}

		for (int flight[] : flights)
			weights[flight[0]][flight[1]] = flight[2];

		long price;
		if (k > 0)
			price = findCheapestPrice(weights, src, dst, k, memory);
		else
			price = weights[src][dst];
		return price >= Integer.MAX_VALUE ? -1 : (int) price;
	}

	private static long findCheapestPrice(int[][] weights, int src, int dst, int k, long[][] memory) {
		if (k == 0)
			return weights[src][dst];
		if (memory[dst][k] >= 0 && memory[dst][k] < Integer.MAX_VALUE)
			return memory[dst][k];
		long cheapestPrice = weights[src][dst];
		for (int i = 0; i < weights.length; i++) {
			if (dst != i && weights[i][dst] < Integer.MAX_VALUE) {
				cheapestPrice = Math.min(cheapestPrice,
						weights[i][dst] + findCheapestPrice(weights, src, i, k - 1, memory));
			}
		}
		memory[dst][k] = cheapestPrice;
		return cheapestPrice;
	}

	public static void main(String[] args) {
//		System.out.println(findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));
//		System.out.println(findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 0));
//		System.out.println(findCheapestPrice(6, new int[][] { { 0, 1, 100 }, { 0, 2, 50 }, { 1, 3, 30 }, { 2, 4, 90 },
//				{ 2, 5, 30 }, { 3, 5, 1 }, { 0, 5, 150 } }, 0, 5, 0));
//		System.out.println(findCheapestPrice(6, new int[][] { { 0, 1, 20 }, { 0, 2, 50 }, { 1, 3, 30 }, { 2, 4, 90 },
//				{ 2, 5, 30 }, { 3, 5, 1 }, { 0, 5, 150 } }, 0, 5, 5));

//		System.out.println(findCheapestPrice(18, new int[][] { { 16, 1, 81 }, { 15, 13, 47 }, { 1, 0, 24 },
//				{ 5, 10, 21 }, { 7, 1, 72 }, { 0, 4, 88 }, { 16, 4, 39 }, { 9, 3, 25 }, { 10, 11, 28 }, { 13, 8, 93 },
//				{ 10, 3, 62 }, { 14, 0, 38 }, { 3, 10, 58 }, { 3, 12, 46 }, { 3, 8, 2 }, { 10, 16, 27 }, { 6, 9, 90 },
//				{ 14, 8, 6 }, { 0, 13, 31 }, { 6, 4, 65 }, { 14, 17, 29 }, { 13, 17, 64 }, { 12, 5, 26 }, { 12, 1, 9 },
//				{ 12, 15, 79 }, { 16, 11, 79 }, { 16, 15, 17 }, { 4, 0, 21 }, { 15, 10, 75 }, { 3, 17, 23 },
//				{ 8, 5, 55 }, { 9, 4, 19 }, { 0, 10, 83 }, { 3, 7, 17 }, { 0, 12, 31 }, { 11, 5, 34 }, { 17, 14, 98 },
//				{ 11, 14, 85 }, { 16, 7, 48 }, { 12, 6, 86 }, { 5, 17, 72 }, { 4, 12, 5 }, { 12, 10, 23 }, { 3, 2, 31 },
//				{ 12, 7, 5 }, { 6, 13, 30 }, { 6, 7, 88 }, { 2, 17, 88 }, { 6, 8, 98 }, { 0, 7, 69 }, { 10, 15, 13 },
//				{ 16, 14, 24 }, { 1, 17, 24 }, { 13, 9, 82 }, { 13, 6, 67 }, { 15, 11, 72 }, { 12, 0, 83 },
//				{ 1, 4, 37 }, { 12, 9, 36 }, { 9, 17, 81 }, { 9, 15, 62 }, { 8, 15, 71 }, { 10, 12, 25 }, { 7, 6, 23 },
//				{ 16, 5, 76 }, { 7, 17, 4 }, { 3, 11, 82 }, { 2, 11, 71 }, { 8, 4, 11 }, { 14, 10, 51 }, { 8, 10, 51 },
//				{ 4, 1, 57 }, { 6, 16, 68 }, { 3, 9, 100 }, { 1, 14, 26 }, { 10, 7, 14 }, { 8, 17, 24 }, { 1, 11, 10 },
//				{ 2, 9, 85 }, { 9, 6, 49 }, { 11, 4, 95 } }, 7, 2, 6));

		System.out.println(findCheapestPrice(10,
				new int[][] { { 0, 1, 20 }, { 1, 2, 20 }, { 2, 3, 30 }, { 3, 4, 30 }, { 4, 5, 30 }, { 5, 6, 30 },
						{ 6, 7, 30 }, { 7, 8, 30 }, { 8, 9, 30 }, { 0, 2, 9999 }, { 2, 4, 9998 }, { 4, 7, 9997 } },
				0, 9, 4));
	}

}
