package Assignment8;

public class PayRateException extends Exception{

	PayRateException(){
		super();
	}
	
	PayRateException(double payRate){
		super("Invalid value for payRate:  " + payRate);
	}

}
