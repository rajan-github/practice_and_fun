package dynamicProgramming.practice;

import java.util.HashSet;
import java.util.Set;

public class UglyNumber2 {
	public int nthUglyNumber(int n) {
		if (n <= 5)
			return n;
		Set<Integer> set = new HashSet<>();
		int[] uglyNumbers = new int[n + 1];
		uglyNumbers[1] = 1;
		uglyNumbers[2] = 2;
		uglyNumbers[3] = 3;
		uglyNumbers[4] = 4;
		uglyNumbers[5] = 5;
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		int nthNumber = 5, computed = 5;
		;
		while (computed < n) {

		}
		return nthNumber;
	}
}
