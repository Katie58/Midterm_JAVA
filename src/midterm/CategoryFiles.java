package midterm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryFiles {
	static ArrayList<String> categories = new ArrayList<String>();
	static ArrayList<String> categoryList = new ArrayList<String>();

	public static ArrayList<String> categoryList() {		
		File[] files = new File("categories").listFiles();
		for (File file : files) {
		    if (file.isFile()) {
		        categories.add(file.getName());
		    }
		}
		return categories;
	}
	
	public static ArrayList<String> readFile(String category) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("categories/" + category + ".txt"));
			String line = reader.readLine();
			while (line != null) {
				line = reader.readLine();
				categoryList.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return categoryList;///////////due to reader.close() will need to create getters 
		///////////////////////////////or a method to close reader when program exits
	}
	
	public static void clearArrays() {
		categories.clear();
		categoryList.clear();
	}
	
}
