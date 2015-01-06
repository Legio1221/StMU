package genLedgerExceptions;

public class NegativeAmountException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeAmountException(){
		super();
	}
	
	public NegativeAmountException(double amount){
		System.out.println("Negative amount declared on check! \nAmount: " + amount);
	}
}
