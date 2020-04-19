package recursion;

public class Factorial {
public int factorial(int n) {
	if(n<=1)
		return 1;
	return n*factorial(n-1);
}

public static void main(String[] args) {
	System.out.printf("Factorial of 5 is: %d\n",new Factorial().factorial(5));
}
}
