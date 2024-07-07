# Problem link: https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def numberOfSubmatrices(self, grid: List[List[str]]) -> int:
        result, rows, cols = 0, len(grid), len(grid[0])
        store = [[[0, 0] for _ in range(cols)] for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 'X':
                    store[row][col][0] += 1
                elif grid[row][col] == 'Y':
                    store[row][col][1] += 1
                
                if col > 0:
                    store[row][col][0] += store[row][col - 1][0]
                    store[row][col][1] += store[row][col - 1][1]
        
        for row in range(rows):
            for col in range(cols):
                if row > 0:
                    store[row][col][0] += store[row - 1][col][0]
                    store[row][col][1] += store[row - 1][col][1]
                
                if store[row][col][0] > 0 and store[row][col][0] == store[row][col][1]:
                    result += 1

        return result
