package Sorting;
import java.util.ArrayList;

import PriorityQueue.Entry;
import PriorityQueue.HeapPriorityQueue;

public class HeapSort<K,V> extends AbstractSort {
	
	private HeapPriorityQueue<K,V> sortHeap;
	private ArrayList<Entry<K,V>> innerHeapList;
	private int lastIndex;
	
	// Constructors
	public HeapSort(ArrayList<Entry<K,V>> a){
		sortHeap = new HeapPriorityQueue<K,V>(a);
		innerHeapList = sortHeap.heap;
		lastIndex = innerHeapList.size() - 1;
	}
	
	public void sort(){
		
		while(lastIndex > 0){
			sortHeap.swap(0, lastIndex);
			lastIndex--;
			sortDownheap(0);	
		}
	}
	
	/* Moves the entry at index i lower, if necessary, to restore the heap property */
	public void sortDownheap(int i){
		while(sortHeap.hasLeft(i) && (sortHeap.left(i) < lastIndex)){
			int leftIndex = sortHeap.left(i);
			int smallChildIndex = leftIndex;
			if(sortHeap.hasRight(i)){
				int rightIndex = sortHeap.right(i);
				if(sortHeap.compare(innerHeapList.get(leftIndex), innerHeapList.get(rightIndex)) > 0){
					smallChildIndex = rightIndex;
				}
			}
			
			if(sortHeap.compare(innerHeapList.get(smallChildIndex), innerHeapList.get(i)) >= 0){
				break;				  // heap property restored
			} 
			
			sortHeap.swap(i, smallChildIndex);
			i = smallChildIndex;
		}
	}
	
	public static <K,V> void showList(ArrayList<Entry<K,V>> a){
		
		for (int i = 0; i < a.size(); i++){
			System.out.print(a.get(i).getKey() + " ");
		}
		
		System.out.println();
	}
	
	public static void main(String[] arg){
		ArrayList<Entry<Integer, String>> test = new ArrayList<>();
		
		test.add(new TestEntry<Integer, String>(12, "a"));
		test.add(new TestEntry<Integer, String>(2, "b"));
		test.add(new TestEntry<Integer, String>(5, "c"));
		test.add(new TestEntry<Integer, String>(1, "d"));
		test.add(new TestEntry<Integer, String>(9, "e"));
		test.add(new TestEntry<Integer, String>(5, "f"));
		test.add(new TestEntry<Integer, String>(15, "g"));
		test.add(new TestEntry<Integer, String>(3, "h"));
		test.add(new TestEntry<Integer, String>(18, "i"));
		
		HeapSort<Integer, String> testSort = new HeapSort<>(test);
		System.out.println("Before: ");
		showList(testSort.innerHeapList);
	
		testSort.sort();
		System.out.println("After: ");
		testSort.showList(test);
	}
}
