// Problem link: https://leetcode.com/problems/count-servers-that-communicate/description/
// Time: O(n * m)
// Space: O(n + m)
class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        int[] rowServers = new int[rows], colServers = new int[cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    rowServers[row]++;
                    colServers[col]++;
                }
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1 && (rowServers[row] > 1 || colServers[col] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }
}
