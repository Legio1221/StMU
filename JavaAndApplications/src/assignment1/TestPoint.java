package assignment1;

import java.util.Scanner;

public class TestPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ThePoint set1 = new ThePoint();
		Scanner keyboard = new Scanner(System.in);
		
		int user, user2;
		
		System.out.println("Please enter a set of points. X will be the first number.");
		user = keyboard.nextInt();
				
		System.out.println("Please enter Y.");
		user2 = keyboard.nextInt();
		
		ThePoint set2 = new ThePoint(user,user2);
		
		System.out.println("The distance between the points is " + ThePoint.distance(set1.getX(),set1.getY(), set2.getA(), set2.getB()));
		
	}

}
