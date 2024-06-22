// Problem link: https://leetcode.com/problems/unique-paths-ii/description/

// Approach 1: Brute force (TLE)
// Time: O(2 ^ (m + n))
// Space: O(m * n)
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return this.dfs(0, 0, m, n, grid);
    }   

    private int dfs(int row, int col, int m, int n, int[][] grid) {
        if(row >= m || col >= n || grid[row][col] == 1)
            return 0;
        else if(row == m - 1 && col == n - 1)
            return 1;
        return this.dfs(row + 1, col, m , n, grid) + this.dfs(row, col + 1, m , n, grid);
    }
}


// Approach 2: Top-down DP
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cache = new int[m][n];

        return this.dfs(0, 0, m, n, grid, cache);
    }   

    private int dfs(int row, int col, int m, int n, int[][] grid, int[][] cache) {
        if(row >= m || col >= n || grid[row][col] == 1)
            return 0;
        else if(cache[row][col] != 0)
            return cache[row][col];
        else if(row == m - 1 && col == n - 1)
            return 1;

        cache[row][col] = this.dfs(row + 1, col, m , n, grid, cache) + this.dfs(row, col + 1, m , n, grid, cache);
        return cache[row][col];
    }
}


// Approach 3: Bottom-up DP
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if(grid[m - 1][n - 1] == 1)
            return 0;

        int[][] DP = new int[m][n];
        DP[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(grid[i][j] != 1) {
                    if(j + 1 < n) 
                        DP[i][j] += DP[i][j + 1];
                    if(i + 1 < m)
                        DP[i][j] += DP[i + 1][j];
                }
            }
        }

        return DP[0][0];
    }
}


// Approach Space optimized DP
// Time: O(m * n)
// Space: O(n)
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if(grid[m - 1][n - 1] == 1)
            return 0;

        int[] DP = new int[n];
        DP[n - 1] = 1;

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(grid[i][j] != 1) {
                    if(j + 1 < n) 
                        DP[j] += DP[j + 1];
                }
                else {
                    DP[j] = 0;
                }
            }
        }

        return DP[0];
    }
}
