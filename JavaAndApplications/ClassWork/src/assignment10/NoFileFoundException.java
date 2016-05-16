package assignment10;
import java.io.*;

public class NoFileFoundException extends Exception{

	NoFileFoundException(){
		super();
	}
	
	NoFileFoundException(String s){
		super(s + " Cannot be found.");
	}
}
