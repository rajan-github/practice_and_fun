package auxiliarymethods;

import java.util.List;

public class Display {

	public static void display(List<List<Integer>> lists) {
		for (List<Integer> list : lists)
			System.out.println(list);
	}

}
