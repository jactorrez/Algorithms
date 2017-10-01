package sorting;

public class CountingSort extends AbstractSort{
	
	public static int[] sort(int[] a, int r){
		int N = a.length;
		int[] count = new int[r+1];
		int[] output = new int[N];
		
		// store count of each element in input sequence
		for (int i = 0; i < N; i++){
			count[a[i]]++;
		}
		
		
		// store cumulates 
		for (int i = 1; i < count.length; i++){
			count[i] += count[i-1];
		} 
		
		// fill output array
		for(int i = N - 1; i >= 0; i--){
			output[count[a[i]]-1] = a[i];
			count[a[i]]--;
		}

		return output;
	}

	
	public static void main(String[] args){
		
		int[] a = {1,4,1,2,7,5,2};
		
		int[] sorted = CountingSort.sort(a, 7);
		showArray(sorted);
	}
}
