# Problem link: https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/
# Time: O(max(m, n))
# Space: O(1)
class Solution:
    def minCost(self, startPos: List[int], homePos: List[int], rowCosts: List[int], colCosts: List[int]) -> int:
        result = 0

        for row in range(min(homePos[0], startPos[0]), max(homePos[0], startPos[0]) + 1):
            result += rowCosts[row]
        
        for col in range(min(homePos[1], startPos[1]), max(homePos[1], startPos[1]) + 1):
            result += colCosts[col]

        return result - rowCosts[startPos[0]] - colCosts[startPos[1]]
