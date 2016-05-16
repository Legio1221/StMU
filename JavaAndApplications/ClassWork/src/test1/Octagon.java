package test1;

public class Octagon extends Polygon{
	
	Octagon(int side, int sideLength){
		super.setSide(side);
		super.setSideLength(sideLength);
	}
	
	public double getArea(){
		double x = (2 + 4*(Math.sqrt(2)));
		double area = x*(super.getSide()*super.getSide());
		
		return area;
	}
	
	public String toString(){
		return "Octagon has " + super.getSide() + " sides" +
	"\n An area of " + getArea() + "\n A perimeter of " + super.getPerimeter() +
	"\n An internal angle of " + super.getAngle() + "\n" + super.getDateCreated();
	}
	
}
