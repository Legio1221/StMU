package assignment9;

import java.util.Scanner;

public class Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);

		int arraySize = 3;

		System.out.println("How many numbers do you want to enter?");
		arraySize = keyboard.nextInt();

		int[] array = new int[arraySize];

		getValues(array);
		
		System.out.println("The highest element is: " + showHighest(array));
		System.out.println("The lowest element is: " + showLowest(array));
		System.out.println("The sum of the elements is: " + showTotal(array));
		System.out.println("The average of the elements is: " + showAverage(array));

	}

	private static int showHighest(int[] array) {
		int max=0;
		
		for(int i =0;i<array.length;i++){		
			if(max<=array[i]){
				max = array[i];
			}
		}
		return max;
	}

	private static int showLowest(int[] array) {
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<array.length;i++){
			if(array[i]<=min){
				min = array[i];
			}
		}
		return min;
	}

	private static int showTotal(int[] array) {
		int total = 0;
		
		for(int i =0;i<array.length;i++){		
			total += array[i];
		}
		return total;
	}

	private static double showAverage(int[] array) {
		double average = 0;
		int total = 0;
		
		for(int i =0;i<array.length;i++){		
			total += array[i];
		}
		
		average = total/array.length;
		
		return average;
	}

	private static void getValues(int[] array) {
		// Create a Scanner objects for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter a series of " + array.length + " numbers.");

		// Read values into the array
		for (int index = 0; index < array.length; index++) {
			System.out.print("Enter number " + (index + 1) + ": ");
			array[index] = keyboard.nextInt();
		}
	}
}
