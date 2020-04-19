package recursion;

public class Binary {
	public static void generateBinary(int[] array, int n) {
		if (n < 0)
			System.out.println(array);
		else {
			array[n] = 0;
			generateBinary(array, n - 1);
			array[n] = 1;
			generateBinary(array, n - 1);
		}
	}
	
	
	public static void main(String[] args) {
		generateBinary(new int[3], 2);
	}
}
