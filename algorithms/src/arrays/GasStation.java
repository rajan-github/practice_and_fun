package arrays;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once in the clockwise direction, otherwise return -1.
 * 
 * Note:
 * 
 * If there exists a solution, it is guaranteed to be unique. Both input arrays
 * are non-empty and have the same length. Each element in the input arrays is a
 * non-negative integer.
 * 
 * @author rajan-c
 *
 */
public class GasStation {

	public static int canCompleteCircuitLinear(int[] gas, int[] cost) {
		int index = 1, reserve = gas[0] - cost[gas.length - 1], start = 0;
		while (index < gas.length) {
			reserve += (gas[index] - cost[index - 1]);
			if ((gas[index] >= cost[index] && start < 0))
				start = index;
			index++;
		}
		return reserve >= 0 ? start : -1;
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0;
		while (start < gas.length) {
			if (gas[start] >= cost[start]) {
				if (canCompleteCircuit(gas, cost, start))
					return start;
			}
			start++;
		}
		return -1;
	}

	private static boolean canCompleteCircuit(int[] gas, int[] cost, int start) {
		int next = (start + 1) % gas.length;
		int reserve = gas[start];
		while (next != start) {
			reserve += (gas[next] - (next == 0 ? cost[cost.length - 1] : cost[next - 1]));
			if (reserve < cost[next])
				return false;
			next = (next + 1) % gas.length;
		}
		return reserve >= cost[next == 0 ? cost.length - 1 : next - 1];
	}

	public static void main(String[] args) {
		int[] gas = new int[] { 1, 2, 3, 4, 5 };
		int[] cost = new int[] { 3, 4, 5, 1, 2 };

		gas = new int[] { 5, 1, 2, 3, 4 };
		cost = new int[] { 4, 4, 1, 5, 1 };

//		gas = new int[] { 3, 1, 1 };
//		cost = new int[] { 1, 2, 2 };
		System.out.println(canCompleteCircuit(gas, cost));
		System.out.println(canCompleteCircuitLinear(gas, cost));
	}
}
