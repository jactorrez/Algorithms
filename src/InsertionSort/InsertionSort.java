package InsertionSort;

import java.util.Arrays;

public class InsertionSort{
	
	protected int[] array;
	
	public InsertionSort(int[] array){
		this.array = array;
	}
	
	public String printArray(){
		String arrToString = Arrays.toString(array);
		return arrToString;
	}
	
	public void sort(){
		int arrLength = array.length;
		
		for(int i = 1; i < arrLength; i++){
			int currentIndex = i;
			int currentVal = array[i];
			
			while(currentIndex >= 1 && currentVal < array[currentIndex - 1]){
				array[currentIndex] = array[currentIndex - 1];
				currentIndex--;
			}
			
			array[currentIndex] = currentVal;
		}
	}
	
	public static void main(String[] args){
		int[] testArr = {9, 8, 7, 5, 3, 1, 0};
		
		InsertionSort test = new InsertionSort(testArr);
		System.out.println("Before sort: " + test.printArray());
		test.sort();
		System.out.println("After sort: " + test.printArray());
		
	}
}

