package b_Money;

public class AccountExistsException extends Exception {
	//static final long serialVersionUID = 1L; 
	
	public AccountExistsException(){
		super( "Error: Account exists.");
	}
}
