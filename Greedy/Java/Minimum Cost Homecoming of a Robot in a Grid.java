// Problem link: https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/
// Time: O(max(m, n))
// Space: O(1)
class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int result = 0;

        for(int idx = Math.min(startPos[0], homePos[0]); idx <= Math.max(startPos[0], homePos[0]); idx++) {
            result += rowCosts[idx];
        }

        for(int idx = Math.min(startPos[1], homePos[1]); idx <= Math.max(startPos[1], homePos[1]); idx++) {
            result += colCosts[idx];
        }

        return result - rowCosts[startPos[0]] - colCosts[startPos[1]];
    }
}
