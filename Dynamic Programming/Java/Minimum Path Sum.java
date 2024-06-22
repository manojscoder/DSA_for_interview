// Problem link: https://leetcode.com/problems/minimum-path-sum/description/

// Approach 1: Brute force (TLE)
// Time: O(2 ^ (m + n))
// Space: O(m + n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        return this.dfs(0, 0, m, n, grid);
    }

    private int dfs(int row, int col, int m, int n, int[][] grid) {
        if(row >= m || col >= n)
            return Integer.MAX_VALUE;
        else if(row == m - 1 && col == n - 1)
            return grid[row][col];
        
        return grid[row][col] + Math.min(this.dfs(row + 1, col, m, n, grid), this.dfs(row, col + 1, m, n, grid));
    }
}

// Approach 2: Top-Down DP
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cache = new int[m][n];

        return this.dfs(0, 0, m, n, grid, cache);
    }

    private int dfs(int row, int col, int m, int n, int[][] grid, int[][] cache) {
        if(row >= m || col >= n)
            return Integer.MAX_VALUE;
        else if(cache[row][col] != 0)
            return cache[row][col];
        else if(row == m - 1 && col == n - 1)
            return grid[row][col];
        
        cache[row][col] = grid[row][col] + Math.min(this.dfs(row + 1, col, m, n, grid, cache), this.dfs(row, col + 1, m, n, grid, cache));
        return cache[row][col];
    }
}


// Approach 3: Bottom-up DP
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(j + 1 < n && i + 1 < m)
                    grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
                else if(j + 1 < n)
                    grid[i][j] += grid[i][j + 1];
                else if(i + 1 < m)
                    grid[i][j] += grid[i + 1][j];
            }
        }

        return grid[0][0];
    }
}

// Approach: Space Optimized DP
// Time: O(m * n)
// Space: O(n)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] DP = new int[n];

        for(int i = 0; i < n - 1; i++) {
            DP[i] = Integer.MAX_VALUE;
        }
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(j + 1 < n)
                    DP[j] = grid[i][j] + Math.min(DP[j], DP[j + 1]);
                else{
                    DP[j] += grid[i][j];
                }
            }
        }

        return DP[0];
    }
}
