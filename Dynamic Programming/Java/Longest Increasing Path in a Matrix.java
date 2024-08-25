// Problem link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, result = 0;
        int[][] cache = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                result = Math.max(result, this.dfs(row, col, Integer.MIN_VALUE, matrix, cache));
            }
        }

        return result;
    }

    private int dfs(int row, int col, int prev, int[][] matrix, int[][] cache) {
        if(row < 0 || col < 0 || col == matrix[0].length || row == matrix.length || matrix[row][col] <= prev) {
            return 0;
        }
        else if(cache[row][col] != 0) {
            return cache[row][col];
        }

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count = 0;

        for(int[] dir : directions) {
            count = Math.max(count, this.dfs(row + dir[0], col + dir[1], matrix[row][col], matrix, cache));
        }

        cache[row][col] = count + 1;
        return cache[row][col];
    }
}
