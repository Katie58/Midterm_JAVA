package midterm;

import java.util.ArrayList;
import java.util.Random;

public class Hangman {

	private String userName;
	
	public String category = "default";/////default maybe random?
	public String difficulty = "default";///easy?
	public String word;
	public char[] wordArray;
	public char[] correctArray;
	public ArrayList<Character> missesArray;
	public int missesMax;
	public int misses;
	public char guess;
	public boolean win;
	//public int score;//possible extended challenge
	
	public Hangman() {
	}
	
	public void setGuess(char guess) {
		this.guess = guess;
	}
	
	public char getGuess() {
		return guess;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
	public void randomWord() {
		CategoryFiles.readFile(category);
		Random r = new Random();
		int random = r.nextInt(CategoryFiles.categoryList.size()) + 1;
		for (int i = 1; i <= CategoryFiles.categoryList.size(); i++) {
			if (i == random) {
				word = CategoryFiles.categoryList.get(i);
				break;
			}
		}
	}
	
}
