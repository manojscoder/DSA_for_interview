// Time:
// Best: O(n ^ 2)
// Average: O(n ^ 2)
// Worst: O(n ^ 2)

// Space: O(1)

import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int[] arr = {9, 4, 1, 3, 6, 7, 7, 5};
		selectionSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void selectionSort(int[] arr, int n) {
	    int minIdx;
	    
	    for(int idx = 0; idx < n; idx++) {
	        minIdx = idx;
	        
	        for(int j = idx + 1; j < n; j++) {
	            if(arr[minIdx] > arr[j]) {
	                minIdx = j;
	            }
	        }
	        
	        if(minIdx != idx) {
	            arr[idx] += arr[minIdx];
	            arr[minIdx] = arr[idx] - arr[minIdx];
	            arr[idx] -= arr[minIdx];
	        }
	    }
	}
}
