package strings;

/**
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1; if version1 < version2 return -1;otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character.
 * 
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * 
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 * 
 * You may assume the default revision number for each level of a version number
 * to be 0. For example, version number 3.4 has a revision number of 3 and 4 for
 * its first and second level revision number. Its third and fourth level
 * revision number are both 0. Note: Version strings are composed of numeric
 * strings separated by dots . and this numeric strings may have leading zeroes.
 * Version strings do not start or end with dots, and they will not be two
 * consecutive dots.
 * 
 * 
 * @author rajan-c
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] versionParts1 = version1.split("[.]"), versionParts2 = version2.split("[.]");
		return compareVersion(versionParts1, versionParts2, 0, 0);
	}

	private int compareVersion(String[] version1, String[] version2, int index1, int index2) {
		if (index1 >= version1.length && index2 >= version2.length)
			return 0;
		else if ((index1 >= version1.length))
			return (areAllZeros(version2, index2)) ? 0 : -1;
		else if (index2 >= version2.length)
			return (areAllZeros(version1, index1)) ? 0 : 1;
		else {
			int p1 = Integer.parseInt(version1[index1]), p2 = Integer.parseInt(version2[index2]);
			if (p1 < p2)
				return -1;
			else if (p1 > p2)
				return 1;
			return compareVersion(version1, version2, index1 + 1, index2 + 1);
		}
	}

	private boolean areAllZeros(String[] versionParts, int index) {
		if (index >= versionParts.length)
			return true;
		int value = Integer.parseInt(versionParts[index]);
		if (value == 0)
			return areAllZeros(versionParts, index + 1);
		return false;
	}

	public static void main(String[] args) {
//		System.out.println(new CompareVersionNumbers().compareVersion("1.01", "1.001"));
		System.out.println(new CompareVersionNumbers().compareVersion("1.01", "1.001"));

//		System.out.println(removeLeadingZeros("001"));
//		System.out.println(removeLeadingZeros("123"));
//		System.out.println(removeLeadingZeros("01"));
//		System.out.println(removeLeadingZeros("0000"));
//		System.out.println(removeLeadingZeros("4"));
//		System.out.println(removeLeadingZeros("0"));
	}

}
