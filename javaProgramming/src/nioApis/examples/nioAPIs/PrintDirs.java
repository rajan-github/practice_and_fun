package nioApis.examples.nioAPIs;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintDirs extends SimpleFileVisitor<Path> {
	public FileVisitResult previFileVisitResult(Path dir, BasicFileAttributes attrs) {
		System.out.println("pre: " + dir);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		System.out.println("file: " + file);
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult visitFileFailed(Path file, IOException ex) {
		return FileVisitResult.CONTINUE;
	}

	public FileVisitResult postVisitDirectory(Path dir, IOException ex) {
		System.out.println("post: " + dir);
		return FileVisitResult.CONTINUE;
	}

	public static void main(String[] args) throws IOException {
		PrintDirs dirs = new PrintDirs();
		Files.walkFileTree(Paths.get("D:\\"), dirs);
	}
}
