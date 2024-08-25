# Problem link: https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        rows, cols, result = len(grid), len(grid[0]), 0
        cache = [[0] * cols for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                result = (result + self.dfs(row, col, -inf, grid, cache)) % (10 ** 9 + 7)
        
        return result
    
    def dfs(self, row ,col, prev, grid, cache):
        if row < 0 or col < 0 or row == len(grid) or col == len(grid[0]) or grid[row][col] <= prev:
            return 0
        elif cache[row][col]:
            return cache[row][col]
        
        count = 0

        for dr, dc in [[0, 1], [1, 0], [-1, 0], [0, -1]]:
            count = (count + self.dfs(row + dr, col + dc, grid[row][col], grid, cache)) % (10 ** 9 + 7)
        
        cache[row][col] = count + 1
        return cache[row][col]
