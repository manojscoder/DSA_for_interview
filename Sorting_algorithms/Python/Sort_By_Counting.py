# Time: O(n ^ 2)
# Space: O(n)

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
