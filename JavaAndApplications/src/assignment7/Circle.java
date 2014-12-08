package assignment7;

public class Circle extends GeometricObject implements Comparable {
int radius;
// 2piR
//piR^2


Circle(int radius){
	this.radius = radius;
}



public double getArea(){
	return (Math.PI*radius*radius);
}



public double getPerimeter(){
	return (2*Math.PI*radius);
}



public boolean isEquals(GeometricObject go){
	if(this.getArea() == go.getArea()){
		return true;
	}else{
		return false;
	}
}

public boolean isGreater(GeometricObject go){
	if(this.getArea() > go.getArea()){
		return true;
	}else{
		return false;
	}
}

public boolean isLess(GeometricObject go){
	if(this.getArea() < go.getArea()){
		return true;
	}else{
		return false;
	}
}



}
