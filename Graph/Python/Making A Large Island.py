# Problem link: https://leetcode.com/problems/making-a-large-island/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        result, rows, cols = 0, len(grid), len(grid[0])
        storeSize, parent = [[0] * cols for _ in range(rows)], [[-1] * (cols + 1) for _ in range(rows + 1)]
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]

        def dfs(row, col, par):
            parent[row][col], size = par, 1
            
            for dr, dc in directions:
                nr, nc = dr + row, dc + col
                if 0 <= nr < rows and 0 <= nc < cols and grid[nr][nc] and parent[nr][nc] == -1:
                    size += dfs(row + dr, col + dc, par)
            
            return size

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] and parent[row][col] == -1:
                    size = dfs(row, col, (row, col))
                    result, storeSize[row][col] = max(result, size), size
        
        for row in range(rows):
            for col in range(cols):
                if not grid[row][col]:
                    uniqueParents = set()

                    for dr, dc in directions:
                        if parent[row + dr][col + dc] != -1:
                            uniqueParents.add(parent[row + dr][col + dc])
                    
                    result = max(result, 1 + sum(storeSize[rw][cl] for rw, cl in uniqueParents))
        
        return result
