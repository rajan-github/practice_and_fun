package dynamicProgramming.practice;

import auxiliaryMethods.CommonMethods;

public class RemoveBoxes {
	public static int removeBoxes(int[] boxes) {
		if (boxes.length == 0)
			return 0;
		int total = Integer.MIN_VALUE;
		for (int i = 0; i < boxes.length; i++) {
			int[] newArray = removeSameColor(boxes, i);
			total = Math.max(total, (int) Math.pow(newArray.length - boxes.length, 2) + removeBoxes(newArray));
		}
		return total;
	}

	private static int[] removeSameColor(int[] boxes, int i) {
		int num = boxes[i], index;
		for (index = i + 1; index < boxes.length; index++) {
			if (boxes[index] != num)
				break;
		}
		index = index - 1;
		if (i <= index) {
			int[] array = new int[boxes.length - (index - i + 1)];
			for (int j = 0, k = 0; j < boxes.length; j++)
				if (j < i || j > index) {
					array[k++] = boxes[j];
				}
			return array;
		}
		return boxes;
	}

	public static void main(String[] args) {
//		int[] array = removeSameColor(new int[] { 1, 3, 2, 2, 2, 3, 4, 3, 1 }, 2);
//		CommonMethods.display(array);
		System.out.println(removeBoxes(new int[] { 1, 3, 2, 2, 2, 3, 4, 3, 1 }));
	}

}
