# Problem link: https://leetcode.com/problems/number-of-closed-islands/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        result, rows, cols = 0, len(grid), len(grid[0])
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        visited = [[0] * cols for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 0 and visited[row][col] == 0:
                    
                    if self.dfs(row, col, visited, directions, grid):
                        result += 1
        
        return result
    
    def dfs(self, row, col, visited, directions, grid):
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]):
            return False
        elif grid[row][col] or visited[row][col]:
            return True
        
        visited[row][col] = 1
        check = True

        for dr, dc in directions:
            if not self.dfs(row + dr, col + dc, visited, directions, grid):
                check = False
        
        return check
