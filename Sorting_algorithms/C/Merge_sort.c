// Time: O(n * log n)
// Space: O(n)

#include <stdio.h>
#include <stdlib.h>

int* merge(int* left, int* right, int left_len, int right_len) {
    int m = 0, n = 0, idx = 0;
    
    int* merged = (int*)malloc((left_len + right_len) * sizeof(int));
    
    while(m < left_len && n < right_len) {
        if(left[m] < right[n]) {
            merged[idx++] = left[m++];
        }
        else {
            merged[idx++] = right[n++];
        }
    }
    
    while(m < left_len) {
        merged[idx++] = left[m++];
    }
    
    while(n < right_len) {
        merged[idx++] = right[n++];
    }
    
    return merged;
}

int* mergeSort(int* arr, int n) {
    if(n > 1) {
        int mid = n / 2;
        
        int* left = (int*)malloc(mid * sizeof(int));
        int* right = (int*)malloc((n - mid) * sizeof(int));
        
        for(int idx = 0; idx < mid; idx++) {
            left[idx] = arr[idx];
        }
        
        for(int idx = mid; idx < n; idx++) {
            right[idx - mid] = arr[idx];
        }
        
        int* sorted = merge(mergeSort(left, mid), mergeSort(right, n - mid), mid, n - mid);
        
        free(left);
        free(right);
        
        return sorted;
    }
    
    return arr;
}

int main() {
    int arr[] = {9, 4, 1, 3, 6, 7, 5};
    int n = 7;
    
    printf("Before sorting: ");
    for(int idx = 0; idx < n; idx++) {
        printf("%d ", arr[idx]);
    }
    
    int* sorted = mergeSort(arr, n);
    
    printf("\n\nAfter sorting: ");
    for(int idx = 0; idx < n; idx++) {
        printf("%d ", sorted[idx]);
    }
    
    free(sorted);
    
    return 0;
}
