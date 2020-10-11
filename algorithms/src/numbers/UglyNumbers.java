package numbers;

import java.util.ArrayList;
import java.util.List;

public class UglyNumbers {
	public static int nthUglyNumber(int n) {
		int count = 5, list3 = 3, list2 = 2, list5 = 5;
		List<Integer> uglyNumbers = new ArrayList<>();
		uglyNumbers.add(1);
		uglyNumbers.add(2);
		uglyNumbers.add(3);
		uglyNumbers.add(4);
		uglyNumbers.add(5);
		while (count < n) {
			int temp1 = list3 + 3, temp2 = list2 + 8, temp3 = list5 + 5;
			if (temp1 <= temp2 && temp1 <= temp3) {
				uglyNumbers.add(temp1);
				list3 = temp1;
			} else if (temp2 <= temp1 && temp2 <= temp3) {
				uglyNumbers.add(temp2);
				list2 = temp2;
			} else {
				uglyNumbers.add(temp3);
				list5 = temp3;
			}
			count++;
		}
		return uglyNumbers.get(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(nthUglyNumber(1));
		System.out.println(nthUglyNumber(2));
		System.out.println(nthUglyNumber(5));
		System.out.println(nthUglyNumber(10));
	}
}
