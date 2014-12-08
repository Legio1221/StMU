package classwork1;

public class Circle {
private int radius;
public static  int numberOfCircles;

Circle(int r){
	radius = r;
	numberOfCircles++;
}

public void setRadius(int r){
	radius = r; 
}

double getArea(){
	return radius*radius*Math.PI;
}

int getRadius(){
	return radius;
}

}
