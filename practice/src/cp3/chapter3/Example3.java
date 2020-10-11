package cp3.chapter3;

/**
 * Let us look at a boring mathematics problem. :-) We have three different
 * integers, x, y and z, which satisfy the following three relations: • x + y +
 * z = A • xyz = B • x 2 + y 2 + z 2 = C You are asked to write a program that
 * solves for x, y and z for given values of A, B and C
 * 
 * @author rajan-c
 *
 */
public class Example3 {

	public static void simpleEquations(int a, int b, int c) {
		for (int i = -100; i <= 100; i++) {
			for (int j = -100; j <= 100; j++) {
				for (int k = -100; k <= 100; k++) {
					if (i != j && j != k && (i * j * k == b && i + j + k == a && i * i + j * j + k * k == c)) {
						System.out.println(i + ", " + j + ", " + k);
						return;
					}
				}
			}
		}
		System.out.println("No solution found!");
	}

	public static void main(String[] args) {
		simpleEquations(1, 2, 3);
		simpleEquations(6, 6, 14);
	}
}
