package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A". Input: J = "aA", S = "aAAbbbb" Output: 3
 * 
 * Note: S and J will consist of letters and have length at most 50. The characters in
 * J are distinct.
 * 
 * @author rajan-c
 *
 */
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
		if (J == null || J.length() == 0)
			return 0;
		Set<Character> jewells = new HashSet<>();
		int count = 0, jewellLength = J.length(), stoneLength = S.length();
		for (int i = 0; i < jewellLength; i++)
			jewells.add(J.charAt(i));
		for (int i = 0; i < stoneLength; i++)
			if (jewells.contains(S.charAt(i)))
				count++;
		return count;
	}
}
