package Assignment8;

public class HoursWorkedException extends Exception {
	public HoursWorkedException(){
		super();
	}
	
	public HoursWorkedException(double hoursWorked){
		super("Invalid value for the hours worked: " + hoursWorked);
	}
	

}
