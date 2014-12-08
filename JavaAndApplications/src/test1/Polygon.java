package test1;

public class Polygon extends GeometricObject1{

	private int side;
	private int sideLength;
	
	
	
	public int getPerimeter(){
		return (sideLength * side);
	}
	
	public double getAngle(){
		
		double angle = ((sideLength - 2)*(180.0/sideLength));
		return angle;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

}
