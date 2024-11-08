# Problem link: https://leetcode.com/problems/count-servers-that-communicate/description/
# Time: O(n * m)
# space: O(n + m)
class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        rows, cols, result = len(grid), len(grid[0]), 0
        rowServers, colServers = [0] * rows, [0] * cols

        for row in range(rows):
            for col in range(cols):
                if grid[row][col]:
                    rowServers[row] += 1
                    colServers[col] += 1
        
        for row in range(rows):
            for col in range(cols):
                if grid[row][col] and (rowServers[row] > 1 or colServers[col] > 1):
                    result += 1
        
        return result
