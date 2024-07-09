// Time:
// Best: O(n)
// Average: O(n ^ 2)
// Worst: O(n ^ 2)

// Space: O(1)
void bubbleSort(int* arr, int n) {
    
    for(int i = 0; i < n - 1; i++) {
        int swapped = 0;
        
        for(int j = 0; j < n - 1 - i; j++) {
            
            if(arr[j + 1] < arr[j]) {
                swapped = 1;
                arr[j + 1] += arr[j];
                arr[j] = arr[j + 1] - arr[j];
                arr[j + 1] -= arr[j];
            }
        }
        
        if(!swapped)
            break;
    }
}
