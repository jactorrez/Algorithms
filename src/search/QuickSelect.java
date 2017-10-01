package search;
import java.util.Random;

public class QuickSelect {
	
	// Array to select kth item from
	int[] arr;
	
	/**
	 * Creates a QuickSelect instance with an array a to select an item from 
	 * @param a	array to select from
	 */
	public QuickSelect(int[] a){
		if(a == null)
			throw new NullPointerException("Null argument given");
		this.arr = a;
	}
	
	/**
	 * Returns the kth item in our array
	 * @param k  kth item to select
	 * @return	 kth item found
	 */
	public int select(int k){
		if(k > arr.length || k < 0)
			throw new IllegalArgumentException("Argument exceeds the lower-bound (0) or upper-bound (length of array)");
		
		int kth = select(0, arr.length-1, k-1);
		return kth;
	}
	
	/**
	 * Internal subroutine to start selection process 
	 * @param start	lower-bound of array area to scan through
	 * @param end	upper-bound of array area to scan through
	 * @param k	    kth item to select
	 * @return		kth item found
	 */
	private int select(int start, int end, int k){
		if(start == end)
			return arr[start];
		
		Random rand = new Random();
		int i = (start + rand.nextInt((end-start)+1));
		
		int pIndex = partition(start, end, i);
		
		if(k < pIndex){
			return select(start, pIndex - 1, k);
		} else if(k > pIndex){
			return select(pIndex + 1, end, k);
		} else {
			return arr[pIndex];
		}
	}
	
	/**
	 * Returns the final index/position of the chosen pivot 
	 * @param start		 lower-bound of array area to scan through
	 * @param end		 upper-bound of array area to scan through
	 * @param pivotIndex index of the pivot element (randomly) chosen
	 * @return			 final position of the pivot element
	 */
	// return index of partition (pivot) element 
	private int partition(int start, int end, int pivotIndex){
		int pivot = arr[pivotIndex];
		int partitionIndex = start;
		
		swap(pivotIndex, end);
		
		for(int i = start; i < end; i++){
			if(arr[i] < pivot){
				swap(i, partitionIndex);
				partitionIndex++;
			}
		}
		
		swap(partitionIndex, end);
		return partitionIndex;
	}
	
	/**
	 * Swaps value at position a with value at position b and vice versa
	 * @param a		index position of value to swap b with
	 * @param b		index position of value to swap a with
	 */
	private void swap(int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/*
	 * Unit testing
	 */
	public static void main(String[] args){
		int[] arr = {4,9,1,3,5};
		QuickSelect qs = new QuickSelect(arr);
		System.out.println(qs.select(2));
	}
}
