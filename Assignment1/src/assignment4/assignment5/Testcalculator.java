package assignment5;
import java.util.Scanner;


public class Testcalculator {
	private static Scanner keyboard;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keyboard = new Scanner(System.in);
		
		Calculator calc = new Calculator();
		
		int num,x,y;
		
		System.out.println("Enter the first integer");
		num = keyboard.nextInt();
		
		System.out.println("Enter the second integer");
		x = keyboard.nextInt();
		
		System.out.println("Enter the third integer");
		y = keyboard.nextInt();
		
		System.out.println("For the numbers " + num + ", " + x + "and " + y);
		System.out.println("The Largest is " + calc.getLargest(num, x, y));
		System.out.println("The Smallest is " + calc.getSmallest(num, x, y));
		System.out.println("The Sum is " + calc.getSum(num, x, y));
		System.out.println("The Product is " + calc.getProduct(num, x, y));
		System.out.println("The Average is " + calc.getAverage(num, x, y));

	}

}
