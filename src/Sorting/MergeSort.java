package Sorting;

import java.util.Arrays;

public class MergeSort{
	
	public static void sort(int[] array){
		// Start sort
		mergeSort(array);
	}
	
	private static void mergeSort(int[] arr){
		
		// Cache  array length
		int arrLength = arr.length;
		
		// Check if length of array is less than or equal to 1
		// If so, return because it is already sorter/unable to split
		if(arrLength <= 1)
			return; 
		
		// Calculate center of array to create two new, equal-sized arrays
		int arrMid = arrLength/2;
		
		// Create new array to represent left-half of previous array 
		int[] leftArray = new int[arrMid];
		
		// Fill new left-half array with content from previous "full" array 
		System.arraycopy(arr, 0, leftArray, 0, arrMid);

		// Create right-half of previous array
		int[] rightArray = new int[arrLength - arrMid];
		
		// Fill new right-half array with content from previous "full" array
		System.arraycopy(arr, leftArray.length, rightArray, 0, rightArray.length);

		mergeSort(leftArray);
		mergeSort(rightArray);
		mergeHalves(leftArray, rightArray, arr);
	}
	
	private static void mergeHalves(int[] leftArray, int[] rightArray, int[] destArray){
		
		// Both arrays are "new" arrays, so index starts at 0
		int indexLeft = 0;
		int indexRight = 0;
		
		// Index of open space in destination array where sorted elements are placed
		int indexDest = 0;
		
		// Caching length of left and right array, respectively
		int leftLength = leftArray.length;
		int rightLength = rightArray.length;
		
		while(indexLeft < leftLength && indexRight < rightLength){
			if(leftArray[indexLeft] < rightArray[indexRight]){
				destArray[indexDest++] = leftArray[indexLeft++];
			} else{
				destArray[indexDest++] = rightArray[indexRight++];
			}
		}

		// Copy remaining elements from both halves if remaining elements exist in either
		System.arraycopy(leftArray, indexLeft, destArray, indexDest, leftLength - indexLeft);
		System.arraycopy(rightArray, indexRight, destArray, indexDest, rightLength - indexRight);
		
	}
	
	public static void main(String[] args){
		// Unsorted array
		int[] testArr = {1, 6, 2, 10, 20, 80, 3};
		
		// Output unsorted array 
		System.out.println("Before: " + Arrays.toString(testArr));
		
		// Call merge sort
		MergeSort.sort(testArr);
		
		// Output sorted array 
		System.out.println("After: " + Arrays.toString(testArr));
	}

}
