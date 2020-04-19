package nioApis.examples.nioAPIs;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {

	public static void resolvePath() {
		Path dir = Paths.get("/home/java");
		Path file = Paths.get("models/model.pdf");
		Path result = dir.resolve(file);
		System.out.println(result);
	}

	public static void relativizePath() {
		Path dir = Paths.get("/home/java");
		Path music = Paths.get("/home/java/country/swift.mp3");
		Path mp3 = dir.relativize(music);
		System.out.println(mp3);
	}

	private static void relativizePath2() {
		Path absolute1 = Paths.get("/home/java");
		Path absolute2 = Paths.get("/usr/local");
		Path absolute3 = Paths.get("/home/java/temp/music.mp3");
		Path relative1 = Paths.get("temp");
		Path relative2 = Paths.get("temp/music.pdf");
		System.out.println(absolute1.relativize(absolute3));
		System.out.println(absolute3.relativize(absolute1));
		System.out.println(absolute1.relativize(absolute2));
		System.out.println(relative1.relativize(relative2));
		System.out.println(absolute1.relativize(relative1));
	}

	public static void main(String[] args) {
		Path path = Paths.get("C:/home/java/workspace");
		System.out.println("getFileName: " + path.getFileName());
		System.out.println("getName(1): " + path.getName(1));
		System.out.println("getNameCount: " + path.getNameCount());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getRoot: " + path.getRoot());
		System.out.println("subpath: " + path.subpath(0, 2));
		System.out.println("toString: " + path.toString());

//		resolvePath();

		System.out.println("++++++++++Separator++++++++");
		relativizePath2();
	}
}
