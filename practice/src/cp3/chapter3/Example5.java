package cp3.chapter3;

/**
 * Given a list l containing 1 ≤ n ≤ 20 integers, is there a subset of list l
 * that sums to another given integer X?
 * 
 * @author rajan-c
 *
 */
public class Example5 {
	public static boolean findSubset(int n, int target) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = i + 1;
		for (int i = 1; i < (1 << n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) > 0)
					sum += array[j];
			}
			if (sum == target)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(findSubset(20, 16));
	}
}
