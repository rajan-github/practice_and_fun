package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {
	public static void main(String[] args) throws IOException {
		System.out.println("reading the file." + System.getProperty("user.dir"));
		File file = new File("D:\\programming\\javaProgramming\\src\\io\\PrintFile.java");
		FileReader reader = new FileReader(file);
		try (BufferedReader bf = new BufferedReader(reader)) {
			while (bf.ready())
				System.out.println(bf.readLine());
		}

	}
}
