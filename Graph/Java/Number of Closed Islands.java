// Problem link: https://leetcode.com/problems/number-of-closed-islands/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int closedIsland(int[][] grid) {
        int result = 0, rows = grid.length, cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0 && visited[row][col] == 0) {
                    if(this.dfs(row, col, directions, visited, grid)) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private boolean dfs(int row, int col, int[][] directions, int[][] visited, int[][] grid) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return false;
        }
        else if(grid[row][col] == 1 || visited[row][col] == 1) {
            return true;
        }

        visited[row][col] = 1;
        boolean check = true;

        for(int[] dir : directions) {
            if(!this.dfs(row + dir[0], col + dir[1], directions, visited, grid)) {
                check = false;
            }
        }

        return check;
    }
}
