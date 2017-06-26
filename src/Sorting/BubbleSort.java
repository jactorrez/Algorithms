package Sorting;

public class BubbleSort extends AbstractSort{
	public static void sort(Comparable[] a){
		int arrLimit = (a.length - 1); 
		boolean sorted = false;
		
		while(!sorted){
			sorted = true;
			
			for(int i = 0; i < arrLimit; i++){
				if(less(a[i+1], a[i])){
					exchange(a, i, i+1);
					sorted = false;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Integer[] a = {1,6,7,8,9,1,4};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
