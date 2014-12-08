package program3;

public class StockTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stockNumber = 1000;
		double COMMISSION_RATE = 0.02;
		double share = 32.87;
		double shareTwo = 33.92;
		
		System.out.println("Joe paid " + stockNumber * share + "for his stocks.");
		System.out.println("Joe paid the commissioner " + (stockNumber*share)*COMMISSION_RATE);
		System.out.println("Joe sold the stock for " + stockNumber*shareTwo);
		System.out.println("Joe paid the commissioner " + (stockNumber*shareTwo)*COMMISSION_RATE);
		System.out.println("Joe made a profit of " + ((stockNumber*shareTwo)-(stockNumber*share)-((stockNumber*share)*COMMISSION_RATE)-((stockNumber*shareTwo)*COMMISSION_RATE)));

	}

}
