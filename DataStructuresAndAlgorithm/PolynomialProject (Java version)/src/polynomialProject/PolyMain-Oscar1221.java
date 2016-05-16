package polynomialProject;

import java.util.Random;
import java.util.*;

public class PolyMain {

	public static void main(String[] args) {

		Poly[] p = new Poly[5];
		Poly[] p2 = new Poly[3];
		ArrayList polyArray = new ArrayList(20);
		Random rand = new Random();
		int n;
		int pow;
		int power, coef;

		for (int i = 0; i < p.length; i++) {
			n = rand.nextInt(10) + 1;
			pow = p.length - i;
			
			p[i] = new Poly();
			
			p[i].setCoef(n);
			p[i].setPower(pow);
			
			System.out.print("Coefficient: " + n);
			System.out.print(" Power: " + pow + "  ");
			System.out.println(p[i].toString());
			
		}
		
		for (int i = 0; i < p2.length; i++) {
			n = rand.nextInt(10) + 1;
			pow = p.length - i;
			
			p2[i] = new Poly();
			
			p2[i].setCoef(n);
			p2[i].setPower(pow);
			
		}
		
		superEval(p, 10);
		print(p);
		print(p2);
		System.out.print("This is the greatest Power: ");
		System.out.println(greatestPower(p));
		System.out.println("This is the comparePower: " + "p[0] = " + p[0].getPower() + " p2[1] = " + p[1].getPower());
		System.out.println(comparePower(p[0],p2[1]));
		System.out.print("This is the compareLength: ");
		System.out.println(compareLength(p,p2));
		System.out.println(p[0].toString());
		System.out.println(p2[0].toString());
		print(add(p,p2));
		print(sub(p,p2));
		print(p);
		print(prime(p));
		
		for(int i=0;i<p.length;i++){
			for(int j=0;j<p2.length;j++){
				power = p[i].getPower() + p2[j].getPower();
				System.out.print("power: " + power);
				coef = p[i].getCoef() + p2[j].getCoef();
				System.out.println("   Coef: " + coef);
				Poly pTemp = new Poly();
		
				polyArray.add(pTemp);
			}
		}
		
		/*for(int i=0;i<polyArray.size();i++){
			System.out.println(polyArray.get(i));
		}*/
		
	}
	
	static public void superEval(Poly[] p, int x){
		
		int placeholder;
	
		for(int i=0; i<p.length; i++){
			placeholder = (p.length - 1) - i;
			System.out.println(p[placeholder].evaluate(x));
		}
		
	}
	
	static public void print(Poly[] p){
		
		System.out.println("The forumula is: ");
	
		for(int i=0; i<p.length; i++){
			if(p[i].getCoef() != 0 && p[i].getPower() != 0){
				System.out.print(p[i].toString());
				System.out.print(" + ");
			}
		}
		
		System.out.println(" 0");
		
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
					System.out.println(coef);
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
		
					System.out.println(coef);
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
	
	static public Poly[] mult(Poly[] p, Poly[] p2){
		//p.length > p2.length
		Poly[][] pMul;
		int coef;
		int power;
		//int highPow = p[0].getPower() * p2[0].getPower();
		int elementNum;
		
		pMul = new Poly[p.length][p2.length];
		
		for (int i = 0; i < p.length; i++) {
			for(int j=0; j<p2.length; j++){
				pMul[i][j] = new Poly();
				pMul[i][j].setCoef(0);
				pMul[i][j].setPower(0);
			}
		}
		
		for(int i=0; i<p.length; i++){
			for(int j=0; j<p2.length; j++){
				power = p[i].getPower() + p2[j].getPower();
				pMul[i][j].setPower(power);
				coef = p[i].getCoef() * p2[j].getCoef();
				pMul[i][j].setCoef(coef);
			}
		}
		
		for(int i=0; i<p.length; i++){
			int pow = p.length - i;
			add(pMul[pow], pMul[pow-1]); 
			
		}
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
			if(p[i].getPower() != 0){
				coef = (p[i].getCoef() * p[i].getPower());
				pPri[i].setCoef(coef);
				pow = (p[i].getPower() - 1);
				pPri[i].setPower(pow);
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
	
	
}
