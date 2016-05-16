package assignment2;

public class Essay extends GradedActivity{
 private double grammar, spelling, content;
	
	public void setEssay(){
		
		double numericScore = grammar + spelling + content;
		
		setScore(numericScore);
	}

	public double getGrammar() {
		return grammar;
	}

	public void setGrammar(double grammar) {
		this.grammar = grammar;
	}

	public double getSpelling() {
		return spelling;
	}

	public void setSpelling(double spelling) {
		this.spelling = spelling;
	}

	public double getContent() {
		return content;
	}

	public void setContent(double content) {
		this.content = content;
	}

}