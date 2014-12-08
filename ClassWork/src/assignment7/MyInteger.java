package assignment7;

public class MyInteger {

	public static boolean isEven(int n){
		if(n%2 == 0) return true;
		
		return false;
		
	}
	
	public static boolean isOdd(int n){
		if(n%2 == 0) return false;
		
		return true;
	}
	
	public static boolean isPrime(int n){
		if(n%2 == 0) return false;
		if(n==5 || n==3) return true;
		if(n%5==0 || n%3==0) return false;
		
		for(int i = 3; i*i<=n; i+=2){
			if(n/i == 0)
				return false;
		}
		
		if(n <= 1) return false;
		
		return true;
	}
	
	

}
