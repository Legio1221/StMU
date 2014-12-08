package Assignment9;

public class TestScoresDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {94,85,65,87,900};
		TestScores test = new TestScores();
		try{
		test.getAverage(array);
		}
		catch(InvalidTestScore e){
			System.out.println("Error - " + e.getMessage());
		}
		finally{
			System.out.println("The average of the legal scores is " + test.average +
					"\nThere are " + test.counter + " legal scores out of " + array.length + " total scores.");
		}
		
	}

}
