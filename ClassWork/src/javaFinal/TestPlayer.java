package javaFinal;

import java.util.Scanner;
import java.util.ArrayList;

public class TestPlayer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);

		int user, num;
		String t, n;

		ArrayList list = new ArrayList();

		System.out.println("How many players do you want to enter into the system?");
		user = keyboard.nextInt();
		

		for (int i = 0; i < user; i++) {
			keyboard.nextLine();
			System.out.println("Please enter the player's team");
			t = keyboard.next();
			keyboard.nextLine();
			System.out.println("Please enter the player's name");
			n = keyboard.next();
			System.out.println("Please enter the player's no");
			num = keyboard.nextInt();

			System.out.println();
			System.out.println();
			System.out.println();

			list.add(new Player(t, n, num));
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		remove(list);
		

		System.out.println("The current list is ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	 private static void remove(ArrayList list){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Would you like to remove players? Enter player's no to remove, enter -1 to keep player.");
		int user = keyboard.nextInt();
		
		if(user!=-1){
			for (int i = 0; i < list.size(); i++) {
				if(((Player) list.get(i)).getNo() == user){   //I think my problem was trying to get the number variable from the array list. 
					list.remove(i);
				}
			}
		}
		
		
	}

}
