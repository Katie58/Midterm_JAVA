package midterm;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HangManUtil {
	static Scanner scnr = new Scanner(System.in);
	static Hangman player = new Hangman();
	

	/////////////////////////////// GREETING ////////////////////////////////////
	public static void greeting() {
		/* get user name and store in object */
		String name;
		System.out.print("Welcome to Hangman what is your name?: ");
		name = scnr.nextLine();
		player.setUserName(name);
	}
	////////////////////////////// MAIN MENU ////////////////////////////////////
	public static void menu() {/* ENTRY FROM MAIN METHOD */
		/* display menu, take user selection, send to corresponding method */
		/* menu items: 1. Play Game 2. High Scores */
		/* method can be bypassed and deleted if timer/score not implemented */
		/* extended challenge 2-player, let a player choose word */
		int selection = 0;
		String clear;
		
		System.out.println("1) Play Menu");
		System.out.println("2) High Scores");
		System.out.println("3) Exit");
		
		do {
			try {
				System.out.print(player.getUserName() + " what would you like to do?: ");
				selection = scnr.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Invalid input. Please try again.");
				clear = scnr.nextLine();
				continue;
			}
			
		} while(false);
		
		do {
			switch(selection) {
				case 1: playMenu();
					break;
				case 2:  System.out.println("High Score");
					break;
				case 3: exit();
					break;
				default: System.out.println("Invalid input! Please try again.");
					continue;
			}
		} while (false);
		
		}

//	public static void highScores() {
//		/* extended challenge */
//	}
	/////////////////////////////// PLAY MENU ///////////////////////////////////
	public static void playMenu() {/* ENTRY FROM MAIN MENU */
		/* display menu, take user selection, send to corresponding method */
		/* menu items: 1. Play Game 2. Difficulty 3. Select Category 4. Exit */
		int selection = 0;
		String clear;
		
		System.out.println("1) Play Game");
		System.out.println("2) Difficulty");
		System.out.println("3) Select Category");
		System.out.println("4) Exit");
		
		do {
			try {
				System.out.print(player.getUserName() + " what would you like to do?: ");
				selection = scnr.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Invalid input. Please try again.");
				clear = scnr.nextLine();
				continue;
			}
			
		} while(false);
		
		do {
			switch(selection) {
				case 1: displayGame();
					break;
				case 2:  difficulty();
					break;
				case 3: selectCategory();
					break;
				case 4: exit();
					break;
				default: System.out.println("Invalid input! Please try again.");
					continue;
			}
		} while(false);
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
		/* send to validate which will get input, check if correct, adjust arrays & misses */
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
	
	public static void validateGuess() {
		boolean valid = false;
		player.guess = ' ';
		while(!valid) {
			/* request input, store as string */
			/* input.trim() & input.toLowerCase */
			/* if input > 1, continue; */
			/* if not [a-z] continue; */
			/* else, valid = true; */
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
		/* sysout goodbye message */
		scnr.close();
	}
}

