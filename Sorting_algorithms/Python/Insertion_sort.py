# Time:
# Best: O(n)
# Average: O(n ^ 2)
# Worst: O(n ^ 2)

# Space: O(1)

def insertionSort(arr):
    n = len(arr)
    for i in range(1, n):
        j = i
        while j > 0 and arr[j] < arr[j - 1]:
            arr[j], arr[j - 1] = arr[j - 1], arr[j]
            j -= 1
    
    return arr
