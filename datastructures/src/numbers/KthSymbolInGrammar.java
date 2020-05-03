package numbers;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the
 * previous row and replace each occurrence of 0 with 01, and each occurrence of
 * 1 with 10.
 * 
 * Given row N and index K, return the K-th indexed symbol in row N. (The values
 * of K are 1-indexed.) (1 indexed).
 * 
 * @author rajan-c
 *
 */
public class KthSymbolInGrammar {
	public static int kthGrammar(int n, int k) {
		if (n == 1)
			return 0;
		else {
			return nthRow(n, k) ? 1 : 0;
		}
	}

	private static boolean nthRow(int n, int k) {
		if (n == 2)
			return k == 1 ? false : true;
		else if (n == 3) {
			boolean[] results = { false, true, true, false };
			return results[k - 1];
		}
		int length = (int) (Math.pow(2, n - 1));
		if (k <= length / 2)
			return nthRow(n - 1, k);
		else if (k > length / 2 && k <= (3 * length) / 4)
			return nthRow(n - 1, (int) (k - length / 2 + (Math.pow(2, n - 3))));
		else
			return nthRow(n - 1, k - (3 * length / 4));
	}

	public static void main(String[] args) {
//		System.out.println(kthGrammar(1, 1));
		System.out.println(kthGrammar(2, 1));
		System.out.println(kthGrammar(2, 2));
		System.out.println(kthGrammar(4, 5));
		System.out.println(kthGrammar(30, 434991989));

//		System.out.println(nthRow(2, 1));
//		System.out.println(nthRow(2, 2));
//		System.out.println(nthRow(3, 1));
//		System.out.println(nthRow(3, 2));
//		System.out.println(nthRow(3, 3));
//		System.out.println(nthRow(3, 4));
		System.out.println(nthRow(4, 1));
		System.out.println(nthRow(4, 2));
		System.out.println(nthRow(4, 3));
		System.out.println(nthRow(4, 4));
		System.out.println(nthRow(4, 5));
		System.out.println(nthRow(4, 6));
		System.out.println(nthRow(4, 7));
		System.out.println(nthRow(4, 8));
		System.out.println(nthRow(30, 434991989));

//		kthGrammar(2, 1);
//		System.out.println();
//		kthGrammar(3, 1);
//		System.out.println();
//		kthGrammar(4, 1);
//		System.out.println();
//		kthGrammar(5, 1);
//		System.out.println();
	}
}
