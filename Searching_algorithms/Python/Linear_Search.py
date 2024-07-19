# Time:
# Best case: O(1)
# Average case: O(n)
# Worst case: O(n)

# Space: O(1)

def linearSearch(arr, key, n):

  for idx in range(n):
    if key == arr[idx]:
      return idx
      
  return -1
