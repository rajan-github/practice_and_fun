package cp3.chapter3.compleSearch;

public class Problem7 {
	public static void openCreditSystem(int[] array) {
		int maxDiff = array[0] - array[1];
		int maxSoFar = array[0];
		for (int i = 1; i < array.length; i++) {
			maxDiff = Math.max(maxDiff, maxSoFar - array[i]);
			maxSoFar = Math.max(maxSoFar, array[i]);
		}
		System.out.println(maxDiff);
	}

	public static void main(String[] args) {
		openCreditSystem(new int[] { 100, 20 });
		openCreditSystem(new int[] { 4, 3, 2, 1 });
		openCreditSystem(new int[] { 1, 2, 3, 4 });
	}
}
