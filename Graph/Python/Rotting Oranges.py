# Problem link: https://leetcode.com/problems/rotting-oranges/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        rows, cols, result, oranges = len(grid), len(grid[0]), 0, 0
        direction = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        queue = deque()

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == 1:
                    oranges += 1
                if grid[row][col] == 2:
                    queue.append((row, col))
        
        while queue and oranges:
            size = len(queue)

            for _ in range(size):
                row, col = queue.popleft()
                for dr, dc in direction:
                    newRow, newCol = dr + row, dc + col
                    if newRow >= 0 and newRow < rows and newCol >= 0 and newCol < cols and grid[newRow][newCol] == 1:
                        queue.append((newRow, newCol))
                        oranges -= 1
                        grid[newRow][newCol] = 2
            result += 1
        
        return -1 if oranges else result
