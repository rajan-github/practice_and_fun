package heap.practice;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * 
 * Each turn, we choose the two heaviest stones and smash them together. Suppose
 * the stones have weights x and y with x <= y. The result of this smash is:
 * 
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight
 * x is totally destroyed, and the stone of weight y has new weight y-x. At the
 * end, there is at most 1 stone left. Return the weight of this stone (or 0 if
 * there are no stones left.)
 * 
 * @author rajan-c
 *
 */
public class LastStoneWeight {
	public static int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length == 0)
			return 0;
		else if (stones.length == 1)
			return stones[0];
		Heap heap = new Heap(stones);
		while (heap.getSize() > 1) {
			int firstMax = heap.extractMax();
			int secondMax = heap.extractMax();
			if (firstMax != secondMax) {
				heap.insert(Math.abs(secondMax - firstMax));
			}
		}
		if (heap.isEmpty())
			return 0;
		else
			return heap.extractMax();
	}

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
	}
}
