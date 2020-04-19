package strings;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other
 * words, convert it to the canonical path.
 * 
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level. For more
 * information, see: Absolute path vs relative path in Linux/Unix
 * 
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 * 
 * @author rajan-c
 *
 */
public class SimplifyPath {

	public static String simplifyPath(String path) {
		if (path == null)
			return path;
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < path.length()) {
			while (i < path.length() && path.charAt(i) == '/')
				i++;
			if (i < path.length()) {
				String dirName = getNextDir(i, path);
				if (dirName.equals("..")) {
					if (stack.size() > 0)
						stack.pop();
				} else if (!dirName.equals(".")) {
					stack.push(dirName);
				}
				i += dirName.length() + 1;
			}
		}
		return constructPath(stack);
	}

	private static String constructPath(Stack<String> stack) {
		if (stack.size() == 0)
			return "/";
		else {
			StringBuilder path = new StringBuilder();
			while (stack.size() > 0) {
				path.insert(0, stack.pop());
				path.insert(0, "/");
			}
			return path.toString();
		}
	}

	private static String getNextDir(int index, String path) {
		StringBuilder dirName = new StringBuilder();
		while (index < path.length() && path.charAt(index) != '/') {
			dirName.append(path.charAt(index++));
		}
		return dirName.toString();
	}

	public static void main(String[] args) {
		System.out.println(simplifyPath("/a//b////c/d//././/.."));
//		System.out.println(simplifyPath("/home/"));
//		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home//foo/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/a/../../b/../c//.//"));

	}

}
