package dynamicProgramming;

/**
 * Given a sequence of words, and a limit on the number of characters that can
 * be put in one line (line width). Put line breaks in the given sequence such
 * that the lines are printed neatly. Assume that the length of each word is
 * smaller than the line width.
 * 
 * The word processors like MS Word do task of placing line breaks. The idea is
 * to have balanced lines. In other words, not have few lines with lots of extra
 * spaces and some lines with small amount of extra spaces.
 * 
 * @author rajan-c
 *
 */
public class WordWrap {

	public static void wordWrap(int lineCapacity, String text) {
		int[] wordLengths = getWordsLength(text);
		long[] memory = new long[wordLengths.length + 1];
		int[] breakPoints = new int[wordLengths.length + 1];
		for (int i = 0; i < memory.length; i++)
			memory[i] = -1;
		wordWrap(lineCapacity, wordLengths, 0, breakPoints, memory);
		printText(text, breakPoints);
	}

	private static long wordWrap(int lineCapacity, int[] wordLengths, int startIndex, int[] breakPoints,
			long[] memory) {
		if (startIndex >= wordLengths.length)
			return 0;
		if (memory[startIndex] >= 0)
			return memory[startIndex];
		long minWaste = Integer.MAX_VALUE;
		int breakPoint = -1;
		for (int index = startIndex; index < wordLengths.length; index++) {
			long temp = wasteSpace(lineCapacity, startIndex, index, wordLengths)
					+ wordWrap(lineCapacity, wordLengths, index + 1, breakPoints, memory);
			if (temp < minWaste) {
				minWaste = temp;
				breakPoint = index;
			}
		}
		memory[startIndex] = minWaste;
		breakPoints[startIndex] = breakPoint;
		return minWaste;
	}

	private static void printText(String text, int[] breakPoints) {
		String[] words = text.split(" ");
		int startPoint = 0, endPoint = 0;
		outer: for (int i = 0; i < breakPoints.length - 1 && startPoint < words.length;) {
			endPoint = breakPoints[startPoint];
			while (startPoint <= endPoint)
				System.out.print(words[startPoint++] + " ");
			System.out.println();
			if (breakPoints[i] >= 0)
				i = breakPoints[i];
			else {
				System.out.println("Cannot print text!");
				break outer;
			}
		}
	}

	private static int[] getWordsLength(String text) {
		String[] words = text.split(" ");
		int[] wordLengths = new int[words.length];
		for (int i = 0; i < words.length; i++)
			wordLengths[i] = words[i].length();
		return wordLengths;
	}

	private static int sum(int[] wordLength, int i, int j) {
		int sum = 0;
		for (int index = i; index <= j; index++)
			sum += wordLength[index];
		return sum;
	}

	private static int wasteSpace(int maxCharacters, int i, int j, int[] wordLengths) {
		int space = maxCharacters - (j - i) - sum(wordLengths, i, j);
		return space < 0 ? Integer.MAX_VALUE : (int) Math.pow(space, 3);
	}

	public static void main(String[] args) {
//		wordWrap(6, "aaa bb cc ddddd");
//		wordWrap(15, "Geeks for Geeks presents word wrap problem");
//		wordWrap(5, "Geeks Geeks Geeks GeeksGeeks");
		wordWrap(20,
				"Science is what we understand well enough to explain to a computer. Art is everything else we do");
	}
}
