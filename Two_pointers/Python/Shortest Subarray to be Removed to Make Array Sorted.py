# Problem link: https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/description
# Time: O(n)
# Space: O(1)
class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        size = len(arr)
        left, right = 0, size - 1

        while right > 0 and arr[right - 1] <= arr[right]:
            right -= 1
        
        result = right

        while left < right:

            while right < size and arr[left] > arr[right]:
                right += 1
            
            result = min(result, right - left - 1)

            if arr[left] > arr[left + 1]:
                break
            
            left += 1
        
        return result
