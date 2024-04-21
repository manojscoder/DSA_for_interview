# Time: O(n)
# Space: O(1)
# Problem link: https://leetcode.com/problems/product-of-array-except-self/description/

class Solution:
    def productExceptSelf(self, nums):
        val = 1
        n = len(nums)
        result = [0] * n

        result[0] = nums[0]
        for i in range(1, n):
            result[i] = nums[i] * result[i - 1]
        
        for i in range(n - 1, 0, -1):
            result[i] = result[i - 1] * val
            val *= nums[i]
        result[0] = val
        
        return result
