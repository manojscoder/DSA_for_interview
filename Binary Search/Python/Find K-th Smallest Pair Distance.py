# Problem link: https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
# Time: O(n * log n)
# Space: O(n)
class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        nums.sort()
        left, right = 0, nums[-1]

        while left < right:
            mid = left + (right - left) // 2
            count = pointerOne = 0

            for pointerTwo in range(1, len(nums)):
                while nums[pointerTwo] - nums[pointerOne] > mid:
                    pointerOne += 1
                count += pointerTwo - pointerOne

            if count < k:
                left = mid + 1
            else:
                right = mid

        return left
