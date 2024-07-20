// Time: O(n * log n)
// Space: O(n)
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int[] arr = {9, 4, 1, 3, 6, 7, 7, 5};
		arr = mergeSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	private static int[] mergeSort(int[] arr, int n) {
	    if(n > 1) {
	        int mid = n / 2;
	        int[] left = new int[mid];
	        int[] right = new int[n - mid];
	        
	        for(int idx = 0; idx < mid; idx++) {
	            left[idx] = arr[idx];
	        }
	        
	        for(int idx = mid; idx < n; idx++) {
	            right[idx - mid] = arr[idx];
	        }
	        
	        left = mergeSort(left, mid);
	        right = mergeSort(right, n - mid);
	        
	        return merge(left, right);
	    }
	    
	    return arr;
	}
	
	private static int[] merge(int[] left, int[] right) {
	    int m = 0, n = 0, idx = 0;
	    int[] merged = new int[left.length + right.length];
	    
	    while(m < left.length && n < right.length) {
	        if(left[m] < right[n]) {
	            merged[idx++] = left[m++];
	        }
	        else {
	            merged[idx++] = right[n++];
	        }
	    }
	    
	    while(m < left.length) {
	        merged[idx++] = left[m++];
	    }
	    
	    while(n < right.length) {
	        merged[idx++] = right[n++];
	    }
	    
	    return merged;
	}
}
