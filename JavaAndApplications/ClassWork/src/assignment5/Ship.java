package assignment5;

public class Ship {
	private String name;
	private int year;
	
	Ship(String name, int year){
		this.name = name;
		this.year = year;
	}
	
	Ship(){
		name = "Default";
		year = 1993;
	}
	
	public String toString(){
		return "Name of Ship: " + name + 
				"\n Year made: " + year +
				"\n------------------------\n";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

}
