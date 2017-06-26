package Sorting;

public class SelectionSort extends AbstractSort
{	// Sort a into ascending order
	public static void sort(Comparable[] a){
		int N = a.length;							// cache array length
		for(int i = 0; i < N; i++){
			int min = i;
			for(int j = i+1; j < N; j++){
				if(less(a[j], a[min])){
					min = j;
				}
			}
			exchange(a, i, min);					// exchanges i with the smallest value found in a[i+1..N]
		}
	}
}
