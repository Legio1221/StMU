package assignment5;

public class Calculator {

	int getLargest(int num, int x, int y) {
		int large = 0;
		if(num>x && num>y){
			large = num;
		}else if(x>num && x>y){
			large = x;
		}else if(y>num && y>x){
			large = y;
		} return large;
	}
	
	int getSmallest(int num, int x, int y){
			int small = 0;
			if(num<x && num<y){
				small = num;
			}else if(x<num && x<y){
				small = x;
			}else if(y<num && y<x){
				small = y;
			} return small;
		}

	int getSum(int num, int x, int y){
		int sum = num+x+y;
		return sum;
	}
	
	int getProduct(int num, int x, int y){
		int product = num*x*y;
		return product;
	}
	
	int getAverage(int num, int x, int y){
		int average = (num+x+y)/3;
		return average;
	}
	
}