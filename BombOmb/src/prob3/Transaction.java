package prob3;

public class Transaction {
	int number;
	int store;
	int dept;
	int mm, dd, yyyy;
	String partNum;
	int code;
	double amount;

	Transaction(int number, int store, int dept, int mm, int dd, int yyyy,
			String partNum, int code, double amount) {
		this.number = number;
		this.store = store;
		this.dept = dept;
		this.mm = mm;
		this.dd = dd;
		this.yyyy = yyyy;
		this.partNum = partNum;
		this.code = code;
		this.amount = amount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}

	public int getYyyy() {
		return yyyy;
	}

	public void setYyyy(int yyyy) {
		this.yyyy = yyyy;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
