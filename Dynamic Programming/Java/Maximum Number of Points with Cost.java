// Problem link: https://leetcode.com/problems/maximum-number-of-points-with-cost/description
// Time: O(m * n)
// Space: O(n)
class Solution {
    public long maxPoints(int[][] points) {
        int rows = points.length, cols = points[0].length;
        long[] DP = new long[cols];
        long result = Long.MIN_VALUE;

        for(int index = 0; index < cols; index++) {
            DP[index] = points[0][index];
        }

        for(int row = 0; row < rows - 1; row++) {
            long[] left = new long[cols];
            left[0] = DP[0];

            for(int col = 1; col < cols; col++) {
                left[col] = Math.max(DP[col], left[col - 1] - 1);
            }

            DP[cols - 1] = points[row + 1][cols - 1] + left[cols - 1];

            for(int col = cols - 2; col >= 0; col--) {
                DP[col] = points[row + 1][col] + Math.max(left[col], Math.max(points[row][col], left[col + 1] - 1));
                left[col] = Math.max(left[col], Math.max(points[row][col], left[col + 1] - 1));
            }
        }

        for(int index = 0; index < cols; index++) {
            result = Math.max(result, DP[index]);
        }

        return result;
    }
}
