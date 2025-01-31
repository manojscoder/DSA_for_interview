// Problem link: https://leetcode.com/problems/making-a-large-island/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int largestIsland(int[][] grid) {
        int result = 0, componentId = 1, rows = grid.length, cols = grid[0].length, size;
        int[] storeSize = new int[rows * cols + 1], parent[] = new int[rows][cols];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Set<Integer> uniqueComponents;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1 && parent[row][col] == 0) {
                    size = this.dfs(row, col, rows, cols, parent, grid, componentId, directions);
                    storeSize[componentId++] = size;
                    result = Math.max(result, size);
                }
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 0) {
                    uniqueComponents = new HashSet<>();
                    size = 0;

                    for(int[] dir : directions)
                        if(row + dir[0] >= 0 && row + dir[0] < rows && col + dir[1] >= 0 && col + dir[1] < cols)
                            uniqueComponents.add(parent[row + dir[0]][col + dir[1]]);

                    for(int component : uniqueComponents)
                        size += storeSize[component];

                    result = Math.max(result, 1 + size);
                }
            }
        }

        return result;
    }

    private int dfs(int row, int col, int rows, int cols, int[][] parent, int[][] grid, int componentId, int[][] directions) {
        parent[row][col] = componentId;
        int size = 1, nr, nc;

        for(int[] dir : directions) {
            nr = row + dir[0];
            nc = col + dir[1];

            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1 && parent[nr][nc] == 0) {
                size += dfs(nr, nc, rows, cols, parent, grid, componentId, directions);
            }
        }

        return size;
    }
}
