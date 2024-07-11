# Problem link: https://leetcode.com/problems/number-of-islands/description/

# Approach: 1 (DFS)
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visit = set()
        result, rows, cols = 0, len(grid), len(grid[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1' and (i, j) not in visit:
                    self.dfs(i, j, grid, visit, directions)
                    result += 1
        
        return result
    
    def dfs(self, row, col, grid, visit, directions):
        if row < 0 or col < 0 or row == len(grid) or col == len(grid[0]) or grid[row][col] == '0' or (row, col) in visit:
            return
        
        visit.add((row, col))

        for r, c in directions:
            self.dfs(row + r, col + c, grid, visit, directions)  

# Approach: 2 (BFS)
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows, cols, result = len(grid), len(grid[0]), 0
        visit, directions = set(), [[1, 0], [0, 1], [-1, 0], [0, -1]]

        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1' and (i, j) not in visit:
                    self.bfs(i, j, visit, grid, directions)
                    result += 1

        return result
        
    
    def bfs(self, row, col, visit, grid, directions):
        queue = deque([(row, col)])
        rows, cols = len(grid), len(grid[0])

        while queue:
            row, col = queue.popleft()

            if (row, col) in visit:
                continue
            
            visit.add((row, col))

            for r, c in directions:
                if r + row >= 0 and r + row < rows and c + col >= 0 and c + col < cols and grid[r + row][c + col] == '1':
                    queue.append((r + row, c + col))
