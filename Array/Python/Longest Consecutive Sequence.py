# Problem link: https://leetcode.com/problems/longest-consecutive-sequence/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numsSet  = set(nums)
        result = size = 0

        for i in nums:
            if i - 1 not in numsSet:
                size = 0

                while i + size in numsSet:
                    size += 1
                
                result = max(result, size)
            
        return result
