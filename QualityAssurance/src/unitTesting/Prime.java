package unitTesting;

public class Prime {
	
	int x;

	public Prime(){
		x = 100;
	}
	
	public static boolean isPrime(int n) {
		boolean isPrime = true;
		if (n == 2){
			return true;
		}
		
		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if ( n % i == 0 ) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
	
	public static boolean isMersennePrime(int n) {
		boolean isMersennePrime = false;
		
		if(isPrime(n)) {
			for (int i = 1; i < Math.sqrt(n) + 1; i++){
				
				if (n == Math.pow(2, i)-1){
					isMersennePrime = true;
				}
			}
		}
		return isMersennePrime;
	}
	
	
	
}
