package search;

public class JumpSearch {

	public static int jumpSearch(int[] array, int length, int key) {
		int index = -1, i = 0;
		int jumpSize = (int) Math.sqrt(length);
		while (array[i] < key)
			i += jumpSize;
		for (int j = i - jumpSize; j >= 0 && j <= i && i <= length; j++) {
			if (array[j] == key) {
				index = j;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int index = jumpSearch(new int[] { 1, 2, 3, 4, 4, 5, 5 }, 6, 5);
		System.out.printf("Found at indes: %d", index);
	}
}
