// Time:
// Best case: O(1)
// Average case: O(n)
// Worst case: O(n)

// Space: O(1)

private int linearSearch(int[] arr, int key, int len) {

  for(int idx = 0; idx < len; idx++) {
    
    if(arr[idx] == key) {
      return idx;
    }
    
  }

  return -1;
}
