package arrays;

public class CeilingAndFloor {

	public static int findCeiling(double[] array, double key) {
		return binarySearch(array, 0, array.length - 1, Math.ceil(key));
	}

	public static int findFloor(double[] array, double key) {
		return binarySearch(array, 0, array.length - 1, (int) key);
	}

	private static int binarySearch(double[] array, int start, int end, double key) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (array[middle] == key)
				return middle;
			else if (array[middle] > key)
				return binarySearch(array, start, middle - 1, key);
			else
				return binarySearch(array, middle + 1, end, key);
		}
		return -1;
	}

	public static void main(String[] args) {
		double[] array = { 1.4, 2.2, 3.4, 4.6, 5.0, 6.1, 7.95, 8.1, 10.0, 10.9 };

		System.out.println(findCeiling(array, 4.6));
		System.out.println(findFloor(array, 10));
	}

}
