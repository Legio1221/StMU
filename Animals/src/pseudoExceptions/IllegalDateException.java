package pseudoExceptions;

public class IllegalDateException extends Exception{
	public IllegalDateException() {
		super();
	}
	
	public IllegalDateException(int date)	{
		System.out.println("Illegal date format!");
	}
}
