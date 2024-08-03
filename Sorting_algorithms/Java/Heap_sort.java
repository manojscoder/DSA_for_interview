// Time:
// Best: O(n log n)
// Average: O(n log n)
// Worst: O(n log n)

// Space: O(1)

public static void deleteNode(int[] arr, int last) {
        swap(arr, 1, last);
        
        int index = 1;
        int swapIdx = index;
        
        while (index * 2 < last) {
            if (arr[index * 2] > arr[index]) {
                swapIdx = index * 2;
            }
            if (index * 2 + 1 < last && arr[index * 2 + 1] > arr[swapIdx]) {
                swapIdx = index * 2 + 1;
            }
            
            if (index == swapIdx) {
                break;
            }
            
            swap(arr, swapIdx, index);
            index = swapIdx;
        }
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void topDownHeap() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter the size of the array for top down approach: ");
        int size = scanner.nextInt();
        int last = size + 1;
        
        int[] arr = new int[size + 1];
        System.out.println("\nEnter " + size + " elements:");
        
        for (int i = 1; i < last; i++) {
            arr[i] = scanner.nextInt();
            int child = i;
            int parent = child / 2;
            
            while (parent > 0 && arr[parent] < arr[child]) {
                swap(arr, parent, child);
                child = parent;
                parent = child / 2;
            }
        }
        
        while (last - 2 > 0) {
            deleteNode(arr, last - 1);
            last--;
        }
        
        System.out.print("\nTop Down Sorted array: ");
        
        for (int i = 1; i < size + 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n---------------------------------");
    }
    
    public static void bottomUpHeap() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter the size of the array for bottom up approach: ");
        int size = scanner.nextInt();
        int last = size + 1;
        
        int[] arr = new int[size + 1];
        System.out.println("\nEnter " + size + " elements:");
        
        for (int i = 1; i < size + 1; i++) {
            arr[i] = scanner.nextInt();
        }
        
        boolean swapped = true;
        
        while (swapped) {
            swapped = false;
            for (int child = last - 1; child > 1; child--) {
                int parent = child / 2;
                if (arr[child] > arr[parent]) {
                    swap(arr, parent, child);
                    swapped = true;
                }
            }
        }
        
        while (last - 2 > 0) {
            deleteNode(arr, last - 1);
            last--;
        }
        
        System.out.print("\nBottom up Sorted array: ");
        
        for (int i = 1; i < size + 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
