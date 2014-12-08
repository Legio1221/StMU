package assignment7;

public class Rectangle extends GeometricObject implements Comparable{

	int side, sideLength;
	
public Rectangle(int side, int sideLength){
	this.side = side;
	this.sideLength = sideLength;
}
	
public double	getArea(){
		return ( side * sideLength);
	}
	
public double getPerimeter(){
	return (2*side + 2*sideLength);
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
