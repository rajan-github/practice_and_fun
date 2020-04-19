package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * Parsing a given text string S according to a given context-free grammar G is
 * the algorithmic problem of constructing a parse tree of rule substitutions
 * defining S as a single nonterminal symbol of G. We assume that the text
 * string S has length n while the grammar G itself is of constant size.Further,
 * we assume that the definitions of each rule are in Chomsky normal form. This
 * means that the right sides of every nontrivial rule consists of (a) exactly
 * two nonterminals, i.e. X → Y Z, or (b) exactly one terminal symbol, X → α.
 * 
 * @author rajan-c
 *
 */
public class ParsingAString {

	/**
	 * DP Solution
	 * 
	 * @param variable
	 * @param productions
	 * @param str
	 * @param memory
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public static boolean isStringParsable(String variable, Map<String, String[]> productions, String str,
			boolean[][] memory, int startIndex, int endIndex) {
		if (str == null || str.length() == 0)
			return true;
		else if (startIndex > endIndex || endIndex > str.length())
			return false;
		else if (startIndex == endIndex) {
			memory[startIndex + 1][endIndex + 1] = search(productions.get(variable),
					str.substring(startIndex, endIndex + 1));
			return memory[startIndex + 1][endIndex + 1];
		}
		boolean parsed = false;
		String[] productionRightEnd = productions.get(variable);
		parsed = search(productionRightEnd, str.substring(startIndex, endIndex + 1));
		if (parsed) {
			memory[startIndex + 1][endIndex + 1] = true;
			return true;
		}

		for (String productionBody : productionRightEnd) {
			if (isVariable(productionBody)) {
				for (int i = startIndex; i < endIndex; i++) {
					parsed = parsed
							|| (isStringParsable(productionBody.charAt(0) + "", productions, str, memory, startIndex, i)
									&& isStringParsable(productionBody.charAt(1) + "", productions, str, memory, i + 1,
											endIndex));
					if (parsed) {
						memory[startIndex][endIndex] = parsed;
						return true;
					}
				}
			}
		}
		return parsed;
	}

	/**
	 * BruteForce method with the help of recursion.
	 * 
	 * @param variable
	 * @param productions
	 * @param str
	 * @return
	 */
	public static boolean isStringParsable1(String variable, Map<String, String[]> productions, String str) {
		if (str == null)
			return true;
		else {
			boolean parsed = false;
			String[] productionRightEnd = productions.get(variable);
			parsed = search(productionRightEnd, str);
			if (parsed)
				return parsed;

			for (String productionBody : productionRightEnd) {
				if (isVariable(productionBody)) {
					for (int i = 0; i < str.length(); i++) {
						parsed = parsed
								|| (isStringParsable1(productionBody.charAt(0) + "", productions, str.substring(0, i))
										&& isStringParsable1("" + productionBody.charAt(1), productions,
												str.substring(i, str.length())));
						if (parsed)
							return parsed;
					}
				}
			}
			return parsed;
		}
	}

	private static boolean isVariable(String productionRightEnd) {
		if (productionRightEnd.charAt(0) >= 97 && productionRightEnd.charAt(0) <= 122)
			return false;
		return true;
	}

	private static boolean search(String[] strArray, String str) {
		for (String item : strArray)
			if (item.equals(str))
				return true;
		return false;
	}

	public static void main(String[] args) {
		Map<String, String[]> productions = new HashMap<>();
		productions.put("A", new String[] { "BC" });
		productions.put("B", new String[] { "BB", "b" });
		productions.put("C", new String[] { "CC", "c" });
		String str = "b";
		boolean[][] memory = new boolean[str.length() + 1][str.length() + 1];
		memory[0][0] = true;
		System.out.println(isStringParsable1("A", productions, "b") == isStringParsable("A", productions, str, memory,
				0, str.length() - 1));
		str = "bc";
		memory = new boolean[str.length() + 1][str.length() + 1];
		memory[0][0] = true;
		System.out.println(isStringParsable1("A", productions, "bc") == isStringParsable("A", productions, str, memory,
				0, str.length() - 1));

		str = "bbbccc";
		memory = new boolean[str.length() + 1][str.length() + 1];
		memory[0][0] = true;
		System.out.println(isStringParsable1("A", productions, str) == isStringParsable("A", productions, str, memory,
				0, str.length() - 1));

		str = "bbbbbbbb";
		memory = new boolean[str.length() + 1][str.length() + 1];
		memory[0][0] = true;
		System.out.println(isStringParsable1("A", productions, str) == isStringParsable("A", productions, str, memory,
				0, str.length() - 1));

		str = "bbbbbbbc";
		memory = new boolean[str.length() + 1][str.length() + 1];
		memory[0][0] = true;
		System.out.println(isStringParsable1("A", productions, str) == isStringParsable("A", productions, str, memory,
				0, str.length() - 1));

		str = "cccccccccccccccccc";
		memory = new boolean[str.length() + 1][str.length() + 1];
		memory[0][0] = true;
		System.out.println(isStringParsable1("A", productions, str) == isStringParsable("A", productions, str, memory,
				0, str.length() - 1));
	}

}
