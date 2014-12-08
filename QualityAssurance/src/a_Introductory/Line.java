package a_Introductory;

public class Line {
	private Point p1, p2;
	
	Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Vector2D getVector() {
		return new Vector2D(p1, p2);
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
	}
	
	public double getCorner(Line l2){
		double length, length2;
		double x,x2,result; 
		double i,j;
		
		length = Math.abs(getLength()); //3
		length2 = Math.abs(l2.getLength());//3
		
		i = length / length2;
		j = length2 / length;
		
		x = Math.atan(i);
		x = Math.abs(x); //absolute value of arctan ( y / x )
		x = Math.toDegrees(x);
		
		x2 = Math.atan(j);
		x2 = Math.abs(x2);//absolute value of arctan ( x / y )
		x2 = Math.toDegrees(x2);
		
		result = x + x2;
		result = 180 - result;
		return result;
		} //used to determine a corner
	
	public Boolean isSameLengthAs(Line l) {
		//Needed change in method
		double result;
		result = Math.abs(getLength() - l.getLength());
		if (result < 0.00001){
			return true;
		} else {
			return false;
		}
		// return (Math.abs(getLength() - l.getLength()) < 0.00001);
	}
}
