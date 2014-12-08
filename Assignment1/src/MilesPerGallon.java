
import java.util.Scanner;
public class MilesPerGallon {
private static Scanner keyboard;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

double gallons;
double miles;

keyboard = new Scanner (System.in);

			
System.out.println("Enter the miles driven:");
miles = keyboard.nextDouble();

System.out.println("Enter the gallons of fuel used:");
gallons = keyboard.nextDouble();


System.out.println("The miles-per-gallon is " + miles/gallons);
			
	}
	

}
