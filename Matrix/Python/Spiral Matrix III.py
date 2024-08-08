# Problem link: https://leetcode.com/problems/spiral-matrix-iii/description
# Time: O(m * n)
# Space: O(1)
class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        result, index, steps = [], 0, 1
        direction = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        while len(result) < rows * cols:
            for x in range(2):
                for y in range(steps):
                    if 0 <= rStart < rows and 0 <= cStart < cols:
                        result.append([rStart, cStart])
                    rStart, cStart = rStart + direction[index][0], cStart + direction[index][1]
                index = (index + 1) % 4
            steps += 1
        
        return result
