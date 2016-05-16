package assignment6;

public class MersennePrime {

	boolean isMersennePrime(int m, double n){
		if(m == (Math.pow(2, n)-1)) return true;
		
		if(m == 2 || m == 3 || m <=1) return false;
		
		return false;
	}

}
