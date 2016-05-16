package test3;

import java.util.Scanner;

public class CountingPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 0;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter the number of letters you want to construct a word with:");

		num = keyboard.nextInt();

		char[] array = new char[num];

		method1(array);
		System.out.println(method2(array) + " is the number of pairs.");

	}

	private static char[] method1(char[] array) {
		String user = "a";
		char firstchar;
		Scanner keyboard2 = new Scanner(System.in);

		for (int i = 0; i < array.length; i++) {
			System.out.println("Please enter a letter ");
			user = keyboard2.nextLine();
			firstchar = user.charAt(0);
			array[i] = firstchar;
		}

		return array;
	}

	private static int method2(char[] array) {
		int pair = 0;

		for (int i = 0; i < array.length; i++) {
			if (i != (array.length - 1)) {
				if (array[i] == array[i + 1]) {
					pair++;
				}
			}
		}
		return pair;
	}

}
