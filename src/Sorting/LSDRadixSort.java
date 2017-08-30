package Sorting;

import java.util.LinkedList;

public class LSDRadixSort {

	public static void sort(String[] arr, int radix){
		final int R = radix;
		int bits = arr[0].length();
		
		@SuppressWarnings("unchecked")
		LinkedList<String>[] buckets = (LinkedList<String>[]) new LinkedList[R];
		
		for(int k = 0; k < R; k++){
			buckets[k] = new LinkedList<String>();
		}
		
		for(int w = bits - 1; w >= 0; w--){

			for(String item : arr){
				int key = Integer.valueOf(item.charAt(w));
				int index = (key >= 48 && key < 65? key - 48 : (key >= 65 ? key - 65 : key));
				buckets[index].addLast(item);
			}	
			
			for(int k = 0, i = 0; k < R; k++){
				while(!buckets[k].isEmpty()){
					arr[i++] = buckets[k].removeFirst();
				}
			}
		}
	}
	
	public static void main(String[] args){
		String[] testInput = {"826491", "649254", 
							  "913285", "831903", 
							  "193524", "732957",
							  "914935", "192846"};
		
		LSDRadixSort.sort(testInput, 26);
		
		System.out.println("Array after sort:");
		for(String item : testInput){
			System.out.println(item + " ");
		}
	}
}
