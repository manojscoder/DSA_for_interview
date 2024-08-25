# Problem link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
# Time: O(n * m)
# space: O(n * m)
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        rows, cols, result = len(matrix), len(matrix[0]), 0
        cache = [[0] * cols for _ in range(rows)]

        for row i in range(rows):
            for col in range(cols):
                result = max(result, self.dfs(row, col, matrix, cache, -inf), result)
        
        return result
    
    def dfs(self, row, col, matrix, cache, prev):
        if row < 0 or col < 0 or row == len(matrix) or col == len(matrix[0]) or matrix[row][col] <= prev:
            return 0
        elif cache[row][col]:
            return cache[row][col]
        
        directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        for dr, dc in directions:
            count = 1 + max(count, self.dfs(row + dr, col + dc, matrix, cache, matrix[row][col]))

        cache[row][col] = count
        return count
