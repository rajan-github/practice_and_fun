package auxiliarymethods;

import java.util.List;

public class Display {

	public static void display(List<List<Integer>> lists) {
		for (List<Integer> list : lists)
			System.out.println(list);
	}

	public static void display(int[] array) {
		System.out.print("[");
		for (int item : array)
			System.out.print(item + ", ");
		System.out.println("]");
	}
}
