// Problem link: https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/description/
// Time: O(m * n * log(m * n))
// Space: O(m * n)
class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, store[], nr, nc;
        int[][] visited = new int[rows][cols], directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PQ.offer(new int[] {0, 0, 0});
        visited[0][0] = 1;

        while(!PQ.isEmpty()) {
            store = PQ.poll();

            if(store[1] == rows - 1 && store[2] == cols - 1) {
                return store[0];
            }

            for(int[] pair : directions) {
                nr = pair[0] + store[1];
                nc = pair[1] + store[2];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
                    PQ.offer(new int[] {store[0] + (grid[nr][nc] == 1 ? 1 : 0), nr, nc});
                    visited[nr][nc] = 1;
                }
            }
        }

        return 0;
    }
}
