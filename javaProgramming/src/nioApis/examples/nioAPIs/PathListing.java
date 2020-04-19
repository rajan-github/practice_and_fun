package nioApis.examples.nioAPIs;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathListing {
	
	public static void main(String[] args) {
		int spaces = 1;
		Path path = Paths.get("tmp", "dir1", "dir2", "dir3", "file.txt");
		for (Path subpath : path) {
			System.out.format("%" + spaces + "s%s%n", "", subpath);
			spaces += 2;
		}
	}
}
