package practice.graph.spanningTrees;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KruskalAlgorithmTests {

	@Test
	public void testMinimumSpanningWeight() {
		int n = 3;
		int[][] edges = new int[][] { { 0, 1, 2 }, { 1, 2, 4 }, { 2, 0, 5 } };
		assertEquals(6, KruskalAlgorithm.minSpanningWeight(n, edges));
		n = 9;
		edges = new int[][] {

				{ 0, 1, 4 }, { 0, 7, 8 }, { 1, 7, 11 }, { 1, 2, 8 }, { 7, 6, 1 }, { 6, 5, 2 }, { 8, 2, 2 }, { 2, 5, 4 },
				{ 2, 3, 7 }, { 3, 4, 9 }, { 3, 5, 14 }, { 4, 5, 10 }, { 7, 8, 7 }, { 8, 6, 6 }

		};

		assertEquals(37, KruskalAlgorithm.minSpanningWeight(n, edges));
	}
}
