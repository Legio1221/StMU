package assignment4;

public class Fan {

int speed;
boolean fanStatus=false;
double radius=5.0;
String color="blue";

Fan(){};

Fan(int s, boolean f, double r, String n){
	speed = s;
	fanStatus=f;
	radius = r;
	color = n;
}

void toString(int speed,  boolean fanStatus, double radius, String color){
	System.out.println("Speed: " + speed);
	System.out.println("Fan Status: " + fanStatus);
	System.out.println("Radius: " + radius);
	System.out.println("Color: " + color);
	
}


}
