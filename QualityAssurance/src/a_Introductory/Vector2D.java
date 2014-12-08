package a_Introductory;

public class Vector2D {
	public Integer x, y;
	public Point p1, p2;
	
	Vector2D(){
		p1 = new Point(0,10);
		p2 = new Point(100,10);
		
		this.x = 100;
		this.y = 0;
	}
	
	/* Construct Vector2D from two points */
	Vector2D(Point p1, Point p2) {
		this.x = p2.x - p1.x;
		this.y = p2.y - p1.y;
	}
	
	public int dotProduct(Vector2D v) {
		return (x * v.x) + (y * v.x);
	}
	
	public boolean isOrthogonalTo(Vector2D v) {
		if (dotProduct(v) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
