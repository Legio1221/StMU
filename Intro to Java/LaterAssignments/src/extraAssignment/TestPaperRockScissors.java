package extraAssignment;
import java.util.Scanner;

public class TestPaperRockScissors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userChoice;
		int counter = 0;
		int counter2 = 42;
		int choose = (int)Math.random()*3;

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a number. 0 for paper, 1 for rock, 2 for scissors.");
		
		userChoice = keyboard.nextInt();
		
		PaperWorkScissors game = new PaperWorkScissors();
		
		game.logic(userChoice, choose);
		counter++;
		
		do{
			System.out.println("Would you like to play again? 1 for yes, 2 for not");
			userChoice = keyboard.nextInt();
			
			choose = (int)((Math.random()*100)%3);
			
			if(userChoice == 1){
				System.out.println("Enter a number. 0 for paper, 1 for rock, 2 for scissors.");
				userChoice = keyboard.nextInt();
				game.logic(userChoice, choose);
				counter++;
			}else if(userChoice == 2){
				System.out.println("Thanks for playing!");
				counter2 =-1;
			}else{
				System.out.println("Not a an option. Terminating program.");
				counter2 =-1;
			}
		}while(counter2!=-1);
	
		System.out.println("You played a total amount of: " + counter);
	}

}
