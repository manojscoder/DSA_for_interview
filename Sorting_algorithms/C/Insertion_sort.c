// Time:
// Best: O(n)
// Average: O(n ^ 2)
// Worst: O(n ^ 2)

// Space: O(1)

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
