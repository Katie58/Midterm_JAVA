package midterm;
import java.util.Scanner;

public class HangManUtil {
	static Scanner scnr = new Scanner(System.in);
	static Hangman player = new Hangman();

	/////////////////////////////// GREETING ////////////////////////////////////
	public static void greeting() {
		/* get user name and store in object */
	}
	////////////////////////////// MAIN MENU ////////////////////////////////////
	public static void menu() {/* ENTRY FROM MAIN METHOD */
		/* display menu, take user selection, send to corresponding method */
		/* menu items: 1. Play Game 2. High Scores */
		/* method can be bypassed and deleted if timer/score not implemented */
		/* extended challenge 2-player, let a player choose word */
	}

//	public static void highScores() {
//		/* extended challenge */
//	}
	/////////////////////////////// PLAY MENU ///////////////////////////////////
	public static void playMenu() {/* ENTRY FROM MAIN MENU */
		/* display menu, take user selection, send to corresponding method */
		/* menu items: 1. Play Game 2. Difficulty 3. Select Category 4. Exit */
	}
	
	public static void difficulty() {
		/* set missesMax */
	}
	
	public static void selectCategory() {
		/* CategoryFiles */
		/* display categories by looping CategoryFiles.categoryList();
		/* get user selection, read file, set random word */
		/* perhaps default picks random category */
		/* clear lists when done */
	}
	/////////////////////////////// PLAY GAME ///////////////////////////////////
	public static void displayGame() {
		/* create switch and/or enum to display underscores & correctly guessed chars */
		/* display current misses and/or available misses */
		/* extended challenge center everything based on console width */
		/* extended challenge add ascii art to replicate hangman */
	}
	
//	public static String padding(int multiplier, char character) {//extended challenge
//		String multiples = "";
//		for (int i = 1; i <= multiplier; i++) {
//			multiples += character;
//		}
//		return multiples;
//	}
	
	public static void guess() {
		boolean valid = false;
		player.guess = ' ';
		while(!valid) {
			System.out.print("\nEnter letter: ");
			String input = scnr.nextLine().trim().toLowerCase();
			char guess = input.charAt(0);
			if (validateCharAlpha(guess)) {
				player.setGuess(guess);
				boolean miss = true;
				int count = 0;
				for (char letter : player.correctArray) {
					if (letter == guess) {
						System.out.print(" already on the board, try again...");
						continue;
					}
				}
				for (char letter : player.missesArray) {
					if (letter == guess) {
						System.out.print(" already guessed that, try again...");
						continue;
					}
				}
				for (char letter : player.wordArray) {
					if (letter == guess) {
						player.correctArray[count] = guess;
						miss = false;
					}
					count++;
				}
				if (miss) {
					player.missesArray.add(guess);
					player.misses++;
				}
			} else {
				continue;
			}
		}	
	}
	
//	public static void displayGameOver() {
//		/* extended challenge ascii art */
//	}
	////////////////////////////// VALIDATORS //////////////////////////////////
	public static int validateMenu(int menuCount) {
		int input = 0;
		boolean valid = false;
		while(!valid) {
			String in = scnr.nextLine().trim();
			if (in.matches("[0-9]")) {
				input = Integer.parseInt(in);
				if (input >= 1 && input <= menuCount) {
					return input;
				} else {
					System.out.print("Sorry, " + input + " is not a menu option, try again... ");
					continue;
				}
			} else if (in.isEmpty()) {
				System.out.print("Perhaps check your numlock and try again... ");
				continue;					
			} else {
				System.out.print("Looking for numbers, try again... ");
				continue;
			}
		}
		return input;
	}
	
	public static boolean validateCharAlpha(char character) {
		String charString = Character.toString(character);
		if (charString.contains("[a-zA-Z]")) {
			return true;
		} else {
			return false;
		}
	}
	/////////////////////////////// YES | NO ////////////////////////////////////
 	public static boolean askUserYN(String question) {//ask user a yes/no question
		System.out.print("\n" + question + " (y/n) ");
		return validateYesNo(scnr.nextLine().charAt(0));
	}
	
	public static boolean validateYesNo(char input) {//validate yes/no user input
		while (input != 'y' && input != 'Y' && input != 'n' && input != 'N') {
			System.out.print("This is a simple yes or no question, try again...");
			input = scnr.nextLine().charAt(0);
		}
		return (input == 'y' || input == 'Y');
	}
	//////////////////////////////// EXIT //////////////////////////////////////
	public static void exit() {
		System.out.println("Nice playing with you, catch you later!");
		scnr.close();
		CategoryFiles.closeReader();
	}
}

