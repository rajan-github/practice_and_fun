package graph.practice;

import java.util.HashMap;
import java.util.Map;

public class SatisfiabilityOfEquations {
	public boolean equationsPossible(String[] equations) {
		Map<Character, Integer> charToColorMap = new HashMap<>();
		for (String equation : equations) {
			char var1 = equation.charAt(0), var2 = equation.charAt(3);
			boolean isEqual = equation.substring(1, 3).equals("==");
			if (var1 == var2) {
				if (isEqual)
					continue;
				else
					return false;
			}
			if (charToColorMap.containsKey(var1) && charToColorMap.containsKey(var2)) {
				if (isEqual && charToColorMap.get(var1) != charToColorMap.get(var2))
					return false;
				else if (!isEqual && charToColorMap.get(var1) == charToColorMap.get(var2))
					return false;
			} else if (!charToColorMap.containsKey(var1) && charToColorMap.containsKey(var2)) {
				if (isEqual)
					charToColorMap.put(var1, charToColorMap.get(var2));
				else
					charToColorMap.put(var1, (int) var1);
			} else if (charToColorMap.containsKey(var1) && !charToColorMap.containsKey(var2)) {
				if (isEqual)
					charToColorMap.put(var2, charToColorMap.get(var1));
				else
					charToColorMap.put(var2, (int) var2);
			} else {
				if (isEqual) {
					charToColorMap.put(var2, -1);
					charToColorMap.put(var1, -1);
				} else {
					charToColorMap.put(var2, (int) var2);
					charToColorMap.put(var1, (int) var1);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SatisfiabilityOfEquations sat = new SatisfiabilityOfEquations();
		System.out.println(sat.equationsPossible(new String[] { "a==b", "b!=a" }));
		System.out.println(sat.equationsPossible(new String[] { "a==b", "b==a" }));
		System.out.println(sat.equationsPossible(new String[] { "a==b", "b==c", "a==c" }));
		System.out.println(sat.equationsPossible(new String[] { "a==b", "b!=c", "c==a" }));
		System.out.println(sat.equationsPossible(new String[] { "c==c", "b==d", "x!=z" }));
		System.out.println(sat.equationsPossible(new String[] { "c!=c" }));
		System.out.println(sat.equationsPossible(new String[] { "c==c", "b==d", "c==b", "a==c", "a==d", "a!=e" }));
		System.out.println(sat.equationsPossible(new String[] { "a!=b", "b!=c", "c!=a" }));

	}
}
