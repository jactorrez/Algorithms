package search;

public class BinarySearch {
	private int[] data;
	
	public BinarySearch(int[] arr){
		this.data = arr;
	}
	
	public boolean search(int target){
		return binarySearch(target, 0, data.length - 1);
	}
	
	public boolean iterativeSearch(int target){
		return binarySearchIterative(target);
	}
	
	/* Returns true if the target value is found in the indicated portion of the array
	 * This search only considers the array portion from data[low] to data[high] inclusive
	 */
	protected boolean binarySearch(int target, int low, int high){
		if(low > high){
			return false;
		} else {
			int mid = (low + high) / 2;
			
			if(data[mid] == target){
				return true;
			} else if(target < data[mid]){
				return binarySearch(target, low, mid - 1);
			} else {
				return binarySearch(target, mid + 1, high);
			}
		}
	}
	
	/* Turns recursive binarySearch function non-recursive (iterative) */
	protected boolean binarySearchIterative(int target){
		int low = 0;
		int high = data.length - 1;
		while(low <= high){
			int mid = (low + high)/2;
			if(target == data[mid]){
				return true;	
			} else if(target < data[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args){
		int[] testArr = {1,2,3,5,6,7,8,9};
		BinarySearch test = new BinarySearch(testArr);
		boolean valueFound = test.search(2); // should return true;
		boolean valueNotFound = test.search(4); // should return false;
		System.out.println("Look for number 2 (Should return true)");
		System.out.println(valueFound);
		System.out.println("Look for number 4 (Should return false)");
		System.out.println(valueNotFound);
		System.out.println("Test non-recursive search function:");
		System.out.println(test.iterativeSearch(2));
		System.out.println(test.iterativeSearch(4));
	}
}
