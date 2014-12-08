package assignment8;
import java.util.Scanner;

public class PrimeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter an integer.");
		
		int arraySize = keyboard.nextInt();
		int primeCounter = 0;
		
		int [] primeArray = new int[arraySize];
		PrimeNumbers pn = new PrimeNumbers();
		
		for(int i = 1;i<=arraySize;i++){
			if(pn.isPrime(i)==true){
				primeArray[i]=i;
				primeCounter++;
			}
			}
			
		for(int i = 0;i<arraySize;i++){
			if(primeArray[i]!=0){
			System.out.print(primeArray[i]+" ");
			}
		}
		
		System.out.println(" ");
		System.out.println("Number of prime numbers smalller than "+arraySize+" are "+primeCounter);
	}
	
	boolean isPrime(int n){
		if(n==5 || n==3 || n==2) return true;
		if(n%2 == 0) return false;
		if(n%5==0 || n%3==0) return false;
		
		for(int i = 3; i*i<=n; i+=2){
			if(n/i == 0)
				return false;
		}
		
		if(n <= 1) return false;
		
		return true;
	}

}
