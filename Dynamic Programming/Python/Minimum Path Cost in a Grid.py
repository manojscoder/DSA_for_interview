# Problem link: https://leetcode.com/problems/minimum-path-cost-in-a-grid/description/
# Time: O(n * m ^ 2)
# Space: O(m)
class Solution:
    def minPathCost(self, grid: List[List[int]], moveCost: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        curr, prev = [0] * cols, grid[-1][::]

        for row in range(rows - 2, -1, -1):
            for col in range(cols):
                curr[col] = grid[row][col] + min(prev[index] + moveCost[grid[row][col]][index] for index in range(cols))
            prev, curr = curr, prev

        return min(prev)
