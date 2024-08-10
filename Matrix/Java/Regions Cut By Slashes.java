// Problem link: https://leetcode.com/problems/regions-cut-by-slashes/description
// Time: O(n ^ 2)
// Space: O(n ^ 2)
class Solution {
    public int regionsBySlashes(String[] grid) {
        int rows = grid.length, cols = grid[0].length(), result = 0, newRow, newCol;
        int[][] store = new int[rows * 3][cols * 3];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < grid[row].length(); col++) {
                newRow = row * 3;
                newCol = col * 3;
                if(grid[row].charAt(col) == '/') {
                    store[newRow][newCol + 2] = store[newRow + 1][newCol + 1] = store[newRow + 2][newCol] = 1;
                }
                else if(grid[row].charAt(col) == '\\') {
                    store[newRow][newCol] = store[newRow + 1][newCol + 1] = store[newRow + 2][newCol + 2] = 1;
                }
            }
        }

        for(int row = 0; row < rows * 3; row++) {
            for(int col = 0; col < cols * 3; col++) {
                if(store[row][col] != 1) {
                    this.dfs(row, col, store, rows * 3, cols * 3);
                    result += 1;
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, int[][] grid, int rows, int cols) {
        if(row < 0 || col < 0 || row == rows || col == cols || grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;
        this.dfs(row + 1, col, grid, rows, cols);
        this.dfs(row, col + 1, grid, rows, cols);
        this.dfs(row - 1, col, grid, rows, cols);
        this.dfs(row, col - 1, grid, rows, cols);
    }
}
