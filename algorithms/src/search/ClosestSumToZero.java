package search;

public class ClosestSumToZero {
	public static int findClosestSumToZero(int[] array) {
		array = MergeSort.mergeSort(array, 0, array.length - 1);
		int optimizedSum = array[0] + array[array.length - 1], left = 0, right = array.length - 1;
		while (left < right && optimizedSum != 0) {
			if (optimizedSum < 0) {
				optimizedSum = array[++left] + array[right];
			} else {
				optimizedSum = array[left] + array[--right];
			}
		}
		return optimizedSum;
	}

	public static void main(String[] args) {
		System.out.println(findClosestSumToZero(new int[] { -2, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
	}

}
