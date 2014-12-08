package a_Introductory;

public class Point {
	public Integer x, y;
	
	Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Point add(Point p, Integer x, Integer y) {
		return new Point(x + p.x, y + p.y);
	}
	
	public Point sub(Point p, Integer x, Integer y) {
		return new Point(x - p.x, y - p.y);
	}
}
