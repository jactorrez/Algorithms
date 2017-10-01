package sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort{
	
	@SuppressWarnings("unchecked")
	public static <T> boolean less(Comparable<T> v, Comparable<T> w){
		return (v.compareTo((T) w) < 0);
	}
	
	public static <T> void sort(Comparable<T>[] arr){
		
		int N = arr.length;
		
		for(int i = 1; i < N; i++){
			int currentIndex = i;
			Comparable<T> currentVal = arr[i];
			
			while(currentIndex >= 1 && less(currentVal, arr[currentIndex - 1])){
				arr[currentIndex] = arr[currentIndex - 1];
				currentIndex--;
			}
			
			arr[currentIndex] = currentVal;
		}
	}
	
	public static <T> void sort(ArrayList<Comparable<T>> arr){
		
		int N = arr.size();
		
		for(int i = 1; i < N; i++){
			int currentIndex = i;
			Comparable<T> currentVal = arr.get(i);
			
			while(currentIndex >= 1 && less(currentVal, arr.get(currentIndex - 1))){
				arr.set(currentIndex, arr.get(currentIndex - 1));
				currentIndex--;
			}
			
			arr.set(currentIndex, currentVal);
		}
	}
	
	
	public static void main(String[] args){
		ArrayList<Comparable<Integer>> testArr = new ArrayList<>();
		testArr.add(5);
		testArr.add(4);
		testArr.add(2);
		testArr.add(90);
		
		InsertionSort.sort(testArr);
	
		System.out.print("[");	
		for(Comparable<Integer> item : testArr){
		
			System.out.print(item + ",");
		}
		System.out.print("]");	
	}
}

