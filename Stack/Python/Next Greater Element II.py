# Problem link: https://leetcode.com/problems/next-greater-element-ii/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        result = [-1] * len(nums)
        stack = []

        for idx in range(len(nums) * 2 - 1, -1, -1):
            while stack and stack[-1] <= nums[idx % len(nums)]:
                stack.pop()
            
            if idx < len(nums) and stack:
                result[idx] = stack[-1]
            
            stack.append(nums[idx % len(nums)])
        
        return result
