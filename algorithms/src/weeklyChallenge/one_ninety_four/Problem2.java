package weeklyChallenge.one_ninety_four;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of strings names of size n. You will create n folders in your
 * file system such that, at the ith minute, you will create a folder with the
 * name names[i].
 * 
 * Since two files cannot have the same name, if you enter a folder name which
 * is previously used, the system will have a suffix addition to its name in the
 * form of (k), where, k is the smallest positive integer such that the obtained
 * name remains unique.
 * 
 * Return an array of strings of length n where ans[i] is the actual name the
 * system will assign to the ith folder when you create it. Input: names =
 * ["gta","gta(1)","gta","avalon"] Output: ["gta","gta(1)","gta(2)","avalon"]
 * Input: names = ["kaido","kaido(1)","kaido","kaido(1)"] Output:
 * ["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
 * 
 * @author rajan-c
 *
 */
public class Problem2 {
	public static String[] getFolderNames(String[] names) {
		Set<String> usedNames = new HashSet<>();
		Map<String, Integer> offsetMap = new HashMap<>();
		String[] folderNames = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			if (!usedNames.contains(names[i])) {
				usedNames.add(names[i]);
				folderNames[i] = names[i];
				offsetMap.put(names[i], 0);
			} else {
				int offset = 0;
				if (offsetMap.containsKey(names[i])) {
					offset = offsetMap.get(names[i]) + 1;
				} else {
					offset = offsetMap.get(names[i].substring(0, names[i].length() - 3));
				}
				String name = names[i], newName = name + "(" + offset + ")";
				while (usedNames.contains(newName)) {
					offset = offset + 1;
					newName = name + "(" + offset + ")";
				}
				usedNames.add(newName);
				offsetMap.put(names[i], offset);
				offsetMap.put(newName, 0);
				folderNames[i] = newName;
			}
		}
		return folderNames;
	}

	public static void main(String[] args) {
		System.out.println(getFolderNames(new String[] { "kaido", "kaido(1)", "kaido", "kaido(1)", "kaido(2)" }));
	}
}
