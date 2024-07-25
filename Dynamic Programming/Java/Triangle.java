// Problem link: https://leetcode.com/problems/triangle/description

// Approach: 1 (Brute force) TLE
// Time: O(2 ^ n)
// Space: O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return this.dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> tri, int row, int col) {
        if(row == tri.size() - 1) {
            return tri.get(row).get(col);
        }

        return tri.get(row).get(col) + Math.min(this.dfs(tri, row + 1, col), this.dfs(tri, row + 1, col + 1));
    }
}


// Approach: 2 (Top-Down)
// Time: O(n ^ 2)
// Space: O(n ^ 2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();

        int[][] cache = new int[size][size];
        for(int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        return this.dfs(triangle, 0, 0, cache);
    }

    private int dfs(List<List<Integer>> tri, int row, int col, int[][] cache) {
        if(row == tri.size() - 1) {
            return tri.get(row).get(col);
        }
        else if(cache[row][col] != Integer.MAX_VALUE) {
            return cache[row][col];
        }

        cache[row][col] = tri.get(row).get(col) + Math.min(this.dfs(tri, row + 1, col, cache), this.dfs(tri, row + 1, col + 1, cache));
        return cache[row][col];
    }
}


// Approach: 3 (Bottom-Up)
// Time: O(n ^ 2)
// Space: O(n ^ 2)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] cache = new int[rows][rows];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < row + 1; col++) {
                cache[row][col] = triangle.get(row).get(col);
            }
        }

        for(int row = rows - 2; row >= 0; row--) {
            for(int col = 0; col < row + 1; col++) {
                cache[row][col] += Math.min(cache[row + 1][col] , cache[row + 1][ col + 1]);
            }
        }
        
        return cache[0][0];
    }
}


// Approach: 4 (Space Optimized)
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] DP = new int[rows + 1];

        for(int row = rows - 1; row >= 0; row--) {
            for(int col = 0; col < row + 1; col++) {
                DP[col] = triangle.get(row).get(col) + Math.min(DP[col], DP[col + 1]);
            }
        }
        
        return DP[0];
    }
}
