package nioApis.examples;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writer2 {
	public static void main(String[] args) {
		char[] in = new char[50]; // to store input
		int size = 0;
		try {
			File file = new File("fileWrite2.txt"); // just an object
			FileWriter fw = new FileWriter(file); // create an actual file and a fileWriter Obj
			fw.write("howdy\nfolks\n"); // write characters to the file
			fw.flush(); //flush before closing
			fw.close();  //close file when done

			FileReader fr = new FileReader(file);  //create a filereader obj
			size = fr.read(in); //read the whole object
			System.out.println("Size is: " + size);
			for (char c : in) {
				System.out.print(c);  
			}
			fr.close();  //close the file reader.
		} catch (IOException ex) {
			System.out.println(ex);
		}

	}
}
