# Problem link: https://leetcode.com/problems/largest-magic-square/description/
# Time: O(n * m * min(n, m))
# Space: O(n * m)
class Solution:
    def largestMagicSquare(self, grid: List[List[int]]) -> int:
        rows, cols, result = len(grid), len(grid[0]), 0

        rowPrefix = [[0] * cols for _ in range(rows)]
        colPrefix = [[0] * cols for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                rowPrefix[row][col] = grid[row][col] + (rowPrefix[row - 1][col] if row > 0 else 0)
                colPrefix[row][col] = grid[row][col] + (colPrefix[row][col - 1] if col > 0 else 0)

        for r in range(rows):
            for c in range(cols):
                dim = min(rows - r, cols - c)
                result = max(result, self.magicSquare(r, c, dim, rowPrefix, colPrefix, grid))
        
        return result
    
    def magicSquare(self, r, c, dim, rowPrefix, colPrefix, grid):
        
        for dim in range(dim, 0, -1):
            totalSum = colPrefix[r][c + dim - 1] - (colPrefix[r][c - 1] if c > 0 else 0)
            checks = left = right = 0

            for idx in range(dim):
                if totalSum != colPrefix[r + idx][c + dim - 1] - (colPrefix[r + idx][c - 1] if c > 0 else 0):
                    break
                if totalSum != rowPrefix[r + dim - 1][c + idx] - (rowPrefix[r - 1][c + idx] if r > 0 else 0):
                    break
                
                left += grid[r + idx][c + idx]
                right += grid[r + idx][c + dim - idx - 1]

                checks += 2

            if checks == dim * 2 and left == totalSum and right == totalSum:
                return dim

        return 0
