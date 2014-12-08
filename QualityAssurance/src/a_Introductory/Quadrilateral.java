package a_Introductory;

public class Quadrilateral {
	private Point p1, p2, p3, p4;
	private Line l1, l2, l3, l4;
	
	Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.l1 = new Line(p1, p2);
		this.l2 = new Line(p2, p3);
		this.l3 = new Line(p3, p4);
		this.l4 = new Line(p4, p1);
	}
	
	/* Boolean isRectangle() {
		Vector2D v1 = l1.getVector();
		Vector2D v2 = l2.getVector();
		Vector2D v3 = l3.getVector();
		Vector2D v4 = l4.getVector();
		
		if (v1.isOrthogonalTo(v2) == true &&
			v2.isOrthogonalTo(v3) == true &&
			v3.isOrthogonalTo(v4) == true &&
			v4.isOrthogonalTo(v1) == true &&
			l1.isSameLengthAs(l3) && l2.isSameLengthAs(l4) &&
			l1.getLength() != l2.getLength())	{
			
			return true;
			
		} else {
			return false;
		}
			
	}*/

	public boolean isRectangle() {
		//Replaced rectangle method with this
		//Implemented method could not correctly determine if a quadrilateral was a rectangle
		boolean result, isAll90, isCorrectSides;
		double corner,corner2,corner3,corner4;
		corner = l1.getCorner(l2);
		corner2 = l2.getCorner(l3);
		corner3 = l3.getCorner(l4);
		corner4 = l4.getCorner(l1);
		
		//Determines if all corners are 90 degrees
		if( corner == 90.0 && corner2 == 90.0 &&
			corner3 == 90.0 && corner4 == 90.0)	{
			isAll90 = true;
		} else {
			isAll90 = false;
		}
		
		//Determines if Line 1 is not equal to Line 2
		if(l1.getLength() != l2.getLength() && l1.getLength() == l3.getLength() &&
			l2.getLength() == l4.getLength()){
			isCorrectSides = true;
		} else {
			isCorrectSides = false;
		}
		
		//Conditions must be met to have rectangle
		if ( isAll90 == true && isCorrectSides == true) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
		
	}
	
	public Boolean isSquare() {
			    //Replaced Square method with this
				//Implemented method could not correctly determine if a Quadrilateral was a rectangle
				boolean result, isAll90, isCorrectSides;
				double corner,corner2,corner3,corner4;
				corner = l1.getCorner(l2);
				corner2 = l2.getCorner(l3);
				corner3 = l3.getCorner(l4);
				corner4 = l4.getCorner(l1);
				
				//Determines if all corners are 90 degrees
				if( corner == 90.0 && corner2 == 90.0 &&
					corner3 == 90.0 && corner4 == 90.0)	{
					isAll90 = true;
				} else {
					isAll90 = false;
				}
				
				//Determines if Line 1 is not equal to Line 2
				if( l1.getLength() == l2.getLength() &&
					l1.getLength() == l3.getLength() &&
					l1.getLength() == l4.getLength()) {
					isCorrectSides = true;
				} else {
					isCorrectSides = false;
				}
				
				//Conditions must be met to have rectangle
				if ( isAll90 == true && isCorrectSides == true) {
					result = true;
				} else {
					result = false;
				}
				
				return result;

	}

}
