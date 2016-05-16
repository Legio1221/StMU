package test01;

class Testclass01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Testclass02 Jake = new Testclass02(); //create new cat object called Jake
		Jake.name="Jake"; // set's the name field to Jake
		Jake.weight=18.5; // set's the weight field to Jake
		Jake.color="Orange"; //set's the color field to Orange
		Jake.age=11; // set's the age field to 11

		System.out.println("Cat's name is " + Jake.name); //prints cat's name
		System.out.println("Cat's age is " + Jake.age); //prints cat's age
		Jake.run(); //calls cat's run method
	}

}
