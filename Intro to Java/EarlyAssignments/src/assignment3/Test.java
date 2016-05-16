package assignment3;
import java.util.Scanner;

public class Test {
	private static Scanner keyboard;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		keyboard = new Scanner(System.in);
		
		Circle c = new Circle();
		
		System.out.println("Enter a radius");
		
		c.radius = keyboard.nextDouble();
		
		c.setRadius(c.radius);
		
		c.getRadius();
		
		c.getArea();
		
		c.getDiameter();
		
		c.getCircumference();
		
		System.out.println("The radius of the circle is: " + c.getRadius() +"\nThe Area is: " + c.getArea() + "\nThe Diameter is: " + c.getDiameter() + "\nThe circumference is: " + c.getCircumference());
		
		

		
	}

}
