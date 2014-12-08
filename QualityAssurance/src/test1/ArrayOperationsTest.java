package test1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayOperationsTest {
	
	int x,y,z; //To be used in the mathematical operations
	int[] array;
	int[][] array2;
	int[] array3;
	int[][] array4;
	
	public void setup(){
		int i,j,x;
		array = new int[]{1,2,3};
		array2 = new int[2][2];
		array3 = new int[]{10,11,12,13,14,15};
		array4 = new int[4][4];
		
		x = 1; //used in initializing array2's values
		
		//for loop to initialize variables within double array
		for(i=0;i<2;i++){
			for(j=0;j<2;j++){
				array2[i][j] = x;
				x++;
			}
		}
		
		x = 1; //reset x = 1 to initialize array4's values
		
		for(i=0;i<4;i++){
			for(j=0;j<3;j++){
				array4[i][j] = x;
				x++;
			}
		}
	}

	@Test
	public void testReverseArray() {
		setup();
		array = ArrayOperations.reverseArray(array);
		array3 = ArrayOperations.reverseArray(array3);
		assertArrayEquals(new int[]{3,2,1},array);
		assertArrayEquals(new int[]{15,14,13,12,11,10},array3);
	}
	
	@Test
	public void testArraySum() {
		setup();
		int z;	//holds integer value from array sum.
		
		z = ArrayOperations.arraySum(array2);
		assertEquals(10,z);
		z = ArrayOperations.arraySum(array4);
		assertEquals(78,z);
	}

}
