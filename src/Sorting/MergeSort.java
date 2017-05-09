package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort{
	
	private int[] array;
	private int length;
	
	public MergeSort(int[] array){
		this.array = array;
		this.length = array.length;
	}
	
	public void sort(){
		divide(array);
	}
	
	private void divide(int[] arr){
		
		if(arr.length <= 1)
			return; 
		
		int arrMid = arr.length/2;
		
		// create left-most array, then populate 
		int[] left = new int[arrMid];
		for(int i = 0; i < arrMid; i++){
			left[i] = arr[i];
		}
		
		// create right-most array, then populate
		int[] right = new int[arr.length - arrMid];
		
		for(int z = arrMid; z < arr.length; z++){
			right[z - arrMid] = arr[z];
		}

		divide(left);
		divide(right);
		merge(left, right, arr);
		
	}
	
	private void merge(int[] arr1, int[] arr2, int[] targetArr){
		
		int left_i = 0;
		int right_i = 0;
		
		int k = 0;
		
		int arr1_length = arr1.length;
		int arr2_length = arr2.length;
		
		while(left_i < arr1_length && right_i < arr2_length){
			if(arr1[left_i] < arr2[right_i]){
				targetArr[k] = arr1[left_i];
				
				left_i++;
			} else{
				targetArr[k] = arr2[right_i];
				right_i++;
			}
			k++;
		}
		
		while(left_i < arr1_length){
			targetArr[k] = arr1[left_i];
			left_i++;
			k++;
		}
		
		while(right_i < arr2_length){			
			targetArr[k] = arr2[right_i];
			right_i++;
			k++;
		}
	}
	
	public static void main(String[] args){
		int[] testArr = {1, 6, 2, 3, 4, 5, 8, 9, 3, 5, 10};
		System.out.println("Before: " + Arrays.toString(testArr));
		MergeSort test = new MergeSort(testArr);
		test.sort();
		System.out.println("After: " + Arrays.toString(testArr));
	}

}
