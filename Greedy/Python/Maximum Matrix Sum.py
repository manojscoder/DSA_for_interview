# Problem link: https://leetcode.com/problems/maximum-matrix-sum/description
# Time: O(n * n)
# Space: O(n * n)
class Solution:
    def maxMatrixSum(self, matrix: List[List[int]]) -> int:
        count = total = 0
        track = float('inf')

        for row in matrix:
            for num in row:
                if num < 0:
                    count += 1
                track = min(track, abs(num))
                total += abs(num)
        
        return total if count % 2 == 0 else total - track * 2
