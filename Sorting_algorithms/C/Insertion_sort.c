// Time:
// Best: O(n)
// Average: O(n ^ 2)
// Worst: O(n ^ 2)

// Space: O(1)


// Approach: 1
void insertionSort(int* arr) {
    for(int i = 1; arr[i] != '\0'; i++) {
        int j = i;
        while(j > 0 && arr[j] < arr[j - 1]) {
            arr[j] = arr[j] + arr[j - 1];
            arr[j - 1] = arr[j] - arr[j - 1];
            arr[j] = arr[j] - arr[j - 1];
            j--;
        }
    }
}

// Approach: 2
void insertionSort(int* arr, int len) {
    int val, j;
    
    for(int idx = 1; idx < len; idx++) {
        val = arr[idx];
        j = idx - 1;
        
        while(j >= 0 && arr[j] > val) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = val;
    }
}
