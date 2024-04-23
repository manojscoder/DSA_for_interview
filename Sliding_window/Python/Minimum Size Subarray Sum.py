# Time: O(n)
# Space: O(1)
# Problem link: https://leetcode.com/problems/minimum-size-subarray-sum/description/
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        total = 0
        result = len(nums) + 1
        i = j = 0

        while j < len(nums):
            total += nums[j]
            while total >= target:
                result = min(result, j - i + 1)
                total -= nums[i]
                i += 1
            j += 1

        return result if result != len(nums) + 1 else 0
