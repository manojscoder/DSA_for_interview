# Problem link: https://leetcode.com/problems/as-far-from-land-as-possible/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        rows, cols, result, queue = len(grid), len(grid[0]), -1, deque()
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        visited = [[0] * cols for _ in range(rows)]


        for row in range(rows):
            for col in range(cols):
                if grid[row][col]:
                    queue.append((row, col, 0))
                    visited[row][col] = 1
        
        while queue:

            for _ in range(len(queue)):
                row, col, dist = queue.popleft()

                for dr, dc in directions:
                    rw, cl = row + dr, col + dc

                    if rw >= 0 and cl >= 0 and rw < rows and cl < cols and not visited[rw][cl]:
                        queue.append((rw, cl, dist + 1))
                        result = max(result, dist + 1)
                        visited[rw][cl] = 1
            
        return result
