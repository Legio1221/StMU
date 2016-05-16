package assignment6;

public abstract class PhoneBill {
	private double monthlyRate;
	private double callRate;
	
	public double getCallRate() {
		return callRate;
	}

	public void setCallRate(double callRate) {
		this.callRate = callRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public PhoneBill(){
		monthlyRate = 30;
	}

	public PhoneBill(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public double getMonthlyRate() {
		return monthlyRate;
	}

	public abstract double calculateBill(int time);
}