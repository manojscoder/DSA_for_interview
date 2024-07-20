// Time: O(n ^ 2)
// Space: O(n)

// Without repeatation
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


