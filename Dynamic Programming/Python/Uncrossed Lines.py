# Problem link: https://leetcode.com/problems/uncrossed-lines/description/
# Time: O(n * m)
# Space: O(m)
class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        rows, cols = len(nums1), len(nums2)
        curr, prev = [0] * (cols + 1), [0] * (cols + 1)

        for row in range(rows - 1, -1, -1):
            for col in range(cols - 1, -1, -1):
                if nums1[row] == nums2[col]:
                    curr[col] = 1 + prev[col + 1]
                else:
                    curr[col] = max(prev[col], curr[col + 1])
            
            for col in range(cols):
                prev[col] = curr[col]
        
        return prev[0]
