package extraAssignment;

import java.util.Scanner;

public class Distinct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[10];

		System.out.println("Enter a set of 10 integers.");
		setDistinctNum(array);
		distinctNum(array);
		
	}

	private static int[] setDistinctNum(int[] array) {
		Scanner keyboard = new Scanner(System.in);
		int userNum=0;

		for (int i = 0; i < array.length; i++) {
			System.out.println("Please enter an intger.");
			userNum = keyboard.nextInt();
			array[i]=userNum;
		}
		return array;
	}
	
	private static void distinctNum(int[] array){
		boolean decide = false;
		System.out.print("The distinct numbers are: ");
		
		for(int i = 0 ;i<array.length;i++){
			decide = true;
			for(int j = 0;j<array.length;j++){
				if(array[i]==array[j]){
					decide = false;
				}
			}
			if(decide == true){
				System.out.print(array[i] + " ");
			}
		}
	}
	
	
}
