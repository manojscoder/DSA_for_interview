# Problem link: https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description
# Time: O(2 ^ n)
# Space: O(n)
class Solution:
    def countMaxOrSubsets(self, nums: List[int]) -> int:
        val = reduce(lambda x, y : x | y, nums)
        return self.dfs(0, nums, val, 0)
    
    def dfs(self, idx, nums, val, orVal):
        if idx == len(nums):
            return 1 if orVal == val else 0
        
        withVal = self.dfs(idx + 1, nums, val, orVal | nums[idx])
        withoutVal = self.dfs(idx + 1, nums, val, orVal)
        return withVal + withoutVal
