package assignment7;
import java.util.Scanner;

public class TestInteger {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter an integer.");
		number = keyboard.nextInt();
		
		if(MyInteger.isEven(number)){
			System.out.println("The number is even.");
		}else if(MyInteger.isOdd(number)){
			System.out.println("The number is odd.");
		}
		
		if(MyInteger.isPrime(number)){
			System.out.println("The number is a Prime.");
		}
		
		
		
		
	}

}
