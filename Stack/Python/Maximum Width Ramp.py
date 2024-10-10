# Problem link: https://leetcode.com/problems/maximum-width-ramp/description
# Time: O(n)
# Space: O(n)
class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        stack, result = [], 0

        for idx in range(len(nums)):
            if not stack or nums[stack[-1]] > nums[idx]:
                stack.append(idx)
        
        for idx in range(len(nums) - 1, -1, -1):
            while stack and nums[stack[-1]] <= nums[idx]:
                result = max(result, idx - stack[-1])
                stack.pop()
        
        return result
