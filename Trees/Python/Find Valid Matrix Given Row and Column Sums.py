# Problem link: https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/description
# Time: O(n * m)
# Space: O(1)
class Solution:
    def restoreMatrix(self, rowSum: List[int], colSum: List[int]) -> List[List[int]]:
        rows, cols = len(rowSum), len(colSum)
        result = [[0] * cols for _ in range(rows)]

        for row in range(rows):
            for col in range(cols):
                result[row][col] = min(rowSum[row], colSum[col])
                rowSum[row] -= result[row][col]
                colSum[col] -= result[row][col]

                if not rowSum[row]:
                    break
        
        return result
