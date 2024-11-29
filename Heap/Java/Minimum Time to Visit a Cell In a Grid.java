// Problem link: https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/
// Time: O(n * m * log(n * m))
// Space: O(n * m)
class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int rows = grid.length, cols = grid[0].length, store[], nr, nc, newTime, diff;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}, visited = new int[rows][cols];
        PQ.offer(new int[] {0, 0, 0});
        visited[0][0] = 1;

        while(!PQ.isEmpty()) {
            store = PQ.poll();

            if(store[1] == rows - 1 && store[2] == cols - 1) {
                return store[0];
            }

            for(int[] dir : directions) {
                nr = dir[0] + store[1];
                nc = dir[1] + store[2];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
                    newTime = store[0] + 1;

                    if(newTime < grid[nr][nc]) {
                        diff = grid[nr][nc] - newTime;
                        newTime += (diff % 2 == 1 ? 1 : 0) + diff;
                    } 

                    PQ.offer(new int[] {newTime, nr, nc});
                    visited[nr][nc] = 1;
                }
            }
        }

        return -1;
    }
}
