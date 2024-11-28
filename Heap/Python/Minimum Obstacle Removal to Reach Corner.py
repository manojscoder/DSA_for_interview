# Problem link: https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/
# Time: O(m * n * log(m * n))
# Space: O(m * n)
class Solution:
    def minimumObstacles(self, grid: List[List[int]]) -> int:
        rows, cols = len(grid), len(grid[0])
        directions = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        visited = [[0] * cols for _ in range(rows)]
        PQ, visited[0][0] = [(0, 0, 0)], 1

        while PQ:
            obs, row, col = heappop(PQ)

            if row == rows - 1 and col == cols - 1:
                return obs

            for dr, dc in directions:
                nr, nc = row + dr, col + dc

                if 0 <= nr < rows and 0 <= nc < cols and not visited[nr][nc]:
                    heappush(PQ, (obs + (1 if grid[nr][nc] else 0), nr, nc))
                    visited[nr][nc] = 1
        
        return 0
