# Problem link: https://leetcode.com/problems/01-matrix/description/
# Time: O(n * m)
# Space: O(n * m)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        visit = [[0] * cols for _ in range(rows)]
        result = [[0] * cols for _ in range(rows)]
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        queue = deque()

        for row in range(rows):
            for col in range(cols):
                if mat[row][col] == 0:
                    queue.append((row, col, 0))
                    visit[row][col] = 1
        
        while queue:
            row, col, dist = queue.popleft()
            result[row][col] = dist

            for dr, dc in directions:
                newR, newC = dr + row, dc + col
                if newR >= 0 and newC >= 0 and newR < rows and newC < cols and visit[newR][newC] == 0:
                    queue.append((newR, newC, dist + 1))
                    visit[newR][newC] = 1
        
        return result
