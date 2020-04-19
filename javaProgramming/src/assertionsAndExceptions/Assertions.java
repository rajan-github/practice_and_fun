package assertionsAndExceptions;

public class Assertions {
	public static void temp(int n) {
		assert (n >= 0);
		System.out.println("Number is: " + n);
	}

	public static void main(String[] args) {
		temp(-1);
		temp(1);
	}
}
