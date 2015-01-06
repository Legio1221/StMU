package pseudoExceptions;

public class IllegalAmountException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalAmountException(){
		super();
	}
	
	public IllegalAmountException(double amount){
		System.out.println("Illegal amount declared on check! \nAmount: " + amount +"\nPlease enter a positive amount");
	}
}
