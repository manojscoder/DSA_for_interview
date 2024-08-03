// Time: 
// Best: O(n log n)
// Average: O(n log n)
// Worst: O(n log n)

// Space: O(1)

void deleteNode(int* arr, int last) {
    arr[1] += arr[last];
    arr[last] = arr[1] - arr[last];
    arr[1] -= arr[last];
    
    int index = 1, swapIdx = index;
    
    while(index * 2 < last) {
        if(arr[index * 2] > arr[index]) {
            swapIdx = index * 2;
        }
        if(index * 2 + 1 < last && arr[index * 2 + 1] > arr[swapIdx]) {
            swapIdx = index * 2 + 1;
        }
        
        if(index == swapIdx) {
            break;
        }
        
        arr[swapIdx] += arr[index];
        arr[index] = arr[swapIdx] - arr[index];
        arr[swapIdx] -= arr[index];
        index = swapIdx;
    }
}

void topDownHeap() {
    int size, parent, child, last;
    
    printf("\nEnter the size of the array for top down approach: " );
    scanf("%d", &size);
    last = size + 1;
    
    int arr[size + 1];
    printf("\nEnter %d elements:" ,size);
    
    for(int i = 1; i < last; i++) {
        scanf("%d", &arr[i]);
        child = i;
        parent = child / 2;
        
        while(parent && arr[parent] < arr[child]) {
            arr[parent] += arr[child];
            arr[child] = arr[parent] - arr[child];
            arr[parent] -= arr[child];
            child = parent;
            parent = child / 2;
        }
    }
    
    
    while(last - 2 > 0) {
        deleteNode(arr, last - 1);
        last--;
    }
    
    printf("\nTop Down Sorted array: ");
    
    for(int i = 1; i < size + 1; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n---------------------------------");
}



void bottomUpHeap() {
    
    int size, last, swapped = 1;
    
    printf("\nEnter the size of the array for bottom up approach: " );
    scanf("%d", &size);
    last = size + 1;
    
    int arr[size + 1];
    printf("\nEnter %d elements:" ,size);
    
    for(int i = 1; i < size + 1; i++) {
        scanf("%d", &arr[i]);
    }
    
    while(swapped) {
        swapped = 0;
        for(int child = last - 1, parent; child > 1; child--) {
            parent = child / 2;
            if(arr[child] > arr[parent]) {
                arr[parent] += arr[child];
                arr[child] = arr[parent] - arr[child];
                arr[parent] -= arr[child];
                swapped = 1;
            }
        }
    }
    
    while(last - 2 > 0) {
        deleteNode(arr, last - 1);
        last--;
    }
    
    printf("\nBottom up Sorted array: ");
    
    for(int i = 1; i < size + 1; i++) {
        printf("%d ", arr[i]);
    }
}
