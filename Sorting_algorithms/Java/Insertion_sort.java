// Time:
// Best: O(n)
// Average: O(n ^ 2)
// Worst: O(n ^ 2)

// Space: O(1)

import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int[] arr = {9, 4, 1, 3, 6, 7, 7, 5};
		insertionSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertionSort(int[] arr, int n) {
	    int i;
	    for(int idx = 1; idx < n; idx++) {
	        i = idx;
	        
	        while(i > 0 && arr[i] < arr[i - 1]) {
	            arr[i] += arr[i - 1];
	            arr[i - 1] = arr[i] - arr[i - 1];
	            arr[i] -= arr[i - 1];
	            i--;
	        }
	    }
	}
}
