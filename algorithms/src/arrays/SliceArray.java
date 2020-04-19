package arrays;

public class SliceArray {
	public static int[] slice(int[] array, int start, int end) {
		if (array.length < (end - start))
			throw new IllegalArgumentException("Invalid argument!");
		int[] slice = new int[end - start];
		for (int i = start, index = 0; i < end; i++) {
			slice[index++] = array[i];
		}
		return slice;
	}

	public static void main(String[] args) {
		int[] slice = slice(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 0, 6);
		for (int item : slice)
			System.out.print(item + ", ");
	}
}
