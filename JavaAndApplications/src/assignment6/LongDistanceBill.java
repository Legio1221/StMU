package assignment6;

public class LongDistanceBill extends PhoneBill{
	

	LongDistanceBill(double monthlyRate, double callRate){
		setMonthlyRate(monthlyRate);
		setCallRate(callRate);
	}
	
	public double calculateBill(int time){
		double bill = ((super.getCallRate()*time)+super.getMonthlyRate());
		
		return bill;
	}
	
}
