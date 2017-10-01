package sorting;

public class KeyIndexedCountingSort extends AbstractSort{

   public static int[] sort(int[] a, int r){
	   int N = a.length;
	   int[] count = new int[r + 1];
	   int[] aux = new int[N];
	   
	   	for (int i = 0; i < N; i++){
	   		count[a[i]+1]++;
	   	}
	    
	   	for (int i = 0; i < r; i++){
	   		count[i+1] += count[i];
	   	}
	   	
	   	for (int i = 0; i < N; i++){
	   		aux[count[a[i]]++] = a[i];
	   	}
	   	
	   	return aux;
   }
   
   public static void main(String[] args){
	   int[] test = {1,4,2,0,3,6,9};
	   
	   int[] sorted = KeyIndexedCountingSort.sort(test, 10);
	   KeyIndexedCountingSort.showArray(sorted);

   }
}
