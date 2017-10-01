package sorting;

import java.util.Random;

public class QuickSort {
	
	// Method client calls to begin sort
	public static <T> void sort(Comparable<T>[] arr){
		// shuffle array to ensure linearithmic running time
		shuffle(arr);
		sort(arr, 0, arr.length - 1);
	}
	
	private static <T> void sort(Comparable<T>[] arr, int lo, int hi){
		
		// check for trivially sorted array (size 1) or illegal parameter  
		if(lo >= hi){
			return;
		}
		
		int splitIndex = partition(arr, lo, hi);
		
		sort(arr, lo, splitIndex - 1);
		sort(arr, splitIndex + 1, hi);	
	}
	
	// Partitioning logic
	private static <T> int partition(Comparable<T>[] array, int lo, int hi){
		Comparable<T> pivot = array[lo];
		
		int i = lo, 
			j = hi + 1;
		
		while(true){

			// find item on left to swap
			while(less(array[++i], pivot)){
				if(i == hi) break;
			}
			
			// find item on right to swap
			while(less(pivot, array[--j])){
				if(j == lo) break;
			}
		
			// check if pointers cross
			if (i >= j) break;
			
			exchange(array, i, j);
		}
		
		// swap with partitioning item
		exchange(array, lo, j);
		
		// return index of item now known to be in place
		return j;
	}
	
	// --- utility methods ---
	
	// Fisher-Yates shuffle to shuffle array
	private static <T> void shuffle(Comparable<T>[] array){
		int index;
		Comparable<T> temp;
		Random random = new Random();
		
		for(int i = array.length - 1; i > 0; i--){
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
	
	// check if value v is less than value w
	@SuppressWarnings("unchecked")
	public static <T> boolean less(Comparable<T> v, Comparable<T> w){
		return (v.compareTo((T) w) < 0);
	}
	
	// exchange item i with item j in array a
	public static <T> void exchange(Comparable<T>[] a, int i, int j){
		Comparable<T> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// unit testing
	public static void main(String[] args){
		String[] test = {"a", "d", "c", "b", "f", "g"};
		
		System.out.println("Sorting array...");
		QuickSort.sort(test);
		
		System.out.print("Result: ");
		for(String i : test){
			System.out.print(i + " ");
		}
	}
	
}
