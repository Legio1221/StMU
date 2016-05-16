package assignment6;

public class Prime {

	boolean isPrime(int n){
		if(n%2 == 0) return false;
		if(n==5 || n==3 || n==2) return true;
		if(n%5==0 || n%3==0) return false;
		
		for(int i = 3; i*i<=n; i+=2){
			if(n/i == 0)
				return false;
		}
		
		if(n <= 1) return false;
		
		return true;
	}
	
	public void setSmallerPrimes(int n){
		for(int i = 1;i<=n;i++){
			if(isPrime(i)==true){
			System.out.print(i+" ");
			}
		}
	}
}
	



