// Time: O(n ^ 2)
// Space: O(n)
// Without duplicates
int* sortByCount(int* arr, int len) {
    int count[len];
    int* result = (int*)malloc(len * sizeof(int));
    
    for(int i = 0; i < len; i++) {
        count[i] = 0;
    }
    
    for(int i = 0; i < len - 1; i++) {
        for(int j = i + 1; j < len; j++) {
            if(arr[j] < arr[i]) {
                count[i]++;
            }
            else {
                count[j]++;
            }
        }
    }
    
    for(int i = 0; i < len; i++) {
        result[count[i]] = arr[i];
    }
    
    return result;
}

// Time: O(n + k)
// Space: O(n + k)
// With duplicates
int* sortByCount(int* arr, int len) {
    int low = arr[0], up = arr[0];
    
    for(int idx = 0; idx < len; idx++) {
        low = low > arr[idx] ? arr[idx] : low;
        up = up < arr[idx] ? arr[idx] : up;
    }
    
    int* count = (int*)malloc((up - low + 1) * sizeof(int));
    int* result = (int*)malloc(len * sizeof(int));
    
    
    for(int idx = 0; idx < up - low + 1; idx++) {
        count[idx] = 0;
    }
    
    
    for(int idx = 0; idx < len; idx++) {
        count[arr[idx] - low] += 1;
    }
    
    
    for(int idx = 1; idx < up - low + 1; idx++) {
        count[idx] += count[idx - 1];
    }
    
    
    for(int idx = 0; idx < len; idx++) {
        result[count[arr[idx] - low] - 1] = arr[idx];
        count[arr[idx] - low]--;
    }
    
    free(count);
    return result;
}


