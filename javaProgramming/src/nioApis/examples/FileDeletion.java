package nioApis.examples;

import java.io.File;
import java.io.IOException;

public class FileDeletion {
	public static void main(String[] args) throws IOException {
		File delDir = new File("deldir");
		delDir.mkdir();
		File delFile1 = new File(delDir, "delFile1.txt"); //add file to the directory
		delFile1.createNewFile();

		File delFile2 = new File(delDir, "delFile2.txt");
		delFile2.createNewFile();
		delFile1.delete(); //delete a file

		System.out.println("attempt to delete the directory: " + delDir.delete());
		File newName = new File(delDir, "newName.txt");
		delFile2.renameTo(newName); //rename file to a new name

		File newDir = new File("newDir");
		delDir.renameTo(newDir); //rename directory to a new directory
	}
}
