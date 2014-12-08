package assignment5;

public class CruiseShip extends Ship{
	
	int passengers;

	CruiseShip(String name, int passengers){
		setName(name);
		this.passengers = passengers;
	}
	
	public String toString(){
		return "The ship's name is: " + getName() + 
				"\n Amount of passengers is: " + passengers +
				"\n------------------------\n";
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
	

	
}
