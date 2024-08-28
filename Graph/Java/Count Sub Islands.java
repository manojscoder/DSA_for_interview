// Problem link: https://leetcode.com/problems/count-sub-islands/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length, cols = grid1[0].length, result = 0;
        int[][] visit = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid2[row][col] == 1 && visit[row][col] == 0 && this.dfs(row, col, grid1, grid2, visit)) {
                    result += 1;
                } 
            }
        }

        return result;
    }

    private boolean dfs(int row, int col, int[][] grid1, int[][] grid2, int[][] visit) {
        if(row < 0 || col < 0 || row == grid1.length || col == grid1[0].length || visit[row][col] == 1 || grid2[row][col] == 0) {
            return true;
        }
        else if(grid2[row][col] == 1 && grid1[row][col] == 0) {
            return false;
        }

        visit[row][col] = 1;

        boolean up = this.dfs(row - 1, col, grid1, grid2, visit);
        boolean down = this.dfs(row + 1, col, grid1, grid2, visit);
        boolean left = this.dfs(row, col - 1, grid1, grid2, visit);
        boolean right = this.dfs(row, col + 1, grid1, grid2, visit);

        return up && down && left && right;
    }
}
