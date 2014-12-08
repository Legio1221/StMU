package polynomialProject;

import java.util.*;

public class PolyMain {

	public static void main(String[] args) {
		
		//Poly(int power, int coef)
		//Poly(int coef, boolean isOnlyCoef)
		
		Poly[] p = new Poly[5];
		Poly[] p2 = new Poly[3];
		Poly[] p3 = new Poly[] {new Poly(5,2), new Poly(4,-3), new Poly(3,2), new Poly(2, -7), new Poly(1,9), new Poly(34,true)};
		Poly[] p4 = new Poly[] {new Poly(5,-2), new Poly(4,-3), new Poly(3,2), new Poly(2, -7), new Poly(1,9), new Poly(0,34)};
		Poly[] p5 = new Poly[] {new Poly(2, 3), new Poly(1,-5), new Poly(4,true)};
		Poly[] p6 = new Poly[] {new Poly(5, 1), new Poly(4,-6), new Poly(3,8), new Poly(2,8), new Poly(1,4), new Poly(-4,true)};
		int n;
		int pow;
		

		for (int i = 0; i < p.length; i++) {
			n = i + 1;
			pow = p.length - i;
			
			p[i] = new Poly();
			
			p[i].setCoef(n);
			p[i].setPower(pow);
		}
		
		for (int i = 0; i < p2.length; i++) {
			n = i*2 + 1;
			pow = p.length - i;
			
			p2[i] = new Poly();
			
			p2[i].setCoef(n);
			p2[i].setPower(pow);
		}
		
		//superEval(p, 10);
		System.out.println("This is polynomial P");
		print(p);
		System.out.println("This is polynomial P2");
		print(p2);
		System.out.println("This is polynomial P3");
		print(p3);
		System.out.println("This is polynomial P4");
		print(p4);
		System.out.println("This is polynomial P5");
		print(p5);
		System.out.println("This is polynomial P6");
		print(p6);
		System.out.println("This is polynomial P3 + P2");
		print(add(p3,p2));
		System.out.println("This is polynomial P2 - P");
		print(sub(p2,p));
		System.out.println("This is polynomial P2 * P");
		print(mult(p,p2));
		System.out.println("This is polynomial f'(P)");
		print(prime(p));
		System.out.println("This is the Newton-Raphson root approach of P6");
		System.out.println(newtonRaphson(p6));
	}
	
	static public void superEval(Poly[] p, int x){
		
		int placeholder;
	
		for(int i=0; i<p.length; i++){
			placeholder = (p.length - 1) - i;
			System.out.println(p[placeholder].evaluate(x));
		}
		
	}
	
	static public double sum(Poly[] p, double x){
		double sum = 0;
		
		for(int i=0; i<p.length; i++){
			sum += p[i].evaluate(x);
		}
		
		return sum;
	}
	
	static public void print(Poly[] p){
		boolean isZero = false;
	
		for(int i=0; i<p.length; i++){
			if(p[i].getCoef() < 0 && i == 0){
				System.out.print("-");
				System.out.print(p[i].toString());
			}
			if(p[i].getCoef() > 0 && i == 0){
				System.out.print(p[i].toString());
			}else if(p[i].getCoef() == 0 && i ==0){
				System.out.print(p[i].toString());
			}
			if(p[i].getCoef() > 0 && i > 0 && i != (p.length)){
				System.out.print(" + ");
				System.out.print(p[i].toString());
			}else if(p[i].getCoef() < 0 && i > 0 && i != (p.length)){
				System.out.print(" - ");
				System.out.print(p[i].toString());
			}
			if(p[i].getPower() == 0){
				isZero = true;
			}
		}
		
		if(isZero){
			System.out.println("\n");
		}else{
			System.out.println(" + 0\n");
		}
		
	}
	
	static public void print(ArrayList<Poly> p){
		
		boolean isZero = false;
		
		for(int i=0; i<p.size(); i++){
			if(p.get(i).getCoef() < 0 && i == 0){
				System.out.print("-");
				System.out.print(p.get(i).toString());
			}
			if(p.get(i).getCoef() > 0 && i == 0){
				System.out.print(p.get(i).toString());
			}
			if(p.get(i).getCoef() > 0 && i > 0 && i != (p.size())){
				System.out.print(" + ");
				System.out.print(p.get(i).toString());
			}else if(p.get(i).getCoef() < 0 && i > 0 && i != (p.size())){
				System.out.print(" - ");
				System.out.print(p.get(i).toString());
			}
			if(p.get(i).getPower() == 0){
				isZero = true;
			}
		}
		
		if(isZero){
			System.out.println("\n");
		}else{
			System.out.println(" + 0\n");
		}
	}
	
	static public Poly[] add(Poly[] p, Poly[] p2){
		/*Adds polynomial functions with a variable X*/
		//p's length > p2
		
		Poly[] pAdd = new Poly[p.length];
		int coef;
		
		//Obtains pAdd's length, This loop does function as intended
		
		/*if(compareLength(p, p2) == 2){
				pAdd = new Poly[p.length];
			}else if(compareLength(p,p2) == 1){
					pAdd = new Poly[p2.length];
				}else if(compareLength(p,p2) == 3){
					pAdd = new Poly[p.length];
					}*/
		
		//initializes the array
		for (int i = 0; i < pAdd.length; i++) {
			pAdd[i] = new Poly();
			pAdd[i].setCoef(0);
			pAdd[i].setPower(0);
		}
			
		//Loops through and adds
		for(int i=0; i<p.length;i++){
			for(int j=0; j<p2.length; j++){
				if(comparePower(p[i],p2[j]) == 3){
					coef = (p[i].getCoef() + p2[j].getCoef());
					//System.out.println(coef);
					pAdd[i].setCoef(coef);
					pAdd[i].setPower(p[i].getPower());
					break;
				}
			}
		}
		
		for(int i=0;i<pAdd.length;i++){
			if(pAdd[i].getCoef() == 0 && pAdd[i].getPower() == 0){
				pAdd[i].setCoef(p[i].getCoef());
				pAdd[i].setPower(p[i].getPower());
			}
		}
		
		return pAdd;
		
	}
	
	static public Poly[] sub(Poly[] p, Poly[] p2){
		//p's length > p2
		
		Poly[] pSub = new Poly[p.length];
		int coef = 0;
		
		for (int i = 0; i < pSub.length; i++) {
			pSub[i] = new Poly();
			pSub[i].setCoef(0);
			pSub[i].setPower(0);
		}
		
		for(int i=0; i<p.length;i++){
			for(int j=0; j<p2.length; j++){
				if(comparePower(p[i],p2[j]) == 3){
					
					if(p[i].getCoef() > p2[j].getCoef()){
						coef = (p[i].getCoef() - p2[j].getCoef());
							}else if(p[i].getCoef() < p2[j].getCoef()){
									coef = (p2[j].getCoef() - p[i].getCoef());
								}
		
					//System.out.println(coef);
					pSub[i].setCoef(coef);
					pSub[i].setPower(p[i].getPower());
					break;
				} 
			}
		}
		
		for(int i=0;i<pSub.length;i++){
			if(pSub[i].getCoef() == 0 && pSub[i].getPower() == 0){
				pSub[i].setCoef(p[i].getCoef());
				pSub[i].setPower(p[i].getPower());
			}
		}
		
		return pSub;
	}
	
	static public ArrayList<Poly> mult(Poly[] p, Poly[] p2){
		
		int power, coef;
		ArrayList<Poly> polyArray = new ArrayList<Poly>(20);
		
		for(int i=0;i<p.length;i++){
			for(int j=0;j<p2.length;j++){
				power = p[i].getPower() + p2[j].getPower();
				//System.out.print("power: " + power);
				coef = p[i].getCoef() * p2[j].getCoef();
				//System.out.println("   Coef: " + coef);				
				polyArray.add(new Poly(power,coef));
				//System.out.println(polyArray.get(i+j).toString());
			}
		}	
		
		
		for(int i=0;i<polyArray.size();i++){
			for(int j=0;j<polyArray.size();j++){
				if(comparePower(polyArray.get(i), polyArray.get(j)) == 3 && polyArray.get(i) != polyArray.get(j)){
					power = polyArray.get(i).getPower();
					coef = polyArray.get(i).getCoef() + polyArray.get(j).getCoef();
					polyArray.set(i, new Poly(power, coef));
					polyArray.remove(j);
				}
			}
		}
		
		print(polyArray);
		
		return polyArray;
	}
	
	
	static public Poly[] prime(Poly [] p){
		Poly[] pPri = new Poly[p.length];
		int coef = 0;
		int pow = 0;
		
		for (int i = 0; i < pPri.length; i++) {
			pPri[i] = new Poly();
			pPri[i].setCoef(0);
			pPri[i].setPower(0);
		}
		
		for(int i=0;i<pPri.length;i++){
			if(p[i].getPower()==1){
				coef = p[i].getCoef();
				pPri[i].setCoef(coef);
				pPri[i].setOnlyCoef(true);
			} 
			if(p[i].getPower() != 0){
				coef = (p[i].getCoef() * p[i].getPower());
				pPri[i].setCoef(coef);
				pow = (p[i].getPower() - 1);
				pPri[i].setPower(pow);
			} else if(p[i].getPower() == 0){
				pPri[i].setCoef(0);
				pPri[i].setOnlyCoef(true);
			}
		}
		
		return pPri;
	}
	
	
	static public int greatestPower(Poly[] p){
		int bigPow;
		bigPow = 0;
		for(int i=0; i<p.length; i++){
			if(bigPow < p[i].getPower())
				bigPow = p[i].getPower();
			
		}
		return bigPow;
	}
	
	
	static public int compareLength(Poly[] p, Poly[] p2){
		/*
		 * If method returns 1, then p < p2
		 * If method returns 2, then p > p2
		 * If method returns 3, then p == 3
		 */
		
		int result = 0;
		
		if(p.length < p2.length){
			result = 1;
		} else if(p.length > p2.length){
			result = 2;
		} else if(p.length == p2.length){
			result = 3;
		}
		
		return result;
	}
	
	
	static public int comparePower(Poly p, Poly p2){
		/*
		 * If method returns 1, then p < p2
		 * If method returns 2, then p > p2
		 * If method returns 3, then p == p2
		 */
		
		int result = 0;
		
		if(p.getPower() < p2.getPower()){
			result = 1;
		} else if(p.getPower() > p2.getPower()){
			result = 2;
		} else if(p.getPower() == p2.getPower()){
			result = 3;
		}
		
		return result;
	}
	
	static public double newtonRaphson(Poly[] p){
		double limit = Math.pow(10, -6); //f(x) must not be smaller than this
		int max = 50; //The maximum amount of iterations
		double x =0; //value after using NR
		double x0 = 3; //X naught
		double fx =1; //f(x), use sum
		double prime =1;//f'(x), use prime and sum
		Poly[] fprime = new Poly[p.length];
		fprime = prime(p);
		
		
		
		for(int i=1;i<max && Math.abs(fx) > limit;i++){
			fx = sum(p,x0);
			prime = sum(fprime,x0);
			x = x0 - (fx/prime);
			x0 = x;
			
		}
		
		return x;
	}
	
	
}
