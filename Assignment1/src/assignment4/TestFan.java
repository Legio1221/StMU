package assignment4;
import java.util.Scanner;

public class TestFan {
private static Scanner keyboard;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		keyboard = new Scanner(System.in);
		
		Fan f = new Fan();
		int x;
		System.out.println("Please enter the speed of the fan");
		f.speed = keyboard.nextInt();
		System.out.println("Is the fan on? press 1 for yes, 2 for no");
		x = keyboard.nextInt();
		if(x==2){
			f.fanStatus = false;
		}else{
			f.fanStatus = true;
		}
		System.out.println("What is the radius?");
		f.radius = keyboard.nextDouble();
		System.out.println("What is the color?");
		f.color = keyboard.nextLine();
		f.color = keyboard.nextLine();
		
		f.toString(f.speed, f.fanStatus, f.radius, f.color);
		
	}

}
