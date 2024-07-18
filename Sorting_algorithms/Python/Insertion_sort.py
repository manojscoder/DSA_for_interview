# Time:
# Best: O(n)
# Average: O(n ^ 2)
# Worst: O(n ^ 2)

# Space: O(1)


# Approach: 1
def insertionSort(arr):
    n = len(arr)
    for i in range(1, n):
        j = i
        while j > 0 and arr[j] < arr[j - 1]:
            arr[j], arr[j - 1] = arr[j - 1], arr[j]
            j -= 1
    
    return arr


# Approach: 2
def insertionSort(arr, n):
    for idx in range(1, n):
        val, j = arr[idx], idx - 1
        
        while j >= 0 and arr[j] > val:
            arr[j + 1], j = arr[j], j - 1
        
        arr[j + 1] = val
    return arr
        
