# Time:
# Base case: O(n log n)
# Average case: O(n log n)
# Worst case: O(n ^ 2)

# Space: O(log n)

def partition(arr, low, high):
    pivot = arr[low]
    i = low + 1
    j = high
    
    while i < j:
        while i < high and arr[i] < pivot:
            i += 1
        
        while j > low and arr[j] > pivot:
            j -= 1
        
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
    
    arr[low], arr[j] = arr[j], arr[low]
    return j

def quickSort(arr, low, high):
    if low < high:
        pivotIdx = partition(arr, low, high)
        quickSort(arr, low, pivotIdx - 1)
        quickSort(arr, pivotIdx + 1, high)
