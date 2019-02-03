package midterm;

import java.util.ArrayList;

public class Hangman {

	private String userName;
	
	public String category = "default";/////default maybe random?
	public String difficulty = "default";///easy?
	public String word;
	public char[] wordArray = word.toCharArray();
	public char[] correctArray = new char[wordArray.length];
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
	
}
