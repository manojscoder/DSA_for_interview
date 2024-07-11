// Approach: 1 (DFS)
// Time: O(n * m)
// Space: o(n * m)

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    this.dfs(i, j, visited, grid, directions);
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] grid, int[][] directions) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] == '0' || visited[row][col])
            return;
        
        visited[row][col] = true;

        for(int[] rc : directions)
            this.dfs(row + rc[0], col + rc[1], visited, grid, directions);
    }
}



// Approach: 2 (BFS)
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        boolean[][] visit = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1' && !visit[i][j]) {
                    result++;
                    this.bfs(grid, i, j, visit);
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] visit) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int rows = grid.length, cols = grid[0].length;
        queue.offer(new int[] {row, col});

        while(!queue.isEmpty()) {
            int[] store = queue.poll();

            if(visit[store[0]][store[1]])
                continue;
            
            visit[store[0]][store[1]] = true;

            for(int[] rc : directions) {
                if(rc[0] + store[0] >= 0 && rc[0] + store[0] < rows && rc[1] + store[1] >= 0 && rc[1] + store[1] < cols)
                    if(grid[rc[0] + store[0]][rc[1] + store[1]] != '0')
                        queue.offer(new int[] {store[0] + rc[0], store[1] + rc[1]});
            }
        }
    }
}
