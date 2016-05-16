package assignment5;

public class CargoShip extends Ship{

	int tonnage;
	
	CargoShip(String name, int tonnage){
		setName(name);
		this.tonnage = tonnage;
	}
	
	public String toString(){
		return "The ship's name is: " + getName() + 
				"\n The ship's tonnage is: " + tonnage +
				"\n------------------------\n";
	}

	public int getTonnage() {
		return tonnage;
	}

	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}
	
	
}
