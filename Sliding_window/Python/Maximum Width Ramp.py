# Problem link: https://leetcode.com/problems/maximum-width-ramp/description
# Time: O(n)
# Space: O(n)
class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        store = [0] * (len(nums) + 1)

        for idx in range(len(nums) - 1, -1, -1):
            store[idx] = max(store[idx + 1], nums[idx])
        
        left, right, result = 0, 1, 0

        while right < len(nums):
            if store[right] >= nums[left]:
                result = max(result, right - left)
                right += 1
            else:
                left += 1
        
        return result
