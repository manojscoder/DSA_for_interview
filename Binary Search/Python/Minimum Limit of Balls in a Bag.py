# Problem link: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description
# Time: O(n * log n)
# Space: O(1)
class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        result, left, right = 0, 1, max(nums)

        while left <= right:
            mid = (left + right) // 2

            if self.canDivide(nums, mid, maxOperations):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return result
    
    def canDivide(self, nums, maxBalls, maxOperations):
        count = 0

        for num in nums:
            count += ceil(num / maxBalls) - 1
            if count > maxOperations:
                return False
        
        return True
