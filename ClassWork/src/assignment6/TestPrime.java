package assignment6;

import java.util.*;

public class TestPrime {
	private static Scanner keyboard;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number;
		int primeCounter=0;
		int merCounter=0;

		keyboard = new Scanner(System.in);
		
		System.out.println("Enter a number.");
		number = keyboard.nextInt();
		
		Prime p = new Prime();

		if(p.isPrime(number)==true){
			System.out.println(number+" is a prime.");
			for(int i = 1;i<=number;i++){
				if(p.isPrime(i)==true){
				System.out.print(i+" ");
				primeCounter++;
				}
			}
		}else{
			System.out.println(number+ " is not a prime.");
		}
		System.out.println(" ");
		System.out.println("The number of primes is " +primeCounter);
		
		MersennePrime mer = new MersennePrime();
		
		for(int j=1;j<=number;j++){
			for(double n2=1;n2<=number;n2++){
				if(mer.isMersennePrime(j, n2)==true){
					System.out.print(j+" ");
					merCounter++;
				}
			}
		}
		
		if(merCounter==0){
			System.out.println("There are no Mersenne primes.");
		}else{
			System.out.println(" ");
			System.out.println("The number of Mersenne primes is " + merCounter);
		}
		
	}

}
