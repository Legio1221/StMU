package general_Ledger;

public class Accountant extends Employee{

private int total941, totalFinStmts, totalPRCks, compNum;
private double missedDays;

/*
 * compNum - Amount of companies under accountant
 */

public Accountant(){
	setName("Oscar");
	setAddress("2146 Madero Dr.");
	setId(572389);
	setZipCode(78526);
	setDependents(0);
	setCitizen(true);
	setHourly(false);
	setWithHolding(true);
	setActive(true);
	setWageRate(10);
	setFicaSocialSecurity(0);
	setFicaMediCare(0);
	setFederalWithHolding(0);
	setInvoiceDollars(0);
}



@Override
public String toString() {
	return "Accountant [total941=" + total941 + ", totalFinStmts="
			+ totalFinStmts + ", totalPRCks=" + totalPRCks + ", compNum="
			+ compNum + ", missedDays=" + missedDays + ", isActive()="
			+ isActive() + ", getName()=" + getName() + ", getAddress()="
			+ getAddress() + ", getId()=" + getId() + ", getSocialSecurity()="
			+ getSocialSecurity() + ", getZipCode()=" + getZipCode()
			+ ", getDependents()=" + getDependents() + ", getInvoiceDollars()="
			+ getInvoiceDollars() + ", isHourly()=" + isHourly()
			+ ", isWithHolding()=" + isWithHolding() + ", isCitizen()="
			+ isCitizen() + ", getWageRate()=" + getWageRate()
			+ ", getFicaSocialSecurity()=" + getFicaSocialSecurity()
			+ ", getFicaMediCare()=" + getFicaMediCare()
			+ ", getFederalWithHolding()=" + getFederalWithHolding()
			+ ", toString()=" + super.toString() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + "]";
}

public int getTotal941() {
	return total941;
}

public void setTotal941(int total941) {
	this.total941 = total941;
}

public int getTotalFinStmts() {
	return totalFinStmts;
}

public void setTotalFinStmts(int totalFinStmts) {
	this.totalFinStmts = totalFinStmts;
}

public int getTotalPRCks() {
	return totalPRCks;
}

public void setTotalPRCks(int totalPRCks) {
	this.totalPRCks = totalPRCks;
}

public double getMissedDays() {
	return missedDays;
}

public void setMissedDays(double missedDays) {
	this.missedDays = missedDays;
}

public int getCompNum() {
	return compNum;
}

public void setCompNum(int compNum) {
	this.compNum = compNum;
}



}