// Time: 
// Best case: O(n log n)
// Average case: O(n log n)
// Worst case: O(n ^ 2)

// Space: O(log n)

int partition(int* arr, int low, int high) {
    int pivot = arr[low], i = low + 1, j = high;
    
    while(i < j) {
        while(i < high && arr[i] < pivot) {
            i++;
        }
        
        while(j > low && arr[j] > pivot) {
            j--;
        }
        
        if(i < j) {
            arr[i] += arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] -= arr[j];
        }
    }
    
    arr[low] += arr[j];
    arr[j] = arr[low] - arr[j];
    arr[low] -= arr[j];
    
    return j;
}

void quickSort(int* arr, int low, int high) {
    if(low < high) {
        int pivotIdx = partition(arr, low, high);
        quickSort(arr, low, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, high);
    }
}
