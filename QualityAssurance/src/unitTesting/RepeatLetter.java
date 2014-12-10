package unitTesting;

public class RepeatLetter {

	public RepeatLetter(){
		
	}
	
	public static int repeat(char[] word){
		int counter = 0;
		for(int i = 0;i < word.length; i++){
			if( i >= 1 && word[i] == word[i-1]){
				counter++;
			}
		}
		return counter;
	} 
}
