package javaFinal;

public class Player {

	String team;
	String name;
	int no;
	
	Player(String t, String n, int num){
		team = t;
		name = n;
		no = num;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String toString() {
		return "Player is from " + team + ", player's name is " + name + " player's no. is " + no;
	}

}
