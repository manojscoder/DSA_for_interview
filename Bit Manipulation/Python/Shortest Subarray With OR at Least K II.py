# Problem link: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description
# Time: O(n)
# Space: O(1)
class Solution:
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        store = [0] * 32
        left = value = 0
        result = len(nums) + 1

        for right in range(len(nums)):

            value |= nums[right]

            for pos in range(32):
                if nums[right] & (1 << pos):
                    store[pos] += 1
                
            while left <= right and value >= k:
                result = min(result, right - left + 1)

                for pos in range(32):
                    if nums[left] & (1 << pos):
                        store[pos] -= 1
                        if not store[pos]:
                            value &= ~(1 << pos)
                left += 1

        return result if result != len(nums) + 1 else -1
