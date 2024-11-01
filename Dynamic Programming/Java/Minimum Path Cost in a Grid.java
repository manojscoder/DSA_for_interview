// Problem link: https://leetcode.com/problems/minimum-path-cost-in-a-grid/description/
// Time: O(n * m ^ 2)
// Space: O(n * m)
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rows = grid.length, cols = grid[0].length, result = Integer.MAX_VALUE;
        int[] curr = new int[cols], prev = Arrays.copyOf(grid[rows - 1], cols);
        Arrays.fill(curr, Integer.MAX_VALUE);

        for(int row = rows - 2; row >= 0; row--) {
            for(int col = 0; col < cols; col++) {
                for(int index = 0; index < cols; index++) {
                    curr[col] = Math.min(curr[col], grid[row][col] + prev[index] + moveCost[grid[row][col]][index]);
                }
            }

            for(int col = 0; col < cols; col++) {
                prev[col] = curr[col];
                curr[col] = Integer.MAX_VALUE;
            }
        }

        for(int index = 0; index < cols; index++) {
            result = Math.min(result, prev[index]);
        }

        return result;
    }
}
