# Problem link: https://leetcode.com/problems/as-far-from-land-as-possible/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        n, result = len(grid), -1

        DP = [[0 if grid[row][col] else float('inf') for col in range(n)] for row in range(n)]

        for row in range(n):
            for col in range(n):
                if not grid[row][col]:
                    if row > 0:
                        DP[row][col] = min(DP[row][col], DP[row - 1][col] + 1)
                    if col > 0:
                        DP[row][col] = min(DP[row][col], DP[row][col - 1] + 1)
        
        for row in range(n - 1, -1, -1):
            for col in range(n - 1, -1, -1):
                if not grid[row][col]:
                    if row + 1 < n:
                        DP[row][col] = min(DP[row][col], DP[row + 1][col] + 1)
                    if col + 1 < n:
                        DP[row][col] = min(DP[row][col], DP[row][col + 1] + 1)
                    result = max(result, DP[row][col])

        return -1 if result == float('inf') else result
