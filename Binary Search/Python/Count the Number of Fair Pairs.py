# Problem link: https://leetcode.com/problems/count-the-number-of-fair-pairs/description
# Time: O(n log n)
# Space: O(n)
class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        nums.sort()
        result = 0

        for index in range(len(nums)):
            largest = self.binarySearch(nums, index, upper - nums[index] + 1)
            smallest = self.binarySearch(nums, index, lower - nums[index])

            result += largest - smallest
        
        return result

    def binarySearch(self, nums, index, target):
        left, right = index + 1, len(nums) - 1
        best = 0

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] >= target:
                right = mid - 1
            else:
                left = mid + 1
            
        return right
