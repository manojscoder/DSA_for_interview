# Problem link: https://leetcode.com/problems/longest-increasing-subsequence/description/
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        DP = [1] * len(nums)

        for i in range(len(nums) - 1, -1, -1):
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    DP[i] = max(DP[i], 1 + DP[j])
        
        return max(DP)
