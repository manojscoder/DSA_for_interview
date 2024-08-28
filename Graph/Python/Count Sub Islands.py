# Problem link: https://leetcode.com/problems/count-sub-islands/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        rows, cols, result = len(grid1), len(grid1[0]), 0
        visit = [[0] * cols for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                if grid2[row][col] == 1 and visit[row][col] == 0 and self.dfs(row, col, grid1, grid2, visit):
                        result += 1
        
        return result
    
    def dfs(self, row, col, grid1, grid2, visit):
        if row < 0 or row >= len(grid1) or col < 0 or col >= len(grid1[0]) or visit[row][col] or grid2[row][col] == 0:
            return True
        
        if grid2[row][col] == 1 and grid1[row][col] == 0:
            return False
        
        visit[row][col] = 1
        
        down = self.dfs(row + 1, col, grid1, grid2, visit)
        up = self.dfs(row - 1, col, grid1, grid2, visit)
        right = self.dfs(row, col + 1, grid1, grid2, visit)
        left =  self.dfs(row, col - 1, grid1, grid2, visit)

        return left and right and down and up
