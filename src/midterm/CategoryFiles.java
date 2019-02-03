package midterm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryFiles {
	static BufferedReader reader;
	static FileWriter write;
	static ArrayList<String> categories = new ArrayList<String>();//list of files
	static ArrayList<String> categoryList = new ArrayList<String>();//list of words in category file

	public static ArrayList<String> categoryList() {//gets file names and stores in list		
		File[] files = new File("categories").listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		    	String category = file.getName().replace(".txt", "");
		        categories.add(category);
		    }
		}
		return categories;
	}
	
	public static ArrayList<String> readFile(String dir) {	
		ArrayList<String> aList = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(dir));
			String line = reader.readLine();
			while (line != null) {
				aList.add(line);
				line = reader.readLine();	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aList;
	}
	
	public static void writeToFile(ArrayList<String> list, String fileName) {
		File remove = new File(fileName);
		remove.delete();
		File newFile = new File(fileName);

		try {
		    write = new FileWriter(newFile, false);
		    for (String line : list) {
		    	write.write(line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void clearArrays() {
		categories.clear();
		categoryList.clear();
	}
	
	public static void closeReader() {
		try {
			reader.close();
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
