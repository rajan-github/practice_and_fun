package nioApis.examples.nioAPIs;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TraversingFile extends SimpleFileVisitor<Path> { // need to extend the visitor
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.getFileName().endsWith(".class"))
			Files.delete(file); // delete the file
		return FileVisitResult.CONTINUE; // go on to the next file
	}

	public static void main(String[] args) throws IOException {
		TraversingFile traverseFiles = new TraversingFile();
		Files.walkFileTree(Paths.get("D:\\"), traverseFiles); // kick off the recursive check starting point the visitor
	}
}
