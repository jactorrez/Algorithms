package Sorting;

public class ShellSort extends AbstractSort{
	
	public static <E> void sort(Comparable<E>[] a){
		
		int N = a.length;
		
		int h = 1;
		
		while (h < N/3){
			h = 3 * h + 1;
		}
		
		while(h >= 1){
			
			for(int i = h; i < N; i++){
				for(int j = i; j >= h && less(a[j], a[j-h]); j -= h){
					exchange(a, j, j-h);
				}
			}
			
			h = h/3;
		}
	}
	
	public static void main(String[] args){
		Integer[] test = {3,5,1,2,7,9,6,3,4};
		
		ShellSort.show(test);
		ShellSort.sort(test);
		ShellSort.show(test);
	}
}
