package test2;

public class EngStudent extends Student implements Comparable{

	int math, eng;
	
	public EngStudent(String Name,int math, int eng){
		this.math = math;
		this.eng = eng;
		setName(Name);
	}
	
	public void setScore(int eng, int math){
		super.setScore(math+eng);
	}

	public void compareScore(EngStudent e){
		if(this.getScore() > e.getScore()){
			System.out.println(this.getName() + ": Math score is: " + this.getMath() + " Eng score is: " + this.getEng() + " Total score is: " + this.getScore() + 
			" Grade is: " + this.getGrade());
			
			
			System.out.println(e.getName() + ": Math score is: " + e.getMath() + " Eng score is: " + e.getEng() + " Total score is: " + e.getScore() + 
					" Grade is: " + e.getGrade());
			
			
			System.out.println(this.getName() + "'s score is higher");
		}else if(this.getScore()<e.getScore()){
			System.out.println(e.getName() + ": Math score is: " + e.getMath() + " Eng score is: " + e.getEng() + " Total score is: " + e.getScore() + 
					" Grade is: " + e.getGrade());
			
			System.out.println(this.getName() + ": Math score is: " + this.getMath() + " Eng score is: " + this.getEng() + " Total score is: " + this.getScore() + 
					" Grade is: " + this.getGrade());
			
			System.out.println(e.getName() + "'s score is higher");
		}else if(this.getScore()==e.getScore()){
			System.out.println(this.getName() + ": Math score is: " + this.getMath() + " Eng score is: " + this.getEng() + " Total score is: " + this.getScore() + 
					" Grade is: " + this.getGrade());
			
			System.out.println(e.getName() + ": Math score is: " + e.getMath() + " Eng score is: " + e.getEng() + " Total score is: " + e.getScore() + 
					" Grade is: " + e.getGrade());
			
			System.out.println("Both scores are the same");
		}
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public String toString(){
		String s = (getName() + ": Math score is: " + getMath() + " Eng score is: " + getEng() + " Total score is: " + getScore() + 
				" Grade is: " + getGrade());
		return s;
	}
	
	
}
