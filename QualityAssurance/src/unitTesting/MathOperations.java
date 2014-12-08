package unitTesting;

public class MathOperations {
	
	int x;
	int y;
	
	MathOperations(){
		x = 4;
		y = 5;
	}

	public static int add(int x, int y){
		int z;
		z = x + y;
		return z;
	}
	
	public static int mul(int x, int y){
		int z;
		z = x * y;
		return z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
