package general_Ledger;

public class Company {
private int id;
private String nationality, address, classification;
private boolean isAmerican;
Accountant PRAccountant;
/* Must implement a database to keep list of companies */
 
	public Company(int id, String nationality, String address, String classification, boolean isAmerican,Accountant accountant){
		this.id = id;
		this.nationality = nationality;
		this.address = address;
		this.classification = classification;
		this.isAmerican = isAmerican;
		this.PRAccountant = accountant;
	}
	
	public Company(){
		this.id = "123456";
		this.nationality = "American";
		this.address = "N/A";
		this.classification = "Small Corp";
		this.isAmerican = true;
		this.PRAccountant = new Accountant();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public boolean isAmerican() {
		return isAmerican;
	}

	public void setAmerican(boolean isAmerican) {
		this.isAmerican = isAmerican;
	}

	public Accountant getPRAccountant() {
		return PRAccountant;
	}

	public void setPRAccountant(Accountant pRAccountant) {
		PRAccountant = pRAccountant;
	}
	
}
