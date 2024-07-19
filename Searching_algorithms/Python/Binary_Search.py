# Time:
# Best case: O(1)
# Average case: O(n)
# Worst case: O(n)

# Space: O(1)

def binarySearch(arr, key, n):

  left, right = 0, n - 1

  while left <= right:
    mid = (left + right) // 2

    if arr[mid] == key:
      return mid
    elif arr[mid] > key:
      right = mid - 1
    else:
      left = mid + 1

  return -1
