# Time: O(n * log n)
# Space: O(n)
def merge(left, right):
    m, n = 0, 0
    merged = []
    
    while m < len(left) and n < len(right):
        if left[m] < right[n]:
            merged.append(left[m])
            m += 1
        else:
            merged.append(right[n])
            n += 1
    
    while m < len(left):
        merged.append(left[m])
        m += 1
    
    while n < len(right):
        merged.append(right[n])
        n += 1
    
    return merged
    

def mergeSort(arr, n):
    if n > 1:
        mid = n // 2
        
        left = mergeSort(arr[:mid], mid)
        right = mergeSort(arr[mid:], n - mid)
        
        return merge(left, right)
    
    return arr

arr = [9, 4, 1, 3, 6, 7, 5]
n = 7
print(mergeSort(arr, n))
