# Problem link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
# Time: O(m * n)
# Space: O(m * n)
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        rows, cols = len(matrix), len(matrix[0])
        DP = [[0] * cols for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                if matrix[row][col]:
                    if row > 0 and col > 0:
                        DP[row][col] += min(DP[row - 1][col - 1], DP[row - 1][col], DP[row][col - 1])
                    DP[row][col] += 1
                
        return sum(sum(arr) for arr in DP)
