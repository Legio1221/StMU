package assignment1;

import java.math.*;

public class ThePoint {

	int x,y,a,b;
	
	ThePoint(){
		x=0;
		x=0;
	}

	ThePoint(int a, int b){
		this.a=a;
		this.b=b;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public static double distance(int x, int y, int a, int b){
		double distance;
		
		distance = Math.sqrt((Math.pow((a-x),2))+(Math.pow((b-y),2)));
		
		return distance;
	}
}
