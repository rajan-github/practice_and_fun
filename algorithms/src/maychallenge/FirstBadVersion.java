package maychallenge;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * @author rajan-c
 *
 */
public class FirstBadVersion {

	private static boolean isBadVersion(long i) {
		return i > 1702766718;
	}

	public int firstBadVersion(int n) {
		return (int) binarySearch(n, 1, n);
	}

	private static long binarySearch(int n, long start, long end) {
		if (start <= end && start <= n) {
			long middle = (start + end) / 2;
			if ((middle == 1 && isBadVersion(middle)) || (!isBadVersion(middle - 1) && isBadVersion(middle)))
				return middle;
			else if (isBadVersion(middle) && (middle > 0 && isBadVersion(middle - 1)))
				return binarySearch(n, start, middle - 1);
			else
				return binarySearch(n, middle + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
	}
}
