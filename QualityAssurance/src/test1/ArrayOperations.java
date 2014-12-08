package test1;

public class ArrayOperations {

	public static int[] reverseArray(int[] array){
		int[] newArray = new int[array.length];
		for(int i=0;i<array.length;i++){
			newArray[i] = array[array.length - i-1]; //required the -1 to work
		}
		return newArray;
	}
	
	public static int arraySum(int[][] array){
		int total = 0;
		
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array[i].length ; j++){ //an extra -1 was in place
				total += array[i][j];
			}
		}
		return total;
	}
}
