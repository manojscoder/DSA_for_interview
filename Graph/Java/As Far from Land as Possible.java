// Problem link: https://leetcode.com/problems/as-far-from-land-as-possible/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int maxDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = -1, rw, cl, size;
        int[][] visited = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 1) {
                    queue.offer(new int[] {row, col, 0});
                    visited[row][col] = 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            size = queue.size();

            for(int itr = 0; itr < size; itr++) {
                int[] store = queue.poll();

                for(int[] dir : directions) {
                    rw = store[0] + dir[0];
                    cl = store[1] + dir[1];

                    if(rw >= 0 && cl >= 0 && rw < rows && cl < cols && visited[rw][cl] == 0) {
                        queue.offer(new int[] {rw, cl, store[2] + 1});
                        result = Math.max(result, store[2] + 1);
                        visited[rw][cl] = 1;
                    }
                }
            }
        }

        return result;
    }
}
