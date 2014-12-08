package Assignment8;

public class StringException extends Exception{

public StringException(){
	super();
}
	


public StringException(String name){
	super("Empty string is given for Employee's name");
}

}
