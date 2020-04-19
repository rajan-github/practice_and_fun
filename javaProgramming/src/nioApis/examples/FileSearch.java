package nioApis.examples;

import java.io.File;
import java.io.IOException;

public class FileSearch {
	public static void main(String[] args) throws IOException {
		File delDir = new File("deldir");
		delDir.mkdir();
		File delFile1 = new File(delDir, "delFile1.txt"); // add file to the directory
		delFile1.createNewFile();

		String[] files;
		files = delDir.list();
		if (files != null) {
			for (String file : files)
				System.out.println("found: " + file);
		}
	}
}
