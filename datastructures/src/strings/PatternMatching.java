package strings;

public class PatternMatching {
	public boolean isMatching(String s, String p) {
		boolean matched = true;
		if (!p.equals(".*") && s != null) {
			int index = 0, pIndex = 0;
			char lastPatternChar = '\0';
			while (index < s.length() && pIndex < p.length()) {
				if (s.charAt(index) == p.charAt(pIndex)) {
					lastPatternChar = p.charAt(pIndex);
					index++;
					pIndex++;
				} else if (p.charAt(pIndex) == '*' && (lastPatternChar == '.' || lastPatternChar == s.charAt(index)))
					index++;
				else if (p.charAt(pIndex) != s.charAt(index)
						&& (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*')) {
					pIndex += 2;
					lastPatternChar = '\0';
				} else if (false) {

				}
			}
		} else if (p == null)
			matched = false;
		return matched;
	}

}
