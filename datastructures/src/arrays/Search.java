package arrays;

public class Search {
	public int binarySearch(int[] array, int key, int start, int end) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (array[middle] == key)
				return middle;
			else if (array[middle] > key)
				return binarySearch(array, key, start, middle - 1);
			else
				return binarySearch(array, key, middle + 1, end);
		} else
			return -1;
	}

	public int numberOfAppearance(int[] array, int key, int start, int end) {
		int index = binarySearch(array, key, start, end);
		int left = index, right = index;
		if (end - start > 2) {
			while (left > 0 && array[left] == key)
				left = left / 2;
			left = left * 2;
			while (left > 0 && array[left] == key)
				left--;
//			left++;
			while (right < end && array[right] == key)
				right = right * 2;
			right = right / 2;
			while (right < end && array[right] == key)
				right++;
//			right--;	
		} else {
			left = left == 0 ? left : left - 1;
//			right=right==0?right
		}
		return right - left + 1;
	}

	public static void main(String[] args) {
		Search search = new Search();
//		int[] array = { 1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 99, 100 };
		int[] array = { 9, 9 };
//		System.out.println("Found at: " + search.binarySearch(array, 9, 0, 1));
//		System.out.println("Found at: " + search.binarySearch(array, 100, 0, 18));
//		System.out.println("Found at: " + search.binarySearch(array, 1, 0, 18));
		System.out.println("Found at: " + search.numberOfAppearance(array, 9, 0, 1));
	}
}
