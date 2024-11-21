// Problem link: https://leetcode.com/problems/swim-in-rising-water/description/
// Time: O(n ^ 2 * log n)
// Space: O(n ^ 2)
class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, row, col, rw, cl, time, store[];
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PQ.offer(new int[] {grid[0][0], 0, 0});

        while(!PQ.isEmpty()) {
            store = PQ.poll();
            time = store[0];
            row = store[1];
            col = store[2];

            if(row == rows - 1 && col == cols - 1) {
                return time;
            }
            else if(visited[row][col]) {
                continue;
            }

            visited[row][col] = true;

            for(int[] dir : directions) {
                rw = dir[0] + row;
                cl = dir[1] + col;
                if(rw >= 0 && rw < rows && cl >= 0 && cl < cols) {
                    PQ.offer(new int[] {Math.max(time, grid[rw][cl]), rw, cl});
                }
            }
        }

        return -1;
    }
}
