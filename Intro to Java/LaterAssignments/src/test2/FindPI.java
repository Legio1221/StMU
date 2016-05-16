package test2;
import java.util.Scanner;

public class FindPI {
	
	private double PiReiteration
	public static double getPI(double ii){
		double PI = 4*( 1 - (1/3) + (1/5) - (1/7) + (1/9) - (1/11) + ((Math.pow(-1, (ii+1)))/(2(ii)-1)) );
		
		return PI;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double i = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the number iterations to find PI");
		
		i = keyboard.nextDouble();
		
		System.currentTimeMillis();
		
		System.out.println(FindPI.getPI(i));
		System.out.println("It took "+ (System.currentTimeMillis()/1000) +" seconds");
		
	}

}
