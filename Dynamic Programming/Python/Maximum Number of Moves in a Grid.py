# Problem link: https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/
# Time: O(m * n)
# Space: O(m)
class Solution:
    def maxMoves(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        curr, prev = [0] * rows, [0] * rows
        directions = [-1, 0, 1]

        for col in range(cols - 2, -1, -1):
            for row in range(rows):
                for dr in directions:
                    if row + dr < rows and row + dr >= 0 and grid[row][col] < grid[row + dr][col + 1]:
                        curr[row] = max(curr[row], 1 + prev[row + dr])

            for row in range(rows):
                prev[row] = curr[row]
                curr[row] = 0
                        
        
        return max(prev)
