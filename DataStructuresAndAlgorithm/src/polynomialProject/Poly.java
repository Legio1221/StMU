package polynomialProject;

import java.lang.Math;

public class Poly {
	
	private int coef;
	private int power;
	private boolean isOnlyCoef = false;
	
	public Poly(){
		
	}
	
	public Poly(int power, int coef){
		this.coef = coef;
		this.power = power;
	}
	
	public Poly(int coef, boolean isOnlyCoef){
		this.coef = coef;
		this.isOnlyCoef = isOnlyCoef;
	}
	
	public double evaluate(double x){
		double result;
		
		result = Math.pow(x, this.power);
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
	
	public boolean isOnlyCoef() {
		return isOnlyCoef;
	}

	public void setOnlyCoef(boolean isOnlyCoef) {
		this.isOnlyCoef = isOnlyCoef;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		if(power != 0){
			s = "" + Math.abs(coef) + "x^(" + power + ")";
		} else if(isOnlyCoef){
			s = "" + Math.abs(coef) + "";
		} else if(power == 0){
			s = "1";
		}
		return s; 
	}
	
}
	