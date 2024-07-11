# Problem link: https://leetcode.com/problems/max-area-of-island/description/

# Approach: 1 (DFS)
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        rows, cols, result = len(grid), len(grid[0]), 0
        visit = set()
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        result = 0

        for i in range(rows):
            for j in range(cols):
                result = max(result, self.dfs(i, j, grid, visit, directions))
        
        return result
        
    def dfs(self, row, col, grid, visit, directions):
        if row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0]) or grid[row][col] == 0 or (row, col) in visit:
            return 0
            
        visit.add((row, col))
        count = 1

        for dr, dc in directions:
            count += self.dfs(row + dr, col + dc, grid, visit, directions)
        
        return count



# Approach: 2 (BFS)
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        rows, cols = len(grid), len(grid[0])
        visit = set()
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        result = 0
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1 and (i, j) not in visit:
                    result = max(result, self.bfs(i, j, grid, visit, directions))
        
        return result
    
    def bfs(self, row, col, grid, visit, directions):
        queue = deque([(row, col)])
        visit.add((row, col))
        count = 0
        
        while queue:
            r, c = queue.popleft()
            count += 1
            
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if nr >= 0 and nr < len(grid) and nc >= 0 and nc < len(grid[0]) and (nr, nc) not in visit and grid[nr][nc] == 1:
                    queue.append((nr, nc))
                    visit.add((nr, nc))
        
        return count
