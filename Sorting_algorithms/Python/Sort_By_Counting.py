# Time: O(n ^ 2)
# Space: O(n)
# Without duplicates
def sortByCount(arr, n):
    count = [0] * n
    result = [0] * n
    
    for i in range(n - 1):
        for j in range(i + 1, n):
            if arr[i] < arr[j]:
                count[j] += 1
            else:
                count[i] += 1
                
    for i in range(n):
        result[count[i]] = arr[i]
    
    return result

# Time: O(n + k)
# Space: O(n + k)
# With duplicates
def sortByCount(arr, size):
    low, up = min(arr), max(arr)
    
    count = [0] * (up - low + 1)
    result = [0] * size
    
    for num in arr:
        count[num - low] += 1
    
    for idx in range(1, len(count)):
        count[idx] += count[idx - 1]
    
    for num in arr:
        result[count[num - low] - 1] = num
        count[num - low] -= 1
    
    return result
