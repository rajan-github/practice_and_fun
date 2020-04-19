package nioApis.examples.nioAPIs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FileAttributes {
	public static void main(String[] args) throws IOException {
		Date januaryFirst = new GregorianCalendar( // create a date
				2013, Calendar.JANUARY, 1).getTime();
		Path path = Paths.get("C:/temp/file2");
		Files.createFile(path); // create another file
		FileTime fileTime = FileTime.fromMillis(januaryFirst.getTime()); // convert to the new FileTime object

		Files.setLastModifiedTime(path, fileTime); // set the time
		System.out.println(Files.getLastModifiedTime(path));
		Files.delete(path); // delete the file
	}
}
