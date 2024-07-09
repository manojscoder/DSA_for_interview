# Time:
# Best: O(n)
# Average: o(n ^ 2)
# Worst: O(n ^ 2)

# Space: O(1)

def bubbleSort(arr, n):
    
    for i in range(n - 1):
        swapped = False
        
        for j in range(n - 1 - i):
            if arr[j + 1] < arr[j]:
                arr[j + 1], arr[j] = arr[j], arr[j + 1]
                swapped = True
        
        if not swapped:
            break
    
    return arr
