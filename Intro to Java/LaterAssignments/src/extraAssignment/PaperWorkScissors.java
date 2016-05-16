package extraAssignment;

public class PaperWorkScissors {

	int paper = 0, rock = 1, scissor = 2;
	
	public void logic(int user, int choose){
		
		if(user == choose) {
			System.out.println("You tied.");
		}
		
		if(user == rock && choose == paper){
			System.out.println("You lost! Paper beats rock.");
		}else if( user == rock && choose == scissor){
			System.out.println("You won! Rock beats scissors.");
		}
		
		if(user == paper && choose == scissor){
			System.out.println("You lost! Scissor beats paper.");
		}else if(user == paper && choose == rock){
			System.out.println("You won! Paper beats rock.");
		}
		
		if(user == scissor && choose == rock){
			System.out.println("You lost! Rock beats scissors.");
		}else if(user == scissor && choose == paper){
			System.out.println("You won! Scissors beat paper.");
		}
	}

}