package Assignment8;

public class Payroll {

String employeeName;
double hourlyPayRate, hoursWorked;
int idNumber;

Payroll(String employeeName, int idNumber) throws IdException, StringException{
	if(idNumber < 0){
		throw new IdException(idNumber);
	}
	if(employeeName == ""){
		throw new StringException(employeeName);
	}
	this.employeeName = employeeName;
	this.idNumber = idNumber;
}



public String getEmployeeName() {
	return employeeName;
}



public void setEmployeeName(String employeeName) throws StringException{
	if(employeeName == ""){
		throw new StringException(employeeName);
	}
	
	this.employeeName = employeeName;
	
	}



public int getIdNumber() {
	return idNumber;
}



public void setIdNumber(int idNumber) throws IdException{
	if(idNumber < 0 || idNumber > 2147483647){
		throw new IdException(idNumber);
	}
	this.idNumber = idNumber;
}



public double getHourlyPayRate() {
	return hourlyPayRate;
}



public void setHourlyPayRate(double hourlyPayRate) throws PayRateException{
	if(hourlyPayRate <= 0){
		throw new PayRateException(hourlyPayRate);
	}
	this.hourlyPayRate = hourlyPayRate;
}



public double getHoursWorked() {
	return hoursWorked;
}



public void setHoursWorked(double hoursWorked) throws HoursWorkedException{
	if(hoursWorked <= 0 || hoursWorked > 84){
		throw new HoursWorkedException(hoursWorked);
	}
	this.hoursWorked = hoursWorked;
}



double grossPay(double hoursWorked, double hourlyPayRate) throws HoursWorkedException, PayRateException{
	if(hoursWorked < 0 || hoursWorked > 84) {
		throw new HoursWorkedException(hoursWorked);
	}
	
	if(hourlyPayRate <= 0){
		throw new PayRateException(hourlyPayRate);
	}
	return (hoursWorked * hourlyPayRate);
}

public String toString(){
	return ("Name: " + employeeName + "\nId: " + idNumber + "");
}

}
