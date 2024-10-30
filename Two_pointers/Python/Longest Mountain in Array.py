# Problem link: https://leetcode.com/problems/longest-mountain-in-array/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def longestMountain(self, arr: List[int]) -> int:
        size, result = len(arr), 0

        if size < 3:
            return 0
        
        for index in range(1, size - 1):
            if arr[index] > arr[index - 1] and arr[index] > arr[index + 1]:
                left = right = index

                while left > 0 and arr[left] > arr[left - 1]:
                    left -= 1
                
                while right < size - 1 and arr[right] > arr[right + 1]:
                    right += 1
                
                result = result if result > right - left + 1 else right - left + 1
        
        return result
