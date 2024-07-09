# Time:
# Best: O(n ^ 2)
# Average: O(n ^ 2)
# Worst: O(n ^ 2)

# Space: O(1)
def selectionSort(arr, n):
    
    for i in range(n):
        minIndex = i
        
        for j in range(i + 1, n):
            if arr[minIndex] > arr[j]:
                minIndex = j
        
        if minIndex != i:
            arr[minIndex], arr[i] = arr[i], arr[minIndex]
