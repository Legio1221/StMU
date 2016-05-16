package polynomialProject;

import java.lang.Math;

public class Poly {
	
	private int coef;
	private int power;
	
	public Poly(){
		
	}
	
	public Poly(int power, int coef){
		this.coef = coef;
		this.power = power;
	}
	
	public int evaluate(int x){
		int result;
		
		result = (int)Math.pow(x, this.power);
		result = this.coef*result;
		
		return result;
	}

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + coef + "x^(" + power + ")"; 
	}
	
}
	