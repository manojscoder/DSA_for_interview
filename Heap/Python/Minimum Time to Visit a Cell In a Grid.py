# Problem link: https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/
# Time: O(n * m * log(n * m))
# Space: O(n * m)
class Solution:
    def minimumTime(self, grid: List[List[int]]) -> int:
        if grid[0][1] > 1 and grid[1][0] > 1:
            return -1

        rows, cols, PQ = len(grid), len(grid[0]), [(0, 0, 0)]
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        visited = [[0] * cols for _ in range(rows)]
        visited[0][0] = 1

        while PQ:
            time, row, col = heappop(PQ)

            if row == rows - 1 and col == cols - 1:
                return time
            
            for dr, dc in directions:
                nr, nc = row + dr, col + dc

                if 0 <= nr < rows and 0 <= nc < cols and (nr, nc) and not visited[nr][nc]:
                    
                    newTime = time + 1

                    if newTime < grid[nr][nc]:
                        diff = grid[nr][nc] - newTime
                        newTime += (1 if diff % 2 else 0) + diff

                    heappush(PQ, (newTime, nr, nc))
                    visited[nr][nc] = 1
        
        return -1
