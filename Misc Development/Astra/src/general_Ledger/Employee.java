package general_Ledger;

public class Employee {
private String 	name, address;
private int		id, socialSecurity, zipCode, dependents;
private double 	invoiceDollars;
private boolean	isHourly, isWithHolding, isCitizen, isActive;

private int wageRate, ficaSocialSecurity, ficaMediCare, federalWithHolding;

/****************************************************************************
 * wageRate holds typical rate of employee.                                 *
 * FICA and federal with holding hold total deduction values.               *
 ****************************************************************************/

public Employee(){
	name = "Unknown";
	address = "N/A";
	id = 123456;
	socialSecurity = 555555555;
	zipCode = 78526;
	dependents = 0;
	isCitizen = true;
	isActive = true;
	isHourly = true;
	isWithHolding = true;
	wageRate = 12;
	ficaSocialSecurity = 0;
	ficaMediCare = 0;
	federalWithHolding = 0;
	invoiceDollars = 0;
}

public boolean isActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getSocialSecurity() {
	return socialSecurity;
}

public void setSocialSecurity(int socialSecurity) {
	this.socialSecurity = socialSecurity;
}

public int getZipCode() {
	return zipCode;
}

public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}

public int getDependents() {
	return dependents;
}

public void setDependents(int dependents) {
	this.dependents = dependents;
}

public double getInvoiceDollars() {
	return invoiceDollars;
}

public void setInvoiceDollars(double invoiceDollars) {
	this.invoiceDollars = invoiceDollars;
}

public boolean isHourly() {
	return isHourly;
}

public void setHourly(boolean isHourly) {
	this.isHourly = isHourly;
}

public boolean isWithHolding() {
	return isWithHolding;
}

public void setWithHolding(boolean isWithHolding) {
	this.isWithHolding = isWithHolding;
}

public boolean isCitizen() {
	return isCitizen;
}

public void setCitizen(boolean isCitizen) {
	this.isCitizen = isCitizen;
}

public int getWageRate() {
	return wageRate;
}

public void setWageRate(int wageRate) {
	this.wageRate = wageRate;
}

public int getFicaSocialSecurity() {
	return ficaSocialSecurity;
}

public void setFicaSocialSecurity(int ficaSocialSecurity) {
	this.ficaSocialSecurity = ficaSocialSecurity;
}

public int getFicaMediCare() {
	return ficaMediCare;
}

public void setFicaMediCare(int ficaMediCare) {
	this.ficaMediCare = ficaMediCare;
}

public int getFederalWithHolding() {
	return federalWithHolding;
}

public void setFederalWithHolding(int federalWithHolding) {
	this.federalWithHolding = federalWithHolding;
}

public String toString(){
	System.out.println("Name: " + name);
	System.out.println("Address: " + address);
	System.out.println("Identifcation Number: " + id);
	System.out.println("Social Security Number:" + socialSecurity);
	System.out.println("Zip Code: " + zipCode);
	System.out.println("Number of Dependents: " + dependents);
	if(isCitizen == true){
		System.out.println("Is citizen? Yes");
	}else{
		System.out.println("Is citizen? No");
	}
	if(isHourly == true){
		System.out.println("Hourly Employee? Yes");
	}else{
		System.out.println("Hourly Employee? No");
	}
	if(isWithHolding == true){
		System.out.println("Does employee have federal with holding? Yes");
	}else{
		System.out.println("Does employee have federal with holding? No");
	}
	System.out.println("Wage Rate: " + wageRate);
	System.out.println("Year to date Social Security deductions: " + ficaSocialSecurity +
			"\nYear to date Medi Care deductions: " + ficaMediCare + 
			"\nYear to date Federal With Holding: " + federalWithHolding);
	System.out.println("Lifetime invoice dollars" + invoiceDollars);
	return "";
}

}
