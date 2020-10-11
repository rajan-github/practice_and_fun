package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public static void permutations(int[] array) {
		List<int[]> permutations = new ArrayList<>();
		permutations(array, 0, permutations);
		for (int[] permute : permutations)
			System.out.println(Arrays.toString(permute));
	}

	private static void permutations(int[] array, int index, List<int[]> permutationList) {
		if (array.length - index <= 2) {
			int[] clone = new int[array.length];
			for (int i = 0; i < array.length; i++)
				clone[i] = array[i];
			permutationList.add(clone);
			clone = new int[array.length];
			for (int i = 0; i < array.length; i++)
				clone[i] = array[i];
			swap(clone, clone.length - 2, clone.length - 1);
			permutationList.add(clone);
		} else {
			for (int i = index; i < array.length; i++) {
				swap(array, i, index);
				permutations(array, index + 1, permutationList);
				swap(array, i, index);
			}
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4 };
		permutations(array);
	}
}
