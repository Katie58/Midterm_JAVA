package midterm;

public class MidTerm {
	
	public static void main(String[] args) {
		
		boolean retry = true;
		
		HangManUtil.greeting();/////////////get user name and display game title
		
		while(retry) {
			HangManUtil.menu();/////////////send to main menu	
			retry = HangManUtil.askUserYN("Are you sure you would like to exit?");////verify user would like to exit
		}
		HangManUtil.exit();/////////////////say goodbye		
	}
}
