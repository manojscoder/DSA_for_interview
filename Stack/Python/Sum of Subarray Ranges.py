# Problem link: https://leetcode.com/problems/sum-of-subarray-ranges/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        return self.sumSub(nums, 0) - self.sumSub(nums, 1)
    
    def sumSub(self, arr, flag):
        result, stack = 0, []

        for idx, val in enumerate(arr):
            while stack and (stack[-1][1] > val if flag else stack[-1][1] < val):
                index, num = stack.pop()
                left = index - stack[-1][0] if stack else index + 1
                right = idx - index
                result +=left * right * num
            stack.append((idx, val))
        
        while stack:
            index, num = stack.pop()
            left = index - stack[-1][0] if stack else index + 1
            right = len(arr) - index
            result += left * right * num
        
        return result
