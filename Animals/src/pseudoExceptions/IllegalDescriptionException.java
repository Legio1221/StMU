package pseudoExceptions;

public class IllegalDescriptionException extends Exception {
	public IllegalDescriptionException	()	{
		super();
	}
	
	public IllegalDescriptionException (char[] description)	{
		System.out.println("Illegal Description!");
	}
}
