package bitOperations;

public class BitOperations {
	public static void main(String[] args) {
		int i = 17;
		System.out.println(i >>= 2);
		int j = 3;
		i = 34;
		i |= (1 << j);
		System.out.println(i);

		System.out.println(i & (1 << j));

		System.out.println(i & ~(1 << j));

		System.out.println(i ^ (1 << 2));
	}
}
