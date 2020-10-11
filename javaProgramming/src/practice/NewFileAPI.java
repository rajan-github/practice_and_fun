package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NewFileAPI {

	public static void copyFile(String sourceString, String targetString) {
		Path source = Paths.get(sourceString), target = Paths.get(targetString);
		try {
			Files.copy(source, target);
			System.out.println("File created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile(String file) {
		Path path = Paths.get(file);
		try {
			Files.delete(path);
			System.out.println("File deleted");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFileAllLines(String fileName) {
		Path path = Paths.get(fileName);
		try {
			List<String> fileData = Files.readAllLines(path);
			for (String line : fileData)
				System.out.println(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile(String fileName) {
		Path path = Paths.get(fileName);
		try {
			byte[] bytes = Files.readAllBytes(path);
			for (byte b : bytes)
				System.out.println((char) b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		System.out.println(Paths.get("").toAbsolutePath().toString());
//		readFileAllLines("D:\\programming\\javaProgramming\\src\\practice\\file.txt");
//		readFile("D:\\programming\\javaProgramming\\src\\practice\\file.txt");
		copyFile("D:\\programming\\javaProgramming\\src\\practice\\file.txt",
				"D:\\programming\\javaProgramming\\src\\practice\\clone.txt");

		deleteFile("D:\\programming\\javaProgramming\\src\\practice\\clone.txt");
	}

}
