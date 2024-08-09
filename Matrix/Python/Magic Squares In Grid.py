# Problem link: https://leetcode.com/problems/magic-squares-in-grid/description/
# Time: O(n * m)
# Space: O(1)
class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        rows, cols, result = len(grid), len(grid[0]), 0

        for row in range(rows - 2):
            for col in range(cols - 2):
                if self.magicSquare(row, col, grid):
                    result += 1
        
        return result
    
    def magicSquare(self, row, col, grid):

        store = [0] * 10
        rowSum, colSum, diagonalSum = [0, 0, 0], [0, 0, 0], [0, 0]

        for r in range(row, row + 3):
            for c in range(col, col + 3):
                if grid[r][c] > 9 or store[grid[r][c]]:
                    return False

                rowSum[r - row] += grid[r][c]
                colSum[c - col] += grid[r][c]

                if r - row == c - col:
                    diagonalSum[0] += grid[r][c]
                if r + c - col - row == 2:
                    diagonalSum[1] += grid[r][c]

                store[grid[r][c]] = 1
        
        for idx in range(3):
            if rowSum[idx] != 15 or colSum[idx] != 15 or (idx < 2 and diagonalSum[idx] != 15):
                return False
        
        return True
