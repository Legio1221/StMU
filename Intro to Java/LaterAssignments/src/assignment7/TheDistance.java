package assignment7;

public class TheDistance {

	public static double getDistance(double x1, double x2, double y1, double y2){
		double distance, x, y;
		
		x = x2 - x1;
		y = y2 - y1;
		distance = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
		
		return distance;
		
	}

}
