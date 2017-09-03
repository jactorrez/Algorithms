package Sorting;

import java.util.Random;

public class ThreeWayQuickSort {
	
	public static <T> void sort(Comparable<T>[] array){
		shuffle(array);
		sort(array, 0, (array.length - 1));
	}
	
	private static <T> void sort(Comparable<T>[] array, int lo, int hi){
		if(lo >= hi){
			return;
		}
		
		Comparable<T> pivot = array[lo];
		
		int	i = lo;
		int lt = lo;
		int	gt = hi;
		
		while(i <= gt){
			@SuppressWarnings("unchecked")
			int comp = array[i].compareTo((T) pivot);
			
			if(comp < 0){
				exchange(array, lt++, i++);
			} else if(comp > 0){
				exchange(array, gt--, i);
			} else{
				i++;
			}
		}

		sort(array, lo, lt - 1);
		sort(array, gt + 1, hi);	
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
	
	public static void main(String[] args){
		String[] test = {"a", "d", "c", "b", "f", "g"};
		
		System.out.println("Sorting array...");
		ThreeWayQuickSort.sort(test);
		
		System.out.print("Result: ");
		for(String i : test){
			System.out.print(i + " ");
		}
	}
}
