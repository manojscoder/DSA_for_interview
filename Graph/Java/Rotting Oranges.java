// Problem link: https://leetcode.com/problems/rotting-oranges/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int result = 0, oranges = 0, size;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    oranges += 1;
                }
                if(grid[row][col] == 2) {
                    queue.offer(new int[] {row, col});
                }
            }
        }

        while(!queue.isEmpty() && oranges > 0) {
            size = queue.size();

            for(int idx = 0; idx < size; idx++) {
                int[] cell = queue.poll();
                for(int[] dim : dir) {
                    int row = cell[0] + dim[0], col = cell[1] + dim[1];
                    if(row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        queue.offer(new int[] {row, col});
                        grid[row][col] = 2;
                        oranges -= 1;
                    }
                }
            }

            result += 1;
        }

        return oranges == 0 ? result : -1;
    }
}
