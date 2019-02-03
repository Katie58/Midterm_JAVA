package midterm;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class HangManUtil {
	static Scanner scnr = new Scanner(System.in);
	static Hangman player = new Hangman();
	

	/////////////////////////////// GREETING ////////////////////////////////////
	public static void greeting() {//get user name, store in object
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
				clear = scnr.nextLine();///////////menu not clearing, needs to move to try
				continue;
			}
			
		} while(false);
		
		do {
			switch(selection) {
				case 1: playMenu();
					break;
				case 2: highScores();
					break;
				case 3: ;/////////////////wasn't exiting program, I deleted exit() to test
					break;
				default: System.out.println("Invalid input! Please try again.");
					continue;
			}
		} while (false);
		
		}

	public static void highScores() {
		System.out.println("===============");
		System.out.println("| HIGH SCORES |");
		System.out.println("===============");
		ArrayList<String> highScore = CategoryFiles.readFile("HighScores");
		TreeSet<String> ordered = new TreeSet<String>();
		for (String score : highScore) {
			ordered.add(score);
		}
		int count = 1;
		for (String score : ordered) {
			String[] timeName = score.split(":");
			System.out.println(count + ". " + timeName[1] + "....." + timeName[0]);
			count++;
		}
		String clear = scnr.nextLine();//**********************menu not clearing needs fix
		System.out.print("\nEnter any key to continue... ");
	}
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
		boolean retry = true;
		while(retry) {
			String[] difficulties = new String[] { "easy", "intermediate", "hard", "extreme", "custom" };
			for (int i = 0; i < difficulties.length; i++) {
				System.out.println((i + 1) + ". " + difficulties[i]);
			}
			int select = validateMenu(difficulties.length);
			player.difficulty = difficulties[select];
			retry = askUserYN("You selected " + player.difficulty + ", is this correct? ");			
		}
		switch(player.difficulty) {
		case "easy": player.missesMax = 10;
		break;
		case "intermediate": player.missesMax = 5;
		break;
		case "hard": player.missesMax = 3;
		break;
		case "extreme": player.missesMax = 1;
		break;
		case "custom": customMisses();
		break;
		}
	}
	
	public static void customMisses() {
		boolean retry = true;
		while(retry) {
			System.out.print("How many tries do you plan to give yourself? ");
			if (scnr.hasNextInt()) {
				player.missesMax = scnr.nextInt();
				scnr.nextLine();
			} else {
				System.out.println("Is your numlock on? try again... ");
				continue;
			}
			retry = askUserYN("Are you sure you can win in " + player.missesMax + "?");
		}		
	}
	
	public static void selectCategory() {
		CategoryFiles.categoryList();//populate category list from files
		boolean retry = true;
		while(retry) {
			int count = 0;
			for (String category : CategoryFiles.categories) {//print categories
				count++;
				System.out.println(count + ". " + category);
			}
			int select = validateMenu(CategoryFiles.categories.size());//user select category
			count = 0;
			for (String category : CategoryFiles.categories) {//set category
				count++;
				if (select == count) {
					player.category = category;
					break;
				}
			}		
			retry = askUserYN("You selected " + player.category + ", is this correct? ");//verify
		}	
		CategoryFiles.categoryList = CategoryFiles.readFile("categories/" + player.category + ".txt");
	}
	/////////////////////////////// PLAY GAME ///////////////////////////////////	
	public static void play() {/* ENTRY FROM PLAY MENU */
		Timer timer = new Timer();
		player.randomWord();//get/set random word from category
		player.wordArray = player.word.toCharArray();
		player.correctArray = new char[player.wordArray.length];
		player.missesArray.clear();
		player.win = false;
		boolean gameOver = false;
		while(!gameOver) {
			displayGame();
			guess();
			gameOver = checkForWin();
		}
		if (player.win) {
			player.time = timer.getTime();
			System.out.println("Congratulations! YOU WON!!! in " + player.time + " seconds!");
			if (addHighScore()) {
				System.out.println("*****NEW HIGH SCORE*****");
			}
		} else {
			System.out.println("YOU LOST :(");
		}
	}	
	
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
			if (!input.isEmpty()) {
				char guess = input.charAt(0);
				if (validateCharAlpha(guess)) {
					player.setGuess(guess);
					boolean miss = true;
					int count = 0;
					for (char letter : player.correctArray) {
						if (letter == guess) {
							System.out.print(" already on the board, try again...");
							miss = false;
							break;
						}
					}
					for (char letter : player.missesArray) {
						if (letter == guess) {
							System.out.print(" already guessed that, try again...");
							miss = false;
							break;
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
			} else {
				continue;
			}
		}	
	}
	
	public static boolean checkForWin() {
		if (player.misses == player.missesMax) {
			for (int i = 0; i < player.wordArray.length; i++) {
				if (validateCharAlpha(player.correctArray[i])) {
					if (player.correctArray[i] != player.wordArray[i]) {
						System.out.println("ERROR - restarting game...");
						return true;
					} 
				} else {
					System.out.println("ERROR - restarting game...");
					return true;
				}
			}	
			player.win = true;
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean addHighScore() {
		ArrayList<String> highScore = CategoryFiles.readFile("HighScores");
		if (highScore.size() < 10) {
			highScore.add(player.time + ":" + player.getUserName());
			return true;
		} 
		int i = 0;
		for (String score : highScore) {
			String[] scoreName = score.split(":");
			int time = Integer.parseInt(scoreName[0]);
			if (player.time < time) {
				highScore.set(i, player.time + ":" + player.getUserName());
				return true;
			}
			i++;
		}
		CategoryFiles.writeToFile(highScore, "HighScores");
		return false;
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
			if (in.isEmpty()) {
				System.out.print("Perhaps check your numlock and try again... ");
				continue;					
			} else if (in.matches("[0-9]")) {
				input = Integer.parseInt(in);
				if (input >= 1 && input <= menuCount) {
					return input;
				} else {
					System.out.print("Sorry, " + input + " is not a menu option, try again... ");
					continue;
				}
			} else {
				System.out.print("Looking for numbers, try again... ");
				continue;
			}
		}
		return input;
	}
	
	public static boolean validateCharAlpha(char character) {
		if (character != 0) {
			String charString = Character.toString(character);
			if (charString.contains("[a-zA-Z]")) {
				return true;
			} else {
				return false;
			}			
		} else {
			return false;
		}
	}
	/////////////////////////////// YES | NO ////////////////////////////////////
 	public static boolean askUserYN(String question) {//ask user a yes/no question
 		String clear = scnr.nextLine();//********************menu not clearing, needs fix
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

