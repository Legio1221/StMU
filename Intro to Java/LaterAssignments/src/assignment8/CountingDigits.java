package assignment8;
import java.util.Scanner;

public class CountingDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] countArray = new int[10];
		
		int counter;
		
		int generateSize = 0;
		
		//Set data in array to 0.
		
		for(int i=0;i<10;i++){
			countArray[i]=0;
		}
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter the numer of random numbers generated.");
		
		generateSize = keyboard.nextInt();
		
		for(int i=0;i<generateSize;i++){
			int index = (int)(Math.random()*9.999);
			
			counter = index;
			
			switch(counter){
			case 0:
				countArray[0]++;
				break;
			case 1:
				countArray[1]++;
				break;
			case 2:
				countArray[2]++;
				break;
			case 3:
				countArray[3]++;
			case 4: 
				countArray[4]++;
				break;
			case 5: 
				countArray[5]++;
				break;
			case 6:
				countArray[6]++;
				break;
			case 7:
				countArray[7]++;
				break;
			case 8:
				countArray[8]++;
				break;
			case 9:
				countArray[9]++;
				break;
			default:
				System.out.println("System Failure, coding failed....");
				break;
			}
			
			}
		
		System.out.println("Count for 0: " +countArray[0]);
		System.out.println("Count for 1: " +countArray[1]);
		System.out.println("Count for 2: " +countArray[2]);
		System.out.println("Count for 3: " +countArray[3]);
		System.out.println("Count for 4: " +countArray[4]);
		System.out.println("Count for 5: " +countArray[5]);
		System.out.println("Count for 6: " +countArray[6]);
		System.out.println("Count for 7: " +countArray[7]);
		System.out.println("Count for 8: " +countArray[8]);
		System.out.println("Count for 9: " +countArray[9]);
		
		}
	}

