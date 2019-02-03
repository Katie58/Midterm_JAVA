package midterm;

public class MidTerm {
	
	public static void main(String[] args) {		
		boolean retry = true;
		
		HangManUtil.greeting();		
		while(retry) {
			HangManUtil.menu();
			HangManUtil.clearScnr();
			retry = !HangManUtil.askUserYN("Are you sure you would like to exit?");
		}
		HangManUtil.exit();
	}
}
