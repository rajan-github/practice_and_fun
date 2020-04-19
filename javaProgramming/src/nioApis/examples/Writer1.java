package nioApis.examples;

import java.io.File;
import java.io.IOException;

public class Writer1 {
	public static void main(String[] args) throws IOException {
		boolean newFile = false;
		File file = new File("filewrite1.txt"); //File is not created yet.
		System.out.println(file.exists());
		newFile = file.createNewFile();
		System.out.println(newFile);
		System.out.println(file.exists());
	}
}
