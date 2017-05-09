package Sorting;

import java.util.Arrays;

public class MergeSort{
	
	private int[] array;
	private int length;
	
	public MergeSort(int[] array){
		this.array = array;
		this.length = array.length;
	}
	
	public void sort(){
		startSort(array);
	}
	
	private void divide(int[] arr){
		
		if(length <= 1)
			return; 
		
		int arrMid = length/2;
		
		// create left-most array, then populate 
		int[] left = new int[arrMid];
		for(int i = 0; i < arrMid; i++){
			left[i] = arr[i];
		}
		
		// create right-most array, then populate
		int[] right = new int[length - arrMid];
		
		for(int z = arrMid; z < length; z++){
			right[z - arrMid] = arr[z];
		}
		
		divide(left);
		divide(right);
		merge(left, right);
		
	}
	
	private int[] merge(int[] arr1, int[] arr2){
		
		int firstIndex = 0;
		int secondIndex = 0;
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
		
		while(firstIndex < arr1Length && secondIndex < arr2Length){
			
		}
		
		while(firstIndex < arr1Length){
			
		}
		
		while(secondIndex < arr1Length){
			
		}
	}
	
	public static void main(String[] args){
		int[] testArr = {2, 3, 4, 5, 7};
		MergeSort test = new MergeSort(testArr);
		test.sort();
	}

}
