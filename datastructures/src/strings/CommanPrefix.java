package strings;

public class CommanPrefix {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder cPrefix = new StringBuilder("");
		if (strs.length > 0) {
			int minLength = Integer.MAX_VALUE;
			int i = 0;
			while (i < strs.length) {
				if (strs[i].length() < minLength)
					minLength = strs[i].length();
				i++;
			}
			for (i = 0; i < minLength; i++) {
				for (int j = 1; j < strs.length; j++) {
					if (strs[0].charAt(i) != strs[j].charAt(i)) {
						cPrefix.append(strs[0].substring(0, i));
						return cPrefix.toString();
					}
				}
			}
			if (i == minLength) {
				cPrefix.append(strs[0].substring(0, i));
			}

		}
		return cPrefix.toString();
	}

	public static void main(String[] args) {
		CommanPrefix cp = new CommanPrefix();
		System.out.println(cp.longestCommonPrefix(new String[] { "c", "c", "" }));
	}
}
