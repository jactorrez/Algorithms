package Sorting;

import java.util.Comparator;

public class quickSortInPlace {
	
	public <K> void sortInPlace(K[] S, Comparator<K> comp, int a, int b){
		
		if(a >= b){ 	
			return;					// subarray is trivially sorted
		}
		
		int left = a;
		int right = b-1;
		K pivot = S[b];
		K temp;						// temp object used for swapping
		
		while(left <= right){
			// scan until reaching value equal or larger than pivot (or right marker)
			while((left <= right) && (comp.compare(S[left], pivot) < 0)){
				left++;
			}
			
			// scan until reaching value equal or smaller than pivot (or left maker)
			while(left <= right && comp.compare(S[right], pivot) > 0){
				right--;
			}
			
			if(left <= right){	// indices did not strictly cross
				// so swap values and shrink range
				temp = S[left];
				S[left] = S[right];
				S[right] = temp;
				left++;
				right--;
			}	
		}
		
		// put pivot into its final place (currently marked by left index)
		temp = S[left];
		S[left] = S[b];
		S[b] = temp;
		
		// make recursive calls
		sortInPlace(S, comp, a, left - 1);
		sortInPlace(S, comp, left + 1, b);
	}
}
