# Problem link: https://leetcode.com/problems/house-robber-ii/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        def helper(left, right):
            one, two = 0, 0

            for i in range(left, right):
                one, two = two, max(one + nums[i], two)
            
            return two
        
        return max(nums[0], helper(0, len(nums) - 1), helper(1, len(nums)))
