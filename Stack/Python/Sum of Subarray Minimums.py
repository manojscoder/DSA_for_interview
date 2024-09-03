# Problem link: https://leetcode.com/problems/sum-of-subarray-minimums/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        result, MOD, stack = 0, 10 ** 9 + 7, []

        for idx, val in enumerate(arr):
            while stack and stack[-1][1] > val:
                index, num = stack.pop()
                left = index - stack[-1][0] if stack else index + 1
                right = idx - index
                result = (result + left * right * num) % MOD
            stack.append((idx, val))
        
        while stack:
            index, num = stack.pop()
            left = index - stack[-1][0] if stack else index + 1
            right = len(arr) - index
            result = (result + left * right * num) % MOD
        
        return result
