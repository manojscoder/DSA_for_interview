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
		bubbleSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void bubbleSort(int[] arr, int n) {
	    for(int idx = 0; idx < n - 1; idx++) {
	        int swapped = 0;
	        for(int j = 0; j < n - 1 - idx; j++) {
	            if(arr[j + 1] < arr[j]) {
	                arr[j + 1] += arr[j];
	                arr[j] = arr[j + 1] - arr[j];
	                arr[j + 1] -= arr[j];
	                swapped = 1;
	            }
	        }
	        
	        if(swapped == 0) {
	            break;
	        } 
	    }
	}
}
