package sorting;

public class ThreeWayRadixSort {
	
	// method client calls to begin sorting
	public static void sort(String[] array){
		sort(array, 0, array.length - 1, 0);
	}
	
	private static void sort(String[] array, int lo, int hi, int d){
		if(lo >= hi) return;
		
		int lt = lo, gt = hi;
		int v = charAt(array[lo], d);
		int i = lo + 1;
		
		while(i <= gt){
			int t = charAt(array[i], d);
			
			if(t < v){
				exch(array, i++, lt++);
			} else if(t > v){
				exch(array, i, gt--);
			} else {
				i++;
			}
		}
		
		sort(array, lo, lt-1, d);
		if(v >= 0)
			sort(array, lt, gt, d + 1);
		sort(array, gt+1, hi, d);
	}
	
	// gets character at index d, returns -1 if no character exists at that index
	private static int charAt(String str, int d){
		if(d < str.length()){
			return str.charAt(d);
		} else {
			return -1;
		}
	}
	
	// replace string in index i with string in index j, and vice versa
	private static void exch(String[] arr, int i, int j){
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// unit testing
	public static void main(String[] args){
		String[] test = {"she", "sells", "seashells", "by", "the", "sea", "shore",
						 "the", "shells", "she", "sells", "are", "surely", "seashells"};
		
		System.out.println("Sorting array...");
		ThreeWayRadixSort.sort(test);
		
		System.out.println("Result");
		for(String i : test){
			System.out.println(i);
		}
	}
}
