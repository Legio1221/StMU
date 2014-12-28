package genLedgerExceptions;

public class NegativeAmountException extends Exception{
	public NegativeAmountException(){
		super();
	}
	
	public NegativeAmountException(double amount){
		System.out.println("Negative amount declared on check! \nAmount: " + amount);
	}
}
