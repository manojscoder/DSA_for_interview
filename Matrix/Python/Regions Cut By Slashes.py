# Problem link: https://leetcode.com/problems/regions-cut-by-slashes/description
# Time: O(n ^ 2)
# Space: O(n ^ 2)
class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        rows, cols, visited = len(grid), len(grid[0]), set()
        store = [[0] * (3 * cols) for _ in range(3 * rows)]

        for row in range(rows):
            for col in range(cols):
                r, c = row * 3, col * 3
                if grid[row][col] == '\\':
                    store[r][c] = store[r + 1][c + 1] = store[r + 2][c + 2] = 1
                elif grid[row][col] == '/':
                    store[r][c + 2] = store[r + 1][c + 1] = store[r + 2][c] = 1

        result = 0
        for row in range(rows * 3):
            for col in range(cols * 3):
                if not store[row][col] and (row, col) not in visited:
                    self.dfs(row, col, store, visited, rows * 3, cols * 3)
                    result += 1
        
        return result
        

    def dfs(self, row, col, grid, visited, rows, cols):
        if row < 0 or col < 0 or row == rows or col == cols or grid[row][col] or (row, col) in visited:
            return
        
        visited.add((row, col))
        for dr, dc in [[row + 1, col], [row, col + 1], [row - 1, col], [row, col - 1]]:
            self.dfs(dr, dc, grid, visited, rows, cols)
