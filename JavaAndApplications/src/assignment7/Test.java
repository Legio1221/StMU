package assignment7;

public class Test {

	public static void main(String[] args){
		Rectangle rec = new Rectangle(5,9);
		GeometricObject cir = new Circle(2);
		Circle cir2 = new Circle(8);
		GeometricObject rec2 = new Rectangle(4,6);
		Rectangle rec3 = new Rectangle(58,10);
		GeometricObject cir3 = new Circle(13);
		
		
		
		rec.getArea();
		cir.getArea();
		
		rec2.getArea();
		cir2.getArea();
		
		rec3.getArea();
		cir3.getArea();
		
		
		
		if(rec.isLess(cir)==true){
			System.out.println("Rectangle has less area than Circle" +
		"\nRectangle Area: " + rec.getArea() + "\nCircle Area: " + cir.getArea());	
		}else if(rec.isLess(cir)==false){
			System.out.println("Rectangle hass less area area as Circle" +
		"\nRectangle Area: " + rec.getArea() + "\nCircle Area: " + cir.getArea());
		}
		
		System.out.println();
		
		if(cir2.isEquals(rec2)==true){
			 System.out.println("Circle2 has equal area with Rectangle2." + 
		"\nRectangle Area: " + rec2.getArea() + "\nCircle Area: " + cir2.getArea());
		}else if (cir2.isEquals(rec2) == false){
			System.out.println("Circle2 does not have equal area with Rectangle2" + 
		"\nRectangle Area: " + rec2.getArea() + "\nCircle Area: " + cir2.getArea());
		}
		
		System.out.println();
		
		if(rec3.isGreater(cir3)==true){
			System.out.println("Rectangle3 has greater area than Circle3." + 
		"\nRectangle Area: " + rec3.getArea() + "\nCircle Area: " + cir3.getArea());
		}else if(rec3.isGreater(cir3)==false){
			System.out.println("Rectangle3 has less area than Circle3." + 
		"\nRectangle Area: " + rec3.getArea() + "\nCircle Area: " + cir3.getArea());
		}
		
		
		
		
		
	}
	
}
