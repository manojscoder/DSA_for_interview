# Problem link: https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/
# Time: O(n * m * h * log(n * m * h))
# Space: O(n * m * h)
class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        queue = [(-(health - grid[0][0]), 0, 0)]
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        rows, cols = len(grid), len(grid[0])
        visited = [[0] * cols for _ in range(rows)] 

        while queue:
            for _ in range(len(queue)):
                hea, row, col = heappop(queue)

                if row == rows - 1 and col == cols - 1:
                    return True

                visited[row][col] = 1

                for dr, dc in directions:
                    rw, cl = row + dr, col + dc

                    if 0 <= rw < rows and 0 <= cl < cols:
                        new_hea = hea + grid[rw][cl]

                        if -new_hea > 0 and not visited[rw][cl]:
                            heappush(queue, (new_hea, rw, cl))
                            visited[rw][cl] = 1
            
        return False
