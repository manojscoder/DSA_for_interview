// Time:
// Best case: O(1)
// Average case: O(log n)
// Worst case: O(log n)

// Space: O(1)

private int binarySearch(int[] arr, int key, int len) {
  int left = 0, right = len - 1, mid;

  while(left <= right) {
    
    mid = (left + right) / 2;
    if(arr[mid] == key) {
      return mid;
    else if(arr[mid] > key) {
      right = mid - 1;
    }
    else {
      left = mid + 1;
    }
    
  }

  return -1;
}
