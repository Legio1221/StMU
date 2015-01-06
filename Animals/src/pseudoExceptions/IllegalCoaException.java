package pseudoExceptions;

public class IllegalCoaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalCoaException ()	{
		super();
	}
	
	public IllegalCoaException(int coa){
		System.out.println("CoA number is not its standard 7 digit display!\nCoA: " + coa);
	}
}
