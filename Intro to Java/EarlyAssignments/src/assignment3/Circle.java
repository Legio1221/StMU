package assignment3;

public class Circle {

	double radius;
	
	void setRadius(double r){
		radius = r;
	}
	
	double getRadius(){
		return radius;
	}
	
	double getArea(){
		return (Math.PI*radius*radius);
	}
	
	double getDiameter(){
		return (radius*2);
	}
	
	double getCircumference(){
		return (2 * Math.PI * radius); 
	}

}
