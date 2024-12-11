# Problem link: https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
# Time: O(n log n)
# Space: O(1)
class Solution:
    def maximumBeauty(self, nums: List[int], k: int) -> int:
        nums.sort()
        result = left = right = 0

        while right < len(nums):
            while nums[right] - nums[left] > 2 * k:
                left += 1
            result = max(result, right - left + 1)
            right += 1
        
        return result
