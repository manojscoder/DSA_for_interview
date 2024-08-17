# Problem link: https://leetcode.com/problems/maximum-number-of-points-with-cost/description
# Time: O(m * n)
# Space: O(n)
class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        rows, cols = len(points), len(points[0])
        dp = points[0].copy()
        
        for row in range(rows - 1):
            left = [0] * cols
            left[0] = dp[0]

            for col in range(1, cols):
                left[col] = max(dp[col], left[col - 1] - 1)
            
            dp[-1] = points[row + 1][-1] + left[-1]
            
            for col in range(cols - 2, -1, -1):
                dp[col] = points[row + 1][col] + max(left[col], points[row][col], left[col + 1] - 1)
                left[col] = max(left[col], points[row][col], left[col + 1] - 1)
        
        return max(dp)
