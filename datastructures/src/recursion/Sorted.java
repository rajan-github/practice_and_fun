package recursion;

public class Sorted {
	public boolean isSorted(int[] array, int n) {
		if (n == 0)
			return true;
		else
			return array[n] >= array[n - 1] && isSorted(array, n - 1);
	}
	
	public static void main(String[] arg) {
		int a[]= {1,2,3,4,4,7};
		System.out.println("Is sorted: "+ new Sorted().isSorted(a, 5));
	}
}
