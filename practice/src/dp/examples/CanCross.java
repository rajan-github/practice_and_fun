package dp.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but it
 * must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1,
 * k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * 
 * @author rajan-c
 *
 */
public class CanCross {
	public boolean canCross(int[] stones) {
		if (stones == null || stones.length == 0)
			return false;
		if (stones[1] != 1)
			return false;
		Map<List<Integer>, Boolean> dp = new HashMap<>();
		return canCross(stones, 1, 1, dp);
	}

	private boolean canCross(int[] stones, int index, int k, Map<List<Integer>, Boolean> dp) {
		if (index >= stones.length - 1)
			return true;
		List<Integer> variables = Arrays.asList(index, k);
		if (dp.containsKey(variables))
			return dp.get(variables);
		boolean canCross = false;
		int nextIndex = findIndex(stones, k + stones[index]);
		if (nextIndex > index)
			canCross = canCross || canCross(stones, nextIndex, k, dp);
		nextIndex = findIndex(stones, 1 + k + stones[index]);
		if (nextIndex > index)
			canCross = canCross || canCross(stones, nextIndex, k + 1, dp);
		nextIndex = findIndex(stones, k - 1 + stones[index]);
		if (nextIndex > index)
			canCross = canCross || canCross(stones, nextIndex, k - 1, dp);
		dp.put(variables, canCross);
		return canCross;
	}

	private int findIndex(int[] stones, int target) {
		int start = 0, end = stones.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (stones[middle] == target && (middle == stones.length - 1 || stones[middle + 1] != target))
				return middle;
			else if (stones[middle] > target)
				end = middle - 1;
			else
				start = middle + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 0, 1, 3, 5, 6, 8, 12, 17 };
		System.out.println(new CanCross().canCross(array));
	}

}
