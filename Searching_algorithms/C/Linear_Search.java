// Time:
// Best case: O(1)
// Average case: O(n)
// Worst case: O(n)

// Space: O(1)

private int linearSearch(int[] arr, int key) {
  
  for(int idx = 0; idx < arr.length; idx++) {
    if(key == arr[idx]) {
      return idx;
    }
  }
  
  return -1;
}
