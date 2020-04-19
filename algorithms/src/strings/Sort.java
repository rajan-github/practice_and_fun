package strings;

/**
 * Sorts the chars of the input string and returns string made of sorted char
 * order.
 * 
 * @author rajan-c
 *
 */
public class Sort {

	public static String sortString(String str) {
		if (str == null || str.length() == 0)
			return str;
		StringBuilder temp = new StringBuilder();
		char[] sortedChars = mergeSort(str.toCharArray(), 0, str.length() - 1);
		for (char c : sortedChars)
			temp.append(c);
		return temp.toString();
	}

	public static char[] mergeSort(char[] str, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			char[] leftArray = mergeSort(str, left, middle);
			char[] rightArray = mergeSort(str, middle + 1, right);
			return merge(leftArray, rightArray);
		}
		return new char[] { str[left] };
	}

	private static char[] merge(char[] leftArray, char[] rightArray) {
		int leftLength = leftArray.length, rightLength = rightArray.length;
		char[] merged = new char[leftLength + rightLength];
		int leftIndex = 0, rightIndex = 0, index = 0;

		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				merged[index++] = leftArray[leftIndex++];
			} else
				merged[index++] = rightArray[rightIndex++];
		}

		while (leftIndex < leftArray.length)
			merged[index++] = leftArray[leftIndex++];

		while (rightIndex < rightArray.length)
			merged[index++] = rightArray[rightIndex++];

		return merged;
	}

	public static void main(String[] args) {
		System.out.println(sortString("rja"));
		System.out.println(sortString("a"));
		System.out.println(sortString("ate"));
		System.out.println(sortString("cat"));
	}

}
