package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstring {
	public static String longestDupSubstring(String s) {
		if (s == null || s.length() == 0)
			return "";
		int length = s.length();
		Map<Character, List<Integer>> indexMap = new HashMap<>();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (!indexMap.containsKey(c))
				indexMap.put(c, new ArrayList<>());
			indexMap.get(c).add(i);
		}
		StringBuilder maxSubstring = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (indexMap.get(c).size() > 1) {
				StringBuilder temp = subString(i, indexMap.get(c), s);
				if (temp.length() > maxSubstring.length())
					maxSubstring = temp;
			}
		}
		return maxSubstring.toString();
	}

	private static StringBuilder subString(int currentIndex, List<Integer> indexList, String str) {
		StringBuilder maxSubstring = new StringBuilder();
		int i = 0, listSize = indexList.size(), stringLength = str.length();
		while (i < listSize && indexList.get(i++) <= currentIndex)
			;
		i -= 1;
		while (i < listSize) {
			if (indexList.get(i) != currentIndex) {
				int index = indexList.get(i);
				char c1 = str.charAt(currentIndex), c2 = str.charAt(index);
				int leftIndex = currentIndex + 1;
				index++;
				StringBuilder duplicate = new StringBuilder();
				while (c1 == c2 && index < stringLength && leftIndex < stringLength) {
					duplicate.append(c1);
					c1 = str.charAt(index);
					c2 = str.charAt(leftIndex);
					index++;
					leftIndex++;
				}
				if (c1 == c2)
					duplicate.append(c1);
				if (duplicate.length() > maxSubstring.length())
					maxSubstring = duplicate;
			}
			i++;
		}
		return maxSubstring;
	}

	public static void main(String[] args) {
		System.out.println(longestDupSubstring("banana"));
		System.out.println(longestDupSubstring("abcda"));
		System.out.println(longestDupSubstring(
				"moplvidmaagmsiyyrkchbyhivlqwqsjcgtumqscmxrxrvwsnjjvygrelcbjgbpounhuyealllginkitfaiviraqcycjmskrozcdqylbuejrgfnquercvghppljmojfvylcxakyjxnampmakyjbqgwbyokaybcuklkaqzawageypfqhhasetugatdaxpvtevrigynxbqodiyioapgxqkndujeranxgebnpgsukybyowbxhgpkwjfdywfkpufcxzzqiuglkakibbkobonunnzwbjktykebfcbobxdflnyzngheatpcvnhdwkkhnlwnjdnrmjaevqopvinnzgacjkbhvsdsvuuwwhwesgtdzuctshytyfugdqswvxisyxcxoihfgzxnidnfadphwumtgdfmhjkaryjxvfquucltmuoosamjwqqzeleaiplwcbbxjxxvgsnonoivbnmiwbnijkzgoenohqncjqnckxbhpvreasdyvffrolobxzrmrbvwkpdbfvbwwyibydhndmpvqyfmqjwosclwxhgxmwjiksjvsnwupraojuatksjfqkvvfroqxsraskbdbgtppjrnzpfzabmcczlwynwomebvrihxugvjmtrkzdwuafozjcfqacenabmmxzcueyqwvbtslhjeiopgbrbvfbnpmvlnyexopoahgmwplwxnxqzhucdieyvbgtkfmdeocamzenecqlbhqmdfrvpsqyxvkkyfrbyolzvcpcbkdprttijkzcrgciidavsmrczbollxbkytqjwbiupvsorvkorfriajdtsowenhpmdtvamkoqacwwlkqfdzorjtepwlemunyrghwlvjgaxbzawmikfhtaniwviqiaeinbsqidetfsdbgsydkxgwoqyztaqmyeefaihmgrbxzyheoegawthcsyyrpyvnhysynoaikwtvmwathsomddhltxpeuxettpbeftmmyrqclnzwljlpxazrzzdosemwmthcvgwtxtinffopqxbufjwsvhqamxpydcnpekqhsovvqugqhbgweaiheeicmkdtxltkalexbeftuxvwnxmqqjeyourvbdfikqnzdipmmmiltjapovlhkpunxljeutwhenrxyfeufmzipqvergdkwptkilwzdxlydxbjoxjzxwcfmznfqgoaemrrxuwpfkftwejubxkgjlizljoynvidqwxnvhngqakmmehtvykbjwrrrjvwnrteeoxmtygiiygynedvfzwkvmffghuduspyyrnftyvsvjstfohwwyxhmlfmwguxxzgwdzwlnnltpjvnzswhmbzgdwzhvbgkiddhirgljbflgvyksxgnsvztcywpvutqryzdeerlildbzmtsgnebvsjetdnfgikrbsktbrdamfccvcptfaaklmcaqmglneebpdxkvcwwpndrjqnpqgbgihsfeotgggkdbvcdwfjanvafvxsvvhzyncwlmqqsmledzfnxxfyvcmhtjreykqlrfiqlsqzraqgtmocijejneeezqxbtomkwugapwesrinfiaxwxradnuvbyssqkznwwpsbgatlsxfhpcidfgzrc"));
		System.out.println(longestDupSubstring("aaaa"));
	}
}
