package assignment7;
import java.util.Scanner;
import java.text.DecimalFormat;

public class TestDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		double x1, x2, y1, y2;
		
		System.out.println("Please enter x1.");
		x1 = keyboard.nextDouble();
		
		System.out.println("Please enter x2.");
		x2 = keyboard.nextDouble();
		
		System.out.println("Please enter y1.");
		y1 = keyboard.nextDouble();
		
		System.out.println("Please enter y2.");
		y2 = keyboard.nextDouble();
		
		DecimalFormat df = new DecimalFormat("#.##");
				
		System.out.println("The distance between the two points is " + df.format(TheDistance.getDistance(x1, x2, y1, y2)));
		
	}

}
