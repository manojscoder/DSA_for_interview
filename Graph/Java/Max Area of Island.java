// Problem link: https://leetcode.com/problems/max-area-of-island/description/

// Approach: 1 (DFS)
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        boolean[][] visit = new boolean[rows][cols];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                result = Math.max(result, this.dfs(i, j, grid, visit, directions));

        return result;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visit, int[][] directions) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == 0 || visit[row][col])
            return 0;
        
        visit[row][col] = true;

        int count = 1;
        for(int[] dir : directions)
            count = count + this.dfs(dir[0] + row, dir[1] + col, grid, visit, directions);

        return count;
    }
}


// Approach: 2 (BFS)
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        boolean[][] visit = new boolean[rows][cols];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                if(grid[i][j] == 1 && !visit[i][j])
                    result = Math.max(result, this.bfs(i, j, grid, visit, directions));
        
        return result;
    }

    private int bfs(int row, int col, int[][] grid, boolean[][] visit, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length, cols = grid[0].length, count = 0, r, c;
        queue.offer(new int[] {row, col});
        visit[row][col] = true;
        int[] cell;

        while(!queue.isEmpty()) {
            cell = queue.poll();
            count++;

            for(int[] dir : directions) {
                r = dir[0] + cell[0];
                c = dir[1] + cell[1];
                if(r >= 0 && r < rows && c >= 0 && c < cols && !visit[r][c] && grid[r][c] == 1) {
                    queue.offer(new int[] {r, c});
                    visit[r][c] = true;
                }
            }
        }

        return count;
    }
}
