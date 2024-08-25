// Problem link: https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int countPaths(int[][] grid) {
        int result = 0, rows = grid.length, cols = grid[0].length;
        int[][] cache = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                result = (result + this.dfs(row, col, Integer.MIN_VALUE, grid, cache)) % 1000000007;
            }
        }

        return result;
    }

    private int dfs(int row, int col, int prev, int[][] grid, int[][] cache) {
        if(row < 0 || col < 0 || col == grid[0].length || row == grid.length || grid[row][col] <= prev) {
            return 0;
        }
        else if(cache[row][col] != 0) {
            return cache[row][col];
        }

        int count = 0;
        for(int[] dir : new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}) {
            count = (count + this.dfs(row + dir[0], col + dir[1], grid[row][col], grid, cache)) % 1000000007;
        }

        cache[row][col] = count + 1;
        return cache[row][col];
    }
}
