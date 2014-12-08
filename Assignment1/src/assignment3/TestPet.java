package assignment3;
import java.util.Scanner;

public class TestPet {
	private static Scanner keyboard;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		keyboard = new Scanner(System.in);
		
		Pet animal = new Pet();
		
		System.out.println("Enter the type of your pet.");
		
		animal.type = keyboard.nextLine();
		
		animal.setType(animal.type);
		
		System.out.println("Enter pet's name");
		
		animal.name = keyboard.nextLine();
		
		System.out.println("Enter pet's age");
		
		animal.age = keyboard.nextInt();
		
		System.out.println("The pet's type is " + animal.type + "\nThe pet's name is " + animal.name + "\nThe pet's age is " + animal.age);
		
		
	}

}
