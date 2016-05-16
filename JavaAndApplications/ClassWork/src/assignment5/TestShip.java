package assignment5;

import java.util.Scanner;

public class TestShip {

	public static void main(String[] args) {
		Ship[] merry = new Ship[3];

		String name;
		int year, variable;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter the ship's name.");
		name = keyboard.nextLine();
		System.out.println("Please enter the ship's year of construction.");
		year = keyboard.nextInt();

		merry[0] = new Ship(name, year);

		keyboard.nextLine();
		System.out.println("Please enter the ship's name.");
		name = keyboard.nextLine();
		System.out.println("Please enter the ship's passengers.");
		variable = keyboard.nextInt();

		merry[1] = new CruiseShip(name, variable);

		keyboard.nextLine();
		System.out.println("Please enter the ship's name.");
		name = keyboard.nextLine();
		System.out.println("Please enter the ship's tonnage.");
		variable = keyboard.nextInt();

		merry[2] = new CargoShip(name, variable);

		System.out.println(merry[0].toString() + merry[1].toString()
				+ merry[2].toString());

	}

}
