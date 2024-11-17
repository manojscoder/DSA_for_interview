# Problem link: https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        rows, cols, result = len(nums1), len(nums2), 0
        DP = [[0] * (cols + 1) for _ in range(rows + 1)]

        for row in range(rows):
            for col in range(cols):
                if nums1[row] == nums2[col]:
                    DP[row + 1][col + 1] = DP[row][col] + 1
                result = max(result, DP[row + 1][col + 1])
        
        return result
