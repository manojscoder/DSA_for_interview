# Problem link: https://leetcode.com/problems/swim-in-rising-water/description/
# Time: O(n ^ 2 * log n)
# Space: O(n ^ 2)
class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        rows, cols = len(grid), len(grid[0])
        visited = [[False] * cols for _ in range(rows)]
        heap = [(grid[0][0], 0, 0)]

        while heap:
            time, row, col = heappop(heap)

            if row == rows - 1 and col == cols - 1:
                return time
            elif visited[row][col]:
                continue
            
            visited[row][col] = True

            for dr, dc in directions:
                rw, cl = row + dr, col + dc
                if 0 <= rw < rows and 0 <= cl < cols:
                    heappush(heap, (max(time, grid[rw][cl]), rw, cl))
        
        return -1
