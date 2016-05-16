package test2;

public abstract class Student extends GradedActivity{

	private int id;
	private String name;
	
	Student(){
		
	}
	
	Student(int score, String name){
		setScore(score);
		this.name = name;
	}
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	

}
