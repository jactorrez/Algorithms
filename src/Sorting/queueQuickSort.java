package Sorting;

import java.util.Comparator;
import Queue.*;

public class queueQuickSort extends AbstractSort{
	
	public static <K> void sort(Queue<K> S, Comparator<K> comp){
		int n = S.size();
		if (n < 2){							// queue is trivially sorted
			return;								
		}
		
		K pivot = S.first();			    // using first as arbitrary pivot
		
		// divide original into L, E, and G
		Queue<K> L = new LinkedQueue<>();
		Queue<K> E = new LinkedQueue<>();
		Queue<K> G = new LinkedQueue<>();
		
		while(!S.isEmpty()){
			K element = S.dequeue();
			int c = comp.compare(element, pivot);
			if(c < 0){					   // element is less than pivot 
				L.enqueue(element);
			} else if(c == 0){
				E.enqueue(element);        // element is equal to pivot
			} else {
				G.enqueue(element);        // element is greater than pivot
			}
		}
		
		// conquer
		quickSort(L, comp);				  // sort elements less than pivot
		quickSort(G, comp);				  // sort elements greater than pivot
		
		// concatenate results
		while(!L.isEmpty()){
			S.enqueue(L.dequeue());
		} 
		
		while(!E.isEmpty()){
			S.enqueue(E.dequeue());
		}
		
		while(!G.isEmpty()){
			S.enqueue(G.dequeue());
		}
	}
}
