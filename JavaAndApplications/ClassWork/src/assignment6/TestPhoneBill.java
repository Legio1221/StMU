package assignment6;
import java.util.Scanner;

public class TestPhoneBill {

	public static void main(String[] args){
		double callRate, monthlyRate;
		int time;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("This program will sort your phone bill.");
		System.out.println("What is your call rate?");
		callRate = keyboard.nextDouble();
		System.out.println("What is your monthly rate?");
		monthlyRate = keyboard.nextDouble();
		
		LongDistanceBill bill = new LongDistanceBill(monthlyRate, callRate);
		
		System.out.println("How many minutes were used?");
		time = keyboard.nextInt();
		
		System.out.println("Your monthly bill is " + bill.calculateBill(time));
		
	}
}
