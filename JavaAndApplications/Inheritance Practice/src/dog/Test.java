package dog;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog d = new Dog();
		d.name ="Rex";
		d.breed="bulldog";
		System.out.println("The dog's name is " + d.name + "\nThe dog's breed is " + d.breed);
		d.bark();

	}

}
