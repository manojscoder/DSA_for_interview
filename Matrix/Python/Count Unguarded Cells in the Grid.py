# Problem link: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def countUnguarded(self, m: int, n: int, guards: List[List[int]], walls: List[List[int]]) -> int:
        grid = [[0] * n for _ in range(m)]

        for x, y in guards:
            grid[x][y] = 1
        
        for x, y in walls:
            grid[x][y] = 2
        
        for row in range(m):
            for col in range(n):
                if grid[row][col] == 1:
                    self.guard(row, col, grid, m, n)
        
        return sum(arr.count(0) for arr in grid)
    
    def guard(self, row, col, grid, m, n):
        rw = row - 1

        while rw >= 0:
            if grid[rw][col] > 0:
                break
            grid[rw][col] = -1
            rw -= 1
                    
        rw = row + 1

        while rw < m:
            if grid[rw][col] > 0:
                break
            grid[rw][col] = -1
            rw += 1
                    
        cl = col - 1

        while cl >= 0:
            if grid[row][cl] > 0:
                break
            grid[row][cl] = -1
            cl -= 1
                    
        cl = col + 1

        while cl < n:
            if grid[row][cl] > 0:
                break
            grid[row][cl] = -1
            cl += 1
