package Assignment8;

public class IdException extends Exception{

public IdException(){
	super();
}

public IdException(int idNumber){
	super("Invalid value is given for the ID Number:  " + idNumber);
}

}
