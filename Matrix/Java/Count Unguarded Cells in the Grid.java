// Problem link: https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description/
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for(int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        for(int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 1) {
                    this.guard(row, col, grid, m, n);
                }
            }
        }

        int result = 0;

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(grid[row][col] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    private void guard(int row, int col, int[][] grid, int m, int n) {
        int rw, cl;

        rw = row - 1;

        while(rw >= 0) {
            if(grid[rw][col] > 0)
                break;
            grid[rw][col] = -1;
            rw--;
        }

        rw = row + 1;

        while(rw < m) {
            if(grid[rw][col] > 0)
                break;
            grid[rw][col] = -1;
            rw++;
        }

        cl = col - 1;

        while(cl >= 0) {
            if(grid[row][cl] > 0)
                break;
            grid[row][cl] = -1;
            cl--;
        }

        cl = col + 1;

        while(cl < n) {
            if(grid[row][cl] > 0)
                break;
            grid[row][cl] = -1;
            cl++;
        }
    }
}
