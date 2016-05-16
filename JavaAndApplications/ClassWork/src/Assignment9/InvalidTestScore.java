package Assignment9;

public class InvalidTestScore extends Exception{

	InvalidTestScore(){
		super("Invalid Test Score");
	}
	InvalidTestScore(int score){
		super("Invalid Score Found." + "\nInvalid Test Score: " + score);
	}

}
