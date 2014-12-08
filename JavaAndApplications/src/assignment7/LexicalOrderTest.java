package assignment7;

public class LexicalOrderTest {
	public static void main(String[] args){
		String s1 = "Tokyo";
		String s2 = "Mexico City";
		
		System.out.println("First string: " + s1 + 
				"\nSecond string: " + s2);
		
		
		
		compare(s1,s2);
	}
	
	
	public static void compare(String s, String s2){
	int decision = s.compareTo(s2);
	if(decision > 0){
		System.out.println("First string follows second string");
	}else if(decision < 0){
		System.out.println("Second string follows first string");
	}
	}
	
	
	
}
