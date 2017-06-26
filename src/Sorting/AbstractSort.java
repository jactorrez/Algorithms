package Sorting;

public abstract class AbstractSort {
	public static void sort(Comparable[] a){}
	
	public static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exchange(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		
		System.out.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i = 1; i < a.length; i++){
			if(less(a[i], a[i-1])){
				return false;
			}
		}
		
		return true;
	}
	
//	public static void main(String[] args){
//		Integer[] a = {4,6,2,3,7,1,9};
//		//sort(a);
//		assert isSorted(a);
//		show(a);
//	}
}
