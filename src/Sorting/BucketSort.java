package sorting;

import java.util.ArrayList;
import java.util.Arrays;

import sorting.InsertionSort;

public class BucketSort {
	
	public static int[] sort(int[] items){
		int N = items.length;				// length of array to sort
		int divisor = findDivisor(items);   // finding divisor to use for hash function
		
		// creating array of arraylists (buckets)
		@SuppressWarnings("unchecked")
		ArrayList<Comparable<Integer>>[] buckets = (ArrayList<Comparable<Integer>>[]) new ArrayList[N];
		 
		// initializing buckets  
		for (int i = 0; i < N; i++) {
		    buckets[i] = new ArrayList<Comparable<Integer>>();
    	}
		
		// distributing items into buckets
		for(int item : items){
			int index = hash(item, divisor, N) == 11 ? 10 : hash(item, divisor, N);
			buckets[index].add(item);
		}
		
		// sort each bucket using insertion sort
		for(ArrayList<Comparable<Integer>> bucket : buckets){
			InsertionSort.sort(bucket);
		}
		
	    // merge the buckets
		int index = 0;
		
	    for (int b = 0; b < N; b++) {
	      for (Comparable<Integer> v : buckets[b]) {
	        items[index++] = (int) v;
	      }
	    }
		
		return items;
	}
	
	// ---- utility functions ----
	
	// hash function for distributing items in buckets
	private static int hash(int number, int divisor, int length){
		double calcHash = length * ((double) number / divisor);

		int hash = (int) Math.floor(calcHash);	
		return hash;
	}
	
	// finding the highest value within input array to use as divisor in the hash function
	private static int findDivisor(int[] items){
		int highest = items[0];
		
		for(int i = 1; i < items.length; i++){
			if(items[i] > highest){
				highest = items[i];
			}
		}
		
		return highest;
	}
	
	// unit testing
	public static void main(String[] args){
		System.out.println("Bucket sort in Java");
	    int[] input = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };
	    
	    BucketSort.sort(input);
	    System.out.println(Arrays.toString(input));
	}
}
