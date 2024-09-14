# Problem link: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description
# Time: O(n)
# Space: O(1)
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        result = curr = count = 0

        for num in nums:
            if curr < num:
                curr = num
                result = count = 0
            
            count = count + 1 if curr == num else 0
            result = max(result, count)
        
        return result
