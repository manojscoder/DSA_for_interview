# Problem link: https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/description
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        size = result = len(nums)
        LIS, LDS = [1] * size, [1] * size

        for pntOne in range(size):
            for pntTwo in range(pntOne):
                if nums[pntTwo] < nums[pntOne]:
                    LIS[pntOne] = max(LIS[pntOne], 1 + LIS[pntTwo])
        
        for pntOne in range(size - 1, -1, -1):
            for pntTwo in range(size - 1, pntOne, -1):
                if nums[pntTwo] < nums[pntOne]:
                    LDS[pntOne] = max(LDS[pntOne], 1 + LDS[pntTwo])

        for index in range(1, size - 1):
            if LIS[index] > 1 and LDS[index] > 1:
                result = min(size - LIS[index] - LDS[index] + 1, result)
        
        return result
