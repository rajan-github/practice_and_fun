package nioApis.examples.nioAPIs;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TraversingDirectory {
	private static void traverseDirectory() throws IOException {
		Path dir = Paths.get("D:\\");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "[PB]*")) {
			for (Path path : stream) { //loop through the stream
				System.out.println(path.getFileName());
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		System.out.println(Paths.get("").toAbsolutePath());
		traverseDirectory();
	}
}
