package Assignment9;

public class TestScores {

	double average;
	int counter = 0;

	public void getAverage(int[] array) throws InvalidTestScore {

		double totalSum = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0 && array[i] <= 100) {
				totalSum += array[i];
				counter++;
			}
		}
		average = totalSum / counter;

		for (int j = 0; j < array.length; j++) {
			if (array[j] < 0 || array[j] > 100) {
				throw new InvalidTestScore(array[j]);
			}
		}

	}
}
