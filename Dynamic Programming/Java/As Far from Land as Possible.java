// Problem link: https://leetcode.com/problems/as-far-from-land-as-possible/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int maxDistance(int[][] grid) {
        int result = -1, n = grid.length;
        int[][] DP = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    DP[row][col] = Integer.MAX_VALUE - 1;
                } else {
                    DP[row][col] = 0;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    if (row > 0) {
                        DP[row][col] = Math.min(DP[row][col], DP[row - 1][col] + 1);
                    }
                    if (col > 0) {
                        DP[row][col] = Math.min(DP[row][col], DP[row][col - 1] + 1);
                    }
                }
            }
        }

        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] == 0) {
                    if (row + 1 < n) {
                        DP[row][col] = Math.min(DP[row][col], DP[row + 1][col] + 1);
                    }
                    if (col + 1 < n) {
                        DP[row][col] = Math.min(DP[row][col], DP[row][col + 1] + 1);
                    }
                    result = Math.max(result, DP[row][col]);
                }
            }
        }

        return result == Integer.MAX_VALUE - 1 ? -1 : result;
    }
}
